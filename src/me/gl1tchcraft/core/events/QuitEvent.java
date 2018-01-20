package me.gl1tchcraft.core.events;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.gl1tchcraft.core.Main;

public class QuitEvent implements Listener {

	File statsFile = Main.getInstance.getStatsFile();
	FileConfiguration stats = YamlConfiguration.loadConfiguration(statsFile);
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) throws IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		
		stats.set(e.getPlayer().getUniqueId() + ".Quit.Time", dateFormat.format(date));
		stats.set(e.getPlayer().getUniqueId() + ".Quit.Location.X", e.getPlayer().getLocation().getX());
		stats.set(e.getPlayer().getUniqueId() + ".Quit.Location.Y", e.getPlayer().getLocation().getY());
		stats.set(e.getPlayer().getUniqueId() + ".Quit.Location.Z", e.getPlayer().getLocation().getZ());
		stats.set(e.getPlayer().getUniqueId() + ".Quit.Location.World", e.getPlayer().getLocation().getWorld().getName());
		stats.save(statsFile);
	}
	
}
