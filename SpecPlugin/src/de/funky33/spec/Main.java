package de.funky33.spec;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin
{
	public ArrayList<String> specPlayers =new ArrayList<String>();
	
	public void onEnable()
	{
		getLogger().info("Plugin by funky33");
		getLogger().info("for help enter /hspec");
		getLogger().info("final version 1.0");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("spec"))
			{
				if (player.hasPermission("spec.spec"))
				{
					if (specPlayers.contains(player.getName()))
					{
						player.setGameMode(GameMode.SPECTATOR);
						specPlayers.remove(player.getName());
						player.sendMessage(ChatColor.YELLOW + "You are now in Spectator mode!");
					}
					else
					{
						player.setGameMode(GameMode.SURVIVAL);
						specPlayers.add(player.getName());
						player.sendMessage(ChatColor.GREEN + "You are no longer in Spectator mode!");
					}
				}
				else
				{
					player.sendMessage(ChatColor.RED + "You need the permission " + ChatColor.YELLOW + "spec.spec " + ChatColor.RED + "to execute this command!");
				}
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED + "You have to be a player to use this command!");
		}
		
		if (cmd.getName().equalsIgnoreCase("hspec"))
		{
			if (player.hasPermission("spec.spec"))
			{
				sender.sendMessage(ChatColor.GREEN + "Help for /spec Command:");
				sender.sendMessage(ChatColor.AQUA + "   Usage: /spec");
				sender.sendMessage(ChatColor.AQUA + "   Change between Spectator mode and Survival mode!");
			}
			else
			{
				player.sendMessage(ChatColor.RED + "You need the permission " + ChatColor.YELLOW + "spec.spec " + ChatColor.RED + "to execute this command!");
			}
		}
		
		return false;
	}
}