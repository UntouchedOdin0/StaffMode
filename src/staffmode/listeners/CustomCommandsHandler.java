package staffmode.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import staffmode.utils.ChatMessages;
import staffmode.utils.ConfigManager;

public class CustomCommandsHandler implements Listener {

	@EventHandler
	public void onCustomCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage().toLowerCase();
	    for (int i = 0; i < Integer.parseInt(ConfigManager.getInstance().getConfig().getString("Commands")); i++) {
	        int i2 = i + 1;
	          String PlayerMessage = ConfigManager.getInstance().getConfig().getString(String.valueOf(i2) + ".messagetoplayer");
	          String ConsoleCommand = ConfigManager.getInstance().getConfig().getString(String.valueOf(i2) + ".consolecommand");
	          ConsoleCommand = ConsoleCommand.replaceAll("%player%", p.getName());
	        String permission = ConfigManager.getInstance().getConfig().getString(String.valueOf(i2) + ".permission");
	        String CustomCommands = ConfigManager.getInstance().getConfig().getString(String.valueOf(i2) + ".command");
	        if (msg.equalsIgnoreCase(CustomCommands)) {
	        	e.setCancelled(true);
	        	if (!p.hasPermission(permission)) {
	        		ChatMessages.getInstance().Nopermissions(p);
	        		return;
	        	}
	        	Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', ConsoleCommand));
	        	
	        	p.sendMessage(ChatColor.GREEN + PlayerMessage);
	    }
		}
}
	
}
