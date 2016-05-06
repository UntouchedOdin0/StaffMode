package staffmode.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import staffmode.utils.VanishManager;


public class VanishHandler implements Listener {

	@EventHandler
	public void onPlayerPickUp(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (VanishManager.getInstance().isVanished(p))
			e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (VanishManager.getInstance().isVanished(p))
			e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (VanishManager.getInstance().isVanished(p))
			e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (VanishManager.getInstance().isVanished(p))
			e.setCancelled(true);
	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {

		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (VanishManager.getInstance().isVanished(p))
				e.setCancelled(true);
		}
	}
}

