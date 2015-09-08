package staffmode.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StaffModeItems implements Listener {

	public StaffModeItems() {

	}

	static StaffModeItems instance = new StaffModeItems();

	public static StaffModeItems getInstance() {
		return instance;
	}

	public void LeaveStaffMode(Player p) {
		ItemStack Leave = new ItemStack(Material.BARRIER, 1);
		ItemMeta LeaveMeta = Leave.getItemMeta();
		LeaveMeta.setDisplayName(ChatColor.RED + "Disable StaffMode");
		Leave.setItemMeta(LeaveMeta);
		p.getInventory().setItem(8, Leave);
		p.updateInventory();
	}

	public void AdminGUI(Player p) {
		ItemStack AdminGUI = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta AdminGMeta = AdminGUI.getItemMeta();
		AdminGMeta.setDisplayName(ChatColor.RED + "Admin GUI");
		AdminGUI.setItemMeta(AdminGMeta);
		p.getInventory().setItem(0, AdminGUI);
		p.updateInventory();
	}

	public void RandomPlayerTeleport(Player p) {
		ItemStack RTP = new ItemStack(Material.COMPASS, 1);
		ItemMeta RTPMeta = RTP.getItemMeta();
		RTPMeta.setDisplayName(ChatColor.RED + "Teleport To A Random Player");
		RTP.setItemMeta(RTPMeta);
		p.getInventory().setItem(2, RTP);
		p.updateInventory();

	}
	public void PlayerInformation(Player p) {
		ItemStack PI = new ItemStack(Material.STICK, 1);
		ItemMeta RTPMeta = PI.getItemMeta();
		RTPMeta.setDisplayName(ChatColor.RED + "Right Click Me On A Player For Information!");
		PI.setItemMeta(RTPMeta);
		p.getInventory().setItem(6, PI);
		p.updateInventory();
		
	}
}
