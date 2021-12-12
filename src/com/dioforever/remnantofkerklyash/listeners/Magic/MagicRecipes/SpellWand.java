package com.dioforever.remnantofkerklyash.listeners.Magic.MagicRecipes;

import com.dioforever.remnantofkerklyash.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

import static com.dioforever.remnantofkerklyash.Utils.color;


public class SpellWand implements Listener {
    private ItemStack SpellWand;
    private ItemStack MagicalOreLVL1 ;

    private Plugin plugin = com.dioforever.remnantofkerklyash.Main.getPlugin(Main.class);
    public void giveItems(Player player){
        //SpellWand
        SpellWand = new ItemStack(Material.STICK,1);
        ItemMeta SpellWandItemMeta = SpellWand.getItemMeta();
        SpellWandItemMeta.setDisplayName(color("&b&lSpell Wand of Wondering Fire"));
        SpellWandItemMeta.setLore(Arrays.asList(color("&7This wand is specialy "),color("&7boosting your magic")));
        SpellWand.setItemMeta(SpellWandItemMeta);

        player.getInventory().addItem(SpellWand);
    }
    public void customRecipe(){
        //Magic Ore LVL1
        MagicalOreLVL1 = new ItemStack(Material.PHANTOM_MEMBRANE,1);
        ItemMeta MagicalOreLVL1Meta = MagicalOreLVL1.getItemMeta();
        MagicalOreLVL1Meta.setLore(Arrays.asList(color("&7Magical Ore used to make special magic items!")));
        MagicalOreLVL1Meta.setDisplayName(color("&b&lMagic Ore"));
        MagicalOreLVL1.setItemMeta(MagicalOreLVL1Meta);

    }
}
