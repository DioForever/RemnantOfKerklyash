package com.dioforever.remnantofkerklyash.component;

public class Skills {
    //Killed
    private int witherkilled;
    //basicStats
    private int points;
    private int health;
    private int agility;
    private int intelligence;
    //Races
    private int human;
    private int demon;
    private int elf;
    private int dwarf;
    private int kitsune;
    private int raiju;
    private int vampire;
    private int vampire1;

    private int racereset;
    //levels/ranks
    private int level;
    private int powerlevel;



    private int levelxp;
    private int evolve;
    private int evolvexp;
    //leveling/ranking/Evolving
    private int killedMonster;
    private int killedAnimal;
    private int killedDragon;
    //Life Force
    private int LifeForce;
    //Mana
    private int ManaMan;
    private int ManaCap;
    private int Mana;
    private int BonusMana;
    private int usingMana;
    private int ToRegenMana;
    //Demon race skills
    private int DemonALevitation;
    private int usingDAL;
    //Demon Lord
     private int DemonLordIs;
     private int DemonLordCooldown;
    //Magic T1
    private int HaveHealMagicT1;
    private int HealT1Cooldown;

    //Heal
    private int HealOn;
    private int countheal;

    //Fire

    //SunBall
    private int FireSunBallHave;
    private int FireSunBallLevel;
    private int FireSunBallCooldown;
    private int FireSunBallX;
    //Scorching Pulse
    private int ScorchingPulseHave;
    private int ScorchingPulseLevel;
    private int ScorchingPulseCooldown;
    private int ScorchingPulseX;
    //Hell Ring Providence
    private int HellRingProvidenceHave;
    private int HellRingProvidenceLevel;
    private int HellRingProvidenceCooldown;
    private int HellRingProvidenceX;
    //Blazing Heart Beat
    private int BlazingHeartBeatHave;
    private int BlazingHeartBeatLevel;
    private int BlazingHeartBeatCooldown;
    private int BlazingHeartBeatX;

    //Lightning

    private int LightningBulletHave;
    private int LightningBulletLevel;
    private int LightningBulletCooldown;
    private int LightningBulletX;

    //Earth

    private int HarvestMineHave;
    private int HarvestMineLevel;
    private int HarvestMineCooldown;
    private int HarvestMineX;

    //Hell Beam
    private int HellBeamMagic;
    private int HellBeamCooldown;
    private int HellBeamLevel;
    private int HellBeamX;
    //Skills
    private int AppraisalSkill;
    private int AppraisalCooldown;
    private int AppraisalLevel;

    private int AllSESkill;
    private int AllSECooldown;
    private int AllSELevel;

    private int HiderSkill;
    private int HiderCooldown;
    private int HiderLevel;










