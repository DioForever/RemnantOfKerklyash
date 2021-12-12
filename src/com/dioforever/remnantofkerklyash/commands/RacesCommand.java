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

public class RacesCommand implements TabExecutor {

    private ProfileManager profileManager;
    private ItemStack pointsItem;
    //races
    private ItemStack humanItem;
    private ItemStack demonItem;
    private ItemStack elfItem;
    private ItemStack dwarfItem;
    private ItemStack kitsuneItem;
    private ItemStack raijuItem;
    private ItemStack vampireItem;
    private ItemStack raceresetItem;


    public RacesCommand(Main main){
        profileManager = main.getProfileManager();


        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&ePoints left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have X points left")));
        pointsItem.setItemMeta(pointsItemMeta);


        //RaceresetItem
        raceresetItem = new ItemStack(Material.TURTLE_EGG,1);
        ItemMeta raceresetItemMeta = raceresetItem.getItemMeta();
        raceresetItemMeta.setLore(Arrays.asList(color("&7You have X chances to change race")));
        raceresetItemMeta.setDisplayName(color("&a&lRace Resets"));
        raceresetItem.setItemMeta(raceresetItemMeta);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(!(sender instanceof Player)){
            log("This feature is allowed only for players!");
            return true;
        }
        Player player = (Player) sender;


        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();

        //Human
        humanItem = new ItemStack(Material.WHITE_BANNER, 1);
        ItemMeta humanItemMeta = humanItem.getItemMeta();
        humanItemMeta.setDisplayName(color("&9&lHUMAN"));
        humanItemMeta.setLore(Arrays.asList(color("&7Human race level: " + skills.getHuman())));
        humanItem.setItemMeta(humanItemMeta);

        //Demon
        demonItem = new ItemStack(Material.BLACK_BANNER, 1);
        ItemMeta demonItemMeta = demonItem.getItemMeta();
        demonItemMeta.setDisplayName(color("&6&lDEMON"));
        demonItemMeta.setLore(Arrays.asList(color("&7Demon race level: " + skills.getDemon())));
        demonItem.setItemMeta(demonItemMeta);

        //Elf
        elfItem = new ItemStack(Material.LIME_BANNER, 1);
        ItemMeta elfItemMeta = elfItem.getItemMeta();
        elfItemMeta.setDisplayName(color("&2&lELF"));
        elfItemMeta.setLore(Arrays.asList(color("&7Elf race level: " + skills.getElf())));
        elfItem.setItemMeta(elfItemMeta);
        //Dwarf
        dwarfItem = new ItemStack(Material.BROWN_BANNER, 1);
        ItemMeta dwarfItemMeta = dwarfItem.getItemMeta();
        dwarfItemMeta.setDisplayName(color("&3&lDWARF"));
        dwarfItemMeta.setLore(Arrays.asList(color("&7Dwarf race level: " + skills.getDwarf())));
        dwarfItem.setItemMeta(dwarfItemMeta);
        //Kitsune
        kitsuneItem = new ItemStack(Material.ORANGE_BANNER, 1);
        ItemMeta kitsuneItemMeta = kitsuneItem.getItemMeta();
        kitsuneItemMeta.setDisplayName(color("&6&lKITSUNE"));
        kitsuneItemMeta.setLore(Arrays.asList(color("&7Kitsune/Fox race level: " + skills.getKitsune())));
        kitsuneItem.setItemMeta(kitsuneItemMeta);
        //Raiju
        raijuItem = new ItemStack(Material.LIGHT_BLUE_BANNER, 1);
        ItemMeta raijuItemMeta = raijuItem.getItemMeta();
        raijuItemMeta.setDisplayName(color("&b&lRAIJU"));
        raijuItemMeta.setLore(Arrays.asList(color("&7Raiju/Wolf race level: " + skills.getRaiju())));
        raijuItem.setItemMeta(raijuItemMeta);
        //Vampire
        vampireItem = new ItemStack(Material.GRAY_BANNER, 1);
        ItemMeta vampireItemMeta = vampireItem.getItemMeta();
        vampireItemMeta.setDisplayName(color("&8&lVAMPIRE"));
        vampireItemMeta.setLore(Arrays.asList(color("&7Vampire race level: " + skills.getVampire1())));
        vampireItem.setItemMeta(vampireItemMeta);
        Inventory racesGUI = Bukkit.createInventory(null, 27, color("&e&lRaces GUI"));



        racesGUI.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        racesGUI.setItem(10, editItem(humanItem.clone(), skills.getHuman(), Arrays.asList(color("&9&lHUMAN" + " "))));
        racesGUI.setItem(11, editItem(demonItem.clone(), skills.getDemon(), Arrays.asList(color("&6&lDEMON"+" " ))));
        racesGUI.setItem(12, editItem(elfItem.clone(), skills.getElf(), Arrays.asList(color("&2&lELF,"+" "))));
        racesGUI.setItem(13, editItem(dwarfItem.clone(), skills.getDwarf(), Arrays.asList(color("&3&lDWARF,"+" "))));
        racesGUI.setItem(14, editItem(kitsuneItem.clone(), skills.getKitsune(), Arrays.asList(color("&6&lKITSUNE,"+" "))));
        racesGUI.setItem(15, editItem(raijuItem.clone(), skills.getRaiju(), Arrays.asList(color("&b&RAIJU,"+" "))));
        racesGUI.setItem(16, editItem(vampireItem.clone(), skills.getVampire1(), Arrays.asList(color("&8&lVAMPIRE,"+" "))));
        racesGUI.setItem(8,editItem(raceresetItem.clone(), skills.getRacereset(), Arrays.asList(color("&a&lRace Resets"))));

        player.openInventory(racesGUI);

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
