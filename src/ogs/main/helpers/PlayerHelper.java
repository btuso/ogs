package ogs.main.helpers;

import java.util.HashSet;

import ogs.main.game.player.Player;
import ogs.main.server.protocol.JSONClientMessageFlags;

public class PlayerHelper implements JSONClientMessageFlags{

	
	HashSet<Player> players;
	
	
	public PlayerHelper() {
		players = new HashSet<Player>();
	}
	
	public void registerPlayer(String userId, String username){
		Player player = new Player(userId, username);
		
		players.add(player);

		MANDAR BROADCAST
		System.out.println("New player registered: "+username);
	}

	public HashSet<Player> getPlayers() {
		return players;
	}
}
