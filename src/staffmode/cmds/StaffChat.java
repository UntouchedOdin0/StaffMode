package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;
import staffmode.utils.StaffChatManager;

public class StaffChat implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only Players Can Use This CMD!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("StaffChat")) {
			if (!p.hasPermission("StaffMode.StaffChat")) { 
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}
			if (StaffChatManager.getInstance().isInStaffChat(p)) {
				StaffChatManager.getInstance().setStaffChat(p, false);
			sender.sendMessage(ChatColor.AQUA + "Staff Chat Has Been " + ChatColor.RED + " Disabled!");
			} else {
				StaffChatManager.getInstance().setStaffChat(p, true);
					sender.sendMessage(ChatColor.AQUA + "Staff Chat Has Been " + ChatColor.GREEN + " Enabled!");
			}
		}
		return true;
	}
}