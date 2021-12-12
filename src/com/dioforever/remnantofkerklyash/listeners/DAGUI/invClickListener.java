package com.dioforever.remnantofkerklyash.listeners.DAGUI;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.Utils.*;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.attribute.Attribute;
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

public class invClickListener implements Listener {

    private ProfileManager profileManager;

    public invClickListener(Main main){
        profileManager = main.getProfileManager();
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&e&lSkills GUI"))){

            //Player doesn´t have skills GUI opened
            return;

        }
        //Cancel all item  moving, editing, droping etc., and player inv too
        event.setCancelled(true);
        if(!event.getClickedInventory().equals(inv)){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();
        ClickType click = event.getClick();
        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();
        int points = skills.getPoints(),health = skills.getHealth(), intel = skills.getIntelligence(), agil = skills.getAgility(), plevel = skills.getPowerlevel();

        switch (slot) {
            case 19:
                //Health slot
                if(health == 0 && click == ClickType.RIGHT || health == 10 && click == ClickType.LEFT){
                    //If player tries to go below minimum / above maximum points.
                    return;

                }
                if(click == ClickType.LEFT){
                        //does player have enough points to add?
                    if(points == 0){
                        //Player doesnt have points, we will do nothing and end the code here
                        return;
                    }else {
                        //Player does! Lets update the variables.
                        skills.setPoints(points - 1);
                        skills.setHealth(health + 1);
                        skills.setPowerlevel(plevel + 1);
                    }
                }else{
                    //Its right click (decrease)
                    skills.setHealth(health - 1);
                    skills.setPoints(points + 1);
                    skills.setPowerlevel(plevel - 1);
                }
                break;
            case 20:
                if(intel == 0 && click == ClickType.RIGHT || intel == 100 && click == ClickType.LEFT){
                    //If player tries to go below minimum / above maximum points.
                    return;

                }
                if(click == ClickType.LEFT){
                    //does player have enough points to add?
                    if(points == 0){
                        //Player doesnt have points, we will do nothing and end the code here
                        return;
                    }else {
                        //Player does! Lets update the variables.
                        skills.setPoints(points - 1);
                        skills.setIntelligence(intel + 1);
                        skills.setPowerlevel(plevel + 1);
                    }
                }else{
                    //Its right click (decrease)
                    skills.setIntelligence(intel - 1);
                    skills.setPoints(points + 1);
                    skills.setPowerlevel(plevel - 1);
                }
                break;
            case 21:
                if(agil == 0 && click == ClickType.RIGHT || agil == 10 && click == ClickType.LEFT){
                    //If player tries to go below minimum / above maximum points.
                    return;

                }
                if(click == ClickType.LEFT){
                    //does player have enough points to add?
                    if(points == 0){
                        //Player doesnt have points, we will do nothing and end the code here
                        return;
                    }else {
                        //Player does! Lets update the variables.
                        skills.setPoints(points - 1);
                        skills.setAgility(agil + 1);
                        skills.setPowerlevel(plevel + 1);
                    }
                }else{
                    //Its right click (decrease)
                    skills.setAgility(agil - 1);
                    skills.setPoints(points + 1);
                    skills.setPowerlevel(plevel - 1);
                }
                break;
        }
        //Update the items after each click, even if its nothing!
        ItemStack pointsItem = inv.getItem(4);
        ItemStack healthItem = inv.getItem(19);
        ItemStack intelItem = inv.getItem(20);
        ItemStack agilItem = inv.getItem(21);

        inv.setItem(4, editItem(pointsItem.clone(), skills.getPoints(), Arrays.asList(color("&c You have: " + skills.getPoints()+" points left."))) );
        inv.setItem(19, editItem(healthItem.clone(), skills.getHealth(), Arrays.asList(color("Health" + "You have: " + skills.getHealth()+" levels."))));
        inv.setItem(20, editItem(intelItem.clone(), skills.getIntelligence(), Arrays.asList(color("Intelligence, You have: " + skills.getIntelligence() +" levels." ))));
        inv.setItem(21, editItem(agilItem.clone(), skills.getAgility(), Arrays.asList(color("Agility, You have: "+ skills.getAgility()+" levels."))));


        //Update player effects stat changes(even if its nothing!)
        //1. Set health
        //Base Hearth 20, 1 heart = 2HP
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20D + skills.getHealth() * 2);
        //This is the 1. 8. 9. and belows way of setting
        //2. Set agility - speed increase by 10%
        player.setWalkSpeed((float) (0.2 + ((skills.getAgility() / 10) * 0.2)));
        //3. Set intelligence

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
