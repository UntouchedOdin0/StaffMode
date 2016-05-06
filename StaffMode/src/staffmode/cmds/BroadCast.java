package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.events.BroadCastEvent;
import staffmode.utils.ChatMessages;
import staffmode.utils.ConfigManager;

public class BroadCast implements CommandExecutor 
{
	

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {

        Player p = (Player) sender;
	    if (cmd.getName().equalsIgnoreCase("BroadCast")) {
	    if (!sender.hasPermission("StaffMode.broadcast")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }

	    if (args.length < 1) {
	      sender.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	        "&8&l>> &cInvalid Ussage! use /Broadcast <Message>"));
	      return true;
	    }
        String message = null;
        message = args[0].trim();
        for (int ii = 1; ii != args.length; ii++) {
          message = message + " " + args[ii];
          }

       Bukkit.getServer().getPluginManager().callEvent(new BroadCastEvent(p));
	        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', 
	        		ConfigManager.getInstance()
					.getConfig().getString("Messages.Prefix") + ChatColor.AQUA + message));
	      }
		return false;
	}
}
