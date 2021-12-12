package com.dioforever.remnantofkerklyash;


import com.dioforever.remnantofkerklyash.SpecialOres.MagicalOre1;
import com.dioforever.remnantofkerklyash.commands.DioAdventureGUI;
import com.dioforever.remnantofkerklyash.commands.RacesCommand;
import com.dioforever.remnantofkerklyash.commands.SkillCommand;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.configs.ProfileConfig;
import com.dioforever.remnantofkerklyash.listeners.*;
import com.dioforever.remnantofkerklyash.listeners.DAGUI.*;
import com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.Elements.EarthMagicClickListner;
import com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.Elements.FireMagicClickListener;
import com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.Elements.LightningMagicClickListener;
import com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.MagicClickListener;
import com.dioforever.remnantofkerklyash.listeners.DAGUI.Magic.Elements.NatureMagicClickListener;
import com.dioforever.remnantofkerklyash.commands.ForceCMDs.*;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Earth.HarvestMineEarth;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire.BlazingHeartBeatFire;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire.HellBeamFire;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire.HellRingProvidenceFire;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Fire.ScorchingPulseFire;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Lightning.LightningBulletLightning;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.RaceSkills.Demon.Changing.RaceSkillBookListener;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills.AppraisalSkill;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills.Changing.SkillBookListener;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills.AllSeeingEyeSkill;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Skills.HiderSkill;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicBooks.Magic.Changing.SpellBookListener;
import com.dioforever.remnantofkerklyash.listeners.Magic.MagicRecipes.SpellWand;
import com.dioforever.remnantofkerklyash.managers.ProfileManager;
import com.sun.jdi.Value;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.logging.Logger;

import static com.dioforever.remnantofkerklyash.Utils.*;

public class Main extends JavaPlugin {

    private static Logger logger;

    private ProfileManager profileManager;
    private ProfileConfig profileConfig;
    public HashMap<Player, Value> map = new HashMap<>();

    public static Object getPlugin() {
        Main.getPlugin();
    return getPlugin();
    }

    @Override
    public void onEnable(){



        logger = getLogger();

        profileConfig = new ProfileConfig(this,"profiles");
        profileConfig.loadConfig();

        profileManager = new ProfileManager(this);
        profileManager.loadProfilesFromConfig();



        for(Player p : Bukkit.getOnlinePlayers()){
            Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
            //Fire
            if(skills.getAppraisalLevel()>=6){
                skills.setAppraisalLevel(5);
                int pointsback = (skills.getAppraisalLevel()-5)*20;
                int pointshave = skills.getPoints();
                skills.setPoints(pointshave + pointsback);
            }
            //Fire
            skills.setScorchingPulseX(0);
            skills.setHellBeamX(0);
            skills.setHellRingProvidenceX(0);
            skills.setBlazingHeartBeatX(0);
            //Lightning
            skills.setLightningBulletX(0);
            p.sendMessage("Restarted!");
        }
        SkillCommand skillCommand = new SkillCommand(this);
        getCommand("skills").setExecutor(skillCommand);
        getCommand("skills").setTabCompleter(skillCommand);

        DioAdventureGUI dioAdventureGUI = new DioAdventureGUI(this);
        getCommand("rokgui").setExecutor(dioAdventureGUI);
        getCommand("rokgui").setTabCompleter(dioAdventureGUI);

        ForceLevelRACE forceLevelRACE = new ForceLevelRACE(this);
        getCommand("forcerace").setExecutor(forceLevelRACE);
        ForceLevelLVL forceLevelLVL = new ForceLevelLVL(this);
        getCommand("forcelvl").setExecutor(forceLevelLVL);
        ForceLevelBoth forceLevelBoth = new ForceLevelBoth(this);
        getCommand("forceboth").setExecutor(forceLevelBoth);
        PointsAdd pointsAdd = new PointsAdd(this);
        getCommand("pointsadd").setExecutor(pointsAdd);

        //ManaRegeneration
        run();
        ActionManaBarRun();
        CoodlownsRun();
        DemonLevitationrun();

        //DAGUI
        getServer().getPluginManager().registerEvents(new MagicClickListener(this), this);
        getServer().getPluginManager().registerEvents(new RaceSkillsClickListener(this), this);
        getServer().getPluginManager().registerEvents(new SkillsClickListener(this),this);
        getServer().getPluginManager().registerEvents(new ROKGClickListener(this), this);
        //DAGUI END
        getServer().getPluginManager().registerEvents(new animalMonsterKillListener(this),this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new invClickListener(this), this);
        getServer().getPluginManager().registerEvents(new RaceInvListener(this),this);
        //Magic
        getServer().getPluginManager().registerEvents(new SpellBookListener(this),this);
        getServer().getPluginManager().registerEvents(new FireMagicClickListener(this),this);
        getServer().getPluginManager().registerEvents(new NatureMagicClickListener(this),this);

        //Lightning
        getServer().getPluginManager().registerEvents(new LightningMagicClickListener(this),this);
        getServer().getPluginManager().registerEvents(new LightningBulletLightning(this),this);

        //Fire
        getServer().getPluginManager().registerEvents(new ScorchingPulseFire(this),this);
        getServer().getPluginManager().registerEvents(new HellBeamFire(this),this);
        getServer().getPluginManager().registerEvents(new HellRingProvidenceFire(this),this);
        getServer().getPluginManager().registerEvents(new BlazingHeartBeatFire(this),this);

        //Earth
        getServer().getPluginManager().registerEvents(new EarthMagicClickListner(this),this);
        getServer().getPluginManager().registerEvents(new HarvestMineEarth(this),this);

        //Skills
        getServer().getPluginManager().registerEvents(new AllSeeingEyeSkill(this),this);
        getServer().getPluginManager().registerEvents(new AppraisalSkill(this),this);
        getServer().getPluginManager().registerEvents(new HiderSkill(this),this);

        //RaceSkillsBook
        getServer().getPluginManager().registerEvents(new RaceSkillBookListener(this),this);
        //SkillBook
        getServer().getPluginManager().registerEvents(new SkillBookListener(this),this);
        //Ores
        getServer().getPluginManager().registerEvents(new MagicalOre1(),this);

        //YNDemonLord
        getServer().getPluginManager().registerEvents(new YNDemonLord(this),this);

        //Custom Recipes
        SpellWand items = new SpellWand();
        items.customRecipe();


        RacesCommand racesCommand = new RacesCommand(this);
        getCommand("races").setExecutor(racesCommand);
        getCommand("races").setTabCompleter(racesCommand);






        log("Plugin enabled!");

    }

