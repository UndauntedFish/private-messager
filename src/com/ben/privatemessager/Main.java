package com.ben.privatemessager;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	/* COMMANDS:
	 * 	/message <player> <message> (args[0] is <player>, args[1] is <message>, etc.)
	 * 	/reply <message>
	 */
	
	private MessageManager manager;
	
	@Override
	public void onEnable()
	{
		System.out.println("PrivateMessager Enabled!");
		
		getCommand("message").setExecutor(new MessageCommand(this));
		getCommand("reply").setExecutor(new ReplyCommand(this));
		
		manager = new MessageManager(this);
	}
	
	public MessageManager getMessageManager() { return manager; }
}
