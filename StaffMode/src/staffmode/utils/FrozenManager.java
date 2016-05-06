package staffmode.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class FrozenManager {

	public FrozenManager() {
		
	}

	static FrozenManager instance = new FrozenManager();

	public static FrozenManager getInstance() {
		return instance;
	}

	private ArrayList<Player> frozen = new ArrayList<Player>();

	public boolean isfrozen(Player p) {
		return frozen.contains(p);
	}	

	public void setfrozenMode(Player p, boolean b) {
		if (b) {
			if (isfrozen(p))
				return;
			frozen.add(p);
		} else {
			if (!isfrozen(p))
				return;
			frozen.remove(p);
		}
	}
}
