package staffmode.utils;

import java.util.ArrayList;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class FrozenManager {

	public FrozenManager() {
		
	}

	static FrozenManager instance = new FrozenManager();

	public static FrozenManager getInstance() {
		return instance;
	}

	private ArrayList<Player> frozen = new ArrayList<Player>();

	public boolean isfrozen(HumanEntity humanEntity) {
		return frozen.contains(humanEntity);
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
