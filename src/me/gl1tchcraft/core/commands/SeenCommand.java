package me.gl1tchcraft.core.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import me.gl1tchcraft.core.Main;
import net.md_5.bungee.api.ChatColor;

public class SeenCommand implements CommandExecutor {
	
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		File statsFile = Main.getInstance.getStatsFile();
		FileConfiguration stats = YamlConfiguration.loadConfiguration(statsFile);
		
	        if (sender instanceof Player) {
	            Player p = (Player) sender;
	            
	            if(cmd.getName().equalsIgnoreCase("seen")) {
	            	if(p.hasPermission("seen.core.gl1tchcraft")) {
	            		if(args.length == 1) {
	            			OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
	            			if(target != null) {
	            				String time = stats.get(target.getUniqueId() + ".Quit.Time").toString();
	            				int x = (int) stats.getDouble(target.getUniqueId() + ".Quit.Location.X");
	            				int y = (int) stats.getDouble(target.getUniqueId() + ".Quit.Location.Y");
	            				int z = (int) stats.getDouble(target.getUniqueId() + ".Quit.Location.Z");
	            				String world = stats.get(target.getUniqueId() + ".Quit.Location.World").toString();
	            				p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY +  " last logged off around "
	            						+ ChatColor.GREEN + time + ChatColor.GRAY + " at " + ChatColor.GREEN + x + ", " +
	            						y + ", " + z + ", world" + ChatColor.GRAY + " and is currently " + getOnline(target) + ChatColor.GRAY + ".");
	            			} else {
	            				p.sendMessage(ChatColor.RED + "Can't find " + args[0]);
	            			}
	            		} else {
	            			p.sendMessage(ChatColor.RED + "Incorrect Arguments... Try '/seen [player]'.");
	            		}
	            	} else {
	            		p.sendMessage(GCMessagesAPI.noPermission);;
	            	}
	            }
	            
	        }
	        return true;
	 }
	
	public String getOnline(OfflinePlayer target) {
		if(target.isOnline()) {
			return ChatColor.GREEN + "Online";
		} else {
			return ChatColor.RED + "Offline";
		}
	}

}
