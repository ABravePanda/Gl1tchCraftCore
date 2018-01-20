package me.gl1tchcraft.core.events;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.gl1tchcraft.core.Main;

public class GuiEvents implements Listener {
	
	File chatColorFiles = Main.getInstance.getChatColorFile();
	FileConfiguration chatColorFile = YamlConfiguration.loadConfiguration(chatColorFiles);

	@EventHandler
	public void onClick2(InventoryClickEvent e) throws IOException {
		
		Player p = (Player) e.getWhoClicked();
		UUID uuid = p.getUniqueId();
		
		if(e.getInventory().getName().equalsIgnoreCase("§cChatColor Select")) {
			p.sendMessage("ChatColor");
			if(e.getCurrentItem().getType() == Material.INK_SACK && e.getCurrentItem().getDurability() == 1) {
				e.setCancelled(true);
				p.closeInventory();
				if(p.hasPermission("red.core.gl1tchcraft")) {
		    		chatColorFile.set(uuid + ".LightRed", false);
		    		chatColorFile.set(uuid + ".Yellow", false);
		    		chatColorFile.set(uuid + ".LightGreen", false);
		    		chatColorFile.set(uuid + ".Aqua", false);
		    		chatColorFile.set(uuid + ".Gold", false);
					chatColorFile.set(uuid + ".LightRed", true);
					chatColorFile.save(chatColorFiles);
					p.sendMessage("§7ChatColor set to: §cLight Red");
				} else {
					p.sendMessage("§cYou don't have permission to do that!");
				}
			}
			
			if(e.getCurrentItem().getType() == Material.INK_SACK && e.getCurrentItem().getDurability() == 10) {
				e.setCancelled(true);
				p.closeInventory();
				if(p.hasPermission("lightgreen.core.gl1tchcraft")) {
		    		chatColorFile.set(uuid + ".LightRed", false);
		    		chatColorFile.set(uuid + ".Yellow", false);
		    		chatColorFile.set(uuid + ".LightGreen", false);
		    		chatColorFile.set(uuid + ".Aqua", false);
		    		chatColorFile.set(uuid + ".Gold", false);
					chatColorFile.set(uuid + ".LightGreen", true);
					chatColorFile.save(chatColorFiles);
					p.sendMessage("§7ChatColor set to: §aLime Green");
				} else {
					p.sendMessage("§cYou don't have permission to do that!");
				}
			}
		}
		
		
		String name = ChatColor.stripColor(e.getInventory().getName());
		
		String[] parts = name.split("-");
		
		
		ItemStack[] Storagecontents = e.getInventory().getStorageContents();
		ItemStack[] endercontents = e.getInventory().getContents();
		
		Player target = Bukkit.getPlayer(parts[0]);
		if(target == null) {
			return;
		} else {
			if(parts[1].equals("Inventory")) {
			target.getInventory().setStorageContents(Storagecontents);
			} 
			if(parts[1].equals("EnderChest")) {
			target.getEnderChest().setContents(endercontents);	
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryInteractEvent e) {
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		String name = ChatColor.stripColor(e.getInventory().getName());
		
		String[] parts = name.split("-");
		
		ItemStack[] Storagecontents = e.getInventory().getStorageContents();
		ItemStack[] endercontents = e.getInventory().getContents();
		
		Player target = Bukkit.getPlayer(name);
		if(target == null) {
			return;
		} else {
			if(parts[1].equals("Inventory")) {
			target.getInventory().setStorageContents(Storagecontents);
			}
			if(parts[1].equals("EnderChest")) {
			target.getEnderChest().setContents(endercontents);	
			}
		}
	}
	
}
