package com.dioforever.remnantofkerklyash.listeners.DAGUI;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;


public class ROKGClickListener implements Listener {

    private ItemStack pointsItem;
    private ItemStack ManaCapabilityItem;
    private ItemStack ManaManipulationItem;
    private ItemStack humanItem;
    private ItemStack demonItem;
    private ItemStack elfItem;
    private ItemStack dwarfItem;
    private ItemStack kitsuneItem;
    private ItemStack raijuItem;
    private ItemStack vampireItem;
    private ItemStack raceresetItem;

    private ItemStack YES;
    private ItemStack NO;


    private ItemStack DAGUIItem;
    //Magic
    private ItemStack FireItem;
    private ItemStack WaterItem;
    private ItemStack EarthItem;
    private ItemStack LightningItem;
    private ItemStack SecretArtItem;
    private ItemStack NatureItem;
    private ItemStack SpellBookItem;
    //Race skills
    //Demon Race Skills
    private ItemStack DemonsLevitationItem;
    private ItemStack RaceSkillBookItem;
    //Skills
    private ItemStack SkillBookItem;
    private ItemStack AppraisalItem;
    private ItemStack allseeingeye;
    private ItemStack HiderSkillItem;



    private ProfileManager profileManager;

    public ROKGClickListener(Main main){
        profileManager = main.getProfileManager();


        //RaceresetItem
        raceresetItem = new ItemStack(Material.TURTLE_EGG,1);
        ItemMeta raceresetItemMeta = raceresetItem.getItemMeta();
        raceresetItemMeta.setLore(Arrays.asList(color("&7You have X chances to change race")));
        raceresetItemMeta.setDisplayName(color("&a&lRace Resets"));
        raceresetItem.setItemMeta(raceresetItemMeta);
        //DAGUI
        DAGUIItem = new ItemStack(Material.PAINTING,1);
        ItemMeta DAGUIItemMeta = DAGUIItem.getItemMeta();
        DAGUIItemMeta.setLore(Arrays.asList(color("&7Click to go back to &6&lKerklyash GUI")));
        DAGUIItemMeta.setDisplayName(color("&6&lKerklyash GUI"));
        DAGUIItem.setItemMeta(DAGUIItemMeta);
        //ManaCapabilityItem
        ManaCapabilityItem = new ItemStack(Material.SEA_LANTERN,1);
        ItemMeta ManaCapabilityItemMeta = ManaCapabilityItem.getItemMeta();
        ManaCapabilityItemMeta.setDisplayName(color("&b&lMana Capability"));
        ManaCapabilityItemMeta.setLore(Arrays.asList(color("&7You can see here how much "),color("&7mana you are able to use.")));
        ManaCapabilityItem.setItemMeta(ManaCapabilityItemMeta);
        //ManaManipulationItem
        ManaManipulationItem = new ItemStack(Material.HEART_OF_THE_SEA,1);
        ItemMeta ManaManipulationItemMeta = ManaManipulationItem.getItemMeta();
        ManaManipulationItemMeta.setDisplayName(color("&b&lMana Manipulation"));
        ManaManipulationItemMeta.setLore(Arrays.asList(color("&7You can see here how you "),color("&7are great with Mana Manipulation.")));
        ManaManipulationItem.setItemMeta(ManaManipulationItemMeta);
        //Fire
        FireItem = new ItemStack(Material.CAMPFIRE,1);
        ItemMeta FireItemMeta = FireItem.getItemMeta();
        FireItemMeta.setLore(Arrays.asList(color("&7Click to go to &4&lFire Magic &7Class")));
        FireItemMeta.setDisplayName(color("&4&lFire Magic"));
        FireItem.setItemMeta(FireItemMeta);
        //Water
        WaterItem = new ItemStack(Material.LINGERING_POTION,1);
        ItemMeta WaterItemMeta = WaterItem.getItemMeta();
        WaterItemMeta.setLore(Arrays.asList(color("&7Click to go to &9&lWater Magic &7Class")));
        WaterItemMeta.setDisplayName(color("&9&lWater Magic"));
        WaterItem.setItemMeta(WaterItemMeta);
        //Earth
        EarthItem = new ItemStack(Material.DEAD_HORN_CORAL_BLOCK,1);
        ItemMeta EarthItemMeta = EarthItem.getItemMeta();
        EarthItemMeta.setLore(Arrays.asList(color("&7Click to go to &8&lEarth Magic &7Class")));
        EarthItemMeta.setDisplayName(color("&8&lEarth Magic"));
        EarthItem.setItemMeta(EarthItemMeta);
        //Lightning
        LightningItem = new ItemStack(Material.BEACON,1);
        ItemMeta LightningItemMeta = LightningItem.getItemMeta();
        LightningItemMeta.setLore(Arrays.asList(color("&7Click to go to &b&lLightning Magic &7Class")));
        LightningItemMeta.setDisplayName(color("&b&lLightning Magic"));
        LightningItem.setItemMeta(LightningItemMeta);
        //SecretArt
        SecretArtItem = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta SecretArtItemMeta = SecretArtItem.getItemMeta();
        SecretArtItemMeta.setLore(Arrays.asList(color("&7Click to go to &5&lSecret Art &7Class")));
        SecretArtItemMeta.setDisplayName(color("&5&lSecret Art"));
        SecretArtItem.setItemMeta(SecretArtItemMeta);
        //Wood Magic
        NatureItem = new ItemStack(Material.SPRUCE_SAPLING,1);
        ItemMeta NatureItemMeta = NatureItem.getItemMeta();
        NatureItemMeta.setLore(Arrays.asList(color("&7Click to go to &2&lNature Magic &7Class")));
        NatureItemMeta.setDisplayName(color("&2&lNature Magic"));
        NatureItem.setItemMeta(NatureItemMeta);

    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&eSkill points left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have "+skills.getPoints()+" &7left")));
        pointsItem.setItemMeta(pointsItemMeta);

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
        //GetSpellBook
        SpellBookItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta SpellBookItemMeta = SpellBookItem.getItemMeta();
        SpellBookItemMeta.setDisplayName(color("&d&lSpell Book"));
        SpellBookItemMeta.setLore(Arrays.asList(color("&7Spell Book of " + player.getName())));
        SpellBookItem.setItemMeta(SpellBookItemMeta);
        //Race Skills
        //Demon race skills
        //GetRaceSkillBook
        RaceSkillBookItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta RaceSkillBookItemMeta = RaceSkillBookItem.getItemMeta();
        RaceSkillBookItemMeta.setDisplayName(color("&3&lRace Skill Book"));
        RaceSkillBookItemMeta.setLore(Arrays.asList(color("&7Race Skill Book of " + player.getName())));
        RaceSkillBookItem.setItemMeta(RaceSkillBookItemMeta);
        //YES
        YES = new ItemStack(Material.LIME_WOOL, 1);
        ItemMeta YESMeta = YES.getItemMeta();
        YESMeta.setDisplayName(color("&a&l[YES]"));
        YESMeta.setLore(Arrays.asList(color("&7Click if YES")));
        YES.setItemMeta(YESMeta);
        //NO
        NO = new ItemStack(Material.RED_WOOL, 1);
        ItemMeta NOMeta = NO.getItemMeta();
        NOMeta.setDisplayName(color("&4&l[NO]"));
        NOMeta.setLore(Arrays.asList(color("&7Click if NO")));
        NO.setItemMeta(NOMeta);
        //DemonsLItem
        DemonsLevitationItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta DemonsLevitationItemMeta = DemonsLevitationItem.getItemMeta();
        DemonsLevitationItemMeta.setDisplayName(color("&8&lDemon Art of Levitation"));
        if(skills.getDemonALevitation()==1){
            DemonsLevitationItemMeta.setLore(Arrays.asList(color("&2&l[UNLOCKED]"),color("&7This Race Skill allows you "),color("&7fly, but uses your mana for it!"), color("&7-20/s &bMana")));
        } else if (skills.getDemonALevitation()==0){
            DemonsLevitationItemMeta.setLore(Arrays.asList(color("&4&l[LOCKED]"),color("&7Click at Race Level 10 to unlock!"),color("&7This Race Skill allows you to fly "), color("&7-20/s &bMana")));

        }
        DemonsLevitationItem.setItemMeta(DemonsLevitationItemMeta);
        //Skills
        //GetSkillBook
        SkillBookItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta SkillBookItemMeta = SkillBookItem.getItemMeta();
        SkillBookItemMeta.setDisplayName(color("&c&lSkill Book"));
        SkillBookItemMeta.setLore(Arrays.asList(color("&7Skill Book of " + player.getName())));
        SkillBookItem.setItemMeta(SkillBookItemMeta);
        //AllSeeingEye
        allseeingeye = new ItemStack(Material.ENDER_EYE, 1);
        ItemMeta allseeingeyeMeta = allseeingeye.getItemMeta();
        allseeingeyeMeta.setDisplayName(color("&6&lAll-seeing Eye"));
        if(skills.getAllSESkill()==1){
            allseeingeyeMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&7Special Skill of the God of Knowledge"),color("&7This Skill shows you lots of info about "),color("&7other players"), color("&6&l[LEGENDARY]")));
        }else if(skills.getAllSESkill()==0){
            allseeingeyeMeta.setLore(Arrays.asList(color("&4&l[LOCKED]"),color("&7Special Skill of the God of Knowledge"),color("&7This Skill shows you lots of info about "),color("&7other players"),color("&7Costs 50 points"), color("&6&l[LEGENDARY]")));
        }

        allseeingeye.setItemMeta(allseeingeyeMeta);
        //Hider
        HiderSkillItem = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemMeta HiderSkillItemMeta = HiderSkillItem.getItemMeta();
        HiderSkillItemMeta.setDisplayName(color("&8&lHider"));
        if(skills.getHiderSkill()==1){
            HiderSkillItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),
                    color("&7This Skill allows you to hide "),
                    color("&7your stats, but can be overlooked"),
                    color("&7if used more powerfull skill/magic!"),
                    color("&7Level: " + skills.getHiderLevel()),
                    color("&5&l[EPIC]")));
        }else if(skills.getHiderSkill()==0){
            HiderSkillItemMeta.setLore(Arrays.asList(color("&4&l[LOCKED]"),
                    color("&7This Skill allows you to hide "),
                    color("&7your stats, but can be overlooked"),
                    color("&7if used more powerfull skill/magic!"),
                    color("&7Costs 20 points"),
                    color("&7Level: " + skills.getHiderLevel()),
                    color("&5&l[EPIC]")));
        }
        HiderSkillItem.setItemMeta(HiderSkillItemMeta);

        //Appraisal
        AppraisalItem = new ItemStack(Material.ENCHANTED_BOOK, skills.getAppraisalLevel());
        ItemMeta AppraisalItemMeta = AppraisalItem.getItemMeta();
        AppraisalItemMeta.setDisplayName(color("&3&lAppraisal"));
        if(skills.getAppraisalSkill()==1){
            AppraisalItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&7This Skill allows you to get some "),color("&7info about other players and things!"),
                    color("&a&l[COMMON]")));
        } else if (skills.getAppraisalSkill()==0){
            AppraisalItemMeta.setLore(Arrays.asList(color("&4&l[LOCKED]"),color("&7This Skill allows you to get some "), color("&7info about other players and things!"),
                    color("&a&l[COMMON]")));

        }
        AppraisalItem.setItemMeta(AppraisalItemMeta);

        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&6&lKerklyash GUI"))){

            //Player doesn´t have skills GUI opened
            return;

        }
        //Cancel all item  moving, editing, droping etc., and player inv too
        event.setCancelled(true);
        if(!event.getClickedInventory().equals(inv)){
            return;
        }


        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();
        ClickType click = event.getClick();

        Inventory magicGUI = Bukkit.createInventory(null,54, color("&d&lMagic GUI"));
        magicGUI.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        magicGUI.setItem(45,editItem(DAGUIItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));
        magicGUI.setItem(20,editItem(FireItem.clone(),1 ,Arrays.asList(color("&7Click to go to &4&lFire Magic &7Class"))));
        magicGUI.setItem(21,editItem(WaterItem.clone(),1,Arrays.asList(color("&7Click to go to &9&lWater Magic &7Class"))));
        magicGUI.setItem(22,editItem(EarthItem.clone(),1,Arrays.asList(color("&7Click to go to &8&lEarth Magic &7Class"))));
        magicGUI.setItem(23,editItem(LightningItem.clone(),1,Arrays.asList(color("&7Click to go to &b&lLightning Magic &7Class"))));
        magicGUI.setItem(24,editItem(SecretArtItem.clone(),1,Arrays.asList(color("&7Click to go to &5&lSecret Art &7Class"))));
        magicGUI.setItem(29,editItem(NatureItem.clone(),1,Arrays.asList(color("&7Click to go to &2&lNature Magic &7Class"))));
        magicGUI.setItem(46,editItem(SpellBookItem.clone(),1,Arrays.asList(color("&7Spell Book of " + player.getName()))));
        Inventory raceskillsGUI = Bukkit.createInventory(null,54,color("&3&lRace skills GUI"));
        raceskillsGUI.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        raceskillsGUI.setItem(45,editItem(DAGUIItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));
        if(skills.getDemon()>=1){
            raceskillsGUI.setItem(1, editItem(demonItem.clone(), skills.getDemon(), Arrays.asList(color("&6&lDEMON"+" " ))));
            if(skills.getDemonALevitation()==1){
                raceskillsGUI.setItem(10,editItem(DemonsLevitationItem.clone(),1,Arrays.asList(color("&2&l[UNLOCKED]"),("&7This Race Skill allows you "),
                        color("&7fly, but uses your mana for it!"))));
            }else if (skills.getDemonALevitation()==0){
                raceskillsGUI.setItem(10,editItem(DemonsLevitationItem.clone(),1,Arrays.asList(color("&4&l[LOCKED]"),("&7This Race Skill allows you "), color("&7fly, but uses your mana for it!"))));

            }
            raceskillsGUI.setItem(46,editItem(RaceSkillBookItem.clone(),1,Arrays.asList(color("&7Race Skill Book of " + player.getName()))));
   }
        Inventory skillsGUI = Bukkit.createInventory(null,54,color("&c&lSkills"));
        skillsGUI.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        skillsGUI.setItem(37,editItem(allseeingeye.clone(),1,Arrays.asList("")));
        skillsGUI.setItem(45,editItem(DAGUIItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));
        skillsGUI.setItem(10,editItem(AppraisalItem.clone(),skills.getAppraisalLevel(),Arrays.asList(color(""))));
        skillsGUI.setItem(46,editItem(SkillBookItem.clone(),1,Arrays.asList(color(""))));
        skillsGUI.setItem(28,editItem(HiderSkillItem.clone(),skills.getHiderLevel(),Arrays.asList()));


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
        racesGUI.setItem(18,editItem(DAGUIItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));

        Inventory DLYes = Bukkit.createInventory(null,27,color("&0     Become a &5&lDemon Lord&0?"));
        DLYes.setItem(11,editItem(YES.clone(),1,Arrays.asList("")));
        DLYes.setItem(15,editItem(NO.clone(),1,Arrays.asList("")));

        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        switch (slot) {
            case 10:
                if (click == ClickType.LEFT) {
                    player.openInventory(racesGUI);
                }
                break;
            case 19:
                if (click == ClickType.LEFT) {
                    player.openInventory(raceskillsGUI);
                }
                break;
            case 28:
                if (click == ClickType.LEFT) {
                    player.openInventory(magicGUI);
                }
                break;
            case 37:
                if (click == ClickType.LEFT) {
                    player.openInventory(skillsGUI);
                }
                break;

        }
        if(skills.getLevel()==50 && skills.getEvolve()==50&& skills.getDemonLordIs()!=1){
            if(skills.getKilledMonster()>=1000 && skills.getWitherkilled()>=3){
                switch (slot){
                    case 13:
                        if(click == ClickType.LEFT){
                            player.openInventory(DLYes);
                        }
                        break;
                }
            }

        }
        //Update the items after each click, even if its nothing!
        ItemStack profileItem = inv.getItem(4);


        inv.setItem(4, editItem(profileItem.clone(), 1, Arrays.asList(color("&eYour Profile " + player.getName()))));


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