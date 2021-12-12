package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.RaceSkills.Demon;

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

public class DemonLevitationRSkill implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    public DemonLevitationRSkill(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }
    @EventHandler
    public void onLeftClick(PlayerInteractEvent e){
        if(e.getAction()== Action.LEFT_CLICK_BLOCK||e.getAction() == Action.LEFT_CLICK_AIR){
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();



            if(!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&3&lRace Skill Book - &8&lDemon Art of Levitation"))){

                    if(skills.getDemonALevitation()==1 ){
                        if(skills.getUsingDAL()==0){
                            skills.setUsingDAL(1);
                            player.setAllowFlight(true);
                            player.sendMessage(color("&8&lDemon Art of Levitation &a&l[ON]"));

                        }else{
                            if(skills.getDemonALevitation()==1 ){
                                if(skills.getUsingDAL()==1){
                                    skills.setUsingDAL(0);
                                    player.setAllowFlight(false);
                                    player.sendMessage(color("&8&lDemon Art of Levitation &c&l[OFF]"));
                                }
                            }

                        }

                    }

                }
            }
        }
    }

}
