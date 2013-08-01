package ogs.main.game.player;

import ogs.main.map.Tile;

import org.json.JSONObject;

public class Player {
	public static String jUUID = "UUID";
	public static String jName = "name";
	
	private String UUID = "UUID";
	private String name = "name";
	private Tile currentTile;
	
	public Player(JSONObject json) {
		this.UUID = json.getString(jUUID);
		this.name = json.getString(jName);
	}
	
	public String getUUID() {
		return UUID;
	}
	
	public String getName() {
		return name;
	}
}
