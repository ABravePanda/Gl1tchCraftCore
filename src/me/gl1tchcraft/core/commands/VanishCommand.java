package me.gl1tchcraft.core.commands;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import me.gl1tchcraft.core.Main;
import net.md_5.bungee.api.ChatColor;

public class VanishCommand implements CommandExecutor {
	
    File statsFile = Main.getInstance.getStatsFile();
	FileConfiguration stats = YamlConfiguration.loadConfiguration(statsFile);
	
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("vanish")) {
	            	if(p.hasPermission("vanish.core.gl1tchcraft")) {
	            		if(args.length == 0) {
		            		if(stats.get(p.getUniqueId() + ".Vanish") == null) {
		            			stats.set(p.getUniqueId() + ".Vanish", true);
		            			try {
									stats.save(statsFile);
								} catch (IOException e) {
									e.printStackTrace();
								}
		            			p.sendMessage(ChatColor.GRAY + "Vanish: " + ChatColor.GREEN + "Enabled");
	            				for(Player ps : Bukkit.getOnlinePlayers()) {
	            					ps.hidePlayer(p);
	            				}
	            				for(Player ps : Bukkit.getOnlinePlayers()) {
	            					if(ps.hasPermission("bypassvanish.core.gl1tchcraft")) {
	            					ps.showPlayer(p);
	            					}
	            				}
		            			return true;
		            		} else {
		            			boolean vanished = stats.getBoolean(p.getUniqueId() + ".Vanish");
		            			if(vanished == false) {
		            				stats.set(p.getUniqueId() + ".Vanish", true);
		            				try {
										stats.save(statsFile);
										p.sendMessage(ChatColor.GRAY + "Vanish: " + ChatColor.GREEN + "Enabled");
									} catch (IOException e) {
										e.printStackTrace();
									}
		    
		            				for(Player ps : Bukkit.getOnlinePlayers()) {
		            					ps.hidePlayer(p);
		            				}
		            				for(Player ps : Bukkit.getOnlinePlayers()) {
		            					if(ps.hasPermission("bypassvanish.core.gl1tchcraft")) {
		            					ps.showPlayer(p);
		            					}
		            				}
		            			}
		            			if(vanished == true) {
		            				stats.set(p.getUniqueId() + ".Vanish", false);
		            				try {
										stats.save(statsFile);
										p.sendMessage(ChatColor.GRAY + "Vanish: " + ChatColor.RED + "Disabled");
									} catch (IOException e) {
										e.printStackTrace();
									}
		            				for(Player ps : Bukkit.getOnlinePlayers()) {
		            					ps.showPlayer(p);
		            				}
		            			}
		            		}
	            		
	            		} else {
	            			Player target = Bukkit.getPlayer(args[0]);
	            			if(target != null) {
	            				if(stats.get(target.getUniqueId() + ".Vanish") == null) {
			            			stats.set(target.getUniqueId() + ".Vanish", false);
			            			try {
										stats.save(statsFile);
									} catch (IOException e) {
										e.printStackTrace();
									}
			            			target.sendMessage(ChatColor.GRAY + "Vanish: " + ChatColor.RED + "Disabled");
			            			p.sendMessage(ChatColor.YELLOW + "(" + target.getName() + ") " + ChatColor.GRAY + "Vanish: " + ChatColor.RED + "Disabled");
			            			return true;
			            		} else {
			            			boolean vanished = stats.getBoolean(target.getUniqueId() + ".Vanish");
			            			if(vanished == false) {
			            				stats.set(target.getUniqueId() + ".Vanish", true);
			            				try {
											stats.save(statsFile);
											target.sendMessage(ChatColor.GRAY + "Vanish: " + ChatColor.GREEN + "Enabled");
											p.sendMessage(ChatColor.YELLOW + "(" + target.getName() + ") " + ChatColor.GRAY + "Vanish: " + ChatColor.GREEN + "Enabled");
										} catch (IOException e) {
											e.printStackTrace();
										}
			    
			            				for(Player ps : Bukkit.getOnlinePlayers()) {
			            					ps.hidePlayer(target);
			            				}
			            				for(Player ps : Bukkit.getOnlinePlayers()) {
			            					if(ps.hasPermission("bypassvanish.core.gl1tchcraft")) {
			            					ps.showPlayer(target);
			            					}
			            				}
			            			}
			            			if(vanished == true) {
			            				stats.set(target.getUniqueId() + ".Vanish", false);
			            				try {
											stats.save(statsFile);
											target.sendMessage(ChatColor.GRAY + "Vanish: " + ChatColor.RED + "Disabled");
											p.sendMessage(ChatColor.YELLOW + "(" + target.getName() + ") " + ChatColor.GRAY + "Vanish: " + ChatColor.RED + "Disabled");
										} catch (IOException e) {
											e.printStackTrace();
										}
			            				for(Player ps : Bukkit.getOnlinePlayers()) {
			            					ps.showPlayer(target);
			            				}
			            			}
			            		}
	            			} else {
	            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
	            			}
	            		}
	            		
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);
	            	}
	            }
	            
	        }
	        
	        return true;
	 }

}
