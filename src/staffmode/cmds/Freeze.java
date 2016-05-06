package staffmode.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import staffmode.utils.ChatMessages;
import staffmode.utils.FrozenManager;

public class Freeze implements CommandExecutor, Listener  {

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("freeze")) {
        	if (!sender.hasPermission("StaffMode.Freeze")) {
        		ChatMessages.getInstance().Nopermissions(sender);
        		return true;
        	}
            if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Please specify a player!");
                    return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                    return true;
            }
            if (target.isOp()) {
            sender.sendMessage(ChatColor.RED + "Invalid! Target Is Opped You Cannot Freeze A Opped Player!");
            return true;
            }
            if (FrozenManager.getInstance().isfrozen(target)) {
        				FrozenManager.getInstance().setfrozenMode(target, false);
                    sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been unfrozen!");
                    target.sendMessage(ChatColor.RED + "You Have Been UnFrozen By " + sender.getName());
                    return true;
            }
            FrozenManager.getInstance().setfrozenMode(target, true);
            sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been frozen!");
            target.sendMessage(ChatColor.RED + "You Have Been Frozen By " + sender.getName());
    }
    return false;

    }
}
