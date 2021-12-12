package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Earth;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class HarvestMineEarth implements Listener {


    private ProfileManager profileManager;
    static Main plugin;


    public HarvestMineEarth(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;

    }

    int taskID;

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {


        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player p = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
            if (!(p.getInventory().getItemInMainHand().getType().isAir())) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &8&lHarvest Mine &a&lT1"))) {
                    if ((skills.getMana() >= 10) && skills.getHarvestMineHave() == 1) {
                        if(skills.getHarvestMineX()==0){
                            skills.setHarvestMineX(1);
                            p.sendMessage(color("&eYou have casted &8&lHarvest Mine &a&l[ON]"));
                            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                                public void run() {
                                    if(!(skills.getMana()<10)){
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1));
                                        int curmana = skills.getMana();
                                        skills.setMana(curmana-(10));
                                    }
                                    if(skills.getMana()<10){
                                        for (PotionEffect pEffect : p.getActivePotionEffects())
                                            if(pEffect.getType()== PotionEffectType.FAST_DIGGING){
                                                p.removePotionEffect(pEffect.getType());
                                                p.sendMessage(color("&eYou have casted &8&lHarvest Mine &c&l[OFF]"));
                                            }


                                    }
                                }


                            }, 0, 20);
                        }else if(skills.getHarvestMineX()==1){
                            skills.setHarvestMineX(0);
                            p.sendMessage(color("&eYou have casted &8&lHarvest Mine &c&l[OFF]"));
                            Bukkit.getScheduler().cancelTask(taskID);
                        }

                        int mana = skills.getMana();
                        //HarvestMine

                            double var = 0;
                            Location first, second;
                            int count = skills.getCountheal();

                            Location loc = p.getLocation();
                            Vector direction = loc.getDirection().normalize();
                            Location location = p.getLocation();

                                skills.setMana(mana - 20);



                            }
                        }
                    }
                }
            }
        }