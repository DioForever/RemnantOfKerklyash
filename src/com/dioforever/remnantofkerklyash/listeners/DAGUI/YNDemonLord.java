package com.dioforever.remnantofkerklyash.listeners.DAGUI;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class YNDemonLord implements Listener {
    private ProfileManager profileManager;
    HashMap<String, Boolean> part = new HashMap<String, Boolean>();
    HashMap<String, Integer> id = new HashMap<String, Integer>();
    static Main plugin;
    int taskID;

    public YNDemonLord(Main main){
        profileManager = main.getProfileManager();
        plugin = main;
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&0     Become a &5&lDemon Lord&0?"))){


            return;
        }
        event.setCancelled(true);
        if(!event.getClickedInventory().equals(inv)){
            return;
        }
        Player p = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();
        ClickType click = event.getClick();

        List<String> racelist = new ArrayList<>();
        Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();



        switch (slot){
            case 11:
                if (click == ClickType.LEFT) {
                        p.sendMessage(color("&aYou chosed to become &5&lDemon Lord&a !"));
                        p.closeInventory();

                        if(part.get(p.getName()) == null) part.put(p.getName(),false);
                        if(part.get(p.getName()) == true) return;

                        if(part.get(p.getName())==false){
                            part.put(p.getName(), true);
                        }
                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
                            double a = 0;

                            public void run(){
                                if(id.get(p.getName())== null){
                                    id.put(p.getName(), taskID);
                                }
                                if(skills.getDemon()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.FLAME, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.FLAME, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.PORTAL,p.getLocation(),100);
                                }
                                if(skills.getHuman()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.SPELL_WITCH, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.SPELL_WITCH, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.PORTAL,p.getLocation(),10);
                                }
                                if(skills.getElf()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.SPELL_MOB, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.SPELL_MOB, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.SQUID_INK,first,1);
                                    p.getWorld().spawnParticle(Particle.SQUID_INK,second,1);
                                    p.getWorld().spawnParticle(Particle.PORTAL,p.getLocation(),10);
                                }
                                if(skills.getDwarf()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.DRIP_LAVA, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.DRIP_LAVA, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.PORTAL,p.getLocation(),50);
                                }
                                if(skills.getKitsune()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.LAVA,p.getLocation(),2);
                                    p.getWorld().spawnParticle(Particle.LAVA,p.getLocation(),2);
                                }
                                if(skills.getRaiju()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.CRIT, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.CRIT, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.FLASH,p.getLocation(),0);
                                    p.getWorld().spawnParticle(Particle.FLASH,p.getLocation(),0);
                                }
                                if(skills.getVampire1()>=1){
                                    a += Math.PI/16;
                                    Location loc = p.getLocation();
                                    Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                                    Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a+ Math.PI));

                                    //CUSTOM
                                    //p.spawnParticle(); Only for the player on the player
                                    p.getWorld().spawnParticle(Particle.SMOKE_LARGE, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.SMOKE_LARGE, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.ASH, first,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.ASH, second,0,0,0,0,0);
                                    p.getWorld().spawnParticle(Particle.PORTAL,p.getLocation(),10);
                                    p.getWorld().spawnParticle(Particle.PORTAL,p.getLocation(),10);
                                }


                                int counth = skills.getDemonLordCooldown();
                                skills.setDemonLordCooldown(1+counth);
                                if(skills.getDemonLordCooldown()==30){
                                    p.sendMessage(color("&d&lIn progress 10%... &a&l▄&8&l▄▄▄▄▄▄▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==60){
                                    p.sendMessage(color("&d&lIn progress 20%... &a&l▄▄&8&l▄▄▄▄▄▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==90){
                                    p.sendMessage(color("&d&lIn progress 30%... &a&l▄▄▄&8&l▄▄▄▄▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==120){
                                    p.sendMessage(color("&d&lIn progress 40%... &a&l▄▄▄▄&8&l▄▄▄▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==150){
                                    p.sendMessage(color("&d&lIn progress 50%... &a&l▄▄▄▄▄&8&l▄▄▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==180){
                                    p.sendMessage(color("&d&lIn progress 60%... &a&l▄▄▄▄▄▄&8&l▄▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==210){
                                    p.sendMessage(color("&d&lIn progress 70%... &a&l▄▄▄▄▄▄▄&8&l▄▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==240){
                                    p.sendMessage(color("&d&lIn progress 80%... &a&l▄▄▄▄▄▄▄▄&8&l▄▄"));

                                }
                                if(skills.getDemonLordCooldown()==270){
                                    p.sendMessage(color("&d&lIn progress 90%... &a&l▄▄▄▄▄▄▄▄▄&8&l▄"));

                                }
                                if(skills.getDemonLordCooldown()==300){
                                    p.sendMessage(color("&5&lFinished"));
                                   skills.setDemonLordIs(1);
                                   int maxmana = skills.getManaCap();
                                   int manareg = skills.getManaMan();
                                   skills.setManaCap(maxmana+1000);
                                   skills.setManaMan(manareg+40);
                                    Bukkit.broadcastMessage(color("&6&l▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄"));
                                    Bukkit.broadcastMessage(color("      &5&lNew Demon Lord         "));
                                    Bukkit.broadcastMessage(color("          &5&lwas born           "));
                                    Bukkit.broadcastMessage(color("                                 "));
                                    if(skills.getHuman()>=1){
                                    Bukkit.broadcastMessage(color("       &5&lThe Chosen One        "));
                                    }
                                    if(skills.getDemon()>=1){
                                        Bukkit.broadcastMessage(color("         &5&lDemon Lord          "));
                                    }
                                    if(skills.getElf()>=1){
                                        Bukkit.broadcastMessage(color("          &5&lMyrkáflar          "));
                                    }
                                    if(skills.getDwarf()>=1){
                                        Bukkit.broadcastMessage(color("            &5&lBrimir           "));
                                    }
                                    if(skills.getKitsune()>=1){
                                        Bukkit.broadcastMessage(color("            &5&lTenko            "));
                                    }
                                    if(skills.getRaiju()>=1){
                                        Bukkit.broadcastMessage(color("            &5&lRaikou           "));
                                    }
                                    if(skills.getVampire1()>=1){
                                        Bukkit.broadcastMessage(color("            &5&lStrix            "));
                                    }
                                    Bukkit.broadcastMessage(color("&6&l▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄"));


                                }
                                if(skills.getDemonLordCooldown()>=300){
                                    Bukkit.getScheduler().cancelTask(id.get(p.getName()));
                                    id.remove(p.getName());
                                    part.put(p.getName(), false);
                                    skills.setDemonLordCooldown(0);

                                }
                            }


                        },0,1);
                }
                break;
            case 15:
                if(click == ClickType.LEFT){
                    p.sendMessage(color("&cYou chosed not to become &5&lDemon Lord&c !"));
                    p.closeInventory();
                }
                break;

        }

    }
    public ItemStack editItem(ItemStack item, int amount, List<String> lore){
        if(amount == 0) {
            //Can´t have item with amount 0
            amount = 1;
        }
        item.setAmount(amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        return item;

    }

}

