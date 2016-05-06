package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;

public class TpHere implements CommandExecutor {


	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		  if (cmd.getName().equalsIgnoreCase("teleporthere")) {
	    if (!sender.hasPermission("StaffMode.teleport")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }

	    if (!(sender instanceof Player)) {
	    	sender.sendMessage(ChatColor.RED + "You Must Be A Player");
	      return true;
	    }

	    Player p = (Player)sender;
	    if (args.length == 0) {
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	        "&cUsage: /tphere <player>"));
	      return true;
	    }

	    Player target = Bukkit.getPlayer(args[0]);
	    if (target == null) {
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	        "cPlayer " + args[0] + " is offline!"));
	      return true;
	    }

	    p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	      "&aTeleporting " + target.getName() + " to you."));
	    target.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	      "&aTeleporting you to " + p.getName() + "!"));
	    target.teleport(p);
	    return true;
	  }
		return false;
	}
}