package me.gl1tchcraft.core.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import net.md_5.bungee.api.ChatColor;

public class SkullCommand  implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("skull")) {
            	if(p.hasPermission("skull.core.gl1tchcraft")) {
            		if(args.length == 1) {
            			String skullOwner = args[0];
            			
            			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte)3);
            			SkullMeta meta = (SkullMeta) skull.getItemMeta();
            			meta.setOwner(skullOwner);
            			meta.setDisplayName("§f" + args[0] + "'s Head");
            			skull.setItemMeta(meta);
            			p.getInventory().addItem(skull);
            			
            		} else {
            			p.sendMessage("§cIncorrect Arguments.. Try /skull {player}!");
            		}
            	} else {
            		p.sendMessage(GCMessagesAPI.noPermission);;
            	}
            }
            
        }
        return true;
    }
}
