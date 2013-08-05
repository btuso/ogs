package ogs.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import ogs.main.game.player.Player;
import ogs.main.map.Map;
import ogs.main.map.Tile;
import ogs.main.server.protocol.JSONMessageFlags;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONMaker implements JSONMessageFlags{
	public static String hashMapToJSONArrayStringWithHeader(HashMap<String,String> map){
		StringBuilder builder = new StringBuilder();
		Iterator<String> it = map.keySet().iterator();
		
		//Attach message header
		builder.append("[{\"");
		builder.append(JSONMessageFlags.HEADER);
		builder.append("\":");
		builder.append(map.get(JSONMessageFlags.HEADER));
		builder.append("\"},");
		
		
		while(it.hasNext()){
			String key = it.next();
			builder.append("\"");
			builder.append(key);
			builder.append("\":\"");
			builder.append(map.get(key));
			builder.append("\",");
		}
		builder.deleteCharAt(builder.length());
		builder.append("}]");
		
		return builder.toString();
	}
	
	public static JSONArray hashMapToJSONArrayWithHeader(HashMap<String, String> map) throws JSONException{
		return new JSONArray(hashMapToJSONArrayStringWithHeader(map));
	}
	
	public static JSONArray makeTilesJSONArray(HashSet<Tile> tiles){
		StringBuilder builder = new StringBuilder();
		Iterator<Tile> it = tiles.iterator();
		
		builder.append("[");
		while(it.hasNext()){
			Tile tile = it.next();
			builder.append(makeTileJSONObject(tile));
		}
		builder.deleteCharAt(builder.length());
		builder.append("]");
		
		return new JSONArray(builder.toString());
	}
	
	private static String makeTileJSONObject(Tile tile) {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		builder.append(X);
		builder.append("\":\"");
		builder.append(tile.getX());
		builder.append("\",\"");
		builder.append(Y);
		builder.append("\":\"");
		builder.append(tile.getY());
		builder.append("\"},");	
		
		return builder.toString();
	}
	
	public static JSONArray makePlayersUpdateJsonArray(HashSet<Player> players){
		StringBuilder builder = new StringBuilder();
		Iterator<Player> it = players.iterator();
		
		builder.append("[");
		while(it.hasNext()){
			Player player = it.next();
			builder.append("{\"");
			builder.append(USERNAME);
			builder.append("\":\"");
			builder.append(player.getUsername());
			builder.append("\",\"");
			builder.append(USER_ID);
			builder.append("\":\"");
			builder.append(player.getUserId());
			builder.append("\",\"");
			builder.append(HP);
			builder.append("\":\"");
			builder.append(player.getHPPercentage());
			builder.append("\",\"");
			builder.append(TILE);
			builder.append("\":");
			builder.append(makeTileJSONObject(player.getCurrentTile()));
			builder.deleteCharAt(builder.length());
			builder.append("},");
		}
		builder.deleteCharAt(builder.length());
		builder.append("]");
		
		return new JSONArray(builder.toString());		
	}
	
}
