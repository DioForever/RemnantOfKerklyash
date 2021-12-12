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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;
import static com.dioforever.remnantofkerklyash.Utils.log;


public class DioAdventureGUI implements TabExecutor {

    private ItemStack DemonLordItem;
    private ProfileManager profileManager;
    private ItemStack pointsItem;
    private ItemStack profileItem;
    private ItemStack ManaCapabilityItem;
    private ItemStack ManaManipulationItem;
    private ItemStack LifeForceItem;
    //Profile = level, race, name, power level in numbers
    private ItemStack raceItem;
    private ItemStack magicItem;
    private ItemStack raceSkillsItem;
    private ItemStack skillItem;
    //races

    public DioAdventureGUI(Main main){
        profileManager = main.getProfileManager();


        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&ePoints left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have X points left")));
        pointsItem.setItemMeta(pointsItemMeta);





    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(!(sender instanceof Player)){
            log("This feature is allowed only for players!");
            return true;
        }
        List<String> racelist = new ArrayList<>();
        Player player = (Player) sender;
        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
        if(skills.getHuman()>= 1 && skills.getHuman() <= 19){
            String race = new String();
            race = color("&9&lHuman&e");
            racelist.add(race);
        }
        if(skills.getHuman()>= 20 && skills.getHuman() <= 29){
            String race = new String();
            race = color("&9&lSmart Human&e");
            racelist.add(race);
        }
        if(skills.getHuman()>= 30&& skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&9&lHuman Hero&e");
            racelist.add(race);
        }

        //Human end
        //Demon Lord
        if(skills.getDemonLordIs()==1&&skills.getDemon()>=1){
            String race = new String();
            race = color("&5&lDemon Lord");
            racelist.add(race);
        }
        if(skills.getDemonLordIs()==1 && skills.getHuman()>=1){
            String race = new String();
            race = color("&5&lThe Chosen One&e");
            racelist.add(race);
        }
        if(skills.getDemonLordIs()==1 && skills.getElf()>=1){
            String race = new String();
            race = color("&5&lMyrkáflar&e");
            racelist.add(race);
        }
        if(skills.getDemonLordIs()==1 && skills.getDwarf()>=1){
            String race = new String();
            race = color("&5&lBrimir&e");
            racelist.add(race);
        }
        if(skills.getDemonLordIs()==1 && skills.getKitsune()>=1){
            String race = new String();
            race = color("&5&lTenko&e");
            racelist.add(race);
        }        if(skills.getDemonLordIs()==1 && skills.getRaiju()>=1){
            String race = new String();
            race = color("&5&lRaikou&e");
            racelist.add(race);
        }        if(skills.getDemonLordIs()==1 && skills.getVampire1()>=1){
            String race = new String();
            race = color("&5&lStrix&e");
            racelist.add(race);
        }
        //Demon
        if(skills.getDemon()>= 1 && skills.getDemon() <=9){
            String race = new String();
            race = color("&6&lLesser Demon&e");
            racelist.add(race);
        }
        if(skills.getDemon()>= 10 && skills.getDemon() <=29){
            String race = new String();
            race = color("&6&lGreater Demon&e");
            racelist.add(race);
        }
        if(skills.getDemon()>= 30&& skills.getDemon() <=39){
            String race = new String();
            race = color("&6&lArch Demon&e");
            racelist.add(race);
        }
        if(skills.getDemon()>= 40&& skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&6&lDemon Noble&e");
            racelist.add(race);
        }
        //Demon end
        //Elf
        if(skills.getElf()>= 1 && skills.getElf() <= 19){
            String race = new String();
            race = color("&2&lElf&e");
            racelist.add(race);
        }
        if(skills.getElf()>= 20&& skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&2&lMaster Elf&e");
            racelist.add(race);
        }
        //Elf end
        //Kitsune
        if(skills.getKitsune()>= 1 && skills.getKitsune() <=9){
            String race = new String();
            race = color("&6&lFox&e");
            racelist.add(race);
        }
        if(skills.getKitsune()>= 10 && skills.getKitsune() <=19){
            String race = new String();
            race = color("&6&lFire Fox&e");
            racelist.add(race);
        }
        if(skills.getKitsune()>= 20 && skills.getKitsune() <=29){
            String race = new String();
            race = color("&6&lFire Doom Fox&e");
            racelist.add(race);
        }
        if(skills.getKitsune()>= 30 && skills.getKitsune() <=39){
            String race = new String();
            race = color("&6&lDoom Fox&e");
            racelist.add(race);
        }
        if(skills.getKitsune()>= 40&& skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&6&lKitsune&e");
            racelist.add(race);
        }
        //Kitsune end
        //Dwarf
        if(skills.getDwarf()>= 1 && skills.getDwarf() <= 9){
            String race = new String();
            race = color("&3&lDwarf&e");
            racelist.add(race);
        }
        if(skills.getDwarf()>= 10 && skills.getDwarf() <= 19){
            String race = new String();
            race = color("&3&lDwarf Traine&e");
            racelist.add(race);
        }
        if(skills.getDwarf()>= 20&& skills.getDemonLordIs()!=1 ){
            String race = new String();
            race = color("&3&lMaster Dwarf&e");
            racelist.add(race);
        }
        //Dwarf end
        //Raiju
        if(skills.getRaiju()>= 1 && skills.getRaiju() <=9){
            String race = new String();
            race = color("&b&lWolf&e");
            racelist.add(race);
        }
        if(skills.getRaiju()>= 10 && skills.getRaiju() <=19){
            String race = new String();
            race = color("&b&lStar Wolf&e");
            racelist.add(race);
        }
        if(skills.getRaiju()>= 20 && skills.getRaiju() <=29){
            String race = new String();
            race = color("&b&lStorm Star Wolf&e");
            racelist.add(race);
        }
        if(skills.getRaiju()>= 30 && skills.getRaiju() <=39){
            String race = new String();
            race = color("&b&lStorm Wolf&e");
            racelist.add(race);
        }
        if(skills.getRaiju()>= 40&& skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&b&lRaiju&e");
            racelist.add(race);
        }
        //Raiju end
        //Vampire
        if(skills.getVampire1()>= 1 && skills.getVampire1() <= 9){
            String race = new String();
            race = color("&8&lVampire&e");
            racelist.add(race);
        }
        if(skills.getVampire1()>= 10 && skills.getVampire1() <= 19){
            String race = new String();
            race = color("&8&lBloody Vampire&e");
            racelist.add(race);
        }
        if(skills.getVampire1()>= 20&& skills.getVampire1()<=29){
            String race = new String();
            race = color("&8&lVampire Lord&e");
            racelist.add(race);
        }
        if(skills.getVampire1()>= 30 && skills.getVampire1() <= 39){
            String race = new String();
            race = color("&8&lVampire Noble&e");
            racelist.add(race);
        }
        if(skills.getVampire1()>= 40 && skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&8&lPure Vampire&e");
            racelist.add(race);
        }
        //Vampire end


        //profileItem
        profileItem = new ItemStack(Material.PAINTING, 1);
        ItemMeta profileItemMeta = pointsItem.getItemMeta();
        profileItemMeta.setDisplayName(color("&aProfile of "+player.getName()));
        profileItemMeta.setLore(Arrays.asList(color("&eYou have level: " + skills.getLevel()),
                color("&eYou have level XP " + skills.getLevelxp()+ "/" + 100*skills.getLevel()), color("&eYour race: "+ racelist),
                color("&eYour Race level: " + skills.getEvolve()),
                color("&eYour Race level XP " + skills.getEvolvexp()+"/"+100*skills.getEvolve()),
                color("&eYour power level: " + skills.getPowerlevel())));
        profileItem.setItemMeta(profileItemMeta);
        //LifeForceItem
        LifeForceItem = new ItemStack(Material.RED_DYE, 1);
        ItemMeta LifeForceItemMeta = LifeForceItem.getItemMeta();
        LifeForceItemMeta.setDisplayName(color("&4&lLife Force"));
        LifeForceItemMeta.setLore(Arrays.asList(color("&7Life Force is energy that is sometimes"), color("&7used for skills and you can get"),
                color("&7more of life force by leveling"),color("&7your race."), color("&7Life Force: &4"+skills.getLifeForce())));
        LifeForceItem.setItemMeta(LifeForceItemMeta);
        //raceItem
        raceItem = new ItemStack(Material.TURTLE_EGG, 1);
        ItemMeta raceItemMeta = raceItem.getItemMeta();
        raceItemMeta.setDisplayName(color("&b&lRaces"));
        raceItemMeta.setLore(Arrays.asList(color("&7Click to open &b&lRaces GUI")));
        raceItem.setItemMeta(raceItemMeta);
        //magicItem
        magicItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta magicItemMeta = magicItem.getItemMeta();
        magicItemMeta.setDisplayName(color("&d&lMagic"));
        magicItemMeta.setLore(Arrays.asList(color("&7Click to open &d&lMagic GUI")));
        magicItem.setItemMeta(magicItemMeta);
        //raceSkillsItem
        raceSkillsItem = new ItemStack(Material.EGG,1);
        ItemMeta raceSkillsItemMeta = raceSkillsItem.getItemMeta();
        raceSkillsItemMeta.setDisplayName(color("&3&lRace Skills"));
        raceSkillsItemMeta.setLore(Arrays.asList(color("&7Click to open &3&lRace skills GUI")));
        raceSkillsItem.setItemMeta(raceSkillsItemMeta);
        //skillItem
        skillItem = new ItemStack(Material.WRITTEN_BOOK,1);
        ItemMeta skillItemMeta = skillItem.getItemMeta();
        skillItemMeta.setDisplayName(color("&c&lSkills"));
        skillItemMeta.setLore(Arrays.asList(color("&7Click to open &c&lSkills GUI")));
        skillItem.setItemMeta(skillItemMeta);
        //ManaCapabilityItem
        ManaCapabilityItem = new ItemStack(Material.SEA_LANTERN,1);
        ItemMeta ManaCapabilityItemMeta = ManaCapabilityItem.getItemMeta();
        ManaCapabilityItemMeta.setDisplayName(color("&b&lMana Capability"));
        ManaCapabilityItemMeta.setLore(Arrays.asList(color("&7You can see here how much "),color("&7mana you are able to use &9&l" + skills.getManaCap())));
        ManaCapabilityItem.setItemMeta(ManaCapabilityItemMeta);
        //ManaManipulationItem
        ManaManipulationItem = new ItemStack(Material.HEART_OF_THE_SEA,1);
        ItemMeta ManaManipulationItemMeta = ManaManipulationItem.getItemMeta();
        ManaManipulationItemMeta.setDisplayName(color("&b&lMana Manipulation"));
        ManaManipulationItemMeta.setLore(Arrays.asList(color("&7You can see here how you "),color("&7are great with Mana Manipulation &9&l" + skills.getManaMan())));
        ManaManipulationItem.setItemMeta(ManaManipulationItemMeta);
        //Demon Lord Egg
        DemonLordItem = new ItemStack(Material.DRAGON_EGG,1);
        ItemMeta DemonLordItemMeta = DemonLordItem.getItemMeta();
        DemonLordItemMeta.setDisplayName(color("&5&lDemon Lord Egg"));
        DemonLordItemMeta.setLore(Arrays.asList(color("&7With Demon Lord Egg "),color("&7you can evolve into Demon Lord"), color("&7under specific circumstances:"),
                color("&7 1. Kill Withers "+skills.getWitherkilled()+"&7/3"), color("&7 2. Kill monsters/animals "+ skills.getKilledMonster()+"&7/1000 "),
                color("&7After completion of these requirements"), color("&d&l[CLICK]")));
        DemonLordItem.setItemMeta(DemonLordItemMeta);
        //SupremeBeingItem
        //SupremeBeingItem = new ItemStack(Material.BLAZE_SPAWN_EGG,1);
        //ItemMeta SupremeBeingItemMeta = SupremeBeingItem.getItemMeta();
        //SupremeBeingItemMeta.setDisplayName(color("&6&lSupreme Being Egg"));
        //SupremeBeingItemMeta.setLore(Arrays.asList(color("&7With &6&lSupreme Being Egg "),color("&7you can evolve into Supreme being"), color("&7under specific circumstances:"),
            //    color("&7 1. Have all legendary skills 0/10"), color("&7 2. Acquire Magic Secret Art 0/1 "),
          //      color("&7After completion of these requirements"), color("&e&l[CLICK]")));
        //SupremeBeingItem.setItemMeta(SupremeBeingItemMeta);

        Inventory DioAdventureGUI = Bukkit.createInventory(null, 54, color("&6&lKerklyash GUI"));



        DioAdventureGUI.setItem(10,editItem(raceItem.clone(),1,Arrays.asList(color("&7Click to open Races"))));
        DioAdventureGUI.setItem(4,editItem(profileItem.clone(),1,Arrays.asList(color("&eYour Profile " + player.getName()))));
        DioAdventureGUI.setItem(19,editItem(raceSkillsItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));
        DioAdventureGUI.setItem(28,editItem(magicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        DioAdventureGUI.setItem(37,editItem(skillItem.clone(),1,Arrays.asList(color("&7Click to open &c&lSkills GUI"))));
        DioAdventureGUI.setItem(16, editItem(ManaCapabilityItem.clone(),1,Arrays.asList(color("&7You can see here how much "),color("&7mana you are able to use &9&l" + skills.getManaCap()))));
        DioAdventureGUI.setItem(25,editItem(ManaManipulationItem.clone(),1,Arrays.asList(color("&7You can see here how you "),color("&7are great with Mana Manipulation &9&l" + skills.getManaMan()))));
        DioAdventureGUI.setItem(34,editItem(LifeForceItem.clone(),1,Arrays.asList()));
        if(skills.getLevel()>=50 && skills.getEvolve()>=50&&skills.getDemonLordIs()!=1){
            DioAdventureGUI.setItem(13,editItem(DemonLordItem.clone(),1,Arrays.asList("")));
        }
        if(skills.getLevel()>=80 && skills.getEvolve()>=80 && skills.getDemonLordIs()!=1){
        }

        player.openInventory(DioAdventureGUI);

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