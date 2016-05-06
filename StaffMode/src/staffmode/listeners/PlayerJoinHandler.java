package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import staffmode.main.Main;
import staffmode.main.UpdateChecker;
import staffmode.utils.VanishManager;

public class PlayerJoinHandler implements Listener {

	protected UpdateChecker updateChecker;

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (p.isOp() || p.hasPermission("StaffMode.Updater")) {
			this.updateChecker = new UpdateChecker(Main.getInstance(),
					"http://dev.bukkit.org/bukkit-plugins/staffmode-sm/files.rss");

			if (this.updateChecker.updateNeeded()) {
				p.sendMessage(ChatColor.AQUA + "[StaffModeLite Updater] "
						+ ChatColor.DARK_AQUA + "Version: "
						+ this.updateChecker.getVersion()
						+ " has been released! Download it here: "
						+ ChatColor.RED + this.updateChecker.getLink());
			}
		}

		if (p.hasPermission("StaffMode.Vanish.See")) {
			for (Player Vanished : VanishManager.getInstance().listInVanish()) {
				p.showPlayer(Vanished);
			}
		} else {
			for (Player Vanished : VanishManager.getInstance().listInVanish()) {
				p.hidePlayer(Vanished);
			}
		}
	}
}