package staffmode.utils;

import java.util.ArrayList;

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
		if (b) {
			if (isVanished(p))
				return;
			Vanish.add(p);
		} else {
			if (!isVanished(p))
				return;
			Vanish.remove(p);
		}
	}

	public ArrayList<Player> listInVanish() {
		return Vanish;
	}
}
