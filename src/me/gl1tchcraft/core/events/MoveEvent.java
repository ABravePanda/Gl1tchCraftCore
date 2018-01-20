package me.gl1tchcraft.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.gl1tchcraft.core.commands.BackCommand;
import net.md_5.bungee.api.ChatColor;

public class MoveEvent implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(BackCommand.teleport.containsKey(p)) {
			if(BackCommand.teleport.get(p.getLocation().getDirection()) == null) {
			p.sendMessage(ChatColor.RED + "Teleport Cancelled.");
			BackCommand.teleport.remove(p);
			}
		}
		
	}

}
