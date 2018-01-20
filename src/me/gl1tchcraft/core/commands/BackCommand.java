package me.gl1tchcraft.core.commands;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import me.gl1tchcraft.core.methods.TeleportManager;
import net.md_5.bungee.api.ChatColor;

public class BackCommand implements CommandExecutor {
	
	public static HashMap<Player, Vector> teleport = new HashMap<Player, Vector>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("back")) {
            	if(p.hasPermission("back.core.gl1tchcraft")) {
            		//if(p.hasPermission("tpoverride.core.gl1tchcraft")) {
            		//	p.teleport(p.getLocation().clone().add(1, 10, 1));
            		//} else {
               		teleport.put(p, p.getLocation().getDirection());
            		TeleportManager.teleport(p, p.getLocation().clone().add(1, 10, 1));
            		p.sendMessage(ChatColor.GRAY + "Teleport initiated." + ChatColor.RED + " Please do not move.");
            		//}
            	} else {
            		p.sendMessage(GCMessagesAPI.noPermission);;
            	}
            }
        }
        return true;
    }
}
