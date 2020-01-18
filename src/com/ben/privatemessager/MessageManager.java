package com.ben.privatemessager;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class MessageManager
{
	private Main main;
	
	public MessageManager(Main main)
	{
		this.main = main;
	}
	
	/* HashMaps are <key, value> data storage mechanisms:
	 * 	In order to get the value (which is the second arg in the constructor), 
	 * 	you have to put in a key (which is the firsts arg).
	 * 
	 * Here, the key is a Player and the value is also a Player
	 */
	public HashMap<Player, Player> recentlyMessaged = new HashMap<>();
	
	
}
