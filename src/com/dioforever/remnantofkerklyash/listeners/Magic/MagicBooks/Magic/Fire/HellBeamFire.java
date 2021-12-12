package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;

import static com.dioforever.remnantofkerklyash.Utils.color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class HellBeamFire implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    public HellBeamFire(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }



    int taskID;

    final int points = 30;
    final double radius = 1.2d;


    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player p = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
            int mana = skills.getMana();

            final Location origin = p.getLocation();

            if(!(p.getInventory().getItemInMainHand().getType().isAir())) {
            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&d&lSpell Book - &4&lHell Beam &6&lT4"))) {
                skills.setHellBeamX(1);
                if ((skills.getMana() >= 50) && skills.getHellBeamMagic() == 1 && skills.getHellBeamX()==0) {


                    taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                        double a = 0;

                        public void run() {
                            a += Math.PI / 16;
                            Location loc = p.getLocation();
                            Location first = loc.clone().add(Math.cos(a), Math.sin(a) + 1, Math.sin(a));
                            Location second = loc.clone().add(Math.cos(a + Math.PI), Math.sin(a) + 1, Math.sin(a + Math.PI));


                            for (int i = 0; i < points; i++) {
                                double angle = 2 * Math.PI * i / points;
                                Location point = origin.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
                                p.spawnParticle(Particle.FLAME, point, 6, 0, 0, 0, 0);
                            }
                            int counth = skills.getCountheal();
                            skills.setCountheal(1 + counth);
                            if (skills.getCountheal() >= 50) {
                                Bukkit.getScheduler().cancelTask(taskID);
                                p.sendMessage("END");
                                skills.setHellRingProvidenceX(0);
                                skills.setCountheal(0);

                            }
                        }


                    }, 0, 1);

                    p.sendMessage(color("&eYou have been healed by &a&lHeal Magic Tier 1"));
                }

            }
        }
        }
    }
}