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
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
		VanishManager.getInstance().setVanish(p, b);
		
	}
	/**
	 * Enable / Disable StaffMode
	 */
	public static void setStaffMode(Player p, boolean b) {
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
		StaffModeManager.getInstance().setStaffMode(p, b);
	}
	/**
	 * Freeze/UnFreeze Player
	 */
	public static void setFreeze(Player p, boolean b) {
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
		FrozenManager.getInstance().setfrozenMode(p, b);
	}
	/**
	 * Enable / Disable StaffMode
	 */
	public static void setStaffChat(Player p, boolean b) {
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
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
	/**
	 * Check if Chat is Muted
	 */
	public static void isChatMuted() {
		ChatManager.getInstance().isMuted();
		
	}
	/**
	 * Check If Player is in StaffCjat
	 */
	public static void isinStaffChat(Player p) {
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
		StaffChatManager.getInstance().isInStaffChat(p);
	}
	/**
	 * Check If Player is Frozen
	 */
	public static void isfrozen(Player p) {
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
		FrozenManager.getInstance().isfrozen(p);
	}
	/**
	 * Check If Player Is In StaffMode
	 */
	public static void isInStaffMode(Player p) {
		if (p == null) {
			System.out.println("Could Not Find Player");
		} else
		StaffModeManager.getInstance().isInStaffMode(p);
	}
	/**
	 * Enable / Disable Vanish
	 */
	public static boolean isVanished(Player p) {
		return VanishManager.getInstance().isVanished(p);
		
		/**
		 * BroadCast Message
		 */
	}
		public static void DEBUG_MESSAGE(String message) {
	        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[DEBUG] &e" + message));
		}
}
