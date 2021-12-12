package com.dioforever.remnantofkerklyash.commands.ForceCMDs;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class ForceLevelRACE implements CommandExecutor {

    private ProfileManager profileManager;
    public ForceLevelRACE(Main main) {
        profileManager = main.getProfileManager();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
                int evolvexp = skills.getEvolvexp();
                int evolve = skills.getEvolve();
                int lifeforce = skills.getLifeForce();
                skills.setEvolve(evolve+1);
                skills.setEvolvexp(evolvexp-evolvexp);
                skills.setLifeForce(lifeforce+10);
                player.sendMessage(color("&e&lYou have leved up your race level to level "+(evolve+1)));
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
            }

        }

        return true;
    }
}
