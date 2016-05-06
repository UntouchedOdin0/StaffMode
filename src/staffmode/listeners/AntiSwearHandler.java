package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import staffmode.utils.ConfigManager;

public class AntiSwearHandler implements Listener {
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ConfigManager.getInstance().getConfig().getBoolean("Settings.AntiSwear"))
            for (String word : e.getMessage().split(" ")) {
                if (ConfigManager.getInstance().getConfig().getStringList("AntiSwearWords").contains(word)) {
		e.setCancelled(true);
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance().getConfig().getString("Messages.NoSwear")));
		
	}
            }
	}
}
