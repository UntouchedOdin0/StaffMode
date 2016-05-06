package staffmode.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AdminGui implements Listener 
{
		

	private ItemStack Help; 
	private ItemStack ClearChat;
	private ItemStack MuteChat;
	private ItemStack Fly;
	private ItemStack Heal;
	private ItemStack Feed;
	private ItemStack Vanish;
	private ItemStack StaffMode;
	private ItemStack StaffChat;
	private ItemStack ClearInventory;
	private ItemStack EnderChest;
	private ItemStack WorkBench;
	private ItemStack Stop;
	private ItemStack Reload;
	
	  private Inventory inv;
	  
	  
	  public AdminGui() {
          inv = Bukkit.getServer().createInventory(null, 9 * 3,(ChatColor.translateAlternateColorCodes('&',"&b&lStaffMode GUI &8&l>>")));

        Help = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me For Help!");
          ClearChat = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To ClearChat!");
          MuteChat = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Mute/UnMute Chat");
          Fly = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Toggle Fly");
          Heal = ItemManager.createItem(Material.GOLDEN_APPLE, ChatColor.GREEN + "Click Me To Heal YourSelf!");
          Feed = ItemManager.createItem(Material.COOKED_BEEF, ChatColor.GREEN + "Click Me To Feed YourSelf!");
          Vanish = ItemManager.createItem(Material.CHAINMAIL_CHESTPLATE, ChatColor.GREEN + "Click Me To Toggle Vanish!");
          StaffMode = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Toggle StaffMode!");
          StaffChat = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Toggle StaffChat!");
          ClearInventory = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Clear Your Inventory!");
          WorkBench = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Open A Crafting Table!");
          EnderChest = ItemManager.createItem(Material.PAPER, ChatColor.GREEN + "Click Me To Your EnderChest!");
          Reload = ItemManager.createItem(Material.PAPER, ChatColor.RED + "Click Me To Reload The Server!");
          Stop = ItemManager.createItem(Material.PAPER, ChatColor.RED + "Click Me To Stop The Server!");
          inv.setItem(0, Help);
          inv.setItem(1, ClearChat);
          inv.setItem(2, MuteChat);
          inv.setItem(3, Fly);
          inv.setItem(4, Heal);
          inv.setItem(5, Feed);
          inv.setItem(6, Vanish);
          inv.setItem(7, StaffMode);
          inv.setItem(8, StaffChat);
          inv.setItem(9, ClearInventory);
          inv.setItem(10, WorkBench);
          inv.setItem(11, EnderChest);;
          inv.setItem(12, Reload);
          inv.setItem(13, Stop);
      }

      
      public void show(Player p) {
              p.openInventory(inv);
      }
      
      @EventHandler
      public void onInventoryClick(InventoryClickEvent e) {
              if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
              if ((e.getCurrentItem() != null) && (!e.getCurrentItem().getType().equals(Material.AIR))){
            	  e.getWhoClicked().closeInventory();
                  e.setCancelled(true);     
          
              } 
                  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Click Me For Help!")) {
                          e.setCancelled(true);
                          Player p = (Player) e.getWhoClicked();
                          e.getWhoClicked().closeInventory();
                          p.performCommand("StaffMode:SHelp");
                  } 
                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To ClearChat!")) {
                              e.setCancelled(true);
                              Player p = (Player) e.getWhoClicked();
                              e.getWhoClicked().closeInventory();
                              p.performCommand("StaffMode:ClearChat");
                      }
                          if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Mute/UnMute Chat")) {
                                  e.setCancelled(true);
                                  Player p = (Player) e.getWhoClicked();
                                  e.getWhoClicked().closeInventory();
                                  p.performCommand("StaffMode:MuteChat");
                          } 
                              if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Toggle Fly")) {
                                      e.setCancelled(true);
                                      Player p = (Player) e.getWhoClicked();
                                      e.getWhoClicked().closeInventory();
                                      p.performCommand("StaffMode:Fly");
                              } 
                                  if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Heal YourSelf!")) {
                                          e.setCancelled(true);
                                          Player p = (Player) e.getWhoClicked();
                                          e.getWhoClicked().closeInventory();
                                          p.performCommand("StaffMode:Heal");
                                  }
                                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Feed YourSelf!")) {
                                              e.setCancelled(true);
                                              Player p = (Player) e.getWhoClicked();
                                              e.getWhoClicked().closeInventory();
                                              p.performCommand("StaffMode:Feed");
                                      } 
                                          if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Toggle Vanish!")) {
                                                  e.setCancelled(true);
                                                  Player p = (Player) e.getWhoClicked();
                                                  e.getWhoClicked().closeInventory();
                                                  p.performCommand("StaffMode:Vanish");
                                          } 
                                        	  if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Toggle StaffMode!")) {
                                                      e.setCancelled(true);
                                                      Player p = (Player) e.getWhoClicked();
                                                      e.getWhoClicked().closeInventory();
                                                      p.performCommand("StaffMode:StaffMode");
                                              } 
                                                  if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Toggle StaffChat!")) {
                                                          e.setCancelled(true);
                                                          Player p = (Player) e.getWhoClicked();
                                                          e.getWhoClicked().closeInventory();
                                                          p.performCommand("StaffMode:StaffChat");
                                                  } 
                                                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Clear Your Inventory!")) {
                                                              e.setCancelled(true);
                                                              Player p = (Player) e.getWhoClicked();
                                                              e.getWhoClicked().closeInventory();
                                                              p.performCommand("StaffMode:ClearInventory");
                                                      } 
                                                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Open A Crafting Table!")) {
                                                              e.setCancelled(true);
                                                              Player p = (Player) e.getWhoClicked();
                                                              e.getWhoClicked().closeInventory();
                                                              p.performCommand("StaffMode:WorkBench");
                                                      } 
                                                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Click Me To Your EnderChest!")) {
                                                              e.setCancelled(true);
                                                              Player p = (Player) e.getWhoClicked();
                                                              e.getWhoClicked().closeInventory();
                                                              p.performCommand("StaffMode:EnderChest");
                                                      } 
                                                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Click Me To Reload The Server!")) {
                                                              e.setCancelled(true);
                                                              Player p = (Player) e.getWhoClicked();
                                                              e.getWhoClicked().closeInventory();
                                                              if (p.hasPermission("StaffMode.AdminGui.Reload")) {
                                                              Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "Reload");
                                                      } else {
                                                    	  ChatMessages.getInstance().Nopermissions(p);
                                                    	  
                                                      }
                                                      } 
                                                      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Click Me To Stop The Server!")) {
                                                              e.setCancelled(true);
                                                              Player p = (Player) e.getWhoClicked();
                                                              e.getWhoClicked().closeInventory();
                                                              if (p.hasPermission("StaffMode.AdminGui.Stop")) {
                                                              Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "Stop");
                                                              } else {
                                                            	  ChatMessages.getInstance().Nopermissions(p);
                                                            	  
                                                              }
                          }
      }
}
