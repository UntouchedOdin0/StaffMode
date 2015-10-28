package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.events.ClearChatEvent;
import staffmode.utils.ChatMessages;

public class ClearChat implements CommandExecutor {
	


	@Override
	public boolean onCommand(CommandSender Sender, Command cmd, String label,
			String[] args) {
		if (!(Sender instanceof Player)) {
			Sender.sendMessage(ChatColor.RED
					+ "Only Players Can Do This Command");
			return true;
		}
		Player p = (Player) Sender;
			if (cmd.getName().equalsIgnoreCase("ClearChat")) {
				if (!Sender.hasPermission("StaffMode.ClearChat")) {
					ChatMessages.getInstance().Nopermissions(Sender);
					return true;
				}
					for (int i = 0; i < 150; i++) {
						Bukkit.broadcastMessage(" ");
					}
				    ChatMessages.getInstance().ClearChat(Sender);
					Bukkit.getServer().getPluginManager().callEvent(new ClearChatEvent(p));
			}
		return true;
	}
}
