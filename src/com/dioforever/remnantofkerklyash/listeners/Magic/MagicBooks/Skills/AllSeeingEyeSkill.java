package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class AllSeeingEyeSkill implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    public AllSeeingEyeSkill(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }

    HashMap<String, Boolean> part = new HashMap<String, Boolean>();
    HashMap<String, Integer> id = new HashMap<String, Integer>();

    int taskID;
    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();


            if (!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &6&lAll-seeing Eye"))) {
                    if (skills.getAllSESkill() == 1) {
                        if (!(Bukkit.getOnlinePlayers().size() == 1)) {
                            int allseC = skills.getAllSECooldown();
                            if (skills.getAllSECooldown() == 0) {
                                player.sendMessage(color("&6&lAll-seeing Eye &a&l[ON]"));
                            }
                            skills.setAllSECooldown(allseC + 1);


                            if (part.get(player.getName()) == null) part.put(player.getName(), false);
                            if (part.get(player.getName()) == true) return;

                            if (part.get(player.getName()) == false) {
                                part.put(player.getName(), true);
                            }
                            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                                public void run() {
                                    if (id.get(player.getName()) == null) {
                                        id.put(player.getName(), taskID);
                                    }
                                    Location loc = player.getLocation();
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p != player) {
                                            Skills skillsp = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
                                            int value = ((skillsp.getPowerlevel() / 10));
                                            player.spawnParticle(Particle.PORTAL, p.getLocation(), value);
                                            if (skills.getAllSECooldown() >= 2) {
                                                Bukkit.getScheduler().cancelTask(id.get(player.getName()));
                                                id.remove(player.getName());
                                                part.put(player.getName(), false);
                                                skills.setAllSECooldown(0);
                                                player.sendMessage(color("&6&lAll-seeing Eye &c&l[OFF]"));
                                            }
                                            if (Bukkit.getOnlinePlayers().size() == 1) {
                                                Bukkit.getScheduler().cancelTask(id.get(player.getName()));
                                                id.remove(player.getName());
                                                part.put(player.getName(), false);
                                                skills.setAllSECooldown(0);
                                                player.sendMessage(color("&6&lAll-seeing Eye &c&l[OFF]"));
                                            }

                                        }
                                    }//p.spawnParticle(); Only for the player on the player
                                }
                            }, 0, 5);
                        }


                    }

                }
            }
        }
    }
}
