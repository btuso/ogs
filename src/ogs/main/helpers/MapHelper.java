package ogs.main.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import ogs.main.map.Map;
import ogs.main.map.Tile;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class MapHelper {
	
	private String PATH_TO_MAP = "/files/maps/6.json";
	HashMap<Integer, Map> maps;
	
	public MapHelper() {
		maps = new HashMap<>();
		try {
			int index = maps.size() + 1;
			Map pepe = new Map(PATH_TO_MAP, index);
			maps.put(index, pepe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Tile getAvailablePlayerSpawnTileFromMap(Integer mapId) {
		Map map = maps.get(mapId);
		return map.getAvailablePlayerSpawnTile();
	}
	
	public HashMap<Integer, Map> getMaps() {
		return maps;
	}
	
}
