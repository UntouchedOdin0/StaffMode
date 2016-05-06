package staffmode.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class GodManager {

	public GodManager() {
		
	}

	static GodManager instance = new GodManager();

	public static GodManager getInstance() {
		return instance;
	}

	private ArrayList<Player> God = new ArrayList<Player>();

	public boolean isinGod(Player p) {
		return God.contains(p);
	}	

	public void setGod(Player p, boolean b) {
		if (b) {
			if (isinGod(p))
				return;
			God.add(p);
		} else {
			if (!isinGod(p))
				return;
		    God.remove(p);
		}
	}
}
