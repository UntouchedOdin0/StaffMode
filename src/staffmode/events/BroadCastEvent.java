package staffmode.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BroadCastEvent extends Event {
	
	 Player p;
	
	 public BroadCastEvent(Player p) {
			this.p = p;
		}
		
		private static final HandlerList handlers = new HandlerList();
		 
		public HandlerList getHandlers() {
		    return handlers;
		}
		 
		public static HandlerList getHandlerList() {
		    return handlers;
		}
		
		public Player getPlayer() {
			return this.p;
		}

	}