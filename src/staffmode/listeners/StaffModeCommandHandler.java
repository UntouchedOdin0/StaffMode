package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import staffmode.utils.ConfigManager;
import staffmode.utils.StaffModeManager;

public class StaffModeCommandHandler implements Listener {
	
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
