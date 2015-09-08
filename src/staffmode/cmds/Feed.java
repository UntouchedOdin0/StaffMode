package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;

public class Feed implements CommandExecutor {

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
	        sender.sendMessage(ChatColor.RED + "Invalid Usage: /Feed <Feed>");
	      }
	      else if (args.length == 1) {
	        Player target = sender.getServer().getPlayer(args[0]);
	        if (target == null) {
	          sender.sendMessage(ChatColor.RED + "Player " + args[0] + ChatColor.RED + " Was Not Found!");
	        } else {
	          target.setFoodLevel(20);
	          target.sendMessage(ChatColor.RED + sender.getName() + ChatColor.GOLD + " Fed you!");

	          sender.sendMessage(ChatColor.GOLD + "You Fed " + ChatColor.GREEN + target.getDisplayName());
	        }

	      }
	      else if (args.length >= 2) {
	        sender.sendMessage(ChatColor.RED + "To many arguments!");
	        sender.sendMessage(ChatColor.RED + "Invalid Usage: /Feed <player>");
	      }

	    }
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("Feed")) {
			if (!sender.hasPermission("StaffMode.Feed")) {
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}
			p.setFoodLevel(20);
			ChatMessages.getInstance().Feed(sender);
			return false;
			
		}
		return false;
	}
}