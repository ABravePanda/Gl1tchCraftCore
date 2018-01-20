package me.gl1tchcraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import net.md_5.bungee.api.ChatColor;

public class TeleportCommand implements CommandExecutor {
	
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("teleport")) {
	            	if(args.length > 0) {
		            	if(args.length == 1) {
		            		if(p.hasPermission("teleport.core.gl1tchcraft")) {
		            			Player target = Bukkit.getPlayer(args[0]);
		            			if(target != null) {
		            				Location targetLocation = target.getLocation();
		            				p.teleport(targetLocation);
		            				p.sendMessage(ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + target.getName() + ".");
		            			} else {
		            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
		            			}
		            		} else {
		            			p.sendMessage(GCMessagesAPI.noPermission);
	                        }
		            	}
		            	if(args.length == 2) {
		            		if(p.hasPermission("teleporother.core.gl1tchcraft")) {
		            			Player target1 = Bukkit.getPlayer(args[0]);
		            			Player target2 = Bukkit.getPlayer(args[1]);
		            			if(target1 != null && target2 != null) {
		            				Location targetLocation = target2.getLocation();
		            				target1.sendMessage(ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + target2.getName() + ".");
		            				target1.teleport(targetLocation);
		            				p.sendMessage(ChatColor.GREEN + target1.getName() + ChatColor.GRAY + " has been teleported to " + ChatColor.GREEN + target2.getName() + ".");
		            			} else {
		            				p.sendMessage(ChatColor.RED + "Can't find one of these players!");
		            			}
		            		} else {
		            			p.sendMessage(GCMessagesAPI.noPermission);
		            		}
		            	}
		            } else {
		            	p.sendMessage(ChatColor.RED + "Incorrect Arguments... Try '/tp [player] <player2>'.");
		            }
	            }
	            
	            if(cmd.getName().equalsIgnoreCase("teleporthere")) {
	            	if(p.hasPermission("tphere.core.gl1tchcraft")) {
		            	if(args.length == 1) {
		            		Player target = Bukkit.getPlayer(args[0]);
	            			if(target != null) {
	            				Location l = p.getLocation();
	            				target.teleport(l);
	            				target.sendMessage(ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + p.getName() + ".");
	            				p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " has been teleported to you.");
	            			} else {
	            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
	            			}
		            	} else {
		            		p.sendMessage(ChatColor.RED + "Incorrect Arguments... Try '/tphere [player]'.");
		            	}
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);
	            	}
	            }
	            
	        }
	        
	        return true;
	 }
}
