package staffmode.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ChatMessages implements Listener {

	public ChatMessages() {

	}

	static ChatMessages instance = new ChatMessages();

	public static ChatMessages getInstance() {
		return instance;
	}


	public void Prefix(Player p) {
		p.sendMessage
		(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix")));
	}
	public void IN_STAFFMODE_DISABLED_CMDS(Player p) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ChatColor.RED + "This Command Is Disabled In StaffMode!"));
	}
	public void PrefixBroadCast() {
		Bukkit.broadcastMessage
		(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix")));
	}

	public void Nopermissions(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +  ConfigManager.getInstance()
				.getConfig().getString("Messages.NoPermission")));
	}

	public void ClearChat(CommandSender p) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
				'&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +
				ConfigManager.getInstance().getConfig()
						.getString("Messages.ClearChat")
						.replaceAll("%PLAYER%", p.getName())));
	}

	public void MuteChat(CommandSender p) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
				'&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +
				ConfigManager.getInstance().getConfig()
						.getString("Messages.MuteChat")
						.replaceAll("%PLAYER%", p.getName())));

	}

	public void UnMuteChat(CommandSender p) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
				'&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +
				ConfigManager.getInstance().getConfig()
						.getString("Messages.UnMuteChat")
						.replaceAll("%PLAYER%", p.getName())));
	}

	public void StaffModeEnable(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.StaffModeEnable")));
		;
	}

	public void StaffModeDisable(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.StaffModeDisable")));
	}

	public void VanishEnable(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.VanishEnable")));
	}

	public void VanishDisable(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.VanishDisable")));
	}

	public void ClearInventory(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes(
				'&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +
				ConfigManager.getInstance().getConfig()
						.getString("Messages.ClearInventory")
						.replaceAll("%PLAYER%", Player.getName())));
		;
	}

	public void Feed(CommandSender p) {
		p.sendMessage(ChatColor.translateAlternateColorCodes(
				'&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +
				ConfigManager.getInstance().getConfig()
						.getString("Messages.Feed")
						.replaceAll("%PLAYER%", p.getName())));
	}

	public void Heal(CommandSender Player) {
		Player.sendMessage(ChatColor.translateAlternateColorCodes(
				'&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") +
				ConfigManager.getInstance().getConfig()
						.getString("Messages.Heal")
						.replaceAll("%PLAYER%", Player.getName())));
	}

	public void FlyEnable(CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.FlyEnable")));
	}

	public void FlyDisable(CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.FlyDisable")));
	}
	public void StaffModeAllSeeEnable(CommandSender sender, Player Player) {
		if (StaffModeManager.getInstance().isInStaffMode(Player));
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("StaffMode.StaffMode.See")) {
		online.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
				.getConfig().getString("Messages.StaffModeSeeEnable").replaceAll("%PLAYER%", Player.getName())));
				}
			}
	}
	
	public void StaffModeAllSeeDisable(CommandSender sender, Player Player) {
		if (StaffModeManager.getInstance().isInStaffMode(Player));
		for (Player online : Bukkit.getOnlinePlayers()) {
			if (online.hasPermission("StaffMode.StaffMode.See")) {
	online.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
			.getConfig().getString("Messages.Prefix") + ConfigManager.getInstance()
			.getConfig().getString("Messages.StaffModeSeeDisable").replaceAll("%PLAYER%", Player.getName())));
			}
		}
}

	}
