package me.gl1tchcraft.core.commands;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import me.gl1tchcraft.core.Main;
import net.md_5.bungee.api.ChatColor;

public class SwearCommand implements CommandExecutor {
	
	File swearsFile = Main.getInstance.getSwearsFile();
	FileConfiguration swears = YamlConfiguration.loadConfiguration(swearsFile);
	
	Main plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("swear")) {
            	if(p.hasPermission("swear.core.gl1tchcraft")) {
            		if(args.length != 0) {
            			if(args[0].equalsIgnoreCase("add")) {
            				List<String> badword = swears.getStringList("Swears");
            				badword.add(args[1]);
            				swears.set("Swears", badword);
            				try {
								swears.save(swearsFile);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
            				p.sendMessage("§7Sucessfully added §a" + args[1] + "§7 to swear list");
            			}
            			if(args[0].equalsIgnoreCase("remove")) {
            				if(swears.getStringList("Swears").contains(args[1])) {
                				List<String> badword = swears.getStringList("Swears");
                				badword.remove(args[1]);
                				swears.set("Swears", badword);
            					try {
    								swears.save(swearsFile);
    							} catch (IOException e) {
    								// TODO Auto-generated catch block
    								e.printStackTrace();
    							}
                				p.sendMessage("§7Sucessfully removed §a" + args[1] + "§7 from swear list");
            				} else {
            					p.sendMessage("§a" + args[1] + " §7isnt in the swear list!");
            				}
            			}
            			if(args[0].equalsIgnoreCase("list")) {
            				List<String> badword = swears.getStringList("Swears");
            				p.sendMessage("§eSwears:");
            				for(String words : badword) {
            					p.sendMessage("§7 - " + words);
            				}
            			}
            		} else {
            			p.sendMessage("§cIncorrect Arguments.. Try /swear [remove,add,list] {swear}");
            		}
            	} else {
            		p.sendMessage(GCMessagesAPI.noPermission);
            	}
            }
            
        }
        if(sender instanceof ConsoleCommandSender) {
        	if(cmd.getName().equalsIgnoreCase("swear")) {
        		List<String> badword = swears.getStringList("Swears");
        		plugin.getServer().getConsoleSender().sendMessage("§eSwears:");
				for(String words : badword) {
					plugin.getServer().getConsoleSender().sendMessage("§c - " + words);
				}
        	}
        }
        
        return true;
    }
}
