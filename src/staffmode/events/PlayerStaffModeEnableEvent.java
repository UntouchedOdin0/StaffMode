package staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerStaffModeEnableEvent extends Event {
	
	 Player p;
	
	 public PlayerStaffModeEnableEvent(Player p) {
		 this.p = p;
	 }

     private static final HandlerList handlers = new HandlerList();
     
	public HandlerList getHandlers() {
        return handlers;
	}
	
	public Player getPlayer() {
		return this.p;
	}

}
