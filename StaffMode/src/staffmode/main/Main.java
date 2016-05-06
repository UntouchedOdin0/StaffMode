package staffmode.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;

import staffmode.cmds.AdminGuiCMD;
import staffmode.cmds.BroadCast;
import staffmode.cmds.ClearChat;
import staffmode.cmds.ClearInventory;
import staffmode.cmds.EnderChest;
import staffmode.cmds.Feed;
import staffmode.cmds.Fly;
import staffmode.cmds.Freeze;
import staffmode.cmds.God;
import staffmode.cmds.Heal;
import staffmode.cmds.Help;
import staffmode.cmds.MuteChat;
import staffmode.cmds.Report;
import staffmode.cmds.StaffChat;
import staffmode.cmds.StaffModeCMD;
import staffmode.cmds.StaffModeReload;
import staffmode.cmds.Tp;
import staffmode.cmds.TpHere;
import staffmode.cmds.VanishCommand;
import staffmode.cmds.Warn;
import staffmode.cmds.WorkBench;
import staffmode.listeners.AntiSwearHandler;
import staffmode.listeners.CustomCommandsHandler;
import staffmode.listeners.FullJoin;
import staffmode.listeners.GodHandler;
import staffmode.listeners.MuteChatHandler;
import staffmode.listeners.PlayerFrozenHandler;
import staffmode.listeners.PlayerJoinHandler;
import staffmode.listeners.PlayerQuitHandler;
import staffmode.listeners.StaffChatHandler;
import staffmode.listeners.StaffModeHandler;
import staffmode.listeners.StaffModeItemsHandler;
import staffmode.listeners.VanishHandler;
import staffmode.utils.AdminGui;
import staffmode.utils.ConfigManager;

public class Main extends IMain {

	ArrayList<String> list = new ArrayList<String>();
	@SuppressWarnings("unused")
	private AdminGui Gui;
	protected UpdateChecker updateChecker;
	public static Main instance;

	@Override
	public void load() {
		Gui = new AdminGui();
		EnableInstance();
		SetUpConfig();
		Updater();

		Server server = getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&b&m================================="));
		console.sendMessage("    ");
		console.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&b          &aStaffMode"));
		console.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&b     Coded By xXkguyXx"));
		console.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&b     Thanks To Vextricity"));
		console.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&b     Current Version: " + this.getDescription().getVersion()));
		console.sendMessage("    ");
		console.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&b&m================================="));

		ConfigManager.getInstance().getConfig().set("Version", "Lite");
		ConfigManager.getInstance().SaveConfig();

	}

	@Override
	public void unload() {
		DisableInstance();

	}

	@Override
	public void loadListeners() {
		loadListener(new PlayerJoinHandler());
		loadListener(new MuteChatHandler());
		loadListener(new StaffModeHandler());
		loadListener(new PlayerFrozenHandler());
		loadListener(new VanishHandler());
		loadListener(new StaffChatHandler());
		loadListener(new AdminGui());
		loadListener(new FullJoin());
		loadListener(new PlayerQuitHandler());
		loadListener(new StaffModeItemsHandler());
		loadListener(new GodHandler());
		loadListener(new CustomCommandsHandler());
		loadListener(new StaffModeCMD());
		loadListener(new AntiSwearHandler());

	}

	@Override
	public void registerCommands() {
		getCommand("StaffMode").setExecutor(new StaffModeCMD());
		getCommand("Vanish").setExecutor(new VanishCommand());
		getCommand("ClearChat").setExecutor(new ClearChat());
		getCommand("MuteChat").setExecutor(new MuteChat());
		getCommand("Fly").setExecutor(new Fly());
		getCommand("Heal").setExecutor(new Heal());
		getCommand("Feed").setExecutor(new Feed());
		getCommand("ClearInventory").setExecutor(new ClearInventory());
		getCommand("StaffChat").setExecutor(new StaffChat());
		getCommand("Freeze").setExecutor(new Freeze());
		getCommand("Warn").setExecutor(new Warn());
		getCommand("Tp").setExecutor(new Tp());
		getCommand("teleporthere").setExecutor(new TpHere());
		getCommand("report").setExecutor(new Report());
		getCommand("SHelp").setExecutor(new Help());
		getCommand("AdminGui").setExecutor(new AdminGuiCMD());
		getCommand("WorkBench").setExecutor(new WorkBench());
		getCommand("EnderChest").setExecutor(new EnderChest());
		getCommand("broadcast").setExecutor(new BroadCast());
		getCommand("god").setExecutor(new God());
		getCommand("smr").setExecutor(new StaffModeReload());
	}

	private void DisableInstance() {
		instance = null;

	}

	private void EnableInstance() {
		instance = this;
	}

	public static Main getInstance() {
		return instance;
	}

	private void SetUpConfig() {
		ConfigManager.getInstance().setup(this);
		ConfigManager.getInstance().SaveConfig();
		ConfigManager.getInstance().SaveDataConfig();
		ConfigManager.getInstance().getConfig().set("Version", "Lite");
		ConfigManager.getInstance().SaveConfig();
	}

	public void set(String string, long currentTimeMillis) {
	}

	private void Updater() {
		this.updateChecker = new UpdateChecker(this,
				"http://dev.bukkit.org/bukkit-plugins/staffmode-sm/files.rss");
		if (updateChecker.updateNeeded()) {
			this.getLogger().warning(
					"[StaffModeLite Updater] Version "
							+ updateChecker.getVersion()
							+ " has been released! Download it here: "
							+ updateChecker.getLink());
			Bukkit.broadcastMessage("[StaffModeLite Updater] Version "
					+ updateChecker.getVersion()
					+ " has been released! Download it here: "
					+ updateChecker.getLink());
		}
	}

	@SuppressWarnings("unused")
	private void SaveConfig() {
		ConfigManager.getInstance().SaveConfig();
		ConfigManager.getInstance().SaveDataConfig();
	}

	public void logToFile(String message)

	{

		try {
			File dataFolder = getDataFolder();
			if (!dataFolder.exists()) {
				dataFolder.mkdir();
			}

			File saveTo = new File(getDataFolder(), "StaffChatLogger.yml");
			if (!saveTo.exists()) {
				saveTo.createNewFile();
			}

			FileWriter fw = new FileWriter(saveTo, true);

			PrintWriter pw = new PrintWriter(fw);

			pw.println(message);

			pw.flush();

			pw.close();

		} catch (IOException e) {

			e.printStackTrace();
			System.out
					.println("Could Not Log StaffChat... Report This Error to Author");

		}

	}
}
