package com.ben.privatemessager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MessageCommand implements CommandExecutor
{
	private Main main;
	
	public MessageCommand(Main main)
	{
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// Blind Cast! Code will break if the CONSOLE is the sender.
		Player player = (Player) sender; 
		
		if (args.length >= 2)
		{
			// Checks to see if target player exists or not.
			if (Bukkit.getPlayerExact(args[0]) != null)
			{
				// Target exists, so store them in a Player variable
				Player target = Bukkit.getPlayerExact(args[0]);
				
				/* Constructs the message by iterating through args[] and 
				 * appending all message arguments to one string via StringBuilder */
				StringBuilder message = new StringBuilder();
				for (int i = 1; i < args.length; i++)
				{
					// Appends each arg like "<value of arg[i]>" + " "
					message.append(args[i]).append(" ");
				}
				
				// Broadcasts to the sender Player the message that they sent to target Player, and vice-versa
				player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY + " " + message.toString());
				target.sendMessage(ChatColor.GREEN + "<- " + player.getName() + ChatColor.GRAY + " " + message.toString());
				
				main.getMessageManager().recentlyMessaged.put(player, target);
			}
			else
			{
				// Target does not exist, throw error
				player.sendMessage(ChatColor.RED + "[PrivateMessager] Player not found!");
			}
		}
		else
		{
			player.sendMessage(ChatColor.RED + "[PrivateMessager] Invalid usage! Use /message <player> <message>");
		}
		
		return false;
	}

}
