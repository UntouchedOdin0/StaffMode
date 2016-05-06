package staffmode.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import staffmode.utils.GodManager;

public class GodHandler implements Listener {
	
	 @EventHandler(priority=EventPriority.HIGHEST)
	  public void onEntityDamage(EntityDamageEvent e)
	  {
	    if (e.isCancelled()) return;
	    Entity entity = e.getEntity();

	    if ((entity instanceof Player)) {
	      Player p = (Player)entity;
	      if (GodManager.getInstance().isinGod(p))
	        e.setCancelled(true);
	    }
	  }
}

