package me.gl1tchcraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gl1tchcraft.api.messages.GCMessagesAPI;
import net.md_5.bungee.api.ChatColor;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("gamemode")) {
                if (args.length >= 1) {
                    if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
                        if (p.hasPermission("creative.core.gl1tchcraft")) {
                            if (args.length == 1) {
                                p.setGameMode(GameMode.CREATIVE);
                                p.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Creative.");
                            } else {
                                Player target = Bukkit.getPlayer(args[1]);
                                if (target == null) {
                                    p.sendMessage(ChatColor.RED + "Can't find " + args[1]);
                                } else {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Creative.");
                                    p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " Gamemode Updated to " + ChatColor.GREEN + "Creative.");
                                }
                            }
                        } else {
                        	p.sendMessage(GCMessagesAPI.noPermission);;
                        }
                    }
                    if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
                    	if (p.hasPermission("survival.core.gl1tchcraft")) {
	                        if (args.length == 1) {
	                            p.setGameMode(GameMode.SURVIVAL);
	                            p.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Survival.");
	                        } else {
	                            Player target = Bukkit.getPlayer(args[1]);
	                            if (target == null) {
	                                p.sendMessage(ChatColor.RED + "Can't find " + args[1]);
	                            } else {
	                                target.setGameMode(GameMode.SURVIVAL);
	                                target.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Survival.");
	                                p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " Gamemode Updated to " + ChatColor.GREEN + "Survival.");
	                            }
	                        }
                    	} else {
                    		p.sendMessage(GCMessagesAPI.noPermission);;
                    	}
                    }
                    if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
                    	if (p.hasPermission("adventure.core.gl1tchcraft")) {
	                        if (args.length == 1) {
	                            p.setGameMode(GameMode.ADVENTURE);
	                            p.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Adventure.");
	                        } else {
	                            Player target = Bukkit.getPlayer(args[1]);
	                            if (target == null) {
	                                p.sendMessage(ChatColor.RED + "Can't find " + args[1]);
	                            } else {
	                                target.setGameMode(GameMode.ADVENTURE);
	                                target.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Adventure.");
	                                p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " Gamemode Updated to " + ChatColor.GREEN + "Adventure.");
	                            }
	                        }
                    	} else {
                    		p.sendMessage(GCMessagesAPI.noPermission);;
                    	}
                    }
                    if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
                    	if (p.hasPermission("spectator.core.gl1tchcraft")) {
	                        if (args.length == 1) {
	                            p.setGameMode(GameMode.SPECTATOR);
	                            p.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Spectator.");
	                        } else {
	                            Player target = Bukkit.getPlayer(args[1]);
	                            if (target == null) {
	                                p.sendMessage(ChatColor.RED + "Can't find " + args[1]);
	                            } else {
	                                target.setGameMode(GameMode.SPECTATOR);
	                                target.sendMessage(ChatColor.GRAY + "Gamemode Updated to " + ChatColor.GREEN + "Spectator.");
	                                p.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.GRAY + " Gamemode Updated to " + ChatColor.GREEN + "Spectator.");
	                            }
	                        }
                    	} else {
                    		p.sendMessage(GCMessagesAPI.noPermission);;
                    	}
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Incorrect Arguments.. Try '/gamemode {c,s,a} <player>'");
                }
            }
        }

        return true;
    }


}