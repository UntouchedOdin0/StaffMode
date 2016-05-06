package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import staffmode.utils.ChatMessages;
import staffmode.utils.ConfigManager;

public class StaffModeReload implements CommandExecutor {
	  
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		  if (cmd.getName().equalsIgnoreCase("smr")) {
	    if (!sender.hasPermission("StaffMode.reload")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }
	    ConfigManager.getInstance().SaveConfig();
	    ConfigManager.getInstance().SaveDataConfig();
	    ConfigManager.getInstance().reloadConfig();
	    ConfigManager.getInstance().reloadData();
	    sender.sendMessage(ChatColor.GREEN + "StaffMode Configs Have been Reloaded");
		return true;

		  }
		return false;
}
}

