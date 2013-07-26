package ogs.main.helpers;

import java.util.HashMap;
import java.util.Map;

import ogs.main.game.player.Player;

import org.json.JSONObject;

public class PlayerHelper {

	Map<String,Player> players = null;
	
	
	public PlayerHelper() {
		players = new HashMap<String, Player>();
	}
	
	public void registerPlayer(JSONObject json){
		Player player = new Player(json);
		
		//TODO - Replace generic naming
		json.put(Player.jName, "Player-"+(players.size()+1));
		players.put(Player.jUUID, player);
		
		System.out.println("New player registered: "+json.toString(1));
	}
	
}
