package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import staffmode.utils.ConfigManager;
import staffmode.utils.StaffModeManager;



public class StaffModeHandler implements Listener {

	@EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (StaffModeManager.getInstance().isInStaffMode(p)) e.setFormat
			(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance()
					.getConfig().getString("Messages.StaffModePrefix") +  e.getPlayer().getDisplayName()  + ChatColor.AQUA  + " " +  e.getMessage()));
	}
	  public int getPing(Player p)
	  {
	    return ((CraftPlayer)p).getHandle().ping;
	  }

	 @EventHandler
	  public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player))) {
	      Player damager = (Player) e.getDamager();
	      Player p = (Player) e.getEntity();
	      if (StaffModeManager.getInstance().isInStaffMode(damager)) {
	    	  e.setCancelled(true);
	          damager.sendMessage(ChatColor.translateAlternateColorCodes('&',
	        "&b-&a-&b-&a- " + p.getName().toString() +" &bInformation &b-&a-&b-&a-"));
	          damager.sendMessage(ChatColor.translateAlternateColorCodes('&',
	        "&aUUID: " + p.getUniqueId().toString()));
	          damager.sendMessage(ChatColor.translateAlternateColorCodes('&',
	        "&aHealth: " + p.getHealth()));
	          damager.sendMessage(ChatColor.translateAlternateColorCodes('&',
	        "&aPing: " + getPing(p)));
	          damager.sendMessage(ChatColor.translateAlternateColorCodes('&',
	        "&aIP: " + p.getAddress().toString()));
	      } 
	      
	    }
	  }
}


