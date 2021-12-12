package com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.Elements;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire.HellBeamFire;
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

import java.util.Arrays;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class FireMagicClickListener implements Listener {

    private ProfileManager profileManager;

    private ItemStack ScorchingPulseItem;

    private ItemStack HellRingProvidence;

    private ItemStack HellBeam;

    private ItemStack BlazingHeartBeat;

    private ItemStack pointsItem;
    private ItemStack DAGUIItem;
    //Magic
    private ItemStack FireItem;
    private ItemStack WaterItem;
    private ItemStack EarthItem;
    private ItemStack LightningItem;
    private ItemStack SecretArtItem;
    private ItemStack NatureItem;


    private ItemStack SpellBookItem;

    public FireMagicClickListener(Main main) {
        profileManager = main.getProfileManager();

        //DAGUI
        DAGUIItem = new ItemStack(Material.PAINTING,1);
        ItemMeta DAGUIItemMeta = DAGUIItem.getItemMeta();
        DAGUIItemMeta.setLore(Arrays.asList(color("&7Click to go back to &6&lDio Adventure GUI")));
        DAGUIItemMeta.setDisplayName(color("&6&lDio Adventure GUI"));
        DAGUIItem.setItemMeta(DAGUIItemMeta);

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
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        ClickType click = event.getClick();
        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
        int slot = event.getSlot();
        int points = skills.getPoints();
        int plevel = skills.getPowerlevel();

        //Skill points
        pointsItem = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta pointsItemMeta = pointsItem.getItemMeta();
        pointsItemMeta.setDisplayName(color("&eSkill points left"));
        pointsItemMeta.setLore(Arrays.asList(color("&7You have "+skills.getPoints()+" points left")));
        pointsItem.setItemMeta(pointsItemMeta);
        Inventory inv = event.getInventory();
        //GetSpellBook
        SpellBookItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta SpellBookItemMeta = SpellBookItem.getItemMeta();
        SpellBookItemMeta.setDisplayName(color("&d&lSpell Book"));
        SpellBookItemMeta.setLore(Arrays.asList(color("&7Spell Book of " + player.getName())));
        SpellBookItem.setItemMeta(SpellBookItemMeta);
        //ScorchingPulse
        ScorchingPulseItem = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta ScorchingPulseItemMeta = ScorchingPulseItem.getItemMeta();
        ScorchingPulseItemMeta.setDisplayName(color("&4&lScorching Pulse"));
        ScorchingPulseItemMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&5&l[TIER 4]"),color("&7This Magic allows you "),
                color("&7to shoot a Scorching Pulse"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
         ScorchingPulseItem.setItemMeta(ScorchingPulseItemMeta);
        //HellRingProvidence
        HellRingProvidence = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HellRingProvidenceMeta = ScorchingPulseItem.getItemMeta();
        HellRingProvidenceMeta.setDisplayName(color("&4&lHell Ring Providence"));
        HellRingProvidenceMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&6&l[TIER 5]"),color("&7This Magic allows you "),
                color("&7to shoot a Hell Ring Providence"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
         HellRingProvidence.setItemMeta(HellRingProvidenceMeta);
        //HellBeam
        HellBeam = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HellBeamMeta = HellBeam.getItemMeta();
        HellBeamMeta.setDisplayName(color("&4&lHell Beam"));
        HellBeamMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&6&l[TIER 5]"),color("&7This Magic allows you "),
                color("&7to shoot a Hell Beam"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));
        HellBeam.setItemMeta(HellBeamMeta);
        //Fire - BlazingHeartBeat
        BlazingHeartBeat = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta BlazingHeartBeatMeta = BlazingHeartBeat.getItemMeta();
        BlazingHeartBeatMeta.setDisplayName(color("&4&lBlazing Heart Beat"));
        BlazingHeartBeatMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&5&l[TIER 3]"),color("&7This Magic allows you "),
                    color("&7to shoot a Blazing Heart Beat"),color("&7- 100&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s")));

        BlazingHeartBeat.setItemMeta(BlazingHeartBeatMeta);

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


        if (!event.getView().getTitle().equalsIgnoreCase(color("&4&lFire Magic"))) {


            return;
        }
        event.setCancelled(true);
        if (!event.getClickedInventory().equals(inv)) {
            return;
        }
        switch (slot) {
            case 10:
                if (click == ClickType.LEFT) {
                    if(skills.getPoints()>=10){
                        skills.setPoints(points-10);
                        skills.setHaveHealMagicT1(1);
                        skills.setPowerlevel(plevel+40);
                    }else if(!(skills.getPoints()>=10) && skills.getHaveHealMagicT1()!=1){
                        player.sendMessage(color("&4You don´t have 10 points to learn this spell!"));
                    }else if(skills.getHaveHealMagicT1()==1)
                        player.sendMessage(color("&aYou already learned this magic spell!"));
                }
                break;
            case 37:
                if(click == ClickType.LEFT){
                    if(skills.getPoints()>=40&& skills.getFireSunBallHave()!=1){
                        skills.setPoints(points-40);
                        skills.setFireSunBallHave(1);
                        skills.setFireSunBallLevel(1);
             }else if(!(skills.getPoints()>=10) && skills.getFireSunBallHave()!=1){
                        player.sendMessage(color("&4You don´t have 40 points to learn this spell!"));
                    }else if(skills.getFireSunBallHave()==1)
                        player.sendMessage(color("&aYou already learned this magic spell!"));
                }
                break;
            case 28:
                if(click == ClickType.LEFT){
                    if(skills.getPoints()>=30&& skills.getScorchingPulseHave()!=1){
                        skills.setPoints(points-30);
                        skills.setScorchingPulseHave(1);
                        skills.setScorchingPulseLevel(1);
                        inv.setItem(38,editItem(ScorchingPulseItem.clone(),1,Arrays.asList(color("&a&l[UNLOCKED]"),color("&5&l[TIER 4]"),color("&7This Magic allows you "),
                                color("&7to shoot a Scorching Pulse"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s"))));

                    }else if(!(skills.getPoints()>=10) && skills.getScorchingPulseHave()!=1){
                        player.sendMessage(color("&4You don´t have 30 points to learn this spell!"));
                    }else if(skills.getScorchingPulseHave()==1)
                        player.sendMessage(color("&aYou already learned this magic spell!"));
                }
                break;
            case 29:
                if(click == ClickType.LEFT){
                    if(skills.getPoints()>=30&& skills.getBlazingHeartBeatHave()!=1){
                        skills.setPoints(points-30);
                        skills.setBlazingHeartBeatHave(1);
                        skills.setBlazingHeartBeatLevel(1);
                        inv.setItem(38,editItem(ScorchingPulseItem.clone(),1,Arrays.asList(color("&a&l[UNLOCKED]"),color("&5&l[TIER 4]"),color("&7This Magic allows you "),
                                color("&7to shoot a Scorching Pulse"),color("&7- 50&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s"))));
                        player.sendMessage(color("&eYou have acquired new Magic Spell: &4&lBlazing Heart Beat&e!"));
                    }else if(!(skills.getPoints()>=30) && skills.getBlazingHeartBeatHave()!=1){
                        player.sendMessage(color("&4You don´t have 30 points to learn this spell!"));
                    }else if(skills.getBlazingHeartBeatHave()==1)
                        player.sendMessage(color("&aYou already learned this magic spell!"));
                }
                break;
            case 38:
                if(click == ClickType.LEFT){
                    if(skills.getPoints()>=40&& skills.getHellBeamMagic()!=1){
                        skills.setPoints(points-40);
                        skills.setHellBeamMagic(1);
                        skills.setHellBeamLevel(1);
                        inv.setItem(38,editItem(HellBeam.clone(),1,Arrays.asList(color("&a&l[UNLOCKED]"),color("&6&l[TIER 5]"),color("&7This Magic allows you "),
                                color("&7to shoot a Hell Beam"),color("&7- 150&b Mana"), color("&7- &c5 DMG"), color("&7Cooldown -&e10s"))));

                    }else if(!(skills.getPoints()>=40) && skills.getHellBeamMagic()!=1){
                        player.sendMessage(color("&4You don´t have 40 points to learn this spell!"));
                    }else if(skills.getHellBeamMagic()==1)
                        player.sendMessage(color("&aYou already learned this magic spell!"));
                }
                break;
            case 39:
                if(click == ClickType.LEFT){
                    if(skills.getPoints()>=10&& skills.getHellRingProvidenceHave()!=1){
                        skills.setPoints(points-10);
                        skills.setHellRingProvidenceHave(1);
                        skills.setHellRingProvidenceLevel(1);
                        inv.setItem(39,editItem(HellRingProvidence.clone(),1,Arrays.asList("")));
                    }else if(!(skills.getPoints()>=10) && skills.getHellRingProvidenceHave()!=1){
                        player.sendMessage(color("&4You don´t have 10 points to learn this spell!"));
                    }else if(skills.getScorchingPulseHave()==1)
                        player.sendMessage(color("&aYou already learned this magic spell!"));
                }
                break;


            case 45:
                if( click == ClickType.LEFT){
                    player.openInventory(magicGUI);
                }
                break;
        }




        ItemStack pointsItem = inv.getItem(0);
        ItemStack SunBallItem = inv.getItem(37);


        inv.setItem(0, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        inv.setItem(37,editItem(SunBallItem.clone(),1,Arrays.asList(color(""))));


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
