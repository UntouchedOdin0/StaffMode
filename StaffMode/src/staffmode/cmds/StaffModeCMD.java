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
	
	public HashMap<UUID, Location> TimeWarpLocation = new HashMap<UUID, Location>();
	SaveInventory si = new SaveInventory();
	@EventHandler
	public void PluginDisable(PluginDisableEvent e) {
		
		for(final Player online :Bukkit.getOnlinePlayers()){
			
		if (StaffModeManager.getInstance().isInStaffMode(online) == false) return;
		
		online.sendMessage(ChatColor.RED + "A Reload Has Forced You To Become Visiable!"); 
		online.showPlayer(online);
		StaffModeManager.getInstance().setStaffMode(online, false);
		VanishManager.getInstance().setVanish(online, false);
		online.setAllowFlight(false);
		online.updateInventory();
		TimeWarpLocation.clear();
		
		si.loadInventory(online);
		
	} 

}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) 
		  {
				 if (!(sender instanceof Player)) {
					 sender.sendMessage(ChatColor.RED + "Players Only");
					 return true;
				 }
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("StaffMode")) {
				if (!sender.hasPermission("StaffMode.StaffMode")) {
					ChatMessages.getInstance().Nopermissions(sender);
					return true;
					
				}
				if (StaffModeManager.getInstance().isInStaffMode(player) == false) {
					StaffModeManager.getInstance().setStaffMode(player, true);
					VanishManager.getInstance().setVanish(player, true);
					
					 player.setAllowFlight(true);
					 ChatMessages.getInstance().StaffModeEnable(player);
					 ChatMessages.getInstance().StaffModeAllSeeEnable(sender, player);
					 TimeWarpLocation.put(player.getUniqueId(), player.getPlayer().getLocation());
					 Bukkit.getServer().getPluginManager().callEvent(new PlayerStaffModeEnableEvent(player));
					 player.setFoodLevel(20);
					 player.setHealth(20);
				     player.setFireTicks(0);
				     try {
						si.saveInventory(player);
					} catch (IOException e) {
						e.printStackTrace();
					}
					 StaffModeItems.getInstance().AdminGUI(player);
					 StaffModeItems.getInstance().LeaveStaffMode(player);
					 StaffModeItems.getInstance().RandomPlayerTeleport(player);
					 StaffModeItems.getInstance().PlayerInformation(player);
					 player.updateInventory();
					
					
					
					return true;
				} else {					
					
					try {

					StaffModeManager.getInstance().setStaffMode(player, false);
					VanishManager.getInstance().setVanish(player, false);
					ChatMessages.getInstance().StaffModeDisable(sender);
					ChatMessages.getInstance().StaffModeAllSeeDisable(sender, player);
					player.getInventory().clear();
					player.updateInventory();
					player.setAllowFlight(false);
					player.teleport(TimeWarpLocation.get(player.getPlayer().getUniqueId()));
					TimeWarpLocation.remove(player);
					Bukkit.getServer().getPluginManager().callEvent(new PlayerStaffModeDisableEvent(player));
					player.updateInventory();
					si.loadInventory(player);
					return true;
					
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				
			}
	  
		return true;
}
}