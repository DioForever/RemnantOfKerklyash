package com.dioforever.remnantofkerklyash.listeners;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Profile;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.dioforever.remnantofkerklyash.Utils.*;
import static com.dioforever.remnantofkerklyash.Utils.log;

public class JoinListener implements Listener {

    private Main main;
    private ProfileManager profileManager;

    public JoinListener(Main main){
        this.main = main;
        profileManager = main.getProfileManager();

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
       Profile profile = profileManager.getPlayerProfile(player.getUniqueId());
       if(profile == null){
           //New Player
           log("New player " + player.getName() + " joined the server!");
           profile = profileManager.createNewProfile(player);

       }else{
           log("Player " + player.getName() + " already exists!");

       }


    }

}
