package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Lightning;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class LightningBulletLightning implements Listener {
    ArrayList<Material> CantBlocks = new ArrayList<>();

    private ProfileManager profileManager;
    static Main plugin;


    public LightningBulletLightning(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
        CantBlocks.add(Material.AIR);
        CantBlocks.add(Material.DEAD_BUSH);
        CantBlocks.add(Material.GRASS);
        CantBlocks.add(Material.SNOW);
        CantBlocks.add(Material.SUGAR_CANE);
        CantBlocks.add(Material.ACACIA_SAPLING);
        CantBlocks.add(Material.BAMBOO_SAPLING);
        CantBlocks.add(Material.BIRCH_SAPLING);
        CantBlocks.add(Material.SPRUCE_SAPLING);
        CantBlocks.add(Material.DARK_OAK_SAPLING);
        CantBlocks.add(Material.JUNGLE_SAPLING);
        CantBlocks.add(Material.OAK_SAPLING);
        CantBlocks.add(Material.TALL_GRASS);
    }

    HashMap<String, Boolean> part = new HashMap<String, Boolean>();
    HashMap<String, Integer> id = new HashMap<String, Integer>();


    int taskID;

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {


        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player p = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
            if (!(p.getInventory().getItemInMainHand().getType().isAir())) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &b&lLightning Bullet &a&lT1"))) {
                    if ((skills.getMana() >= 20) && skills.getLightningBulletHave() == 1 && skills.getLightningBulletX() == 0) {

                        int mana = skills.getMana();
                        //HELL RING PROVIDENCE
                        if (!(p.getInventory().getItemInMainHand().getType().isAir())) {

                            double var = 0;
                            Location first, second;
                            int count = skills.getCountheal();

                            Location loc = p.getLocation();
                            Vector direction = loc.getDirection().normalize();
                            Location location = p.getLocation();

                                if (part.get(p.getName()) == null) part.put(p.getName(), false);
                                if (part.get(p.getName()) == true) return;

                                if (part.get(p.getName()) == false) {
                                    part.put(p.getName(), true);
                                }
                                taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                                    double a = 0;
                                    double phi = 0;
                                    double t = 0;

                                    public void run() {
                                        if (id.get(p.getName()) == null) {
                                            id.put(p.getName(), taskID);
                                        }


                                        t = t + 1;

                                        phi += Math.PI / 5;

                                        int size = 1;
                                        for (int d = 0; d <= 90; d += 1) {
                                            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                                            double x = direction.getX() * t;
                                            double y = direction.getY() * t + 1.5;
                                            double z = direction.getZ() * t;
                                            particleLoc.add(x, y, z);


                                            location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(Color.AQUA, 5));
                                            Material specific = particleLoc.getBlock().getType();
                                            if (!(CantBlocks.contains(specific))) {
                                                if (id.containsKey(p.getName())) {
                                                    Bukkit.getScheduler().cancelTask(id.get(p.getName()));
                                                    id.remove(p.getName());
                                                    part.put(p.getName(), false);
                                                    skills.setLightningBulletX(0);
                                                }
                                            }
                                            particleLoc.subtract(x, y, z);
                                            if (t > 35) {
                                                if (id.containsKey(p.getName())) {
                                                    Bukkit.getScheduler().cancelTask(id.get(p.getName()));
                                                    id.remove(p.getName());
                                                    part.put(p.getName(), false);
                                                    skills.setLightningBulletX(0);
                                                }

                                            }
                                        }
                                        //DAMAGE
                                        for (int d = 0; d <= 90; d += 1) {
                                            for (Entity e : p.getWorld().getEntities()) {
                                                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                                                double x = direction.getX() * t;
                                                double y = direction.getY() * t + 1.5;
                                                double z = direction.getZ() * t;
                                                particleLoc.add(x, y, z);
                                                if (e.getLocation().distance(particleLoc) < 2.0) {
                                                    if (e != p) {
                                                        if (e instanceof LivingEntity) {
                                                            ((LivingEntity) e).damage(3 + (2 / 25 * (skills.getManaCap() / 50)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        //END DAMAGE

                                    }


                                }, 0, 1);
                                skills.setMana(mana - 20);


                                p.sendMessage(color("&eYou have casted &b&lLightning Bullet &a&lT1"));
                            }
                        }
                    }
                }
            }
        }
    }