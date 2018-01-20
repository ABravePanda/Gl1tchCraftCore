package me.gl1tchcraft.core.events;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.gl1tchcraft.core.Main;

public class JoinEvent implements Listener {

	File statsFile = Main.getInstance.getStatsFile();
	FileConfiguration stats = YamlConfiguration.loadConfiguration(statsFile);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws IOException {
		Player p = e.getPlayer();
		if(stats.get(p.getUniqueId() + ".Fly") == null) {
			return;
		}
		if(stats.getBoolean(p.getUniqueId() + ".Fly") == true) {
			p.setAllowFlight(true);
			p.setFlying(true);
		}
		if(stats.getBoolean(p.getUniqueId() + ".Fly") == false) {
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		
	}

}
