package me.gl1tchcraft.core.commands;

import java.io.File;
import java.io.IOException;

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

public class FlyCommand implements CommandExecutor {
	
    File statsFile = Main.getInstance.getStatsFile();
	FileConfiguration stats = YamlConfiguration.loadConfiguration(statsFile);
	
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("fly")) {
	            	if(p.hasPermission("fly.core.gl1tchcraft")) {
	            		if(stats.get(p.getUniqueId() + ".Fly") == null) {
	            			stats.set(p.getUniqueId() + ".Fly", true);
	            			p.sendMessage(ChatColor.GRAY + "Flying: " + ChatColor.GREEN + "Enabled");
	            			p.setAllowFlight(true);
	            			p.setFlying(true);
	            			try {
								stats.save(statsFile);
							} catch (IOException e) {
								e.printStackTrace();
							}
	            		} else {
	            			boolean flying = stats.getBoolean(p.getUniqueId() + ".Fly");
	            			if(flying == false) {
	            				stats.set(p.getUniqueId() + ".Fly", true);
	            				try {
									stats.save(statsFile);
									p.sendMessage(ChatColor.GRAY + "Flying: " + ChatColor.GREEN + "Enabled");
									p.setAllowFlight(true);
									p.setFlying(true);
								} catch (IOException e) {
									e.printStackTrace();
								}
	            			}
	            			if(flying == true) {
	            				stats.set(p.getUniqueId() + ".Fly", false);
	            				try {
									stats.save(statsFile);
									p.sendMessage(ChatColor.GRAY + "Flying: " + ChatColor.RED + "Disabled");
									p.setAllowFlight(false);
									p.setFlying(false);
									p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 50, 300));
								} catch (IOException e) {
									e.printStackTrace();
								}
	            			}
	            		}
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);;
	            	}
	            }
	            
	        }
	        return true;
	 }

}
