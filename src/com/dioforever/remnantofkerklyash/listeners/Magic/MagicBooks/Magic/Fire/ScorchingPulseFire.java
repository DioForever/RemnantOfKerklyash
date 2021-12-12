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
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ScorchingPulseFire implements Listener {

    private ProfileManager profileManager;
    static Main plugin;


    public ScorchingPulseFire(Main main) {
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
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lScorching Pulse &5&lT3"))) {
                    if ((skills.getMana() >= 50) && skills.getScorchingPulseX()==0 && skills.getScorchingPulseHave()==1) {
                        skills.setScorchingPulseX(1);

                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                            double phi = 0;
                            double t = 0;

                            Location loc = p.getLocation();
                            Vector direction = loc.getDirection().normalize();

                            public void run() {

                                t = t + 0.5;
                                double xs = direction.getX() * t;
                                double ys = direction.getY() * t + 1.5;
                                double zs = direction.getZ() * t;

                                phi += Math.PI / 30;


                                for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 80) {
                                    double r = 1.5;
                                    double x = (direction.getX() * t) + (r * cos(theta) * sin(phi));
                                    double y = (direction.getY() * t) + 1.5 + (r * cos(phi));
                                    double z = (direction.getZ() * t) + (r * sin(theta) * sin(phi));
                                    loc.add(x, y, z);
                                    p.getWorld().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 0);
                                    if (loc.getWorld().getBlockAt(loc).getType() != Material.AIR) {
                                        if (loc.getWorld().getBlockAt(loc).getType() != Material.DEAD_BUSH ){
                                            if (loc.getWorld().getBlockAt(loc).getType() != Material.GRASS){
                                                if(loc.getWorld().getBlockAt(loc).getType() != Material.SNOW){
                                                    if(loc.getWorld().getBlockAt(loc).getType() != Material.SUGAR_CANE){
                                                        if(loc.getWorld().getBlockAt(loc).getType() != Material.ACACIA_SAPLING){
                                                            if(loc.getWorld().getBlockAt(loc).getType() != Material.BAMBOO_SAPLING){
                                                                if(loc.getWorld().getBlockAt(loc).getType() != Material.BIRCH_SAPLING){
                                                                    if(loc.getWorld().getBlockAt(loc).getType() != Material.SPRUCE_SAPLING){
                                                                        if(loc.getWorld().getBlockAt(loc).getType() != Material.DARK_OAK_SAPLING){
                                                                            if(loc.getWorld().getBlockAt(loc).getType() != Material.JUNGLE_SAPLING){
                                                                                if(loc.getWorld().getBlockAt(loc).getType() != Material.OAK_SAPLING) {
                                                                                    if (loc.getWorld().getBlockAt(loc).getType() != Material.TALL_GRASS) {
                                                                                        Bukkit.getScheduler().cancelTask(taskID);
                                                                                        skills.setScorchingPulseX(0);
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
                                    loc.subtract(x, y, z);

                                }

                                // phi += Math.PI/30;
                                //for(double theta = 0; theta <=2*Math.PI; theta += Math.PI/80){


                                // double r = 1.5;
                                // double x = r*cos(theta)*sin(phi);
                                // double y = r*cos(phi) + 1.5;
                                // double z = r*sin(theta)*sin(phi);
                                //loc.add(x,y,z);
                                //p.getWorld().spawnParticle(Particle.FLAME,loc,0,0,0,0,0);
                                // loc.subtract(x,y,z);


                                //}
                                //DAMAGE
                                for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 80) {
                                    for (Entity e : p.getWorld().getEntities()) {
                                        Location particleLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
                                        double r = 1.5;
                                        double x = direction.getX() * t + (r * cos(theta) * sin(phi));
                                        double y = direction.getY() * t + 1.5 + (r * cos(phi) + 1.5);
                                        double z = direction.getZ() * t + (r * sin(theta) * sin(phi));
                                        particleLoc.add(x,y,z);

                                        if (e.getLocation().distance(particleLoc) < 2.0) {
                                            if (e != p) {
                                                e.setFireTicks(20 * 6);
                                            }
                                        }
                                    }
                                }
                                //END DAMAGE

                                //Only for the player on the player                                p.spawnParticle();


                                if (t > 30) {
                                    skills.setScorchingPulseX(0);
                                    Bukkit.getScheduler().cancelTask(taskID);

                                }
                            }


                        }, 0, 1);
                        p.sendMessage(color("&eYou have casted &4&lScorching Pulse &6&lT5"));
                        skills.setMana(mana - 150);
                    }

                }
            }
        }
    }
}