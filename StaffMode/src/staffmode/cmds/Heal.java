package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.events.BroadCastEvent;
import staffmode.utils.ChatMessages;

public class Heal implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED
					+ "Only Players Can Do This Command");
			return true;
		}
	    if ((!(sender instanceof Player)) && (cmd.getName().equalsIgnoreCase("Feed")))
	    {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Not enough arguments!");
				sender.sendMessage(ChatColor.RED
						+ "Invalid Usage: /Heal <player>");
			} else if (args.length == 1) {
				Player target = sender.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(ChatColor.RED + "Player " + args[0]
							+ ChatColor.RED + " Was Not Found!");
				} else {
					target.setHealth(20);
					target.sendMessage(ChatColor.RED + sender.getName()
							+ ChatColor.GOLD + " healed you!");

					sender.sendMessage(ChatColor.GOLD + "You Healed "
							+ ChatColor.GREEN + target.getDisplayName());
				       Bukkit.getServer().getPluginManager().callEvent(new BroadCastEvent(target));
				}

			} else if (args.length >= 2) {
				sender.sendMessage(ChatColor.RED + "To many arguments!");
				sender.sendMessage(ChatColor.RED
						+ "Invalid Usage: /Heal <player>");
				return false;
			}

		}
	    Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("Heal")) {
			if (!sender.hasPermission("StaffMode.Heal")) {
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}

			p.setHealth(20);
			ChatMessages.getInstance().Heal(sender);
		       Bukkit.getServer().getPluginManager().callEvent(new BroadCastEvent(p));
		}
		return false;
	}
}