    public Skills(int points, int health, int intel, int agility, int human, int demon, int elf, int dwarf, int kitsune, int raiju,
                  int vampire1, int racereset,
                  int level, int powerlevel, int killedAnimal, int killedDragon, int killedMonster,
                  int levelxp, int evolvexp, int evolve, int ManaCap, int ManaMan, int Mana,
                  int DemonALevitation, int usingMana,
                  int HaveHealMagicT1,int HealT1Cooldown,
                  int usingDAL, int ToRegenMana, int HealOn,int countheal,
                  int AppraisalSkill,
                  int AppraisalCooldown, int AppraisalLevel,
                  int AllSESkill, int AllSECooldown,int AllSELevel,
                  int BonusMana, int LifeForce,
                  int witherkilled, int DemonLordIs, int DemonLordCooldown,
                  int FireSunBallHave, int FireSunBallLevel, int FireSunBallCooldown,int FireSunBallX,
                  int ScorchingPulseHave, int ScorchingPulseLevel, int ScorchingPulseCooldown,int SchorchingPulseX,
                  int HellRingProvidenceHave, int HellRingProvidenceLevel, int HellRingProvidenceCooldown, int HellRingProvidenceX,
                  int HiderSkill, int HiderCooldown, int HiderLevel,
                  int HellBeamMagic, int HellBeamCoooldown, int HellBeamLevel, int HellBeamX,
                  int LightningBulletHave, int LightningBulletLevel, int LightningBulletCooldown, int LightningBulletX,
                  int BlazingHeartBeatHave, int BlazingHeartBeatLevel, int BlazingHeartBeatCooldown, int BlazingHeartBeatX,
                  int HarvestMineHave, int HarvestMineLevel, int HarvestMineCooldown, int HarvestMineX
                  ) {
        this.points = points;
        this.health = health;
        this.agility = agility;
        this.intelligence = intel;
        this.human = human;
        this.demon = demon;
        this.elf = elf;
        this.dwarf = dwarf;
        this.kitsune = kitsune;
        this.raiju = raiju;
        this.vampire = vampire;
        this.racereset = racereset;
        this.vampire1 = vampire1;
        this.level = level;
        this.levelxp = levelxp;
        this.evolve = evolve;
        this.evolvexp = evolvexp;

        //Levels
        this.powerlevel = powerlevel;

        this.killedAnimal = killedAnimal;
        this.killedDragon = killedDragon;
        this.killedMonster = killedMonster;

        this.LifeForce = LifeForce;

        this.witherkilled = witherkilled;

        this.DemonLordIs = DemonLordIs;
        this.DemonLordCooldown = DemonLordCooldown;

        this.Mana= Mana;
        this.BonusMana = BonusMana;
        this.ManaCap = ManaCap;
        this.ManaMan = ManaMan;
        this.usingMana= usingMana;
        this.ToRegenMana = ToRegenMana;

        this.HealOn = HealOn;
        this.countheal= countheal;

        this.HaveHealMagicT1 = HaveHealMagicT1;
        this.HealT1Cooldown = HealT1Cooldown;

        this.DemonALevitation = DemonALevitation;
        this.usingDAL = usingDAL;

        this.FireSunBallCooldown = FireSunBallCooldown;
        this.FireSunBallHave = FireSunBallHave;
        this.FireSunBallLevel =FireSunBallLevel;
        this.FireSunBallX = FireSunBallX;

        this.ScorchingPulseHave = ScorchingPulseHave;
        this.ScorchingPulseLevel = ScorchingPulseLevel;
        this.ScorchingPulseCooldown = ScorchingPulseCooldown;
        this.ScorchingPulseX = SchorchingPulseX;

        this.HellRingProvidenceHave = HellRingProvidenceHave;
        this.HellRingProvidenceLevel = HellRingProvidenceLevel;
        this.HellRingProvidenceCooldown = HellRingProvidenceCooldown;
        this.HellRingProvidenceX = HellRingProvidenceX;

        this.BlazingHeartBeatHave = BlazingHeartBeatHave;
        this.BlazingHeartBeatLevel = BlazingHeartBeatLevel;
        this.BlazingHeartBeatCooldown = BlazingHeartBeatCooldown;
        this.BlazingHeartBeatX = BlazingHeartBeatX;

        //Lightning

        this.LightningBulletHave = LightningBulletHave;
        this.LightningBulletLevel = LightningBulletLevel;
        this.LightningBulletCooldown = LightningBulletCooldown;
        this.LightningBulletX = LightningBulletX;

        //Earth

        //Earth - Harvest Mine
        this.HarvestMineHave = HarvestMineHave;
        this.HarvestMineLevel = HarvestMineLevel;
        this.HarvestMineCooldown = HarvestMineCooldown;
        this.HarvestMineX = HarvestMineX;


        this.HellBeamMagic = HellBeamMagic;
        this.HellBeamCooldown = HellBeamCoooldown;
        this.HellBeamLevel = HellBeamLevel;
        this.HellBeamX = HellBeamX;

        //Skills
        this.AppraisalSkill = AppraisalSkill;
        this.AppraisalCooldown = AppraisalCooldown;
        this.AppraisalLevel = AppraisalLevel;

        this.AllSESkill = AllSESkill;
        this.AllSECooldown = AllSECooldown;
        this.AllSELevel = AllSELevel;

        this.HiderSkill = HiderSkill;
        this.HiderLevel = HiderLevel;
        this.HiderCooldown = HiderCooldown;



    }

    public int getHarvestMineCooldown() {
        return HarvestMineCooldown;
    }

