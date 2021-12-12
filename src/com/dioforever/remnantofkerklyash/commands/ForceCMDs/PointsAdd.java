package com.dioforever.remnantofkerklyash.commands.ForceCMDs;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class PointsAdd implements CommandExecutor {

    private ProfileManager profileManager;
    public PointsAdd(Main main) {
        profileManager = main.getProfileManager();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
                int points = skills.getPoints();
                skills.setPoints(points+2);
                player.sendMessage(color("&e&lYou have been added points + 2 = "+(skills.getPoints())));

            }

        }

        return true;
    }
}
