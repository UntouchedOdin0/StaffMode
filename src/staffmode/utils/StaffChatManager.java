package staffmode.utils;

import java.util.ArrayList;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class StaffChatManager implements Listener {

	public StaffChatManager() {
		
	}

	static StaffChatManager instance = new StaffChatManager();

	public static StaffChatManager getInstance() {
		return instance;
	}

	private ArrayList<Player> StaffChat = new ArrayList<Player>();

	public boolean isInStaffChat(HumanEntity humanEntity) {
		return StaffChat.contains(humanEntity);
	}

	public void setStaffChat(Player p, boolean b) {
		if (b) {
			if (isInStaffChat(p))
				return;
			StaffChat.add(p);
		} else {
			if (!isInStaffChat(p))
				return;
			StaffChat.remove(p);
		}
	}

	public ArrayList<Player> listInStaffChat() {
		return StaffChat;
	}
}
	
