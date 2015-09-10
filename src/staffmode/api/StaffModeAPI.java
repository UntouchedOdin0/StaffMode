package staffmode.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import staffmode.utils.ChatManager;
import staffmode.utils.ConfigManager;
import staffmode.utils.FrozenManager;
import staffmode.utils.StaffChatManager;
import staffmode.utils.StaffModeManager;
import staffmode.utils.VanishManager;

public class StaffModeAPI 
{
	private StaffModeAPI() {
		
	}
	/**
	 * Enable / Disable Vanish
	 */
	public static void setVanish(Player p, boolean b) {
		VanishManager.getInstance().setVanish(p, b);
		
	}
	/**
	 * Enable / Disable StaffMode
	 */
	public static void setStaffMode(Player p, boolean b) {
		StaffModeManager.getInstance().setStaffMode(p, b);
	}
	/**
	 * Freeze/UnFreeze Player
	 */
	public static void setFreeze(Player p, boolean b) {
		FrozenManager.getInstance().setfrozenMode(p, b);
	}
	/**
	 * Enable / Disable StaffMode
	 */
	public static void setStaffChat(Player p, boolean b) {
		StaffChatManager.getInstance().setStaffChat(p, b);
	}
	/**
	 * BroadCast Message
	 */
	public static void broadcastmessage(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', 
        		ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ChatColor.AQUA + message));
	}
	/**
	 * Mute / UnMute Chat
	 */
	public static void setChatMuted(boolean b) {
		ChatManager.getInstance().setMuted(b);
	}
}
