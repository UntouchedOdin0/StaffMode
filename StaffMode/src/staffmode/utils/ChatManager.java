package staffmode.utils;

import org.bukkit.plugin.Plugin;


public class ChatManager {

	Plugin p;

	public ChatManager() {

	}

	static ChatManager instance = new ChatManager();

	public static ChatManager getInstance() {
		return instance;
	}

	public void setup(Plugin p) {
		this.p = p;
	}

	public Plugin getPlugin() {
		return p;
	}

	private boolean muted;

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean b) {
		muted = b;

	}
}

