package com.dioforever.remnantofkerklyash.configs;

import com.dioforever.remnantofkerklyash.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static com.dioforever.remnantofkerklyash.Utils.*;

public class ProfileConfig {

    private Main main;
    private String fileName;
    private File file;
    private FileConfiguration config = new YamlConfiguration();

    public ProfileConfig(Main main, String fileName){
        this.main = main;
        this.fileName = fileName;
        file = new File(main.getDataFolder(), fileName+".yml");


    }

    public void loadConfig(){
        if(!file.exists()){
            file.getParentFile().mkdirs();
            main.saveResource(fileName + ".yml", false);
            log("Created profile config file!");
        }else{
            log("Found existing profile config file!");
        }
        try{
            config.load(file);
            log("Loaded profile config file!");
        } catch (IOException | InvalidConfigurationException expection){

            error("Error while loading profile config!");
            expection.printStackTrace();
        }

    }

    public void saveConfig(){
        try{
            config.save(file);
            log("Saved profile config to file!");
        } catch (IOException exception){
            error("Error while saving profile config!");
            exception.printStackTrace();
        }
    }
    public FileConfiguration getConfig(){
        return config;
    }


}