package staffmode.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class VanishManager implements Listener {

	public VanishManager() {

	}

	static VanishManager instance = new VanishManager();

	public static VanishManager getInstance() {
		return instance;
	}

	private ArrayList<Player> Vanish = new ArrayList<Player>();

	public boolean isVanished(Player p) {
		return Vanish.contains(p);
	}

	public void setVanish(Player p, boolean b) {
		if (b == true) {

			Vanish.add(p);
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("StaffMode.Vanish.See")) {
					online.showPlayer(p);

				} else {
					online.hidePlayer(p);
				}
			}
		}
		if (b == false) {
			Vanish.remove(p);
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.showPlayer(p);
			}
		}
	}

	public ArrayList<Player> listInVanish() {
		return Vanish;
	}
}
