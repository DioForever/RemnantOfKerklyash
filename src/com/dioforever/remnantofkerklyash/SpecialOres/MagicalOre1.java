package com.dioforever.remnantofkerklyash.SpecialOres;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class MagicalOre1 implements Listener {
    private ItemStack MagicalOreLVL1;
    public MagicalOre1() {
        //Magic Ore LVL1
        MagicalOreLVL1 = new ItemStack(Material.PHANTOM_MEMBRANE,1);
        ItemMeta MagicalOreLVL1Meta = MagicalOreLVL1.getItemMeta();
        MagicalOreLVL1Meta.setLore(Arrays.asList(color("&7Magical Ore used to make special magic items!")));
        MagicalOreLVL1Meta.setDisplayName(color("&b&lMagic Ore"));
        MagicalOreLVL1.setItemMeta(MagicalOreLVL1Meta);
    }
    @EventHandler
    public void onPlayerBreakBlockEvent(BlockBreakEvent event){
        if(event.getBlock().getType() == Material.DIAMOND_ORE){
            Player player = event.getPlayer();
            Location Bloc = event.getBlock().getLocation();

            Random randomCh = new Random();
            int min = 1;
            int max = 5;
            int Chance = randomCh.nextInt((max-min) + 1) + min;
            if(Chance == 5){
                Bloc.getWorld().dropItemNaturally(Bloc,MagicalOreLVL1);

            }

            }
        }
    }
