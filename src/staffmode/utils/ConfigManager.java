package staffmode.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

 
public class ConfigManager {
	
 
        private ConfigManager() { }
       
        static ConfigManager instance = new ConfigManager();
       
        public static ConfigManager getInstance() {
                return instance;
        }
        
        Plugin p;
       
        FileConfiguration config;
        File cfile;
       
        FileConfiguration data;
        File dfile;
        
        
        
       
        public void setup(Plugin p) {
    		this.p = p;
                cfile = new File(p.getDataFolder(), "config.yml");
                config = p.getConfig();
               
                config.options().copyDefaults(true);
                if (!p.getDataFolder().exists()) {
        			p.getDataFolder().mkdir();


                }
               
                dfile = new File(p.getDataFolder(), "data - DO NOT EDIT.yml");
               
                if (!dfile.exists()) {
                        try {
                                dfile.createNewFile();                 }
                        catch (IOException e) {
                                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data - DO NOT EDIT.yml!");
                        }
                }
               
                data = YamlConfiguration.loadConfiguration(dfile);
        }
       
        public FileConfiguration getData() {
                return data;
        }
       
        public void SaveDataConfig() {
                try {
                        data.save(dfile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data - DO NOT EDIT.yml!");
                }
      
    }
        public void reloadData() {
                data = YamlConfiguration.loadConfiguration(dfile);
        }
        public FileConfiguration getConfig() {
                return config;
        }
       
        public void SaveConfig() {
                try {
                        config.save(cfile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
                }
        }
        public void reloadConfig() {
                config = YamlConfiguration.loadConfiguration(cfile);
        }
       
        public PluginDescriptionFile getDesc() {
                return p.getDescription();
        }
}