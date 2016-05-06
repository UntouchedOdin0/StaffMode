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

			if (VanishManager.getInstance().isVanished(p) == true) {
				
				VanishManager.getInstance().setVanish(p, false);
				Bukkit.getServer().getPluginManager().callEvent(new PlayerVanishDisableEvent(p));

				 ChatMessages.getInstance().VanishDisable(sender);
				 
				 return true;

			} else {
				VanishManager.getInstance().setVanish(p, true);
				ChatMessages.getInstance().VanishEnable(sender);
				Bukkit.getServer().getPluginManager().callEvent(new PlayerVanishEnableEvent(p));
				return true;
			}

		}
		return true;
	}

}
