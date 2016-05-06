package staffmode.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class StaffModeManager {

	public StaffModeManager() {
		
	}

	static StaffModeManager instance = new StaffModeManager();

	public static StaffModeManager getInstance() {
		return instance;
	}

	private ArrayList<Player> StaffMode = new ArrayList<Player>();

	public boolean isInStaffMode(Player p) {
		return StaffMode.contains(p);
	}

	public void setStaffMode(Player p, boolean b) {
		if (b) {
			if (isInStaffMode(p))
				return;
			StaffMode.add(p);
		} else {
			if (!isInStaffMode(p))
				return;
			StaffMode.remove(p);
		}
	}
}
