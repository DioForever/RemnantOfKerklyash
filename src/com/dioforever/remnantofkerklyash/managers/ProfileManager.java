package com.dioforever.remnantofkerklyash.managers;

import com.dioforever.remnantofkerklyash.Main;
import com.dioforever.remnantofkerklyash.component.Profile;
import com.dioforever.remnantofkerklyash.component.Skills;
import com.dioforever.remnantofkerklyash.configs.ProfileConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.dioforever.remnantofkerklyash.Utils.*;
import static com.dioforever.remnantofkerklyash.Utils.log;

public class ProfileManager {

    private Main main;
    private Map<UUID, Profile> profiles = new HashMap<>();

    private ProfileConfig profileConfig;
    private FileConfiguration config;

    public ProfileManager(Main main){
        this.main = main;
        profileConfig = main.getProfileConfig();
        config = profileConfig.getConfig();
    }

    public void loadProfilesFromConfig(){
        for(String id : config.getConfigurationSection("").getKeys(false)){
            UUID uuid = UUID.fromString(id);
            int points = config.getInt(id + ".skills.points");
            int health = config.getInt(id + ".skills.health");
            int intel =  config.getInt(id + ".skills.intel");
            int agility =config.getInt(id + ".skills.agility");
            //races
            int human = config.getInt(id+".races.human");
            int demon = config.getInt(id+".races.demon");
            int elf = config.getInt(id+".races.elf");
            int dwarf = config.getInt(id+".races.dwarf");
            int kitsune = config.getInt(id+".races.kitsune");
            int raiju = config.getInt(id+".races.raiju");
            int vampire1 = config.getInt(id+".races.vampire");
            int racereset = config.getInt(id+".races.racereset");
            int level = config.getInt(id+".levels.level");

            int killedAnimal = config.getInt(id+".killed.mob.killedAnimal");
            int killedDragon = config.getInt(id+".killed.mob.killedDragon");
            int killedMonster = config.getInt(id+".killed.mob.killedMonster");
            int levelxp = config.getInt(id+".levels.levelxp");
            int evolvexp = config.getInt(id+".levels.evolvexp");
            int evolve = config.getInt(id+".levels.evolve");
            int manaman = config.getInt(id+".levels.manaman");
            int manacap = config.getInt(id+".levels.manacap");
            int mana = config.getInt(id+".levels.mana");
            int demonlevitation = config.getInt(id+".demon.skills.levitation");
            int usingmana = config.getInt(id+".using.mana");
            int havehealt1 = config.getInt(id+".magic.tier1.healmagic");
            int HealT1Cooldown = config.getInt(id+".cooldowns.healmagict1");
            int usingDAL = config.getInt(id+".using.demonlevitation");
            //Life Force
            int LifeForce = config.getInt(id+".levels.lifeforce");
            //Power
            int powerlevel = config.getInt(id+".levels.power.level");

            //Display

            //Mana
            int toregenmana = config.getInt(id+".to.regen.mana");
            int bonusmana = config.getInt(id+".mana.bonus");
            //HealMagic
            int healon = config.getInt(id+".using.tier1.heal");
            int countheal = config.getInt(id+".counts.heal");
            //Appraisal
            int appraisal = config.getInt(id+".skills.appraisal.have");
            int appraisalL = config.getInt(id+".skills.appraisal.level");
            int appraisalC = config.getInt(id+".skills.appraisal.cooldown");
            //All-seeing Eye
            int allse = config.getInt(id+".skills.All-seeingEye.have");
            int allseL = config.getInt(id+".skills.All-seeingEye.level");
            int allseC = config.getInt(id+".skills.All-seeingEye.cooldown");
            //Killed
            int witherKilled = config.getInt(id+".killed.mob.wither");
            //Demon Lord
            int DemonLordIs = config.getInt(id+".races.demonlord.is");
            int DemonLordC = config.getInt(id+".races.demonlord.cooldown");

            int SunBallHave = config.getInt(id+".magic.fire.sunball.have");
            int SunBallLevel = config.getInt(id+".magic.fire.sunball.level");
            int SunBallCooldown = config.getInt(id+".magic.fire.sunball.cooldown");
            int SunBallX = config.getInt(id+".magic.fire.sunball.X");

            int ScorchingPulseHave = config.getInt(id+".magic.fire.ScorchingPulse.have");
            int ScorchingPulseLevel = config.getInt(id+".magic.fire.ScorchingPulse.level");
            int ScorchingPulseCooldown = config.getInt(id+".magic.fire.ScorchingPulse.cooldown");
            int ScorchingPulseX = config.getInt(id+".magic.fire.ScorchingPulse.X");

            int HellRingProvidenceHave = config.getInt(id+".magic.fire.HellRingProvidence.have");
            int HellRingProvidenceLevel = config.getInt(id+".magic.fire.HellRingProvidence.level");
            int HellRingProvidenceCooldown = config.getInt(id+".magic.fire.HellRingProvidence.cooldown");
            int HellRingProvidenceX = config.getInt(id+".magic.fire.HellRingProvidence.X");

            int HiderSkill = config.getInt(id+".skills.hider.have");
            int HiderCooldown = config.getInt(id+".skills.hider.cooldown");
            int HiderLevel = config.getInt(id+".skills.hider.level");

            int HellBeamMagic = config.getInt(id+".magic.fire.HellBeam.have");
            int HellBeamCooldown = config.getInt(id+".magic.fire.HellBeam.cooldown");
            int HellBeamLevel = config.getInt(id+".magic.fire.HellBeam.level");
            int HellBeamX = config.getInt(id+".magic.fire.HellBeam.X");

            //Lightning Bullet
            int LightningBulletHave = config.getInt(id+".magic.lightning.LightningBullet.have");
            int LightningBulletLevel = config.getInt(id+".magic.lightning.LightningBullet.level");
            int LightningBulletCooldown = config.getInt(id+".magic.lightning.LightningBullet.cooldown");
            int LightningBulletX = config.getInt(id+".magic.lightning.LightningBullet.X");

            //Fire - Blazing Heart Beat
            int BlazingHeartBeatHave = config.getInt(id+".magic.fire.BlazingHeartBeat.have");
            int BlazingHeartBeatLevel = config.getInt(id+".magic.fire.BlazingHeartBeat.level");
            int BlazingHeartBeatCooldown = config.getInt(id+".magic.fire.BlazingHeartBeat.cooldown");
            int BlazingHeartBeatX = config.getInt(id+".magic.fire.BlazingHeartBeat.X");

            //Earth - HarvestMine
            int HarvestMineHave = config.getInt(id+".magic.earth.HarvestMine.have");
            int HarvestMineLevel = config.getInt(id+".magic.earth.HarvestMine.level");
            int HarvestMineCooldown = config.getInt(id+".magic.earth.HarvestMine.cooldown");
            int HarvestMineX = config.getInt(id+".magic.earth.HarvestMine.X");



            Skills skills = new Skills(points, health, intel, agility,
                    human,demon,elf,dwarf,kitsune,raiju, vampire1, racereset,
                    level, powerlevel,
                    killedAnimal, killedDragon, killedMonster, levelxp, evolvexp, evolve,
                    manacap, manaman, mana,
                    demonlevitation, usingmana,
                    havehealt1, HealT1Cooldown,
                    usingDAL, toregenmana, healon, countheal,
                    appraisal, appraisalC, appraisalL,
                    allse, allseC, allseL,
                    bonusmana, LifeForce,
                    witherKilled, DemonLordIs, DemonLordC,
                    SunBallHave, SunBallLevel, SunBallCooldown,SunBallX,
                    ScorchingPulseHave, ScorchingPulseLevel, ScorchingPulseCooldown,ScorchingPulseX,
                    HellRingProvidenceHave, HellRingProvidenceLevel,HellRingProvidenceCooldown,HellRingProvidenceX,
                    HiderSkill, HiderCooldown, HiderLevel,
                    HellBeamMagic, HellBeamCooldown, HellBeamLevel,HellBeamX,
                    LightningBulletHave, LightningBulletLevel, LightningBulletCooldown, LightningBulletX,
                    BlazingHeartBeatHave, BlazingHeartBeatLevel, BlazingHeartBeatCooldown, BlazingHeartBeatX,
                    HarvestMineHave, HarvestMineLevel, HarvestMineCooldown, HarvestMineX);
            Profile profile = new Profile(skills);
            profiles.put(uuid,profile);
            log("Loaded profile for " + id+"!");
        }


    }
    public void saveProfilesToConfig(){
        for(UUID uuid : profiles.keySet()){
            String id = uuid.toString();
            Profile profile = profiles.get(uuid);
            Skills skills = profile.getSkills();
            config.set(id + ".skills.points", skills.getPoints());
            config.set(id + ".skills.health", skills.getHealth());
            config.set(id + ".skills.intel", skills.getIntelligence());
            config.set(id + ".skills.agility", skills.getAgility());
            config.set(id + ".races.human", skills.getHuman());
            config.set(id + ".races.demon", skills.getDemon());
            config.set(id + ".races.elf", skills.getElf());
            config.set(id + ".races.dwarf", skills.getDwarf());
            config.set(id + ".races.kitsune", skills.getKitsune());
            config.set(id + ".races.raiju", skills.getRaiju());
            config.set(id + ".races.vampire", skills.getVampire1());
            config.set(id + ".races.racereset", skills.getRacereset());
            config.set(id + ".levels.level", skills.getLevel());

            config.set(id + ".killed.mob.killedAnimal", skills.getKilledAnimal());
            config.set(id + ".killed.mob.killedDragon", skills.getKilledDragon());
            config.set(id + ".killed.mob.killedMonster", skills.getKilledMonster());
            config.set(id+".levels.levelxp", skills.getLevelxp());
            config.set(id+".levels.evolvexp", skills.getEvolvexp());
            config.set(id+".levels.evolve", skills.getEvolve());
            config.set(id+".levels.manacap", skills.getManaCap());
            config.set(id+".levels.manaman", skills.getManaMan());
            config.set(id+".levels.mana", skills.getMana());
            config.set(id+".demon.skills.levitation", skills.getDemonALevitation());
            config.set(id+".using.mana", skills.getUsingMana());
            config.set(id+".magic.tier1.healmagic", skills.getHaveHealMagicT1());
            config.set(id+".cooldowns.healmagict1", skills.getHealT1Cooldown());
            config.set(id+".using.demonlevitation", skills.getUsingDAL());
            //Life Force
            config.set(id+".levels.lifeforce",skills.getLifeForce());
            //Power

            config.set(id + ".levels.power.level", skills.getPowerlevel());

            //Mana
            config.set(id+".to.regen.mana", skills.getToRegenMana());
            config.set(id+".levels.bonus.mana",skills.getBonusMana());
            //HealMagic
            config.set(id+".using.tier1.heal", skills.getHealOn());
            config.set(id+".counts.heal", skills.getCountheal());
            //Appraisal
            config.set(id+".skills.appraisal.have",skills.getAppraisalSkill());
            config.set(id+".skills.appraisal.level", skills.getAppraisalLevel());
            config.set(id+".skills.appraisal.cooldown",skills.getAppraisalCooldown());
            //All-seeing Eye
            config.set(id+".skills.All-seeingEye.have",skills.getAllSESkill());
            config.set(id+".skills.All-seeingEye.level", skills.getAllSELevel());
            config.set(id+".skills.All-seeingEye.cooldown",skills.getAllSECooldown());
            //Hider
            config.set(id+".skills.hider.have",skills.getHiderSkill());
            config.set(id+".skills.hider.cooldown",skills.getHiderCooldown());
            config.set(id+".skills.hider.level",skills.getHiderLevel());


            //Kiled
            config.set(id+".killed.mob.wither",skills.getWitherkilled());
            //Demon Lord
            config.set(id+".races.demonlord.is",skills.getDemonLordIs());
            config.set(id+".races.demonlord.cooldown",skills.getDemonLordCooldown());
            //Fire - SunBall
            config.set(id+".magic.fire.sunball.have",skills.getFireSunBallHave());
            config.set(id+".magic.fire.sunball.level",skills.getFireSunBallLevel());
            config.set(id+".magic.fire.sunball.cooldown",skills.getFireSunBallCooldown());
            config.set(id+".magic.fire.sunball.X", skills.getFireSunBallX());
            //Fire - Scorching Pulse
            config.set(id+".magic.fire.ScorchingPulse.have",skills.getScorchingPulseHave());
            config.set(id+".magic.fire.ScorchingPulse.level",skills.getScorchingPulseLevel());
            config.set(id+".magic.fire.ScorchingPulse.cooldown",skills.getScorchingPulseCooldown());
            config.set(id+".magic.fire.ScorchingPulse.X", skills.getScorchingPulseX());
            //Fire - HellRingProvidence
            config.set(id+".magic.fire.HellRingProvidence.have",skills.getHellRingProvidenceHave());
            config.set(id+".magic.fire.HellRingProvidence.level",skills.getHellRingProvidenceLevel());
            config.set(id+".magic.fire.HellRingProvidence.cooldown",skills.getHellRingProvidenceCooldown());
            config.set(id+".magic.fire.HellRingProvidence.X",skills.getHellRingProvidenceX());
            //Fire - HellBeam
            config.set(id+".magic.fire.HellBeam.have",skills.getHellBeamMagic());
            config.set(id+".magic.fire.HellBeam.cooldown",skills.getHellBeamCooldown());
            config.set(id+".magic.fire.HellBeam.level",skills.getHellBeamLevel());
            config.set(id+".magic.fire.HellBeam.X",skills.getHellBeamX());
            //Lightning - Lightning Bullet
            config.set(id+".magic.lightning.LightningBullet.have",skills.getLightningBulletHave());
            config.set(id+".magic.lightning.LightningBullet.level",skills.getLightningBulletLevel());
            config.set(id+".magic.lightning.LightningBullet.cooldown",skills.getLightningBulletCooldown());
            config.set(id+".magic.lightning.LightningBullet.X",skills.getLightningBulletX());
            //Fire - BlazingHeartBeat
            config.set(id+".magic.fire.BlazingHeartBeat.have",skills.getBlazingHeartBeatHave());
            config.set(id+".magic.fire.BlazingHeartBeat.level",skills.getBlazingHeartBeatLevel());
            config.set(id+".magic.fire.BlazingHeartBeat.cooldown",skills.getBlazingHeartBeatCooldown());
            config.set(id+".magic.fire.BlazingHeartBeat.X",skills.getBlazingHeartBeatX());
            //Earth - HarvestMine
            config.set(id+".magic.earth.HarvestMine.have",skills.getHarvestMineHave());
            config.set(id+".magic.earth.HarvestMine.level",skills.getHarvestMineLevel());
            config.set(id+".magic.earth.HarvestMine.cooldown",skills.getHarvestMineCooldown());
            config.set(id+".magic.earth.HarvestMine.X",skills.getHarvestMineX());
            log("Saved profile for " + id + "!");
        }
    }

    public Profile createNewProfile(Player player){
        Skills skills = new Skills(10,0,0,0,
                0,0,0,0,0,0, 0,10,
                1,0,0,0,0,0,0,2,
                100,20,0,
                0,
                1,
                0,0,
                0,
                1,0,0,
                0,0,0,
                0,0,0,
                0,50,0,
                0,0,
                0,0,0, 0,
                0,0, 0, 0,
                0, 0, 0,0,
                0, 0,0,
                0,0,0,0,
                0,0,0,0,
                0,0,0,0,
                0,0,0,0);
        Profile profile = new Profile(skills);
        profiles.put(player.getUniqueId(), profile);

        return profile;
    }

    public Profile getPlayerProfile(UUID uuid){
        return profiles.get(uuid);
    }
}
