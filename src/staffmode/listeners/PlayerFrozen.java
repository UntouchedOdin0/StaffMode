package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import staffmode.utils.ConfigManager;
import staffmode.utils.FrozenManager;



public class PlayerFrozen implements Listener {
	
	
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent event) {
	    Player player = event.getPlayer();

	    if (FrozenManager.getInstance().isfrozen(player)) player.teleport(player);
	    if (FrozenManager.getInstance().isfrozen(player)) event.getPlayer().sendMessage((ChatColor.translateAlternateColorCodes('&',ConfigManager.getInstance()
				.getConfig().getString("Messages.Prefix") + ChatColor.RED + "You Are Currently Frozen!")));
    } 
	  }
