package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;

public class ClearInventory implements CommandExecutor {
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  	  {
		 if (!(sender instanceof Player)) {
			 sender.sendMessage(ChatColor.RED + "Players Only");
			 return true;
		 }
		 Player p = (Player) sender;
		  if (cmd.getName().equalsIgnoreCase("clearinventory")) {
	    if (!sender.hasPermission("StaffMode.clearinventory")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }
	    ChatMessages.getInstance().ClearInventory(p);
	    p.getInventory().clear();
	    p.updateInventory();
	    }
		return false;
	  }
}
