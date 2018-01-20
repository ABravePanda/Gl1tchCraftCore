package me.gl1tchcraft.core.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import net.md_5.bungee.api.ChatColor;

public class InvseeCommand implements CommandExecutor {
	
	
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("inventorysee")) {
	            	if(p.hasPermission("invsee.core.gl1tchcraft")) {
	            		if(args.length == 1) {
	            			Player target = Bukkit.getPlayer(args[0]);
	            			if(target != null) {
	            				ItemStack[] targetInv = target.getInventory().getStorageContents();
	            				Inventory i = Bukkit.createInventory(null, 36, ChatColor.YELLOW + target.getName() + "-Inventory");
	            				i.setStorageContents(targetInv);
	            				p.openInventory(i);
	            			} else {
	            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
	            			}
	            		} else {
	            			p.sendMessage(ChatColor.RED + "Incorrect Arguments... Try '/invsee {player}'");
	            		}
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);;
	            	}
	            }
	            
	            if(cmd.getName().equalsIgnoreCase("enderchestsee")) {
	            	if(p.hasPermission("endersee.core.gl1tchcraft")) {
	            		if(args.length == 1) {
	            			Player target = Bukkit.getPlayer(args[0]);
	            			if(target != null) {
	            				ItemStack[] targetInv = target.getEnderChest().getStorageContents();
	            				Inventory i = Bukkit.createInventory(null, 27, ChatColor.YELLOW + target.getName() + "-EnderChest");
	            				i.setStorageContents(targetInv);
	            				p.openInventory(i);
	            			} else {
	            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
	            			}
	            		} else {
	            			p.sendMessage(ChatColor.RED + "Incorrect Arguments... Try '/endersee {player}'");
	            		}
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);;
	            	}
	            }
	            	
	            
	        }
	        return true;
	 }

}
