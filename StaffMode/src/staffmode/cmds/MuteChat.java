package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.events.MuteChatEvent;
import staffmode.utils.ChatManager;
import staffmode.utils.ChatMessages;


public class MuteChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("MuteChat")) {
			if (!sender.hasPermission("StaffMode.MuteChat")) {
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}

			if (ChatManager.getInstance().isMuted()) {
				ChatManager.getInstance().setMuted(false);
				ChatMessages.getInstance().UnMuteChat(sender);
				Bukkit.getServer().getPluginManager().callEvent(new MuteChatEvent(p));
				
			} else {
				ChatManager.getInstance().setMuted(true);
				ChatMessages.getInstance().MuteChat(sender);
				Bukkit.getServer().getPluginManager().callEvent(new MuteChatEvent(p));
			}

		}
		return true;
	}

}
