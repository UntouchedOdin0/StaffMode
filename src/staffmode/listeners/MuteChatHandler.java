package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import staffmode.utils.ChatManager;
import staffmode.utils.ConfigManager;



public class MuteChatHandler implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ChatManager.getInstance().isMuted()) {
			if (p.hasPermission("StaffMode.Mutechat.Bypass"))
				return;
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
					.getConfig().getString("Messages.Prefix") + ChatColor.RED + "Chat is currently muted!"));
			e.setCancelled(true);
		}
	}

}
