package com.bot.tutorial;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.*;
import java.net.*;
import org.json.*;

public class BotListener extends ListenerAdapter{
	
	public void onMessageReceived(MessageReceivedEvent e) {
		if(e.getMessage().getRawContent().equalsIgnoreCase(">catfact")) {
			
			MessageChannel channel = e.getChannel();

			try {
				URL url = new URL("http://catfacts-api.appspot.com/api/facts");
	
		        //String query = "{'number': '5'}";
	
		        //make connection
		        HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
	
		        // use get mode
		        urlc.setRequestMethod("GET");
		        urlc.setDoOutput(true);
	
		        // add request header
		        urlc.setRequestProperty("number", "1");
		        //urlc.setAllowUserInteraction(false);
	
		        int responseCode = urlc.getResponseCode();
		        System.out.println("sending 'GET' request to URL : " + url);
		        System.out.println("Response Code : " + responseCode);
	
		        //get result
		        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
		        String l = null;
		        StringBuilder buffer = new StringBuilder();
		        while ((l=br.readLine())!=null) {
		            System.out.println(l);
		            buffer.append(l);
		        }
		        
		        l = buffer.toString();
		        
		        // convert string to json
		        JSONObject obj = new JSONObject(l);
		        JSONArray factArr = obj.getJSONArray("facts");
		        String fact = factArr.toString(0);
		        fact = fact.replaceAll("\"", "");
		        fact = fact.replaceAll("[\\[\\]]", "");
		        
		        channel.sendMessage(fact).queue();
		        
		        br.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
}
