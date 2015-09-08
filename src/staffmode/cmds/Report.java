package staffmode.cmds;

import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;
import staffmode.utils.ConfigManager;

public class Report implements CommandExecutor {
	
	
	@Override
public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
{
   Player p = (Player) sender;
	 if (cmd.getName().equalsIgnoreCase("Report"))
	      if (!sender.hasPermission("StaffMode.Report")) {
	    	  ChatMessages.getInstance().Nopermissions(sender);
	    	  return true;
	      }
	 
	 long reportTime = ((Long) ConfigManager.getInstance().getData()
				.getLong("players." + p.getName() + ".reportTime"))
				.longValue();

		long currentTime = new Date().getTime() - reportTime;

		if (currentTime / 1000 >= 60) {
	 
	 
	        if (args.length == 0) {
	          sender.sendMessage(ChatColor.translateAlternateColorCodes(
	            '&', 
	        		  "&8&l» &cPlease Use /Report <Player> <Reason>"));
	          return true;
	        }
	        if (args.length == 1) {
		          if ((sender instanceof Player)) {
	        
	      }
	return false;
}
	        Player target = Bukkit.getPlayer(args[0]);
	        if (target == null) {
	          p.sendMessage(ChatColor.RED + "Player " + args[0] + " is offline!");
	          return true;
	        }

	        String message = null;
	        message = args[1].trim();
	        for (int ii = 2; ii != args.length; ii++) {
	          message = message + " " + args[ii];
		            
		          }
	        	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', args[0] + " &aHas Been Reported!"));
	        	 for (Player online : Bukkit.getOnlinePlayers()) {
	        	      if (online.hasPermission("StaffMode.Report.See")) {
	        	        online.sendMessage(ChatColor.translateAlternateColorCodes('&', 
	        	        		ConfigManager.getInstance().getConfig().getString("Messages.ReportMessageToStaff")
	        	        		        .replaceAll("%PLAYER%", p.getName())
	        	        				.replaceAll("%TARGET%", target.getName()) + message));
	        	        
	        	        
	    				ConfigManager
						.getInstance()
						.getData()
						.set("players." + p.getName() + ".reportTime",
								System.currentTimeMillis());

				ConfigManager.getInstance().SaveDataConfig();
				return true;
	        	      }

	        	      
	        	 }
				return false;
		}
		return false;
}
}
	