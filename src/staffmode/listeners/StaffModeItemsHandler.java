package staffmode.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import staffmode.utils.ConfigManager;
import staffmode.utils.StaffModeManager;


public class StaffModeItemsHandler implements Listener {


	@EventHandler
	public void PlayerInteractCompass(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack PlayerHand = p.getItemInHand();
		if (StaffModeManager.getInstance().isInStaffMode(p)) {
			if (PlayerHand != null && PlayerHand.getType() == Material.COMPASS) {
			List<Player> onlinePlayers = new ArrayList<Player>();
		for (Player online : Bukkit.getOnlinePlayers()) {
			onlinePlayers.add(online);
			Random random = new Random();
			int i = random.nextInt(onlinePlayers.size());
			Player randomPlayer = (Player) onlinePlayers.get(i);
			p.teleport(randomPlayer);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					ConfigManager.getInstance()
					.getConfig().getString("Messages.Prefix") + ChatColor.AQUA + " You Have Been Teleported To &6" + randomPlayer.getName()));
			return;
		}
			}
		}
		}
		
	

		@EventHandler
		public void PlayerInteractLeaveStaffMode(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			ItemStack PlayerHand = p.getItemInHand();
			if (StaffModeManager.getInstance().isInStaffMode(p)) {
				if (PlayerHand != null && PlayerHand.getType() == Material.BARRIER) {
		p.performCommand("StaffMode:StaffMode");
			
	}
			}
			}
		
		@EventHandler
		public void PlayerInteractAdminGUI(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			ItemStack PlayerHand = p.getItemInHand();
			if (StaffModeManager.getInstance().isInStaffMode(p)) {
				if (PlayerHand != null && PlayerHand.getType() == Material.DIAMOND_SWORD) {
		p.performCommand("StaffMode:adminGui");
			}
			}
		
		}
}

