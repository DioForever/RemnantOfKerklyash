package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.RaceSkills.Demon.Changing;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class RaceSkillBookListener implements Listener {

    private ProfileManager profileManager;

    public RaceSkillBookListener(Main main) {
        profileManager = main.getProfileManager();
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
            if (!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&3&lRace Skill Book"))) {
                    if (skills.getDemonALevitation() == 1) {
                        ItemStack item = player.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        itemmeta.setDisplayName(color("&3&lRace Skill Book - &8&lDemon Art of Levitation"));
                        item.setItemMeta(itemmeta);
                    }


                } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&3&lRace Skill Book - &8&lDemon Art of Levitation"))) {
                    ItemStack item = player.getItemInHand();
                    ItemMeta itemmeta = item.getItemMeta();
                    itemmeta.setDisplayName(color("&3&lRace Skill Book"));
                    item.setItemMeta(itemmeta);

                }
            }
        }
    }
}
