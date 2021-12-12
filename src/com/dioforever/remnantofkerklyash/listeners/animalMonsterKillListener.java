package com.dioforever.remnantofkerklyash.listeners;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import org.bukkit.entity.Animals;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

import static com.dioforever.remnantofkerklyash.Utils.*;
import static com.dioforever.remnantofkerklyash.Utils.color;

public class animalMonsterKillListener implements Listener {

    private ProfileManager profileManager;

    public animalMonsterKillListener(Main main){
        profileManager = main.getProfileManager();

    }

    @EventHandler
    public void onEntityDeath(final EntityDeathEvent event){
        if(event.getEntity() instanceof Monster) {
            Monster monsterDied = (Monster) event.getEntity();
            if(monsterDied.getKiller() instanceof Player){
                Player killer = (Player) monsterDied.getKiller();
                Skills skills = profileManager.getPlayerProfile(killer.getUniqueId()).getSkills();
                int points = skills.getPoints();
                int levelxp = skills.getLevelxp();
                int level = skills.getLevel();
                int evolvexp = skills.getEvolvexp();
                int evolve = skills.getEvolve();
                int manacap = skills.getManaCap();
                int manaman = skills.getManaMan();

                Random randomNo = new Random();
                int min = 2;
                int max = 6;
                int Emin = 1;
                int Emax = 4;
                int XP = randomNo.nextInt((max-min) + 1) + min;
                int XPE = randomNo.nextInt((Emax-Emin) + 1) + min;
                int Cmin = 1;
                int Cmax = 7;
                int chance = randomNo.nextInt((Cmax-Cmin) + 1) + Cmin;
                int WLmin = 100;
                int WLmax = 200;
                int WLchance = randomNo.nextInt((WLmax-WLmin)+1);
                int WEmin = 100;
                int WEmax = 200;
                int WEchance = randomNo.nextInt((WEmax-WEmin)+1);

                if(monsterDied.getType().equals(EntityType.WITHER)){
                    skills.setLevelxp(levelxp+WLchance);
                    skills.setEvolvexp(evolvexp+WEchance);
                    if(skills.getLevel()==50&&skills.getEvolve()==50){
                        int witherkilled = skills.getWitherkilled();
                        skills.setWitherkilled(witherkilled+1);
                        killer.sendMessage(color("&7You already killed "+((skills.getWitherkilled()))+"&7/3 &8Withers &7 required to evolve into &5Demon Lord"));
                    }
                }
                if(skills.getLevel()==50&&skills.getEvolve()==50){
                    int killed = skills.getKilledMonster();
                    skills.setKilledMonster(killed+1);

                }
                //Points
                if(chance==5){
                    skills.setPoints(points+1);
                    killer.sendMessage(color("&eYou have earned 1 Point thanks to your hard work!"));
                }

                skills.setLevelxp(levelxp + XP);
                skills.setEvolvexp(evolvexp+ XPE);

                //Level uping
                if(skills.getLevelxp()>=(100*level)){
                    skills.setPoints(points+5);
                    skills.setLevel(level+1);
                    skills.setLevelxp(levelxp-levelxp);
                    skills.setManaCap((manacap+40));
                    skills.setManaMan((manaman+2));


                    killer.sendMessage(color("&b&lYou have leveled to level "+ (level+1)));
                }

                //evolving

                if(skills.getEvolvexp()>= 100*evolve){
                    skills.setEvolve(evolve+1);
                    skills.setEvolvexp(evolvexp-evolvexp);
                    killer.sendMessage(color("&e&lYou have leved up your race level to level "+(evolve+1)));
                    if(skills.getEvolve()>=1){
                        if(skills.getHuman()>= 1){
                            skills.setHuman((evolve+1));
                        }
                        if(skills.getDemon()>= 1){
                            skills.setDemon((evolve+1));
                        }
                        if(skills.getElf()>= 1){
                            skills.setElf((evolve+1));
                        }
                        if(skills.getDwarf()>= 1){
                            skills.setDwarf((evolve+1));
                        }
                        if(skills.getKitsune()>= 1){
                            skills.setKitsune((evolve+1));
                        }
                        if(skills.getRaiju()>= 1){
                            skills.setRaiju((evolve+1));
                        }
                        if(skills.getVampire1()>= 1){
                            skills.setVampire1((evolve+1));
                        }

                    }


                }
            }

            }
        }
        @EventHandler
        public void onAnimalDie(EntityDeathEvent event){
            if(event.getEntity() instanceof Animals) {
                Animals animalDied = (Animals) event.getEntity();
                if(animalDied.getKiller() instanceof Player){
                    Player killer = (Player) animalDied.getKiller();
                    Skills skills = profileManager.getPlayerProfile(killer.getUniqueId()).getSkills();

                    int points = skills.getPoints();
                    int levelxp = skills.getLevelxp();
                    int level = skills.getLevel();
                    int evolvexp = skills.getEvolvexp();
                    int evolve = skills.getEvolve();
                    int manacap = skills.getManaCap();
                    int manaman = skills.getManaMan();
                    Random randomNo = new Random();
                    int min = 1;
                    int max = 3;
                    int Emin = 1;
                    int Emax = 2;

                    int XP = randomNo.nextInt((max-min) + 1) + min;
                    int XPE = randomNo.nextInt((Emax-Emin) + 1) + Emin;
                    int Cmin = 1;
                    int Cmax = 7;
                    int chance = randomNo.nextInt((Cmax-Cmin) + 1) + Cmin;


                    skills.setLevelxp(levelxp + XP);
                    skills.setEvolvexp(evolvexp+ XPE);
                    if(skills.getLevel()==50&&skills.getEvolve()==50){
                        int killed = skills.getKilledMonster();
                        skills.setKilledMonster(killed+1);

                    }
                    //Points
                    if(chance==5){
                        skills.setPoints(points+1);
                        killer.sendMessage(color("&eYou have earned 1 Point thanks to your hard work!"));
                    }


                    //Level uping
                    if(skills.getLevelxp()>=(100*level)){
                        skills.setPoints(points+5);
                        skills.setLevel(level+1);
                        skills.setLevelxp(levelxp-levelxp);
                        skills.setManaCap((manacap+40));
                        skills.setManaMan((manaman+2));


                        killer.sendMessage(color("&b&lYou have leveled to level "+ (level+1)));
                    }
                        //evolving
                    if(skills.getEvolvexp()>= 100*evolve){
                        skills.setEvolve(evolve+1);
                        skills.setEvolvexp(evolvexp-evolvexp);
                        killer.sendMessage(color("&e&lYou have leved up your race level to level "+(evolve+1)));
                        if(skills.getEvolve()>=1){
                            if(skills.getHuman()>= 1){
                                skills.setHuman((evolve+1));
                            }
                            if(skills.getDemon()>= 1){
                                skills.setDemon((evolve+1));
                            }
                            if(skills.getElf()>= 1){
                                skills.setElf((evolve+1));
                            }
                            if(skills.getDwarf()>= 1){
                                skills.setDwarf((evolve+1));
                            }
                            if(skills.getKitsune()>= 1){
                                skills.setKitsune((evolve+1));
                            }
                            if(skills.getRaiju()>= 1){
                                skills.setRaiju((evolve+1));
                            }
                            if(skills.getVampire1()>= 1){
                                skills.setVampire1((evolve+1));
                            }

                        }


                    }
                }

            }
        }
    }

