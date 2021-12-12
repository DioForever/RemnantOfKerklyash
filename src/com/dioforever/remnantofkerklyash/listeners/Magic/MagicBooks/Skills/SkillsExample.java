package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class SkillsExample implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    public SkillsExample(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }
    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();


            if (!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &3&lExample"))) {

                    if (skills.getAppraisalSkill() == 1) {

                        Block block = player.getTargetBlock(null, 100);
                        Location bl = block.getLocation();
                        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                            player.sendMessage(color("&3&lAppraisal: " + e.getClickedBlock().getType()));
                        }
                        if (e.getAction() == Action.LEFT_CLICK_AIR) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                Skills OSkills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
                                if (p.getLocation().distance(player.getLocation()) < 30) {
                                    if (p != player) {


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
