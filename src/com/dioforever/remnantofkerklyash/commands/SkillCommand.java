package com.dioforever.remnantofkerklyash.commands;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.*;

public class SkillCommand implements TabExecutor {

    private ProfileManager profileManager;
    private ItemStack pointsItem;
    private ItemStack healthItem;
    private ItemStack intelItem;
    private ItemStack agilityItem;

    public SkillCommand(Main main){
        profileManager = main.getProfileManager();

        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&eSkill points left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have X points left")));
        pointsItem.setItemMeta(pointsItemMeta);

        //Healths
        healthItem = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta healthItemMeta = healthItem.getItemMeta();
        healthItemMeta.setDisplayName(color("&cHealth"));
        healthItemMeta.setLore(Arrays.asList(color("&7Points allocated: &30")));
        healthItem.setItemMeta(healthItemMeta);

        //Intelligence
        intelItem = new ItemStack(Material.BOOK, 1);
        ItemMeta intelItemMeta = intelItem.getItemMeta();
        intelItemMeta.setDisplayName(color("&dIntelligence"));
        intelItemMeta.setLore(Arrays.asList(color("&7Points allocated: &30")));
        intelItem.setItemMeta(intelItemMeta);

        //Agility
        agilityItem = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta agilityItemMeta = agilityItem.getItemMeta();
        agilityItemMeta.setDisplayName(color("&aAgility"));
        agilityItemMeta.setLore(Arrays.asList(color("&7Points allocated: &30")));
        agilityItem.setItemMeta(agilityItemMeta);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if(!(sender instanceof Player)){
            log("This feature is allowed only for players!");
            return true;
        }
        Player player = (Player) sender;


        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();

        Inventory skillsGUI = Bukkit.createInventory(null, 54, color("&e&lSkills GUI"));



        skillsGUI.setItem(4, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        skillsGUI.setItem(19, editItem(healthItem.clone(), skills.getHealth(), Arrays.asList(color("Health" + "You have: " + skills.getHealth()+" levels."))));
        skillsGUI.setItem(20, editItem(intelItem.clone(), skills.getIntelligence(), Arrays.asList(color("Intelligence, You have: " + skills.getIntelligence() +" levels." ))));
        skillsGUI.setItem(21, editItem(agilityItem.clone(), skills.getAgility(), Arrays.asList(color("Agility, You have: "+ skills.getAgility()+" levels."))));

        player.openInventory(skillsGUI);

        return true;
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
    public ItemStack editItem(ItemStack item, int amount, List<String> lore){
        if(amount == 0) {
            //Can´t have item with amount 0
            amount = 1;
        }
        item.setAmount(amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        return item;

    }

}