    public void setHarvestMineCooldown(int harvestMineCooldown) {
        HarvestMineCooldown = harvestMineCooldown;
    }

    public int getHarvestMineHave() {
        return HarvestMineHave;
    }

    public void setHarvestMineHave(int harvestMineHave) {
        HarvestMineHave = harvestMineHave;
    }

    public int getHarvestMineLevel() {
        return HarvestMineLevel;
    }

    public void setHarvestMineLevel(int harvestMineLevel) {
        HarvestMineLevel = harvestMineLevel;
    }

    public int getHarvestMineX() {
        return HarvestMineX;
    }

    public void setHarvestMineX(int harvestMineX) {
        HarvestMineX = harvestMineX;
    }

    public int getBlazingHeartBeatCooldown() {
        return BlazingHeartBeatCooldown;
    }

    public void setBlazingHeartBeatCooldown(int blazingHeartBeatCooldown) {
        BlazingHeartBeatCooldown = blazingHeartBeatCooldown;
    }

    public int getBlazingHeartBeatHave() {
        return BlazingHeartBeatHave;
    }

    public void setBlazingHeartBeatHave(int blazingHeartBeatHave) {
        BlazingHeartBeatHave = blazingHeartBeatHave;
    }

    public int getBlazingHeartBeatLevel() {
        return BlazingHeartBeatLevel;
    }

    public void setBlazingHeartBeatLevel(int blazingHeartBeatLevel) {
        BlazingHeartBeatLevel = blazingHeartBeatLevel;
    }

    public int getBlazingHeartBeatX() {
        return BlazingHeartBeatX;
    }

    public void setBlazingHeartBeatX(int blazingHeartBeatX) {
        BlazingHeartBeatX = blazingHeartBeatX;
    }

    public int getLightningBulletCooldown() {
        return LightningBulletCooldown;
    }

    public void setLightningBulletCooldown(int lightningBulletCooldown) {
        LightningBulletCooldown = lightningBulletCooldown;
    }

    public int getLightningBulletHave() {
        return LightningBulletHave;
    }

    public void setLightningBulletHave(int lightningBulletHave) {
        LightningBulletHave = lightningBulletHave;
    }

    public int getLightningBulletLevel() {
        return LightningBulletLevel;
    }

    public void setLightningBulletLevel(int lightningBulletLevel) {
        LightningBulletLevel = lightningBulletLevel;
    }

    public int getLightningBulletX() {
        return LightningBulletX;
    }

    public void setLightningBulletX(int lightningBulletX) {
        LightningBulletX = lightningBulletX;
    }

    public int getFireSunBallX() {
        return FireSunBallX;
    }

    public void setFireSunBallX(int fireSunBallX) {
        FireSunBallX = fireSunBallX;
    }

    public int getScorchingPulseX() {
        return ScorchingPulseX;
    }

    public void setScorchingPulseX(int scorchingPulseX) {
        ScorchingPulseX = scorchingPulseX;
    }

    public int getHellBeamX() {
        return HellBeamX;
    }

    public void setHellBeamX(int hellBeamX) {
        HellBeamX = hellBeamX;
    }

    public int getHellRingProvidenceX() {
        return HellRingProvidenceX;
    }

    public void setHellRingProvidenceX(int hellRingProvidenceX) {
        HellRingProvidenceX = hellRingProvidenceX;
    }

    public int getHellBeamMagic() {
        return HellBeamMagic;
    }

    public void setHellBeamMagic(int hellBeamMagic) {
        HellBeamMagic = hellBeamMagic;
    }

    public int getHellBeamCooldown() {
        return HellBeamCooldown;
    }

    public void setHellBeamCooldown(int hellBeamCooldown) {
        HellBeamCooldown = hellBeamCooldown;
    }

    public int getHellBeamLevel() {
        return HellBeamLevel;
    }

    public void setHellBeamLevel(int hellBeamLevel) {
        HellBeamLevel = hellBeamLevel;
    }

    public int getHiderLevel() {
        return HiderLevel;
    }

    public void setHiderLevel(int hiderLevel) {
        HiderLevel = hiderLevel;
    }

    public int getHiderSkill() {
        return HiderSkill;
    }

