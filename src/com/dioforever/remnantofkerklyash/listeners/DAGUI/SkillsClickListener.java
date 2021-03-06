package com.dioforever.remnantofkerklyash.listeners.DAGUI;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class SkillsClickListener implements Listener {

    private ItemStack DemonLordItem;
    private ItemStack LifeForceItem;
    private ItemStack pointsItem;
    private ItemStack profileItem;
    private ItemStack ManaCapabilityItem;
    private ItemStack ManaManipulationItem;
    //Profile = level, race, name, power level in numbers
    private ItemStack raceItem;
    private ItemStack magicItem;
    private ItemStack raceSkillsItem;
    private ItemStack skillItem;
    //Skills
    private ItemStack SkillBookItem;
    private ItemStack allseeingeye;
    private ItemStack HiderSkillItem;





    private ProfileManager profileManager;

    public SkillsClickListener(Main main){
        profileManager = main.getProfileManager();
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){


        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&c&lSkills"))){


            return;
        }
        event.setCancelled(true);
        if(!event.getClickedInventory().equals(inv)){
            return;
        }
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();
        ClickType click = event.getClick();

        List<String> racelist = new ArrayList<>();
        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&eSkill points left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have "+skills.getPoints()+" &7left")));
        pointsItem.setItemMeta(pointsItemMeta);

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
            race = color("&5&lMyrk??flar&e");
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
        allseeingeyeMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&7Special Skill of the God of Knowledge"),color("&7This Skill shows you lots of info about "),color("&7other players"), color("&6&l[LEGENDARY]")));
        allseeingeye.setItemMeta(allseeingeyeMeta);
        //LifeForceItem
        LifeForceItem = new ItemStack(Material.RED_DYE, 1);
        ItemMeta LifeForceItemMeta = LifeForceItem.getItemMeta();
        LifeForceItemMeta.setDisplayName(color("&4&lLife Force"));
        LifeForceItemMeta.setLore(Arrays.asList(color("&7Life Force is energy that is sometimes"), color("&7used for skills and you can get"),
                color("&7more of life force by leveling"),color("&7your race."), color("&7Life Force: &4"+skills.getLifeForce())));
        LifeForceItem.setItemMeta(LifeForceItemMeta);
        //Demon Lord Egg
        DemonLordItem = new ItemStack(Material.DRAGON_EGG,1);
        ItemMeta DemonLordItemMeta = DemonLordItem.getItemMeta();
        DemonLordItemMeta.setDisplayName(color("&5&lDemon Lord Egg"));
        DemonLordItemMeta.setLore(Arrays.asList(color("&7With Demon Lord Egg "),color("&7you can evolve into Demon Lord"), color("&7under specific circumstances:"),
                color("&7 1. Kill Withers "+skills.getWitherkilled()+"&7/3"), color("&7 2. Kill monsters/animals "+ skills.getKilledMonster()+"&7/1000 "),
                color("&7After completion of these requirements"), color("&d&l[CLICK]")));
        DemonLordItem.setItemMeta(DemonLordItemMeta);
        //Hider
        HiderSkillItem = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemMeta HiderSkillItemMeta = HiderSkillItem.getItemMeta();
        HiderSkillItemMeta.setDisplayName(color("&8&lHider"));
            HiderSkillItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),
                    color("&7This Skill allows you to hide "),
                    color("&7your stats, but can be overlooked"),
                    color("&7if used more powerfull skill/magic!"),
                    color("&7Level: " + skills.getHiderLevel()),
                    color("&5&l[EPIC]")));
        HiderSkillItem.setItemMeta(HiderSkillItemMeta);


        Inventory DioAdventureGUI = Bukkit.createInventory(null, 54, color("&6&lKerklyash GUI"));



        DioAdventureGUI.setItem(10,editItem(raceItem.clone(),1,Arrays.asList(color("&7Click to open Races"))));
        DioAdventureGUI.setItem(4,editItem(profileItem.clone(),1,Arrays.asList(color("&eYour Profile " + player.getName()))));
        DioAdventureGUI.setItem(19,editItem(raceSkillsItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));
        DioAdventureGUI.setItem(28,editItem(magicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        DioAdventureGUI.setItem(37,editItem(skillItem.clone(),1,Arrays.asList(color("&7Click to open &c&lSkills GUI"))));
        DioAdventureGUI.setItem(16, editItem(ManaCapabilityItem.clone(),1,Arrays.asList(color("&7You can see here how much "),color("&7mana you are able to use &9&l" + skills.getManaCap()))));
        DioAdventureGUI.setItem(25,editItem(ManaManipulationItem.clone(),1,Arrays.asList(color("&7You can see here how you "),color("&7are great with Mana Manipulation &9&l" + skills.getManaMan()))));
        DioAdventureGUI.setItem(34,editItem(LifeForceItem.clone(),1,Arrays.asList()));
        if(skills.getLevel()==50 && skills.getEvolve()==50 && skills.getDemonLordIs()!=1){
            DioAdventureGUI.setItem(13,editItem(DemonLordItem.clone(),1,Arrays.asList("")));
        }


        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }

        int human = skills.getHuman(), demon = skills.getDemon(), elf = skills.getElf(), dwarf = skills.getDwarf(),
                kitsune = skills.getKitsune(), vampire = skills.getVampire1(), raiju = skills.getRaiju(), points = skills.getPoints(), racereset = skills.getRacereset()
                , appraisalL = skills.getAppraisalLevel(), allseeingeyelvl = skills.getAllSELevel(), hiderlevel = skills.getHiderLevel();

        switch (slot){
            case 10:
                if (click == ClickType.LEFT) {
                    if (click == ClickType.LEFT) {
                        if(skills.getPoints()>=20 &&skills.getAppraisalLevel()!=5){
                            skills.setPoints(points-20);
                            skills.setAppraisalSkill(1);
                            skills.setAppraisalLevel(appraisalL+1);
                        }else if(!(skills.getPoints()>=20) && skills.getAppraisalLevel()!=5){
                            player.sendMessage(color("&4You don??t have 20 points to learn this skill or you already learned everything!"));
                        }else if(skills.getAppraisalLevel()>=5){
                            player.sendMessage(color("&4You have already maxed out this skill! (5)!"));
                        }
                    }
                }
                break;
            case 28:
            if(click == ClickType.LEFT){
                if(skills.getPoints()>=20 &&!(skills.getHiderLevel()>=5)){
                    skills.setHiderSkill(1);
                    skills.setHiderLevel(hiderlevel+1);
                    skills.setPoints(points-20);
                }else if(!(skills.getPoints()>=20)&&skills.getHiderSkill()!=1){
                    player.sendMessage(color("&4You don??t have 20 points to learn this spell!"));
                }else if(skills.getHiderLevel()==5){
                    player.sendMessage(color("&4You have already maxed out this skill! (5)!"));
                }
            }

            break;
            case 37:
                if(click == ClickType.LEFT){
                    if(skills.getPoints()>=50){
                            skills.setAllSESkill(1);
                            skills.setAllSELevel(allseeingeyelvl+1);
                            skills.setPoints(points-50);
                            inv.setItem(37,editItem(allseeingeye.clone(),1,Arrays.asList("")));

                    }else if(!(skills.getPoints()>=20)&& skills.getAppraisalLevel()>=6){
                        player.sendMessage(color("&4You don??t have 50 points to learn this spell or you already learned everything!"));
                    }
                }

                break;
            case 45:
                if (click == ClickType.LEFT) {
                    player.openInventory(DioAdventureGUI);
                }
                break;
            case 46:
                if(click == ClickType.LEFT){
                    player.getInventory().addItem(SkillBookItem);
                }
                break;

        }
        ItemStack pointsItem = inv.getItem(0);

        ItemStack AppraisalItem = inv.getItem(10);
        ItemStack HiderItem = inv.getItem(28);

        inv.setItem(10,editItem(AppraisalItem.clone(),skills.getAppraisalLevel(),Arrays.asList(color(""))));
        inv.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        inv.setItem(28,editItem(HiderItem.clone(),skills.getHiderLevel(),Arrays.asList("")));



    }
    public ItemStack editItem(ItemStack item, int amount, List<String> lore){
        if(amount == 0) {
            //Can??t have item with amount 0
            amount = 1;
        }
        item.setAmount(amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        return item;

    }

}

