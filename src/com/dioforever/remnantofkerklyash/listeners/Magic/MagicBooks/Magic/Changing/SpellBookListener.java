package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Changing;


import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.lang.Math;

import java.util.HashMap;

import static com.dioforever.remnantofkerklyash.Utils.*;
import static com.dioforever.remnantofkerklyash.Utils.color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class SpellBookListener implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    private float radius = 1.5f;
    private float angle = 0f;

    public SpellBookListener(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }

    HashMap<String, Boolean> part = new HashMap<String, Boolean>();
    HashMap<String, Integer> id = new HashMap<String, Integer>();
    HashMap<String, Boolean> partSUN = new HashMap<String, Boolean>();
    HashMap<String, Integer> idSUN = new HashMap<String, Integer>();
    HashMap<String, Boolean> partSP = new HashMap<String, Boolean>();
    HashMap<String, Integer> idSP = new HashMap<String, Integer>();
    HashMap<String, Boolean> partHFP = new HashMap<String, Boolean>();
    HashMap<String, Integer> idHFP = new HashMap<String, Integer>();

    int taskID;
    int taskIDSUN;
    int taskIDSP;
    int taskIDHFP;

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e){
        if(e.getAction()== Action.LEFT_CLICK_BLOCK||e.getAction() == Action.LEFT_CLICK_AIR) {
            Player p = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
            int mana = skills.getMana();


            if (!(p.getInventory().getItemInMainHand().getType().isAir())) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lSun Ball &6&lT5"))) {
                    if ((skills.getMana() >= 50) && skills.getFireSunBallHave() == 1) {

                        if (partSUN.get(p.getName()) == null) partSUN.put(p.getName(), false);
                        if (partSUN.get(p.getName()) == true) return;

                        if (partSUN.get(p.getName()) == false) {
                            partSUN.put(p.getName(), true);
                        }
                        taskIDSUN = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                            double phi = 0;
                            double t = 0;

                            Location loc = p.getLocation();
                            Vector direction = loc.getDirection().normalize();

                            public void run() {
                                if (idSUN.get(p.getName()) == null) {
                                    idSUN.put(p.getName(), taskIDSUN);
                                }
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


                                //Only for the player on the player                                p.spawnParticle();


                                if (t > 30) {
                                    Bukkit.getScheduler().cancelTask(idSUN.get(p.getName()));
                                    idSUN.remove(p.getName());
                                    partSUN.put(p.getName(), false);
                                    skills.setFireSunBallCooldown(0);
                                }
                            }


                        }, 0, 1);
                        skills.setMana(mana - 100);
                    }

                }
                if (p.getInventory().getItemInMainHand() == null) {

                } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &a&lHeal Magic T1"))) {
                    double var = 0;
                    Location loc, first, second;
                    int count = skills.getCountheal();
                    if ((skills.getMana() >= 50) && skills.getHealT1Cooldown() == 0 && skills.getHaveHealMagicT1() == 1) {

                        if (part.get(p.getName()) == null) part.put(p.getName(), false);
                        if (part.get(p.getName()) == true) return;

                        if (part.get(p.getName()) == false) {
                            part.put(p.getName(), true);
                        }
                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                            double a = 0;

                            public void run() {
                                if (id.get(p.getName()) == null) {
                                    id.put(p.getName(), taskID);
                                }
                                a += Math.PI / 16;
                                Location loc = p.getLocation();
                                Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a + Math.PI));


                                //Only for the player on the player                                p.spawnParticle();
                                p.getWorld().spawnParticle(Particle.HEART, first, 0, 0, 0, 0, 0);
                                p.getWorld().spawnParticle(Particle.HEART, second, 0, 0, 0, 0, 0);
                                int counth = skills.getCountheal();
                                skills.setCountheal(1 + counth);
                                if (skills.getCountheal() >= 50) {
                                    Bukkit.getScheduler().cancelTask(id.get(p.getName()));
                                    id.remove(p.getName());
                                    part.put(p.getName(), false);
                                    skills.setCountheal(0);

                                }
                            }


                        }, 0, 1);


                        skills.setHealOn(1);

                        skills.setMana(mana - 100);
                        skills.setHealT1Cooldown(10);
                        double hp = p.getHealth();
                        if(p.getHealth()>=16&& p.getHealth()<=20){
                            p.setHealth(20);
                        }else {
                            p.setHealth(hp + 5);
                        }

                        p.sendMessage(color("&eYou have been healed by &a&lHeal Magic Tier 1"));
                    }

                }


            }
        }



        }
    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        if(e.getAction()== Action.RIGHT_CLICK_AIR||e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = e.getPlayer();

            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();

            if(!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book"))) {
                    if (skills.getHaveHealMagicT1() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &a&lHeal Magic T1"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getLightningBulletHave() == 1) {
                    ItemStack item = player.getEquipment().getItemInMainHand();
                    ItemMeta itemmeta = item.getItemMeta();
                    itemmeta.setDisplayName(color("&d&lSpell Book - &b&lLightning Bullet &a&lT1"));
                    item.setItemMeta(itemmeta);
                    } else if (skills.getHarvestMineHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &8&lHarvest Mine &a&lT1"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getScorchingPulseHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lScorching Pulse &5&lT3"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getFireSunBallHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lSun Ball &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellBeamMagic() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Beam &6&lT4"));
                        item.setItemMeta(itemmeta);
                    }


                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &a&lHeal Magic T1"))) {
                    if (skills.getLightningBulletHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &b&lLightning Bullet &a&lT1"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getHarvestMineHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &8&lHarvest Mine &a&lT1"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getScorchingPulseHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lScorching Pulse &5&lT3"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getFireSunBallHave() == 1) {

                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lSun Ball &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book"));
                        item.setItemMeta(itemmeta);
                    }
                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &8&lHarvest Mine &a&lT1"))) {
                     if (skills.getScorchingPulseHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lScorching Pulse &5&lT3"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getFireSunBallHave() == 1) {

                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lSun Ball &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book"));
                        item.setItemMeta(itemmeta);
                    }
                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lSun Ball &6&lT4"))) {
                    if (skills.getHellBeamMagic() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Beam &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book"));
                        item.setItemMeta(itemmeta);
                    }
                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"))) {
                    ItemStack item = player.getEquipment().getItemInMainHand();
                    ItemMeta itemmeta = item.getItemMeta();
                    itemmeta.setDisplayName(color("&d&lSpell Book"));
                    item.setItemMeta(itemmeta);
                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lScorching Pulse &5&lT3"))) {
                     if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getFireSunBallHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lSun Ball &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellBeamMagic() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Beam &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book"));
                        item.setItemMeta(itemmeta);
                    }
                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lHell Beam &6&lT4"))) {
                    if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book"));
                        item.setItemMeta(itemmeta);
                    }
                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &b&lLightning Bullet &a&lT1"))) {
                     if (skills.getHarvestMineHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &8&lHarvest Mine &a&lT1"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getScorchingPulseHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lScorching Pulse &5&lT3"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    }else if (skills.getBlazingHeartBeatHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getFireSunBallHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lSun Ball &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellBeamMagic() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Beam &6&lT4"));
                        item.setItemMeta(itemmeta);
                    }

                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lBlazing Heart Beat &5&lT3"))) {
                    if (skills.getFireSunBallHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lSun Ball &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellRingProvidenceHave() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Ring Providence &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHellBeamMagic() == 1) {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book - &4&lHell Beam &6&lT4"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getEquipment().getItemInMainHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&d&lSpell Book"));
                        item.setItemMeta(itemmeta);
                    }
                }
            }

        }
    }
}
