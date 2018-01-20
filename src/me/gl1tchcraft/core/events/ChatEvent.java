package me.gl1tchcraft.core.events;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.gl1tchcraft.core.Main;
import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatEvent implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();
		String messageFinal = "";
		
		if(m.startsWith(".")) {
			m = m.substring(1, m.length());
		}
		
		File swearsFile = Main.getInstance.getSwearsFile();
		FileConfiguration swears = YamlConfiguration.loadConfiguration(swearsFile);
		
		List<String> swearList = swears.getStringList("Swears");
		String message = e.getMessage().toLowerCase();
		for(String blockedword : swearList) {
			if(message.contains(blockedword.toLowerCase())) {
				m = "*Contains Swear*";
			}
		}
		
		
		PermissionUser user = PermissionsEx.getUser(p);
		String prefix = ChatColor.translateAlternateColorCodes('&', user.getPrefix(p.getWorld().toString()));
		
		if(p.hasPermission("colorchat.core.gl1tchcraft")) {
			String newMessage = ChatColor.translateAlternateColorCodes('&', m);
			e.setFormat(prefix + p.getName() + ChatColor.WHITE + " : " + ChatColor.GRAY + newMessage.replaceAll("%", "%%"));
		} else {
			e.setFormat(prefix + p.getName() + ChatColor.WHITE + " : " + ChatColor.GRAY + m);
		}
		
	}

}
