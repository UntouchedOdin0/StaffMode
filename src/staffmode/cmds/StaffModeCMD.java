package staffmode.cmds;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

import staffmode.events.PlayerStaffModeDisableEvent;
import staffmode.events.PlayerStaffModeEnableEvent;
import staffmode.utils.ChatMessages;
import staffmode.utils.SaveInventory;
import staffmode.utils.StaffModeItems;
import staffmode.utils.StaffModeManager;
import staffmode.utils.VanishManager;

public class StaffModeCMD implements CommandExecutor, Listener {
	
	SaveInventory si = new SaveInventory();
	static StaffModeCMD instance = new StaffModeCMD();
	public HashMap<UUID, Location> TimeWarpLocation = new HashMap<UUID, Location>();

	public static StaffModeCMD getInstance() {
		return instance;
	}
	
	@EventHandler
	public void PluginDisable(PluginDisableEvent e) {
		for(final Player online :Bukkit.getOnlinePlayers()){
		if (!StaffModeManager.getInstance().isInStaffMode(online)) {
			return;
		}
		online.sendMessage(ChatColor.RED + "A Reload Has Forced You To Become Visiable!"); 
		online.showPlayer(online);
		StaffModeManager.getInstance().setStaffMode(online, false);
		VanishManager.getInstance().setVanish(online, false);
		online.setAllowFlight(false);
		si.loadInventory(online);
		online.updateInventory();
		TimeWarpLocation.clear();
		return;
 		
	} 

}


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
					 online.hidePlayer(player);
					 TimeWarpLocation.put(player.getUniqueId(), player.getPlayer().getLocation());
					 Bukkit.getServer().getPluginManager().callEvent(new PlayerStaffModeEnableEvent(player));
					 player.setFoodLevel(20);
					 player.setHealth(20);
				        player.setFireTicks(0);
					
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
					online.showPlayer(player);
					player.updateInventory();
					player.teleport(TimeWarpLocation.get(player.getPlayer().getUniqueId()));
					TimeWarpLocation.remove(online);
					 Bukkit.getServer().getPluginManager().callEvent(new PlayerStaffModeDisableEvent(player));
					return false;
				}

				}
				
			}
	  }
		return false;
}
}