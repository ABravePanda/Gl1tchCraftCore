package me.gl1tchcraft.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import net.md_5.bungee.api.ChatColor;

public class WeatherCommands implements CommandExecutor {
	
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("day")) {
	            	if(p.hasPermission("day.core.gl1tchcraft")) {
	            		p.getWorld().setTime(0);
	            		p.sendMessage(ChatColor.GRAY + "Time has been set to" + ChatColor.GREEN + " day.");
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);
	            	}
	            }
	            
	            if(cmd.getName().equalsIgnoreCase("night")) {
	            	if(p.hasPermission("night.core.gl1tchcraft")) {
	            		p.getWorld().setTime(15000);
	            		p.sendMessage(ChatColor.GRAY + "Time has been set to" + ChatColor.GREEN + " night.");
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);
	            	}
	            }
	            
	            if(cmd.getName().equalsIgnoreCase("sun")) {
	            	if(p.hasPermission("sun.core.gl1tchcraft")) {
	            		p.getWorld().setStorm(false);
	            		p.sendMessage(ChatColor.GRAY + "Weather has been set to" + ChatColor.GREEN + " sun.");
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);
	            	}
	            }
	            
	            if(cmd.getName().equalsIgnoreCase("rain")) {
	            	if(p.hasPermission("rain.core.gl1tchcraft")) {
	            		p.getWorld().setStorm(true);
	            		p.sendMessage(ChatColor.GRAY + "Weather has been set to" + ChatColor.GREEN + " rain.");
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);
	            	}
	            }
	            
	        }
	        return true;
	 }

}