    public void setHiderSkill(int hiderSkill) {
        HiderSkill = hiderSkill;
    }

    public int getHiderCooldown() {
        return HiderCooldown;
    }

    public void setHiderCooldown(int hiderCooldown) {
        HiderCooldown = hiderCooldown;
    }

    public int getHellRingProvidenceCooldown() {
        return HellRingProvidenceCooldown;
    }

    public void setHellRingProvidenceCooldown(int hellRingProvidenceCooldown) {
        HellRingProvidenceCooldown = hellRingProvidenceCooldown;
    }

    public int getHellRingProvidenceHave() {
        return HellRingProvidenceHave;
    }

    public void setHellRingProvidenceHave(int hellRingProvidenceHave) {
        HellRingProvidenceHave = hellRingProvidenceHave;
    }

    public int getHellRingProvidenceLevel() {
        return HellRingProvidenceLevel;
    }

    public void setHellRingProvidenceLevel(int hellRingProvidenceLevel) {
        HellRingProvidenceLevel = hellRingProvidenceLevel;
    }

    public int getScorchingPulseCooldown() {
        return ScorchingPulseCooldown;
    }

    public void setScorchingPulseCooldown(int scorchingPulseCooldown) {
        ScorchingPulseCooldown = scorchingPulseCooldown;
    }

    public int getScorchingPulseHave() {
        return ScorchingPulseHave;
    }

    public void setScorchingPulseHave(int scorchingPulseHave) {
        ScorchingPulseHave = scorchingPulseHave;
    }

    public void setScorchingPulseLevel(int scorchingPulseLevel) {
        ScorchingPulseLevel = scorchingPulseLevel;
    }

    public int getScorchingPulseLevel() {
        return ScorchingPulseLevel;
    }

    public int getFireSunBallCooldown() {
        return FireSunBallCooldown;
    }

    public void setFireSunBallCooldown(int fireSunBallCooldown) {
        FireSunBallCooldown = fireSunBallCooldown;
    }

    public int getFireSunBallHave() {
        return FireSunBallHave;
    }

    public void setFireSunBallHave(int fireSunBallHave) {
        FireSunBallHave = fireSunBallHave;
    }

    public int getFireSunBallLevel() {
        return FireSunBallLevel;
    }

    public void setFireSunBallLevel(int fireSunBallLevel) {
        FireSunBallLevel = fireSunBallLevel;
    }

    public int getDemonLordCooldown() {
        return DemonLordCooldown;
    }

    public void setDemonLordCooldown(int demonLordCooldown) {
        DemonLordCooldown = demonLordCooldown;
    }

    public int getDemonLordIs() {
        return DemonLordIs;
    }

    public void setDemonLordIs(int demonLordIs) {
        DemonLordIs = demonLordIs;
    }

    public int getWitherkilled() {
        return witherkilled;
    }

    public void setWitherkilled(int witherkilled) {
        this.witherkilled = witherkilled;
    }

    public int getLifeForce() {
        return LifeForce;
    }

    public void setLifeForce(int lifeForce) {
        LifeForce = lifeForce;
    }

    public int getBonusMana() {
        return BonusMana;
    }

    public void setBonusMana(int bonusMana) {
        BonusMana = bonusMana;
    }

    public int getAllSECooldown() {
        return AllSECooldown;
    }

    public void setAllSECooldown(int allSECooldown) {
        AllSECooldown = allSECooldown;
    }

    public int getAllSELevel() {
        return AllSELevel;
    }

    public void setAllSELevel(int allSELevel) {
        AllSELevel = allSELevel;
    }

    public int getAllSESkill() {
        return AllSESkill;
    }

    public void setAllSESkill(int allSESkill) {
        AllSESkill = allSESkill;
    }

    public int getAppraisalCooldown() {
        return AppraisalCooldown;
    }

    public void setAppraisalCooldown(int appraisalCooldown) {
        AppraisalCooldown = appraisalCooldown;
    }

    public int getAppraisalLevel() {
        return AppraisalLevel;
    }

    public void setAppraisalLevel(int appraisalLevel) {
        AppraisalLevel = appraisalLevel;
    }

    public int getAppraisalSkill() {
        return AppraisalSkill;
    }

