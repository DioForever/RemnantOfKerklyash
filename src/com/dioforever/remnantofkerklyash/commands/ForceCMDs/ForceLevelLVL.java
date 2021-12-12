package com.dioforever.remnantofkerklyash.commands.ForceCMDs;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class ForceLevelLVL implements CommandExecutor {

    private ProfileManager profileManager;
    public ForceLevelLVL(Main main) {
        profileManager = main.getProfileManager();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
                int points = skills.getPoints();
                int levelxp = skills.getLevelxp();
                int level = skills.getLevel();
                int evolvexp = skills.getEvolvexp();
                int evolve = skills.getEvolve();
                int manacap = skills.getManaCap();
                int manaman = skills.getManaMan();
                skills.setPoints(points+3);
                skills.setLevel(level+1);
                skills.setLevelxp(levelxp-levelxp);
                skills.setManaCap((manacap+40));
                skills.setManaMan((manaman+2));

                player.sendMessage(color("&b&lYou have leveled to level "+ (level+1)));
            }

        }

        return true;
    }
}
