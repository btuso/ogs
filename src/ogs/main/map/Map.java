package ogs.main.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ogs.main.helpers.MapHelper;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Map {
	public static int TILE_HEIGHT = 32;
	public static int TILE_WIDTH = 32;
	public static int MAP_HEIGHT = 100;
	public static int MAP_WIDTH = 100;
	public static String Y = "y";
	public static String X = "x";
	public static String HEIGHT = "height";
	public static String WIDTH = "width";
	
	private String KEY = "\"objects\":";
	private String COLLISION = "Collisions";
	private String MOB_SPAWNER = "MobSpawner";
	
	private int mapId;
	private Set<Tile> collisionTiles;
	private Set<MobSpawn> spawnTiles;
	
	
	public Map(String pathToFile, int mapId) throws IOException{
		this.mapId = mapId;
		InputStream is = MapHelper.class.getResourceAsStream(pathToFile);
		String map = IOUtils.toString(is);
		
		initCollisions(map);
		initSpawners(map);
	}
	
	private void initCollisions(String map) {
		collisionTiles = new HashSet<>();
		JSONArray collisions = getJSONObjectsFromString(map, COLLISION);

		for(int i = 0; i < collisions.length(); i++){
			JSONObject collisionGroup = (JSONObject) collisions.get(i);
			
			int offsetY = collisionGroup.getInt(Y) / TILE_HEIGHT;
			int offsetX = collisionGroup.getInt(X) / TILE_WIDTH;
			
			int amountX = collisionGroup.getInt(HEIGHT) / TILE_HEIGHT;
			int amountY = collisionGroup.getInt(WIDTH) / TILE_WIDTH;

			for(int b = 0; b < amountY; b++){
				for(int a = 0; b < amountX; b++){
					Tile tile = new Tile(mapId, offsetX + b, offsetY + a, true);
					collisionTiles.add(tile);
				}
			}
		}
	}
	
	private void initSpawners(String map){
		spawnTiles = new HashSet<>();
		JSONArray spawners = getJSONObjectsFromString(map, MOB_SPAWNER);
		
		for(int i = 0; i < spawners.length(); i++){
			Set<Tile> spawnGroupTiles = new HashSet<>();
			JSONObject spawnGroup = (JSONObject) spawners.get(i);
			
			int offsetY = spawnGroup.getInt(Y) / TILE_HEIGHT;
			int offsetX = spawnGroup.getInt(X) / TILE_WIDTH;
			
			int amountX = spawnGroup.getInt(HEIGHT) / TILE_HEIGHT;
			int amountY = spawnGroup.getInt(WIDTH) / TILE_WIDTH;

			for(int b = 0; b < amountY; b++){
				for(int a = 0; b < amountX; b++){
					//TODO hardcoded map code 
					Tile tile = new Tile(mapId, offsetX + b, offsetY + a, true);
					spawnGroupTiles.add(tile);
				}
			}
			
			new MobSpawn(spawnGroupTiles, spawnGroup.getJSONObject("properties"));
		}
	}
	
	private JSONArray getJSONObjectsFromString(String map, String objectGroup) {
		int startIndex = map.indexOf(objectGroup);
		int objectsStartIndex = map.indexOf("[", startIndex);
		int objectsEndIndex = map.indexOf("]", objectsStartIndex) + 1;
		
		return new JSONArray(map.substring(objectsStartIndex, objectsEndIndex));
	}
}
