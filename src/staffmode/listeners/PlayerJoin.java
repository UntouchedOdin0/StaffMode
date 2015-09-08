package staffmode.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import staffmode.utils.VanishManager;


public class PlayerJoin implements Listener {
	

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("StaffMode.Vanish.See")) {
			for (Player online : VanishManager.getInstance().listInVanish()) {
				p.showPlayer(online);
			}
		} else {
				p.hidePlayer(p);
			}
		}
	}
