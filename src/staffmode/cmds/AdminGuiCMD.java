package staffmode.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.AdminGui;
import staffmode.utils.ChatMessages;

public class AdminGuiCMD implements CommandExecutor {
	private  AdminGui Gui;
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		 if (!(sender instanceof Player)) {
			 sender.sendMessage(ChatColor.RED + "Players Only");
			 return true;
		 }
		 Player p = (Player) sender;
		  if (cmd.getName().equalsIgnoreCase("AdminGui")) {
	    if (!sender.hasPermission("StaffMode.AdminGui")) {
	    	ChatMessages.getInstance().Nopermissions(sender);
	      return true;
	    }
	    p.sendMessage(ChatColor.GREEN + "Opening Admin Gui.....");
			Gui = new AdminGui();
			Gui.show(p);
			    }
		return false;
		
	}
}

