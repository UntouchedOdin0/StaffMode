package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import staffmode.utils.ConfigManager;
import staffmode.utils.StaffModeManager;



public class StaffModeHandler implements Listener {

	@EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ConfigManager.getInstance().getConfig().getBoolean("Settings.StaffModePrefix"))
		if (StaffModeManager.getInstance().isInStaffMode(p)) e.setFormat
			(ChatColor.translateAlternateColorCodes('&', ConfigManager.getInstance()
					.getConfig().getString("Messages.StaffModePrefix") +  p.getDisplayName()  + ChatColor.AQUA  + " &8&l>> &b" +  e.getMessage()));
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
	      @EventHandler
	      public void onCommandProcess(PlayerCommandPreprocessEvent e)
	      {
	        String cmd = e.getMessage();
	        if ((StaffModeManager.getInstance().isInStaffMode(e.getPlayer())) && 
	          (!cmd.toLowerCase().startsWith("/kick")) && 
	          (!cmd.toLowerCase().startsWith("/ban")) && 
	          (!cmd.toLowerCase().startsWith("/warn")) && 
	          (!cmd.toLowerCase().startsWith("/warp")) && 
	          (!cmd.toLowerCase().startsWith("/kit")) && 
	          (!cmd.toLowerCase().startsWith("/staffchat")) && 
	          (!cmd.toLowerCase().startsWith("/sc")) && 
	          (!cmd.toLowerCase().startsWith("/kickall")) && 
	          (!cmd.toLowerCase().startsWith("/ekit")) && 
	          (!cmd.toLowerCase().startsWith("/ewarp")) && 
	          (!cmd.toLowerCase().startsWith("/mutechat")) && 
	          (!cmd.toLowerCase().startsWith("/mc")) && 
	          (!cmd.toLowerCase().startsWith("/clearchat")) && 
	          (!cmd.toLowerCase().startsWith("/cc")) && 
	          (!cmd.toLowerCase().startsWith("/sm")) && 
	          (!cmd.toLowerCase().startsWith("/admingui")) && 
	          (!cmd.toLowerCase().startsWith("/ag")) && 
	          (!cmd.toLowerCase().startsWith("/freeze")) && 
	          (!cmd.toLowerCase().startsWith("/tp")) && 
	          (!cmd.toLowerCase().startsWith("/tphere")) && 
	          (!cmd.toLowerCase().startsWith("/enderchest")) && 
	          (!cmd.toLowerCase().startsWith("/broadcast")) && 
	          (!cmd.toLowerCase().startsWith("/staffmode"))) {
	          e.getPlayer().sendMessage(
	            ChatColor.translateAlternateColorCodes('&', 
	            ConfigManager.getInstance().getConfig().getString("Messages.Prefix") + " &cThis Command is Disabled In StaffMode!"));
	          e.setCancelled(true);
	        } else {
	          e.setCancelled(false);
	          return;
	        }
	    
	  }
}
	      