    public void setAppraisalSkill(int appraisalSkill) {
        AppraisalSkill = appraisalSkill;
    }

    public int getCountheal() {
        return countheal;
    }

    public void setCountheal(int countheal) {
        this.countheal = countheal;
    }

    public int getHealOn() {
        return HealOn;
    }

    public void setHealOn(int healOn) {
        HealOn = healOn;
    }

    public int getToRegenMana() {
        return ToRegenMana;
    }

    public void setToRegenMana(int toRegenMana) {
        ToRegenMana = toRegenMana;
    }

    public int getUsingDAL() {
        return usingDAL;
    }

    public void setUsingDAL(int usingDAL) {
        this.usingDAL = usingDAL;
    }

    public int getHealT1Cooldown() {
        return HealT1Cooldown;
    }

    public void setHealT1Cooldown(int healT1Cooldown) {
        HealT1Cooldown = healT1Cooldown;
    }

    public int getHaveHealMagicT1() {
        return HaveHealMagicT1;
    }

    public void setHaveHealMagicT1(int haveHealMagicT1) {
        HaveHealMagicT1 = haveHealMagicT1;
    }

    public int getUsingMana() {
        return usingMana;
    }

    public void setUsingMana(int usingMana) {
        this.usingMana = usingMana;
    }

    public int getDemonALevitation() {
        return DemonALevitation;
    }

    public void setDemonALevitation(int demonALevitation) {
        DemonALevitation = demonALevitation;
    }

    public int getMana() {
        return Mana;
    }

    public void setMana(int mana) {
        Mana = mana;
    }

    public int getManaCap() {
        return ManaCap;
    }

    public void setManaCap(int manaCap) {
        ManaCap = manaCap;
    }

    public int getManaMan() {
        return ManaMan;
    }

    public void setManaMan(int manaMan) {
        ManaMan = manaMan;
    }

    public int getEvolve() {
        return evolve;
    }

    public void setEvolve(int evolve) {
        this.evolve = evolve;
    }

    public int getEvolvexp() {
        return evolvexp;
    }

    public void setEvolvexp(int evolvexp) {
        this.evolvexp = evolvexp;
    }

    public int getLevelxp() {
        return levelxp;
    }

    public void setLevelxp(int levelxp) {
        this.levelxp = levelxp;
    }

    public int getKilledAnimal() {
        return killedAnimal;
    }

    public void setKilledAnimal(int killedAnimal) {
        this.killedAnimal = killedAnimal;
    }

    public int getKilledDragon() {
        return killedDragon;
    }

    public void setKilledDragon(int killedDragon) {
        this.killedDragon = killedDragon;
    }

    public int getKilledMonster() {
        return killedMonster;
    }

    public void setKilledMonster(int killedMonster) {
        this.killedMonster = killedMonster;
    }

    public int getPowerlevel() {
        return powerlevel;
    }

    public void setPowerlevel(int powerlevel) {
        this.powerlevel = powerlevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRacereset() {
        return racereset;
    }

    public void setRacereset(int racereset) {
        this.racereset = racereset;
    }

    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
        this.points = points;
    }

    public int getVampire1() {
        return vampire1;
    }

    public void setVampire1(int vampire1) {
        this.vampire1 = vampire1;
    }

    public int getVampire() {
        return vampire;
    }
    public void setVampire(int vampire) {
        this.vampire = vampire;
    }



    public void setRaiju(int raiju) {
        this.raiju = raiju;
    }

    public int getRaiju() {
        return raiju;
    }

    public void setKitsune(int kitsune) {
        this.kitsune = kitsune;
    }

    public int getKitsune() {
        return kitsune;
    }

    public void setElf(int elf) {
        this.elf = elf;
    }

    public int getElf() {
        return elf;
    }

    public void setDemon(int demon) {
        this.demon = demon;
    }

    public int getDemon() {
        return demon;
    }

    public void setHuman(int human) {
        this.human = human;
    }

    public int getHuman() {
        return human;
    }

    public int getDwarf() {
        return dwarf;
    }

    public void setDwarf(int dwarf) {
        this.dwarf = dwarf;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getAgility(){
        return agility;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }

}