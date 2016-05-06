package staffmode.utils;

import org.bukkit.ChatColor;
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

	@SuppressWarnings("deprecation")
	public void LeaveStaffMode(Player p) {
		//ItemStack Leave = new ItemStack(Material.BARRIER, 1);
		ItemStack Leave = new ItemStack(ConfigManager.getInstance().getConfig().getInt("Items.LeaveStaffMode"));
		ItemMeta LeaveMeta = Leave.getItemMeta();
		LeaveMeta.setDisplayName(ChatColor.RED + "Disable StaffMode");
		Leave.setItemMeta(LeaveMeta);
		p.getInventory().setItem(8, Leave);
		p.updateInventory();
	}

	@SuppressWarnings("deprecation")
	public void AdminGUI(Player p) {
		ItemStack AdminGuiConfig = new ItemStack(ConfigManager.getInstance().getConfig().getInt("Items.AdminGui"));
		//ItemStack AdminGuiConfig = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta AdminGMeta = AdminGuiConfig.getItemMeta();
		AdminGMeta.setDisplayName(ChatColor.RED + "Admin GUI");
		AdminGuiConfig.setItemMeta(AdminGMeta);
		p.getInventory().setItem(0, AdminGuiConfig);
		p.updateInventory();
	}

	@SuppressWarnings("deprecation")
	public void RandomPlayerTeleport(Player p) {
		//ItemStack RTP = new ItemStack(Material.COMPASS, 1);
		ItemStack RTP = new ItemStack(ConfigManager.getInstance().getConfig().getInt("Items.RandomTeleport"));
		ItemMeta RTPMeta = RTP.getItemMeta();
		RTPMeta.setDisplayName(ChatColor.RED + "Teleport To A Random Player");
		RTP.setItemMeta(RTPMeta);
		p.getInventory().setItem(2, RTP);
		p.updateInventory();

	}
	@SuppressWarnings("deprecation")
	public void PlayerInformation(Player p) {
		ItemStack PI = new ItemStack(ConfigManager.getInstance().getConfig().getInt("Items.PLAYERINFORMATION"));
		//ItemStack PI = new ItemStack(Material.STICK, 1);
		ItemMeta RTPMeta = PI.getItemMeta();
		RTPMeta.setDisplayName(ChatColor.RED + "Right Click Me On A Player For Information!");
		PI.setItemMeta(RTPMeta);
		p.getInventory().setItem(6, PI);
		p.updateInventory();
		
	}
}
