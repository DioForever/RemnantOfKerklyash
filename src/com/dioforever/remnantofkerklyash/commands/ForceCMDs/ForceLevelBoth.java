package com.dioforever.remnantofkerklyash.commands.ForceCMDs;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class ForceLevelBoth implements CommandExecutor {

    private ProfileManager profileManager;
    public ForceLevelBoth(Main main) {
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
                int lifeforce = skills.getLifeForce();
                skills.setPoints(points+3);
                skills.setLevel(level+1);
                skills.setLevelxp(levelxp-levelxp);
                skills.setManaCap((manacap+40));
                skills.setManaMan((manaman+2));
                skills.setEvolve(evolve+1);
                skills.setEvolvexp(evolvexp-evolvexp);
                skills.setLifeForce(lifeforce+10);

                if(skills.getHuman()>= 1){
                    skills.setHuman((evolve+1));
                }
                if(skills.getDemon()>= 1){
                    skills.setDemon((evolve+1));
                }
                if(skills.getElf()>= 1){
                    skills.setElf((evolve+1));
                }
                if(skills.getDwarf()>= 1){
                    skills.setDwarf((evolve+1));
                }
                if(skills.getKitsune()>= 1){
                    skills.setKitsune((evolve+1));
                }
                if(skills.getRaiju()>= 1){
                    skills.setRaiju((evolve+1));
                }
                if(skills.getVampire1()>= 1){
                    skills.setVampire1((evolve+1));
                }
                player.sendMessage(color("&e&lYou have leved up your race level to level "+(evolve+1)));
                player.sendMessage(color("&b&lYou have leveled to level "+ (level+1)));
            }

        }

        return true;
    }
}
