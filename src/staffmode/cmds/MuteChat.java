package staffmode.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import staffmode.utils.ChatManager;
import staffmode.utils.ChatMessages;


public class MuteChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("MuteChat")) {
			if (!sender.hasPermission("StaffMode.MuteChat")) {
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}

			if (ChatManager.getInstance().isMuted()) {
				ChatManager.getInstance().setMuted(false);
				ChatMessages.getInstance().UnMuteChat(sender);
				
			} else {
				ChatManager.getInstance().setMuted(true);
				ChatMessages.getInstance().MuteChat(sender);
			}

		}
		return true;
	}

}
