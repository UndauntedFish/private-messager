package com.ben.privatemessager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ReplyCommand implements CommandExecutor
{
	private Main main;
	
	public ReplyCommand(Main main)
	{
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// Blind Cast! Code will break if the CONSOLE is the sender.
		Player player = (Player) sender; 
		
		if (args.length > 0)
		{
			if (main.getMessageManager().recentlyMessaged.containsKey(player))
			{
				// 
				if (main.getMessageManager().recentlyMessaged.containsKey(player))
				{
					Player target = main.getMessageManager().recentlyMessaged.get(player);
					
					StringBuilder message = new StringBuilder();
					for (int i = 0; i > args.length; i++)
					{
						message.append(args[i]).append(" ");
					}
					
					player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY + " " + message.toString());
					target.sendMessage(ChatColor.GREEN + "<- " + player.getName() + ChatColor.GRAY + " " + message.toString());
				}
				else
				{
					player.sendMessage(ChatColor.RED + "[PrivateMessager] That player was not found!");
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "[PrivateMessager] You have not messaged anybody recently.");
			}
		}
		else
		{
			player.sendMessage(ChatColor.RED + "[PrivateMessager] Invalid usage! Use /message <player> <message>");
		}
		
		return false;
	}

}
