package staffmode.cmds;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;
import staffmode.utils.SaveInventory;
import staffmode.utils.StaffModeItems;
import staffmode.utils.StaffModeManager;
import staffmode.utils.VanishManager;

public class StaffModeCMD implements CommandExecutor {

	ArrayList<String> StaffMode = new ArrayList<String>();
	SaveInventory si = new SaveInventory();
	static StaffModeCMD instance = new StaffModeCMD();

	public static StaffModeCMD getInstance() {
		return instance;
	}
	public boolean isInStaffMode(Player p) {
		return StaffMode.contains(p);
	}
	
	

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			for (Player online : Bukkit.getOnlinePlayers()) {
			if (cmd.getName().equalsIgnoreCase("StaffMode")) {
				if (!sender.hasPermission("StaffMode.StaffMode")) {
					ChatMessages.getInstance().Nopermissions(sender);
					return true;
					
				}
				if (!StaffModeManager.getInstance().isInStaffMode(player)) {
					StaffModeManager.getInstance().setStaffMode(player, true);
					VanishManager.getInstance().setVanish(player, true);
					 player.setAllowFlight(true);
					 ChatMessages.getInstance().StaffModeEnable(player);
					 ChatMessages.getInstance().StaffModeAllSeeEnable(sender, player);
					 
					
					
					 try {
						 si.saveInventory(player);
					 }
		                catch (IOException e) {
		                	e.printStackTrace();
		      		      Bukkit.getLogger().warning(
		  						"StaffMode Save Inventory! Please Ignore This!");
		                }
					 player.getInventory().clear();
					 StaffModeItems.getInstance().AdminGUI(player);
					 StaffModeItems.getInstance().LeaveStaffMode(player);
					 StaffModeItems.getInstance().RandomPlayerTeleport(player);
					 StaffModeItems.getInstance().PlayerInformation(player);
					 player.updateInventory();
					
					
					
					return false;
				}
				if (StaffModeManager.getInstance().isInStaffMode(player)) {
					StaffModeManager.getInstance().setStaffMode(player, false);
					VanishManager.getInstance().setVanish(player, false);
					ChatMessages.getInstance().StaffModeDisable(sender);
					ChatMessages.getInstance().StaffModeAllSeeDisable(sender, player);
					player.getInventory().clear();
					player.updateInventory();
					player.setAllowFlight(false);
					si.loadInventory(player);
					player.updateInventory();
					return false;
				}

				}
				
			}
	  }
		return false;
}
}