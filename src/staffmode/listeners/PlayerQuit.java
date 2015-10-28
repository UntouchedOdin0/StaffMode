package staffmode.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import staffmode.utils.FrozenManager;
import staffmode.utils.SaveInventory;
import staffmode.utils.StaffChatManager;
import staffmode.utils.StaffModeManager;
import staffmode.utils.VanishManager;

public class PlayerQuit implements Listener {
	
	SaveInventory si = new SaveInventory();
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		VanishManager.getInstance().setVanish(p, false);
		StaffChatManager.getInstance().setStaffChat(p, false);
		StaffModeManager.getInstance().setStaffMode(p, false);
		FrozenManager.getInstance().setfrozenMode(p, false);
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.showPlayer(p);
			return;
		}
	}
}

