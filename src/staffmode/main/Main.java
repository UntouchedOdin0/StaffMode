package staffmode.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import staffmode.cmds.AdminGuiCMD;
import staffmode.cmds.BroadCast;
import staffmode.cmds.ClearChat;
import staffmode.cmds.ClearInventory;
import staffmode.cmds.EnderChest;
import staffmode.cmds.Feed;
import staffmode.cmds.Fly;
import staffmode.cmds.Freeze;
import staffmode.cmds.Heal;
import staffmode.cmds.Help;
import staffmode.cmds.MuteChat;
import staffmode.cmds.Report;
import staffmode.cmds.StaffChat;
import staffmode.cmds.StaffModeCMD;
import staffmode.cmds.Tp;
import staffmode.cmds.TpHere;
import staffmode.cmds.VanishCommand;
import staffmode.cmds.Warn;
import staffmode.cmds.WorkBench;
import staffmode.listeners.FullJoin;
import staffmode.listeners.PlayerChat;
import staffmode.listeners.PlayerFrozen;
import staffmode.listeners.PlayerJoin;
import staffmode.listeners.StaffChatHandler;
import staffmode.listeners.StaffModeHandler;
import staffmode.listeners.StaffModeItemsHandler;
import staffmode.listeners.VanishHandler;
import staffmode.utils.AdminGui;
import staffmode.utils.ConfigManager;
import staffmode.utils.Metrics;
import staffmode.utils.SaveInventory;


public class Main extends JavaPlugin {
	
	ArrayList<String> list = new ArrayList<String> ();
	@SuppressWarnings("unused")
	private AdminGui Gui;
	SaveInventory si = new SaveInventory();
	protected UpdateChecker updateChecker;
	public static Main instance;
	
	
	public void onEnable() {
		registerCommands();
		EnableInstance();
		loadListeners();
		SetUpConfig();
		Updater();
		Metrics();
		Gui = new AdminGui();
		
	}
	public void onDisable() {
		DisableInstance();
	}

	private void DisableInstance() {
		instance = null;
		
	}
	private void EnableInstance() {
		instance = this;
	}
		
		public static Main getInstance() {
			return instance;
		}

	
	private void registerCommands() {
		getCommand("StaffMode").setExecutor(new StaffModeCMD());
		getCommand("Vanish").setExecutor(new VanishCommand());
		getCommand("ClearChat").setExecutor(new ClearChat());
		getCommand("MuteChat").setExecutor(new MuteChat());
		getCommand("Fly").setExecutor(new Fly());
		getCommand("Heal").setExecutor(new Heal());
		getCommand("Feed").setExecutor(new Feed());
		getCommand("ClearInventory").setExecutor(new ClearInventory());
		getCommand("StaffChat").setExecutor(new StaffChat());
		getCommand("Freeze").setExecutor(new Freeze());
		getCommand("Warn").setExecutor(new Warn());
		getCommand("Tp").setExecutor(new Tp());
		getCommand("teleporthere").setExecutor(new TpHere());
		getCommand("report").setExecutor(new Report());
		getCommand("SHelp").setExecutor(new Help());
		getCommand("AdminGui").setExecutor(new AdminGuiCMD());
		getCommand("WorkBench").setExecutor(new WorkBench());
		getCommand("EnderChest").setExecutor(new EnderChest());
		getCommand("broadcast").setExecutor(new BroadCast());
		
		}
	private void loadListeners() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerChat(), this);
		Bukkit.getPluginManager().registerEvents(new StaffModeHandler(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFrozen(), this);
		Bukkit.getPluginManager().registerEvents(new VanishHandler(), this);
		Bukkit.getPluginManager().registerEvents(new StaffChatHandler(), this);
		Bukkit.getPluginManager().registerEvents(new AdminGui(), this);
		Bukkit.getPluginManager().registerEvents(new FullJoin(), this);
		Bukkit.getPluginManager().registerEvents(new StaffModeItemsHandler(), this);
	}
	private void SetUpConfig() {
		ConfigManager.getInstance().setup(this);
		ConfigManager.getInstance().SaveConfig();
		ConfigManager.getInstance().SaveDataConfig();
		
	}
	public void set(String string, long currentTimeMillis) {
	}
	private void Updater() {
		this.updateChecker = new UpdateChecker(this,
				"http://dev.bukkit.org/bukkit-plugins/staffmode-sm/files.rss");
		if (updateChecker.updateNeeded()) {
			this.getLogger().warning(
					"[StaffMode Updater] Version " + updateChecker.getVersion()
							+ " has been released! Download it here: "
							+ updateChecker.getLink());
		}
	}
	@SuppressWarnings("unused")
	private void SaveConfig() {
		ConfigManager.getInstance().SaveConfig();
		ConfigManager.getInstance().SaveDataConfig();	
	}
	private void Metrics() {
		
		try {
		      Metrics metrics = new Metrics(this);
		      metrics.start();
		    } catch (IOException e) {
		      e.printStackTrace();
		      Bukkit.getLogger().warning(
						"StaffMode Metrics Had A Problem Starting! Dont Worry! You May Still Use The Plugin!");
		    }
	}
	    public void logToFile(String message)
	     
        {
     
            try
            {
                File dataFolder = getDataFolder();
                if(!dataFolder.exists())
                {
                    dataFolder.mkdir();
                }
     
                File saveTo = new File(getDataFolder(), "StaffChatLogger.yml");
                if (!saveTo.exists())
                {
                    saveTo.createNewFile();
                }
     
     
                FileWriter fw = new FileWriter(saveTo, true);
     
                PrintWriter pw = new PrintWriter(fw);
     
                pw.println(message);
     
                pw.flush();
     
                pw.close();
     
            } catch (IOException e)
            {
     
                e.printStackTrace();
     
            }
            
     
        }
	}
	