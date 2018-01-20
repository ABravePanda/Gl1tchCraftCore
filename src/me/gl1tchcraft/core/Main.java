package me.gl1tchcraft.core;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import me.gl1tchcraft.core.commands.AnnounceCommand;
import me.gl1tchcraft.core.commands.BackCommand;
import me.gl1tchcraft.core.commands.ChatColorCommand;
import me.gl1tchcraft.core.commands.FlyCommand;
import me.gl1tchcraft.core.commands.GamemodeCommand;
import me.gl1tchcraft.core.commands.HealCommand;
import me.gl1tchcraft.core.commands.InvseeCommand;
import me.gl1tchcraft.core.commands.KillCommand;
import me.gl1tchcraft.core.commands.PluginsCommand;
import me.gl1tchcraft.core.commands.SeenCommand;
import me.gl1tchcraft.core.commands.SkullCommand;
import me.gl1tchcraft.core.commands.SwearCommand;
import me.gl1tchcraft.core.commands.TeleportCommand;
import me.gl1tchcraft.core.commands.VanishCommand;
import me.gl1tchcraft.core.commands.WeatherCommands;
import me.gl1tchcraft.core.events.ChatEvent;
import me.gl1tchcraft.core.events.GuiEvents;
import me.gl1tchcraft.core.events.JoinEvent;
import me.gl1tchcraft.core.events.MoveEvent;
import me.gl1tchcraft.core.events.QuitEvent;

public class Main extends JavaPlugin {

	public static Main getInstance;
	
	@Override
	public void onEnable() {

		getInstance = this;
		getStatsFile();
		getSwearsFile();
		
		this.getServer().getPluginManager().registerEvents(new GuiEvents(), this);
		this.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		this.getServer().getPluginManager().registerEvents(new ChatEvent(), this);
		this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		this.getServer().getPluginManager().registerEvents(new MoveEvent(), this);
		
		
		this.getCommand("gamemode").setExecutor(new GamemodeCommand());
		this.getCommand("teleport").setExecutor(new TeleportCommand());
		this.getCommand("teleporthere").setExecutor(new TeleportCommand());
		this.getCommand("vanish").setExecutor(new VanishCommand());
		this.getCommand("inventorysee").setExecutor(new InvseeCommand());
		this.getCommand("enderchestsee").setExecutor(new InvseeCommand());
		this.getCommand("seen").setExecutor(new SeenCommand());
		this.getCommand("plugins").setExecutor(new PluginsCommand());
		this.getCommand("rain").setExecutor(new WeatherCommands());
		this.getCommand("sun").setExecutor(new WeatherCommands());
		this.getCommand("night").setExecutor(new WeatherCommands());
		this.getCommand("day").setExecutor(new WeatherCommands());
		this.getCommand("fly").setExecutor(new FlyCommand());
		this.getCommand("heal").setExecutor(new HealCommand());
		this.getCommand("kill").setExecutor(new KillCommand());
		this.getCommand("announce").setExecutor(new AnnounceCommand());
		this.getCommand("back").setExecutor(new BackCommand());
		this.getCommand("swear").setExecutor(new SwearCommand());
		this.getCommand("chatcolor").setExecutor(new ChatColorCommand());
		this.getCommand("skull").setExecutor(new SkullCommand());
	}
	
	@Override
	public void onDisable() {
	
		
	}
	
    public File getStatsFile() {

        File balanceFile = new File(this.getDataFolder() + File.separator, "Stats.yml");
        return balanceFile;
    }
    
    public File getChatColorFile() {

        File chatColorFile = new File(this.getDataFolder() + File.separator, "ChatColors.yml");
        return chatColorFile;
    }
    
    
    public File getSwearsFile() {

        File swearsFile = new File(this.getDataFolder() + File.separator, "Swears.yml");
        return swearsFile;
    }
	
}
