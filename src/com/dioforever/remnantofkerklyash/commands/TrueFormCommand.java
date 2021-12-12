package com.dioforever.remnantofkerklyash.commands;

import com.dioforever.remnantofkerklyash.Entity.CustomKitsune;
import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import static com.dioforever.remnantofkerklyash.Utils.*;

public class TrueFormCommand implements CommandExecutor {
    private ProfileManager profileManager;

    public TrueFormCommand(Main main){
        profileManager = main.getProfileManager();
    }
    int onoff = 1;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();

            CustomKitsune kitsuneform = new CustomKitsune(p.getLocation());
            WorldServer world = ((CraftWorld) p.getWorld()).getHandle();


            kitsuneform.setCustomName(new ChatComponentText(color( p.getName())));
            kitsuneform.setCustomNameVisible(true);



            if(skills.getKitsune() >= 1){

                if(onoff==1){

                world.addEntity(kitsuneform);




                    p.sendMessage(color("&3You have been transformed to your Kitsune form!"));
                    onoff++;

                }else if(onoff==2) {

                    world.removeEntity(kitsuneform);
                    p.sendMessage(color("&3You have been transformed from your Kitsune form!"));
                    onoff--;
                }




            }
        }else {
            log("You dont have acces to this transformation!");
        }
        return true;
    }

}