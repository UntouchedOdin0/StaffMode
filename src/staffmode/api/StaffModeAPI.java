package staffmode.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import staffmode.events.BroadCastEvent;
import staffmode.events.ClearChatEvent;
import staffmode.events.MuteChatEvent;
import staffmode.events.PlayerHealEvent;
import staffmode.events.PlayerStaffModeDisableEvent;
import staffmode.events.PlayerStaffModeEnableEvent;
import staffmode.events.PlayerVanishDisableEvent;
import staffmode.events.PlayerVanishEnableEvent;
import staffmode.main.Main;
import staffmode.utils.ChatManager;
import staffmode.utils.ConfigManager;
import staffmode.utils.FrozenManager;
import staffmode.utils.GodManager;
import staffmode.utils.StaffChatManager;
import staffmode.utils.StaffModeManager;
import staffmode.utils.VanishManager;

public class StaffModeAPI {

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
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
				'&',
				ConfigManager.getInstance().getConfig()
						.getString("Messages.Prefix")
						+ ChatColor.AQUA + message));
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

	}

	/**
	 * Get A Players Ping
	 */
	public int getPing(Player p) {
		return ((CraftPlayer) p).getHandle().ping;
	}

	/**
	 * DEBUG Message
	 */
	public static void DEBUG(String message) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
				"&8[DEBUG] &e" + message));
	}

	/**
	 * Calls All StaffMode Events
	 */
	public static void CALLALLSTAFFMODEEVENTS(Player p) {
		Bukkit.getServer().getPluginManager().callEvent(new BroadCastEvent(p));
		Bukkit.getServer().getPluginManager().callEvent(new ClearChatEvent(p));
		Bukkit.getServer().getPluginManager().callEvent(new MuteChatEvent(p));
		Bukkit.getServer().getPluginManager().callEvent(new PlayerHealEvent(p));
		Bukkit.getServer().getPluginManager()
				.callEvent(new PlayerStaffModeDisableEvent(p));
		Bukkit.getServer().getPluginManager()
				.callEvent(new PlayerStaffModeEnableEvent(p));
		Bukkit.getServer().getPluginManager()
				.callEvent(new PlayerVanishEnableEvent(p));
		Bukkit.getServer().getPluginManager()
				.callEvent(new PlayerVanishDisableEvent(p));
	}

	/**
	 * Disable StaffMode Using AnotherPlugin 
	 */
	public static void DISABLE_STAFFMODE(Plugin plugin) {
		Bukkit.getServer().getPluginManager().disablePlugin(Main.getInstance());
		System.out
				.println("[StaffMode] StaffMode Has Been Disabled By Another Plugin.");
		System.out.println("[StaffMode] StaffMode Has Been Disabled By "
				+ plugin.getName());
	}

	/**
	 * Edit The StaffMode Config From Another Plugin
	 * 
	 */
	public static FileConfiguration getConfig() {
		return ConfigManager.getInstance().getConfig();	}

	/**
	 * Reset Player Status in StaffMode
	 * 
	 */
	public static void RESET_STAFFMODE_PLAYER(Player p) {
		CALLALLSTAFFMODEEVENTS(p);
		FrozenManager.getInstance().setfrozenMode(p, false);
		VanishManager.getInstance().setVanish(p, false);
		StaffModeManager.getInstance().setStaffMode(p, false);
		StaffChatManager.getInstance().setStaffChat(p, false);
		GodManager.getInstance().setGod(p, false);
	}
}
