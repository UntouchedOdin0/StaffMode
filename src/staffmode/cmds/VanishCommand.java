package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.events.PlayerVanishDisableEvent;
import staffmode.events.PlayerVanishEnableEvent;
import staffmode.utils.ChatMessages;
import staffmode.utils.VanishManager;

public class VanishCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can use this command!");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("Vanish")) {
			if (!p.hasPermission("StaffMode.StaffMode")) { 
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}

			if (VanishManager.getInstance().isVanished(p)) {
				VanishManager.getInstance().setVanish(p, false);
				Bukkit.getServer().getPluginManager().callEvent(new PlayerVanishDisableEvent(p));
				for (Player online : Bukkit.getOnlinePlayers()) {
					online.showPlayer(p);
				}
				 ChatMessages.getInstance().VanishDisable(sender);

			} else {
				VanishManager.getInstance().setVanish(p, true);
				for (Player online : Bukkit.getOnlinePlayers()) {
					if (online.hasPermission("StaffMode.Vanish.See")) {
						online.showPlayer(p);

					} else {
						online.hidePlayer(p);
					}
				}
				ChatMessages.getInstance().VanishEnable(sender);
				Bukkit.getServer().getPluginManager().callEvent(new PlayerVanishEnableEvent(p));
			}

		}
		return true;
	}

}
