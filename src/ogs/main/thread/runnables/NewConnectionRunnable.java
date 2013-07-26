package ogs.main.thread.runnables;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import ogs.main.helpers.PlayerHelper;

import org.json.JSONObject;

public class NewConnectionRunnable implements Runnable{

	Socket client = null;
	
	public NewConnectionRunnable(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
		//TODO Send update message
		
		//me quedo esperando que mande algo
		//player create / log player
		try {
	     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	     String result = "";
	        String inputLine;
	        JSONObject json = null;
			while ((inputLine = in.readLine()) != null) {
				result = result.concat(inputLine);  
				json = new JSONObject(result);
				PlayerHelper papa = new PlayerHelper();
				papa.registerPlayer(json);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
