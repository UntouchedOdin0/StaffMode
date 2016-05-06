package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;

public class Fly implements CommandExecutor {

	 public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
	  {
		 if (!(sender instanceof Player)) {
			 sender.sendMessage(ChatColor.RED + "Only Players Can Do This Command");
		 }
		 Player p = (Player) sender;
		 if (cmd.getName().equalsIgnoreCase("Fly")) {
	    if (!sender.hasPermission("StaffMode.fly")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }
	    if (args.length == 0) {
	      if (p.getAllowFlight()) {
	        p.setAllowFlight(false);
	        ChatMessages.getInstance().FlyDisable(sender);
	      }
	      else {
	        p.setAllowFlight(true);
	        ChatMessages.getInstance().FlyEnable(sender);
	    
	    	}
	    }
		 }
	    
		return false;
	  }
}