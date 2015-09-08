package staffmode.cmds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;


public class Tp implements CommandExecutor {
	
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	    if (!sender.hasPermission("StaffMode.teleport")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }

	    if (!(sender instanceof Player)) {
	      sender.sendMessage(ChatColor.RED + "You Must Be a Player!");
	      return true;
	    }

	    Player p = (Player)sender;
	    if (args.length == 0) {
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	        "&cUsage: /tp <player>"));
	      return true;
	    }

	    Player target = Bukkit.getPlayer(args[0]);
	    if (target == null) {
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	        "&cPlayer " + args[0] + " is offline!"));
	      return true;
	    }

	    p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	      "&aTeleporting you to " + target.getName() + "!"));
	    p.teleport(target);
		return false;
	  }
}
