package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import static com.dioforever.remnantofkerklyash.Utils.color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class BlazingHeartBeatFire implements Listener {

    private ProfileManager profileManager;
    static Main plugin;


    public BlazingHeartBeatFire(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }

    int taskID;

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player p = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
            int mana = skills.getMana();
            if (!(p.getInventory().getItemInMainHand().getType().isAir())) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"))) {
                    if ((skills.getMana() >= 100) && skills.getBlazingHeartBeatHave() == 1) {
                        if (skills.getBlazingHeartBeatX() == 0) {

                            skills.setBlazingHeartBeatX(1);


                            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                                double phi = 0;
                                double t = 0;

                                Location loc = p.getLocation();
                                Vector direction = loc.getDirection().normalize();
                                Location location = p.getLocation();

                                public void run() {
                                    t = t + 0.5;
                                    phi += Math.PI / 5;

                                    int size = 1;
                                    for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 80) {
                                        double r = 1.5;
                                        Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                                        double x = direction.getX() * t + (r * cos(theta) * sin(phi));
                                        double y = direction.getY() * t + 1.5 + (r * cos(phi) + 1.5);
                                        double z = direction.getZ() * t + (r * sin(theta) * sin(phi));
                                        particleLoc.add(x,y,z);
                                        //location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(Color.RED, 5));
                                        location.getWorld().spawnParticle(Particle.FLAME, particleLoc, 0, 0, 0, 0, 1);
                                        if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.AIR) {
                                            if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.DEAD_BUSH) {
                                                if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.GRASS) {
                                                    if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.SNOW) {
                                                        if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.SUGAR_CANE) {
                                                            if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.ACACIA_SAPLING) {
                                                                if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.BAMBOO_SAPLING) {
                                                                    if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.BIRCH_SAPLING) {
                                                                        if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.SPRUCE_SAPLING) {
                                                                            if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.DARK_OAK_SAPLING) {
                                                                                if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.JUNGLE_SAPLING) {
                                                                                    if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.OAK_SAPLING) {
                                                                                        if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.TALL_GRASS) {
                                                                                            Bukkit.getScheduler().cancelTask(taskID);
                                                                                            skills.setBlazingHeartBeatX(0);
                                                                                            particleLoc.subtract(x,y,z);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (t > 35) {
                                            Bukkit.getScheduler().cancelTask(taskID);
                                            skills.setBlazingHeartBeatX(0);
                                            particleLoc.subtract(x,y,z);
                                        }
                                    }
                                    //DAMAGE
                                    for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 80) {
                                        for (Entity e : p.getWorld().getEntities()) {
                                            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                                            double r = 1.5;
                                            double x = direction.getX() * t + (r * cos(theta) * sin(phi));
                                            double y = direction.getY() * t + 1.5 + (r * cos(phi) + 1.5);
                                            double z = direction.getZ() * t + (r * sin(theta) * sin(phi));
                                            particleLoc.add(x,y,z);

                                            if (e.getLocation().distance(particleLoc) < 2.0) {
                                                if (e != p) {
                                                    e.setFireTicks(20 * 6);
                                                    particleLoc.subtract(x,y,z);
                                                }
                                            }
                                        }
                                    }
                                    //END DAMAGE


                                    //Only for the player on the player                                p.spawnParticle();


                                    if (t > 50) {
                                        Bukkit.getScheduler().cancelTask(taskID);
                                        skills.setBlazingHeartBeatX(0);
                                    }
                                }


                            }, 0, 1);
                            p.sendMessage(color("&eYou have casted &4&lBlazing Heart Beat &5&lT3"));
                            skills.setMana(mana - 100);
                        }

                    }
                }
            }
        }
    }
}