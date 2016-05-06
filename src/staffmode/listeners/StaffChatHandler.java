package staffmode.listeners;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import staffmode.main.Main;
import staffmode.utils.ConfigManager;
import staffmode.utils.StaffChatManager;



public class StaffChatHandler implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		if (StaffChatManager.getInstance().isInStaffChat(p))
		{
		{

			for (Player online : Bukkit.getOnlinePlayers()) {
			{
				{
				    Date date = new Date();
				    DateFormat filenameDateFormat = new SimpleDateFormat("[dd-MM-yyyy][HH:mm:ss]");
					e.setCancelled(true);
				        if (online.hasPermission("StaffMode.StaffChat")) {
					online.sendMessage(ChatColor.DARK_RED + (ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance()
							.getConfig().getString("Messages.StaffChatPrefix") + ChatColor.DARK_GRAY  + ChatColor.GREEN + p.getDisplayName() + ChatColor.DARK_GRAY + " >> " + ChatColor.AQUA + e.getMessage().replaceAll("&([l-ok0-8k9a-f])", "§$1"))));
					Main.getInstance().logToFile(filenameDateFormat.format(date) + p.getName() + " >> " + e.getMessage());
					
				        }
				}
			}
			}
		}
		}
	}
}
