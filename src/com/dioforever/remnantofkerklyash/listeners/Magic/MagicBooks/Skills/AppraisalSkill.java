package com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import com.mojang.datafixers.kinds.App;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

import static com.dioforever.remnantofkerklyash.Utils.color;

public class AppraisalSkill implements Listener {

    private ProfileManager profileManager;
    static Main plugin;

    public AppraisalSkill(Main main) {
        profileManager = main.getProfileManager();
        plugin = main;
    }

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = e.getPlayer();
            Skills skills = profileManager.getPlayerProfile(player.getUniqueId()).getSkills();


            if (!(player.getInventory().getItemInMainHand().getType().isAir())) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(color("&c&lSkill Book - &3&lAppraisal"))) {

                    if (skills.getAppraisalSkill() == 1) {

                        Block block = player.getTargetBlock(null, 100);
                        Location bl = block.getLocation();
                        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                            player.sendMessage(color("&3&lAppraisal: " + e.getClickedBlock().getType()));
                        }
                        if (e.getAction() == Action.LEFT_CLICK_AIR) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                Skills Appskills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
                                if (p.getLocation().distance(player.getLocation()) < 30) {
                                    if (p != player) {

                                        List<String> racelist = new ArrayList<>();
                                        if (Appskills.getHuman() >= 1 && Appskills.getHuman() <= 19) {
                                            String race = new String();
                                            race = color("&9&lHuman&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getHuman() >= 20 && Appskills.getHuman() <= 29) {
                                            String race = new String();
                                            race = color("&9&lSmart Human&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getHuman() >= 30 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&9&lHuman Hero&e");
                                            racelist.add(race);
                                        }

                                        //Human end
                                        //Demon Lord
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getDemon() >= 1) {
                                            String race = new String();
                                            race = color("&5&lDemon Lord");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getHuman() >= 1) {
                                            String race = new String();
                                            race = color("&5&lThe Chosen One&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getElf() >= 1) {
                                            String race = new String();
                                            race = color("&5&lMyrkáflar&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getDwarf() >= 1) {
                                            String race = new String();
                                            race = color("&5&lBrimir&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getKitsune() >= 1) {
                                            String race = new String();
                                            race = color("&5&lTenko&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getRaiju() >= 1) {
                                            String race = new String();
                                            race = color("&5&lRaikou&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemonLordIs() == 1 && Appskills.getVampire1() >= 1) {
                                            String race = new String();
                                            race = color("&5&lStrix&e");
                                            racelist.add(race);
                                        }
                                        //Demon
                                        if (Appskills.getDemon() >= 1 && Appskills.getDemon() <= 9) {
                                            String race = new String();
                                            race = color("&6&lLesser Demon&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemon() >= 10 && Appskills.getDemon() <= 29) {
                                            String race = new String();
                                            race = color("&6&lGreater Demon&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemon() >= 30 && Appskills.getDemon() <= 39) {
                                            String race = new String();
                                            race = color("&6&lArch Demon&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDemon() >= 40 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&6&lDemon Noble&e");
                                            racelist.add(race);
                                        }
                                        //Demon end
                                        //Elf
                                        if (Appskills.getElf() >= 1 && Appskills.getElf() <= 19) {
                                            String race = new String();
                                            race = color("&2&lElf&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getElf() >= 20 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&2&lMaster Elf&e");
                                            racelist.add(race);
                                        }
                                        //Elf end
                                        //Kitsune
                                        if (Appskills.getKitsune() >= 1 && Appskills.getKitsune() <= 9) {
                                            String race = new String();
                                            race = color("&6&lFox&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getKitsune() >= 10 && Appskills.getKitsune() <= 19) {
                                            String race = new String();
                                            race = color("&6&lFire Fox&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getKitsune() >= 20 && Appskills.getKitsune() <= 29) {
                                            String race = new String();
                                            race = color("&6&lFire Doom Fox&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getKitsune() >= 30 && Appskills.getKitsune() <= 39) {
                                            String race = new String();
                                            race = color("&6&lDoom Fox&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getKitsune() >= 40 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&6&lKitsune&e");
                                            racelist.add(race);
                                        }
                                        //Kitsune end
                                        //Dwarf
                                        if (Appskills.getDwarf() >= 1 && Appskills.getDwarf() <= 9) {
                                            String race = new String();
                                            race = color("&3&lDwarf&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDwarf() >= 10 && Appskills.getDwarf() <= 19) {
                                            String race = new String();
                                            race = color("&3&lDwarf Traine&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getDwarf() >= 20 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&3&lMaster Dwarf&e");
                                            racelist.add(race);
                                        }
                                        //Dwarf end
                                        //Raiju
                                        if (Appskills.getRaiju() >= 1 && Appskills.getRaiju() <= 9) {
                                            String race = new String();
                                            race = color("&b&lWolf&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getRaiju() >= 10 && Appskills.getRaiju() <= 19) {
                                            String race = new String();
                                            race = color("&b&lStar Wolf&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getRaiju() >= 20 && Appskills.getRaiju() <= 29) {
                                            String race = new String();
                                            race = color("&b&lStorm Star Wolf&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getRaiju() >= 30 && Appskills.getRaiju() <= 39) {
                                            String race = new String();
                                            race = color("&b&lStorm Wolf&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getRaiju() >= 40 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&b&lRaiju&e");
                                            racelist.add(race);
                                        }
                                        //Raiju end
                                        //Vampire
                                        if (Appskills.getVampire1() >= 1 && Appskills.getVampire1() <= 9) {
                                            String race = new String();
                                            race = color("&8&lVampire&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getVampire1() >= 10 && Appskills.getVampire1() <= 19) {
                                            String race = new String();
                                            race = color("&8&lBloody Vampire&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getVampire1() >= 20 && Appskills.getDemonLordIs() != 1) {
                                            String race = new String();
                                            race = color("&8&lVampire Lord&e");
                                            racelist.add(race);
                                        }
                                        if (Appskills.getHiderCooldown() == 1) {
                                            if (Appskills.getHiderLevel() >= skills.getAppraisalLevel()) {
                                                player.sendMessage(color("&3&lAppraisal: "));
                                                player.sendMessage(color("&6Name: &4&l[UNKNOWN]"));
                                                player.sendMessage(color("&eLevel: &4&l[UNKNOWN]"));
                                                player.sendMessage(color("&eRace Level: &4&l[UNKNOWN]"));
                                                player.sendMessage(color("&ePower: &4&l[UNKNOWN]"));
                                                player.sendMessage(color("&eRace: &4&l[UNKNOWN]"));
                                            } else {
                                                player.sendMessage(color("&3&lAppraisal: "));
                                                player.sendMessage(color("&6Name: &e&l" + p.getName()));
                                                player.sendMessage(color("&eLevel: " + Appskills.getLevel()));
                                                player.sendMessage(color("&eRace Level: " + Appskills.getEvolve()));
                                                player.sendMessage(color("&ePower: " + Appskills.getPowerlevel()));
                                                player.sendMessage(color("&eRace: " + racelist));
                                            }
                                        } else if (Appskills.getHiderCooldown() == 0) {
                                            player.sendMessage(color("&3&lAppraisal: "));
                                            player.sendMessage(color("&6Name: &e&l" + p.getName()));
                                            player.sendMessage(color("&eLevel: " + Appskills.getLevel()));
                                            player.sendMessage(color("&eRace Level: " + Appskills.getEvolve()));
                                            player.sendMessage(color("&ePower: " + Appskills.getPowerlevel()));
                                            player.sendMessage(color("&eRace: " + racelist));
                                        }
                                    }


                                }
                            }


                        }

                    }

                }
            }
        }
    }
}

