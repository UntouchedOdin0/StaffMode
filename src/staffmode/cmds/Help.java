package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import staffmode.utils.ChatMessages;

public class Help implements CommandExecutor {
	  
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		  if (cmd.getName().equalsIgnoreCase("SHelp")) {
	    if (!sender.hasPermission("StaffMode.Help")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&7&l----- &b&lStaffMode Help &7&l---------"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l----- &bCoded By &b&lxXkguyXx &7&l--------"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&7&l----- Thanks To &b&lVextricity! &7&l-----"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lStaffMode Commands: "));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&b&l/ClearChat"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Vanish"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l/StaffMode"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/MuteChat"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/StaffChat"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l/Freeze"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Warn"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Heal"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l/Fly"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l/Tp"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/TpHere")); 
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Ci")); 
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Report")); 
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/EnderChest"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/WorkBench")); 
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Admingui"));
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&b&l/Broadcast"));
	    
	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lThank You For Using This Plugin!")); 
		  }
		return false;
		  
	  }
}