    @Override
    public void onDisable(){
        // Save the profiles BEFORE saving the config file!
        profileManager.saveProfilesToConfig();
        profileConfig.saveConfig();
        //NOT HERE
        // profileManager.saveblahblahblah

        log("Plugin disabled!");
    }

    public static Logger getPluginLogger() {
        return logger;
    }

    public  ProfileManager getProfileManager(){
        return profileManager;
    }

    public ProfileConfig getProfileConfig(){
        return profileConfig;
    }

//Mana regen, WORKING
    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();

                    int racelvl = skills.getEvolve();
                    int maxmana= skills.getManaCap();
                    int mana = skills.getMana();
                    int manaregen = skills.getManaMan();
                    int lifeforce = skills.getLifeForce();

                    skills.setPowerlevel((racelvl*5)+(maxmana)+(manaregen*6)+(lifeforce));

                    if(skills.getMana()!=skills.getManaCap()){
                        skills.setMana(mana+(manaregen/10));
                    }
                    if(skills.getMana()>=skills.getManaCap()){
                        skills.setMana(maxmana);
                    }

                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,10);
    }

    //Mana regen, WORKING
    public void DemonLevitationrun() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
                    int maxmana= skills.getManaCap();
                    int mana = skills.getMana();
                    int bonusmana = skills.getBonusMana();
                    if(skills.getUsingDAL()==1){
                       if(skills.getMana()>=0) {
                           skills.setMana(mana-20);
                           p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color("&bMana&e&l " + (mana+bonusmana) + "&b/&e&l" + maxmana)));
                       }else if(skills.getMana()<=0){
                           skills.setUsingDAL(0);
                           p.setAllowFlight(false);
                           p.sendMessage(color("&8&lDemon Art of Levitation &c&l[OFF]"));
                           skills.setMana(0);
                       }
                    }


                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,10);
    }
    public void ActionManaBarRun() {
        new BukkitRunnable() {
            public void runTask(Plugin plugin, int i, int i1) {
            }

            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
                    int maxmana= skills.getManaCap();
                    int mana = skills.getMana();
                    int bonusmana = skills.getBonusMana();
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color("&bMana&e&l " + (mana+bonusmana) + "&b/&e&l" + maxmana)));
                }

            }

        }.runTaskTimer((Plugin) this,0,10);
    }
    public void CoodlownsRun() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    Skills skills = profileManager.getPlayerProfile(p.getUniqueId()).getSkills();
                    int maxmana= skills.getManaCap();
                    int mana = skills.getMana();
                    int cooldown = skills.getHealT1Cooldown();
                    if(skills.getHealT1Cooldown()!=0) {
                        skills.setHealT1Cooldown(cooldown-1);
                    }
                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,20);
    }
}


  //  public void runnable(){
  //      new BukkitRunnable(){
  //          public void runTaskAsynchronously(Main main, int i, int i1) {
 //           }
//
//            @Override
 //           public void run() {
 //               for(LivingEntity e: getServer().getWorld("world").getLivingEntities()){
 //                   String playerOwner = e.getCustomName();
 //                   System.out.println(playerOwner);
 //                   Player player = Bukkit.getPlayer(playerOwner);
//                    if(e.getCustomName()==(playerOwner)){
//                      player.sendMessage("You have spawned a kitsune!");
//                    }

 //               }
 //           }
//        }.runTaskTimerAsynchronously(this, 0, 10);

