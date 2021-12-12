package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills.Changing;

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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class SkillBookListener implements Listener {


    private ProfileManager profileManager;
    static Main plugin;

    public SkillBookListener(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }

    HashMap<String, Boolean> part = new HashMap<String, Boolean>();
    HashMap<String, Integer> id = new HashMap<String, Integer>();

    int taskID;

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
            if (!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book"))) {
                    if (skills.getAppraisalSkill() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book - &3&lAppraisal"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getHiderSkill() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book - &8&lHider"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getAllSESkill() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book - &6&lAll-seeing Eye"));
                        item.setItemMeta(itemmeta);
                    }


                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &3&lAppraisal"))) {
                    if (skills.getHiderSkill() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book - &8&lHider"));
                        item.setItemMeta(itemmeta);
                    } else if (skills.getAllSESkill() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book - &6&lAll-seeing Eye"));
                        item.setItemMeta(itemmeta);
                    }else{
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book"));
                        item.setItemMeta(itemmeta);
                    }


                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &6&lAll-seeing Eye"))) {
                    ItemStack item = player.getItemInHand();
                    ItemMeta itemmeta = item.getItemMeta();
                    itemmeta.setDisplayName(color("&c&lSkill Book"));
                    item.setItemMeta(itemmeta);

                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &8&lHider"))) {
                    if (skills.getAllSESkill() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book - &6&lAll-seeing Eye"));
                        item.setItemMeta(itemmeta);
                    } else {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&c&lSkill Book"));
                        item.setItemMeta(itemmeta);
                    }
                }
            }
        }
    }
}