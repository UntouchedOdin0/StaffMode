package staffmode.main;

import java.util.logging.Level;

import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class IMain extends JavaPlugin {
	
	PluginManager pm = this.getServer().getPluginManager();
	
	String pluginname = "StaffMode";

	public abstract void load();
	
	public abstract void unload();
	
	public abstract void loadListeners();
	
	public abstract void registerCommands();
	
	@Override
	public void onEnable() {
		load();
		loadListeners();
		registerCommands();
		
	}
	@Override
	public void onDisable() {
		unload();
	}
	public final void loadListener(Listener lis) {
		
		pm.registerEvents(lis, this);
		
	}
	
	public String getPluginName() {
		
		return pluginname;
		
	}
	public Plugin getPlugin() {
		
		return pm.getPlugin(pluginname);
		
	}
	
	public final void log(String log, Level level) {
		
		this.getServer().getLogger().log(level, log);
	}
	
	public Server getBukkitServer() {
		return getServer();
	}
}
