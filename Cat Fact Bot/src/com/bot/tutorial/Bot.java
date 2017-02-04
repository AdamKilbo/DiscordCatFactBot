package com.bot.tutorial;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Bot {
	
	public static JDA jda;
	
	public static final String BOT_TOKEN = "Mjc2MTkwODgzMzg3NTM5NDcz.C3LnBQ.JJMFfx4hc8LCRDWgQhP8dWH7mQc";

	public static void main(String[] args) {
		
		try {
			jda = new JDABuilder(AccountType.BOT).addListener(new BotListener()).setToken(BOT_TOKEN).buildBlocking();
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			e.printStackTrace();
		}
		
	}

}
