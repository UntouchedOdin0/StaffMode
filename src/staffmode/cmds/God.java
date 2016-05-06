package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;
import staffmode.utils.GodManager;

public class God implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can use this command!");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("God")) {
			if (!p.hasPermission("StaffMode.God")) { 
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}

			if (GodManager.getInstance().isinGod(p)) {
				GodManager.getInstance().setGod(p, false);
				 p.sendMessage(ChatColor.RED + "God Mode Disabled");

			} else {
				GodManager.getInstance().setGod(p, true);
				p.sendMessage(ChatColor.GREEN + "God Mode Enabled");
			}

		}
		return true;
	}

}
