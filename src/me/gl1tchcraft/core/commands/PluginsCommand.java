package me.gl1tchcraft.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import me.gl1tchcraft.core.Main;
import net.md_5.bungee.api.ChatColor;

public class PluginsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("plugins")) {
            	if(p.hasPermission("plugins.core.gl1tchcraft")) {
            		p.sendMessage(ChatColor.GRAY + "Active Plugins: " + ChatColor.GREEN + "Gl1tchCraftCore, Gl1tchCraftEconomy, Gl1tchCraftSignShops");
            	} else {
            		p.sendMessage(GCMessagesAPI.noPermission);;
            	}
            }
            
        }
        return true;
    }

}
