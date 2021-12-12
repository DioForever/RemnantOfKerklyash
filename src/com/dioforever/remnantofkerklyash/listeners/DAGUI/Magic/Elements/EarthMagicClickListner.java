package com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.Elements;

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

import java.util.Arrays;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class EarthMagicClickListner implements Listener {

    private ProfileManager profileManager;

    private ItemStack HarvestMine;


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

    public EarthMagicClickListner(Main main) {
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
        //Earth - HarvestMine
        HarvestMine = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta HarvestMineMeta = HarvestMine.getItemMeta();
        HarvestMineMeta.setDisplayName(color("&8&lHarvest Mine"));
        HarvestMineMeta.setLore(Arrays.asList(color("&a&l[UNLOCKED]"),color("&a&l[TIER 1]"),color("&7This Magic allows you "),
                    color("&7to get mining boost!"),color("&7- 10/s&b Mana"), color("&7 Cost - 10 points")));

        HarvestMine.setItemMeta(HarvestMineMeta);

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


        if (!event.getView().getTitle().equalsIgnoreCase(color("&8&lEarth Magic"))) {


            return;
        }
        event.setCancelled(true);
        if (!event.getClickedInventory().equals(inv)) {
            return;
        }
        switch (slot) {
            case 10:
                if (click == ClickType.LEFT) {
                    if(skills.getPoints()>=10&& skills.getHarvestMineHave()!=1){
                        skills.setPoints(points-10);
                        skills.setHarvestMineHave(1);
                        skills.setHarvestMineLevel(1);
                        player.sendMessage(color("&eYou have acquired new Magic Spell: &8&lHarvest Mine&e!"));
                        inv.setItem(10,editItem(HarvestMine.clone(),1,Arrays.asList("")));
                    }else if(!(skills.getPoints()>=10) && skills.getHarvestMineHave()!=1){
                        player.sendMessage(color("&4You don´t have 10 points to learn this spell!"));
                    }else if(skills.getHarvestMineHave()==1)
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
