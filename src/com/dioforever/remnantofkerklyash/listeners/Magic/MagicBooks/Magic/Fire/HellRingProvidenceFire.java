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

import java.util.HashMap;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class HellRingProvidenceFire implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    private float radius = 1.5f;
    private float angle = 0f;

    public HellRingProvidenceFire(Main main) {
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
            //HELL RING PROVIDENCE
            if(!(p.getInventory().getItemInMainHand().getType().isAir())) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"))) {
                    if ((skills.getMana() >= 10) && skills.getHellRingProvidenceHave() == 1 && skills.getHellRingProvidenceX() ==0) {
                        skills.setHellRingProvidenceX(1);


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
                                for (int d = 0; d <= 90; d += 1) {
                                    Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                                    particleLoc.setX(direction.getX() * t + location.getX() + Math.cos(d) * size);
                                    particleLoc.setZ(direction.getZ() * t + location.getZ() + Math.sin(d) * size);
                                    particleLoc.setY(location.getBlockY() + 1);
                                    //location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(Color.RED, 5));
                                    location.getWorld().spawnParticle(Particle.FLAME, particleLoc, 0, 0, 0, 0, 1);
                                    if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.AIR) {
                                        if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.DEAD_BUSH ){
                                            if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.GRASS){
                                                if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.SNOW){
                                                    if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.SUGAR_CANE){
                                                        if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.ACACIA_SAPLING){
                                                            if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.BAMBOO_SAPLING){
                                                                if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.BIRCH_SAPLING){
                                                                    if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.SPRUCE_SAPLING){
                                                                        if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.DARK_OAK_SAPLING){
                                                                            if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.JUNGLE_SAPLING){
                                                                                if(particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.OAK_SAPLING) {
                                                                                    if (particleLoc.getWorld().getBlockAt(particleLoc).getType() != Material.TALL_GRASS) {
                                                                                        Bukkit.getScheduler().cancelTask(taskID);
                                                                                        skills.setHellRingProvidenceX(0);
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
                                        skills.setHellRingProvidenceX(0);
                                    }
                                }
                                //DAMAGE
                                for (int d = 0; d <= 90; d += 1) {
                                    for (Entity e : p.getWorld().getEntities()) {
                                        Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                                        particleLoc.setX(direction.getX() * t + location.getX() + Math.cos(d) * size);
                                        particleLoc.setZ(direction.getZ() * t + location.getZ() + Math.sin(d) * size);

                                        if (e.getLocation().distance(particleLoc) < 2.0) {
                                            if (e != p) {
                                                e.setFireTicks(20 * 6);
                                            }
                                        }
                                    }
                                }
                                //END DAMAGE


                                //Only for the player on the player                                p.spawnParticle();


                                if (t > 50) {
                                    Bukkit.getScheduler().cancelTask(taskID);
                                    skills.setHellRingProvidenceX(0);
                                }
                            }


                        }, 0, 1);
                        p.sendMessage(color("&eYou have casted &4&lHell Ring Providence &6&lT5"));
                        skills.setMana(mana - 200);
                    }

                }
            }
        }
    }
}