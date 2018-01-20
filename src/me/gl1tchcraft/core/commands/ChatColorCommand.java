package me.gl1tchcraft.core.commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import me.gl1tchcraft.core.Main;
import me.gl1tchcraft.core.methods.ItemCreator;
import net.md_5.bungee.api.ChatColor;

public class ChatColorCommand implements CommandExecutor {
	
	File chatColorFiles = Main.getInstance.getChatColorFile();
	FileConfiguration chatColorFile = YamlConfiguration.loadConfiguration(chatColorFiles);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("chatcolor")) {
            	Inventory i = null;
				try {
					i = colorInventory(p.getUniqueId());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	p.openInventory(i);
            }
        }
        return true;
    }
    
    public Inventory colorInventory(UUID uuid) throws IOException {
    	
    	Inventory i = Bukkit.createInventory(null, 9, "§cChatColor Select");
    	
    	if(chatColorFile.get(uuid + "") == null) {
    		chatColorFile.set(uuid + ".LightRed", false);
    		chatColorFile.set(uuid + ".Yellow", false);
    		chatColorFile.set(uuid + ".LightGreen", false);
    		chatColorFile.set(uuid + ".Aqua", false);
    		chatColorFile.set(uuid + ".Gold", false);
    		chatColorFile.save(chatColorFiles);
    		
    		ItemStack lightRed = ItemCreator.createWoolItem(Material.INK_SACK, 1, "§cRed", 1);
    		ItemStack lightGreen = ItemCreator.createWoolItem(Material.INK_SACK, 10, "§aLime Green", 1);
    		ItemStack yellow = ItemCreator.createWoolItem(Material.INK_SACK, 11, "§eYellow", 1);
    		ItemStack aqua = ItemCreator.createWoolItem(Material.INK_SACK, 12, "§bAqua", 1);
    		ItemStack gold = ItemCreator.createWoolItem(Material.INK_SACK, 14, "§6Gold", 1);
    		i.addItem(lightRed);
    		i.addItem(lightGreen);
    		i.addItem(yellow);
    		i.addItem(aqua);
    		i.addItem(gold);
    		
    		return i;
    		
    	} else {
    		boolean lr = chatColorFile.getBoolean(uuid + ".LightRed");
    		boolean y = chatColorFile.getBoolean(uuid + ".Yellow");
    		boolean lg = chatColorFile.getBoolean(uuid + ".LightGreen");
    		boolean a = chatColorFile.getBoolean(uuid + ".Aqua");
    		boolean g = chatColorFile.getBoolean(uuid + ".Gold");
    		
    		ItemStack lightRed = null;
    		ItemStack lightGreen = null;
    		ItemStack yellow = null;
    		ItemStack aqua = null;
    		ItemStack gold = null;
    		
    		if(lr == true) {
    			lightRed = ItemCreator.createSelectedWoolItem(Material.INK_SACK, 1, "§cRed §9[Selected]", 1, Enchantment.DURABILITY);
    			i.addItem(lightRed);
    		} else {
    			lightRed = ItemCreator.createWoolItem(Material.INK_SACK, 1, "§cRed", 1);
    			i.addItem(lightRed);
    		}
    		
    		if(y == true) {
    			yellow = ItemCreator.createSelectedWoolItem(Material.INK_SACK, 11, "§eYellow §9[Selected]", 1, Enchantment.DURABILITY);
    			i.addItem(yellow);
    		} else {
    			yellow = ItemCreator.createWoolItem(Material.INK_SACK, 11, "§eYellow", 1);
    			i.addItem(yellow);
    		}
    		
    		
    		if(lg == true) {
    			lightGreen = ItemCreator.createSelectedWoolItem(Material.INK_SACK, 10, "§aLime Green §9[Selected]", 1, Enchantment.DURABILITY);
    			i.addItem(lightGreen);
    		} else {
    			lightGreen = ItemCreator.createWoolItem(Material.INK_SACK, 10, "§aLime Green", 1);
    			i.addItem(lightGreen);
    		}
    		
    		if(a == true) {
    			aqua = ItemCreator.createSelectedWoolItem(Material.INK_SACK, 12, "§bAqua §9[Selected]", 1, Enchantment.DURABILITY);
    			i.addItem(aqua);
    		} else {
    			aqua = ItemCreator.createWoolItem(Material.INK_SACK, 12, "§bAqua", 1);
    			i.addItem(aqua);
    		}
    		
    		if(g == true) {
    			gold = ItemCreator.createSelectedWoolItem(Material.INK_SACK, 14, "§6Gold §9[Selected]", 1, Enchantment.DURABILITY);
    			i.addItem(gold);
    		} else {
    			gold = ItemCreator.createWoolItem(Material.INK_SACK, 14, "§6Gold", 1);
    			i.addItem(gold);
    		}
    		
    		return i;
    	}
    	
    }

}
