package me.gl1tchcraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.gl1tchcraft.core.Main;

public class AnnounceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("announce")) {
            	  ByteArrayDataOutput out = ByteStreams.newDataOutput();
            	  out.writeUTF("Subchannel");
            	  out.writeUTF("Argument");
            	  
            	  Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

            	  player.sendPluginMessage(Main.getInstance, "BungeeCord", out.toByteArray());
            	
            	
            }
            
        }
        return true;
    }

}
