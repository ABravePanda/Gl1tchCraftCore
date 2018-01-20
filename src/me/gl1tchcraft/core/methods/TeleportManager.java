package me.gl1tchcraft.core.methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.gl1tchcraft.core.Main;
import me.gl1tchcraft.core.commands.BackCommand;
import net.md_5.bungee.api.ChatColor;

public class TeleportManager {
	static int taskId = 0;
	
	public static void teleport(Player p, Location l) {
		taskId = Main.getInstance.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance, new Runnable() {
			 int Count = 5;
			 
			  public void run() {
				  if(BackCommand.teleport.containsKey(p)) {
			      if(Count == 0) {
			      p.sendMessage(ChatColor.GRAY + "Commencing Teleport...");
			      p.teleport(l);
			      BackCommand.teleport.remove(p);
			      Bukkit.getScheduler().cancelTask(taskId);
			      } else {
				  p.sendMessage(ChatColor.GRAY + "Commencing teleport in " + ChatColor.GREEN + Count + " seconds");
			      Count--;
			      }
				  } else {
					  Bukkit.getScheduler().cancelTask(taskId);
				  }
			  }
			}, 0L, 20L);

	}
	
}
