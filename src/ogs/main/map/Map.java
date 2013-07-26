package ogs.main.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
	
	private List<Integer> collisionTiles;
	
	public Map(String pathToFile) throws IOException{
		InputStream is = MapHelper.class.getResourceAsStream(pathToFile);
		String map = IOUtils.toString(is);
		
		initCollisions(map);
	}
	
	private void initCollisions(String map) {
		collisionTiles = new ArrayList<>();

		int collisionsIndex = map.indexOf(COLLISION);
		int objectsStartIndex = map.indexOf("[", collisionsIndex);
		int objectsEndIndex = map.indexOf("]", objectsStartIndex) + 1;
		
		JSONArray collisions = new JSONArray(map.substring(objectsStartIndex, objectsEndIndex));

		for(int i = 0; i < collisions.length(); i++){
			JSONObject collisionGroup = (JSONObject) collisions.get(i);
			
			int offsetY = ((Integer)collisionGroup.get(Y) / TILE_HEIGHT);
			int offsetX = ((Integer)collisionGroup.get(X) / TILE_WIDTH);
			
			int amountX = ((Integer)collisionGroup.get(HEIGHT) / TILE_HEIGHT);
			int amountY = ((Integer)collisionGroup.get(WIDTH) / TILE_HEIGHT);
			for(int b = 0; b < amountY; b++){
				for(int a = 0; b < amountX; b++){
					//new tile with X: offsetX + b  && Y: offsetY + a
					//change collision to a SET and override .equals in tile
				}
			}
			
		}
	}
}
