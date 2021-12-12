package com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.type.Fire;
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

public class MagicClickListener implements Listener {

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
    //races
    //magic
    private ItemStack BackToMagicItem;
    private ItemStack HealMagicT1Item;
    private ItemStack SpellBookItem;
    //SunBall
    private ItemStack SunBallItem;
    //ScorchingPulse
    private ItemStack ScorchingPulseItem;
    //HellRingProvidence
    private ItemStack HellRingProvidence;
    //HellBeam
    private ItemStack HellBeam;
    //Blazing Heart Beat
    private ItemStack BlazingHeartBeat;

    //Lightning
    private ItemStack LightningBullet;

    //Earth
    private ItemStack HarvestMine;


    private ProfileManager profileManager;

    public MagicClickListener(Main main){
        profileManager = main.getProfileManager();
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&d&lMagic GUI"))){


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
        if(skills.getVampire1()>= 20&& skills.getDemonLordIs()!=1){
            String race = new String();
            race = color("&8&lVampire Lord&e");
            racelist.add(race);
        }
        //Vampire end

        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&eSkill points left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have "+skills.getPoints()+" &7left")));
        pointsItem.setItemMeta(pointsItemMeta);


        //GetSpellBook
        SpellBookItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta SpellBookItemMeta = SpellBookItem.getItemMeta();
        SpellBookItemMeta.setDisplayName(color("&d&lSpell Book"));
        SpellBookItemMeta.setLore(Arrays.asList(color("&7Spell Book of " + player.getName())));
        SpellBookItem.setItemMeta(SpellBookItemMeta);


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
        //MagicItem
        BackToMagicItem = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta BackToMagicItemMeta = BackToMagicItem.getItemMeta();
        BackToMagicItemMeta.setDisplayName(color("&d&lMagic GUI"));
        BackToMagicItemMeta.setLore(Arrays.asList(color("&7Click to go back to &d&lMagic GUI")));
        BackToMagicItem.setItemMeta(BackToMagicItemMeta);
        //LifeForceItem
        LifeForceItem = new ItemStack(Material.RED_DYE, 1);
        ItemMeta LifeForceItemMeta = LifeForceItem.getItemMeta();
        LifeForceItemMeta.setDisplayName(color("&4&lLife Force"));
        LifeForceItemMeta.setLore(Arrays.asList(color("&7Life Force is energy that is sometimes"), color("&7used for skills and you can get"),
                color("&7more of life force by leveling"),color("&7your race."), color("&7Life Force: &4"+skills.getLifeForce())));
        LifeForceItem.setItemMeta(LifeForceItemMeta);
        //HealMagicT1Item
        HealMagicT1Item = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HealMagicT1ItemMeta = ManaManipulationItem.getItemMeta();
        HealMagicT1ItemMeta.setDisplayName(color("&2&lHeal Magic"));
        if(skills.getHaveHealMagicT1()==1){
            HealMagicT1ItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&a&l[TIER 1]"),color("&7This Magic allows you "),
                    color("&7to heal yourself!"),color("&7- 50&b Mana"), color("&7+ &c5 HP"), color("&7Cooldown -&e10s")));
        } else if (skills.getDemonALevitation()==0){
            HealMagicT1ItemMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&7This Magic allows you "),
                    color("&7to heal yourself"),color("&7Costs 50 points"),color("&7- 50&b Mana"), color("&7+ &c5 HP"), color("&7Cooldown -&e10s"),color("&a&l[TIER 1]")));

        } HealMagicT1Item.setItemMeta(HealMagicT1ItemMeta);
        //Demon Lord Egg
        DemonLordItem = new ItemStack(Material.DRAGON_EGG,1);
        ItemMeta DemonLordItemMeta = DemonLordItem.getItemMeta();
        DemonLordItemMeta.setDisplayName(color("&5&lDemon Lord Egg"));
        DemonLordItemMeta.setLore(Arrays.asList(color("&7With Demon Lord Egg "),color("&7you can evolve into Demon Lord"), color("&7under specific circumstances:"),
                color("&7 1. Kill Withers "+skills.getWitherkilled()+"&7/3"), color("&7 2. Kill monsters/animals "+ skills.getKilledMonster()+"&7/1000 "),
                color("&7After completion of these requirements"), color("&d&l[CLICK]")));
        DemonLordItem.setItemMeta(DemonLordItemMeta);
        //SunBallItem
        SunBallItem = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta SunBallItemMeta = ManaManipulationItem.getItemMeta();
        SunBallItemMeta.setDisplayName(color("&4&lSun Ball"));
        if(skills.getFireSunBallHave()==1){
            SunBallItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&6&l[TIER 4]"),color("&7This Magic allows you "),
                    color("&7to shoot a sun"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
        } else if (skills.getFireSunBallHave()==0){
            SunBallItemMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&6&l[TIER 4]"),color("&7This Magic allows you "),
                    color("&7to shoot a sun"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));

        }
        SunBallItem.setItemMeta(SunBallItemMeta);
        //ScorchingPulse
        ScorchingPulseItem = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta ScorchingPulseItemMeta = ScorchingPulseItem.getItemMeta();
        ScorchingPulseItemMeta.setDisplayName(color("&4&lScorching Pulse"));
        if(skills.getScorchingPulseHave()==1){
            ScorchingPulseItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&5&l[TIER 3]"),color("&7This Magic allows you "),
                    color("&7to shoot a Scorching Pulse"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
        } else if (skills.getScorchingPulseHave()==0){
            ScorchingPulseItemMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&5&l[TIER 3]"),color("&7This Magic allows you "),
                    color("&7to shoot a Scorching Pulse"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));

        }
        ScorchingPulseItem.setItemMeta(ScorchingPulseItemMeta);
        Inventory DioAdventureGUI = Bukkit.createInventory(null, 54, color("&6&lKerklyash GUI"));
        //HellRingProvidence
        HellRingProvidence = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HellRingProvidenceMeta = ScorchingPulseItem.getItemMeta();
        HellRingProvidenceMeta.setDisplayName(color("&4&lHell Ring Providence"));
        if(skills.getHellRingProvidenceHave()==1){
            HellRingProvidenceMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&6&l[TIER 4]"),color("&7This Magic allows you "),
                    color("&7to shoot a Hell Ring Providence"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
        } else if (skills.getHellRingProvidenceHave()==0){
            HellRingProvidenceMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&6&l[TIER 4]"),color("&7This Magic allows you "),
                    color("&7to shoot a Hell Ring Providence"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));

        }
        HellRingProvidence.setItemMeta(HellRingProvidenceMeta);
        //HellBeam
        HellBeam = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HellBeamMeta = HellBeam.getItemMeta();
        HellBeamMeta.setDisplayName(color("&4&lHell Beam"));
        if(skills.getHellBeamMagic()==1){
            HellBeamMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&6&l[TIER 4]"),color("&7This Magic allows you "),
                    color("&7to shoot a Hell Beam"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
        } else if (skills.getHellBeamMagic()==0){
            HellBeamMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&6&l[TIER 4]"),color("&7This Magic allows you "),
                    color("&7to shoot a Hell Beam"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));

        }
        HellBeam.setItemMeta(HellBeamMeta);
        //Fire - BlazingHeartBeat
        BlazingHeartBeat = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta BlazingHeartBeatMeta = BlazingHeartBeat.getItemMeta();
        BlazingHeartBeatMeta.setDisplayName(color("&4&lBlazing Heart Beat"));
        if(skills.getBlazingHeartBeatHave()==1){
            BlazingHeartBeatMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&5&l[TIER 3]"),color("&7This Magic allows you "),
                    color("&7to shoot a Blazing Heart Beat"),color("&7- 100&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
        } else if (skills.getBlazingHeartBeatHave()==0){
            BlazingHeartBeatMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&5&l[TIER 3]"),color("&7This Magic allows you "),
                    color("&7to shoot a Blazing Heart Beat"),color("&7- 100&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));

        }
        BlazingHeartBeat.setItemMeta(BlazingHeartBeatMeta);

        //LightningBullet
        LightningBullet = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta LightningBulletMeta = LightningBullet.getItemMeta();
        LightningBulletMeta.setDisplayName(color("&b&lLightning Bullet"));
        if(skills.getLightningBulletHave()==1){
            LightningBulletMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&a&l[TIER 1]"),color("&7This Magic allows you "),
                    color("&7to shoot a &bLightning Bullet"),color("&7- 150&b Mana"), color("&7- &c2 DMG"), color("&7Cooldown -&e10s")));
        } else if (skills.getLightningBulletHave()==0){
            LightningBulletMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&a&l[TIER 1]"),color("&7This Magic allows you "),
                    color("&7to shoot a &bLightning Bullet"),color("&7- 150&b Mana"), color("&7- &c2 DMG"), color("&7Cooldown -&e10s")));

        }
        LightningBullet.setItemMeta(LightningBulletMeta);
        //Earth - HarvestMine
        HarvestMine = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HarvestMineMeta = HarvestMine.getItemMeta();
        HarvestMineMeta.setDisplayName(color("&8&lHarvest Mine"));
        if(skills.getHarvestMineHave()==1){
            HarvestMineMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&a&l[TIER 1]"),color("&7This Magic allows you "),
                    color("&7to get mining boost!"),color("&7- 10/s&b Mana"), color("&7 Cost - 10 points")));
        } else if (skills.getHarvestMineHave()==0){
            HarvestMineMeta.setLore(Arrays.asList(color("&c&l[LOCKED]"),color("&a&l[TIER 1]"),color("&7This Magic allows you "),
                    color("&7to get mining boost!"),color("&7- 10/s&b Mana"), color("&7 Cost - 10 points")));

        }
        HarvestMine.setItemMeta(HarvestMineMeta);



        DioAdventureGUI.setItem(10,editItem(raceItem.clone(),1,Arrays.asList(color("&7Click to open Races"))));
        DioAdventureGUI.setItem(4,editItem(profileItem.clone(),1,Arrays.asList(color("&eYour Profile " + player.getName()))));
        DioAdventureGUI.setItem(19,editItem(raceSkillsItem.clone(),1,Arrays.asList(color("&6&lDio Adventure GUI"))));
        DioAdventureGUI.setItem(28,editItem(magicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        DioAdventureGUI.setItem(37,editItem(skillItem.clone(),1,Arrays.asList(color("&7Click to open &c&lSkills GUI"))));
        DioAdventureGUI.setItem(16, editItem(ManaCapabilityItem.clone(),1,Arrays.asList(color("&7You can see here how much "),color("&7mana you are able to use &9&l" + skills.getManaCap()))));
        DioAdventureGUI.setItem(25,editItem(ManaManipulationItem.clone(),1,Arrays.asList(color("&7You can see here how you "),color("&7are great with Mana Manipulation &9&l" + skills.getManaMan()))));
        DioAdventureGUI.setItem(34,editItem(LifeForceItem.clone(),1,Arrays.asList()));
        if(skills.getLevel()==50 && skills.getEvolve()==50&&skills.getDemonLordIs()!=1){
            DioAdventureGUI.setItem(13,editItem(DemonLordItem.clone(),1,Arrays.asList("")));
        }

        Inventory NatureMagicGUI = Bukkit.createInventory(null,54,color("&2&lNature Magic"));
        NatureMagicGUI.setItem(0,editItem(pointsItem.clone(),skills.getPoints(),Arrays.asList("")));
        NatureMagicGUI.setItem(45,editItem(BackToMagicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        if(skills.getHaveHealMagicT1()==1){
            NatureMagicGUI.setItem(10,editItem(HealMagicT1Item.clone(),1,Arrays.asList(color("&2&l[UNLOCKED]"),("&7This Race Skill allows you "), color("&7to heal yourself!"))));
        }else if (skills.getHaveHealMagicT1()==0){
            NatureMagicGUI.setItem(10,editItem(HealMagicT1Item.clone(),1,Arrays.asList(color("&4&l[LOCKED]"),("&7This Race Skill allows you "), color("&7to heal yourself!"))));

        }
        Inventory LightningMagicGUI = Bukkit.createInventory(null,54,color("&b&lLightning Magic"));
        LightningMagicGUI.setItem(0,editItem(pointsItem.clone(),skills.getPoints(),Arrays.asList("")));
        LightningMagicGUI.setItem(45,editItem(BackToMagicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        LightningMagicGUI.setItem(10,editItem(LightningBullet.clone(),1,Arrays.asList("")));

        Inventory FireMagicGUI = Bukkit.createInventory(null,54,color("&4&lFire Magic"));
        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        FireMagicGUI.setItem(37,editItem(SunBallItem.clone(),1,Arrays.asList("")));
        FireMagicGUI.setItem(28,editItem(ScorchingPulseItem.clone(),1,Arrays.asList("")));
        FireMagicGUI.setItem(29,editItem(BlazingHeartBeat.clone(),1,Arrays.asList("")));
        FireMagicGUI.setItem(0,editItem(pointsItem.clone(),skills.getPoints(),Arrays.asList("")));
        FireMagicGUI.setItem(45,editItem(BackToMagicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        FireMagicGUI.setItem(39,editItem(HellRingProvidence.clone(),1,Arrays.asList("")));
        FireMagicGUI.setItem(38,editItem(HellBeam.clone(),1,Arrays.asList("")));


        Inventory EarthMagicGUI = Bukkit.createInventory(null,54,color("&8&lEarth Magic"));
        EarthMagicGUI.setItem(0,editItem(pointsItem.clone(),skills.getPoints(),Arrays.asList("")));
        EarthMagicGUI.setItem(45,editItem(BackToMagicItem.clone(),1,Arrays.asList(color("&7Click to open &d&lMagic GUI"))));
        EarthMagicGUI.setItem(10,editItem(HarvestMine.clone(),1,Arrays.asList("")));

        int human = skills.getHuman(), demon = skills.getDemon(), elf = skills.getElf(), dwarf = skills.getDwarf(),
                kitsune = skills.getKitsune(), vampire = skills.getVampire1(), raiju = skills.getRaiju(), points = skills.getPoints(), racereset = skills.getRacereset();

        switch (slot){
            case 45:
                if (click == ClickType.LEFT) {
                    player.openInventory(DioAdventureGUI);
                }
                break;
            case 20:
                if(click == ClickType.LEFT){
                    player.openInventory(FireMagicGUI);
                }
                break;
            case 22:
                if(click == ClickType.LEFT){
                    player.openInventory(EarthMagicGUI);
                }
                break;
            case 23:
                if(click == ClickType.LEFT){
                    player.openInventory(LightningMagicGUI);
                }
                break;
            case 29:
                if(click == ClickType.LEFT){
                    player.openInventory(NatureMagicGUI);
                }
                break;
            case 46:
                if(click == ClickType.LEFT){
                    player.getInventory().addItem(SpellBookItem);
                }
                break;

        }
        ItemStack pointsItem = inv.getItem(0);

        inv.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );




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

