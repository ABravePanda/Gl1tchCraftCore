package me.gl1tchcraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import net.md_5.bungee.api.ChatColor;

public class HealCommand implements CommandExecutor {
	
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("heal")) {
	            	if(args.length == 0) {
		            	if(p.hasPermission("heal.core.gl1tchcraft")) {
		            		p.setHealth(20);
		            		p.setFoodLevel(20);
		            		p.sendMessage(ChatColor.GRAY + "You have been healed.");
		            	} else {
		            		 p.sendMessage(GCMessagesAPI.noPermission);;
		            	}
	            	}
	            	if(args.length == 1) {
	            		if(p.hasPermission("healother.core.gl1tchcraft")) {
	            			Player target = Bukkit.getPlayer(args[0]);
	            			if(target != null) {
		            		target.setHealth(20);
		            		target.setFoodLevel(20);
		            		target.sendMessage(ChatColor.GRAY + "You have been healed.");
		            		p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " has been healed");
	            			} else {
	            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
	            			}
		            	} else {
		            		p.sendMessage(GCMessagesAPI.noPermission);;
		            	}
	            	}
	            	
	            }
	            
	        }
	        return true;
	 }

}
