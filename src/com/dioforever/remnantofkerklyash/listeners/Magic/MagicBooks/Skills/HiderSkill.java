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

import static com.dioforever.remnantofkerklyash.Utils.color;

public class HiderSkill implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    public HiderSkill(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }
    @EventHandler
    public void onLeftClick(PlayerInteractEvent e){
        if(e.getAction()== Action.LEFT_CLICK_BLOCK||e.getAction() == Action.LEFT_CLICK_AIR){
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();



            if(!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &8&lHider"))) {

                    if (skills.getHiderSkill() == 1) {

                        Block block = player.getTargetBlock(null, 100);
                        Location bl = block.getLocation();
                        int hiderc = skills.getHiderCooldown();
                        skills.setHiderCooldown(hiderc+1);

                        if(skills.getHiderCooldown()==1){
                            player.sendMessage(color("&8&lHider &a&l[ON]"));;
                        }else if(skills.getHiderCooldown()>=2){
                            player.sendMessage(color("&8&lHider &c&l[OFF]"));
                            skills.setHiderCooldown(0);
                        }

                    }
                }
            }

        }
    }

}