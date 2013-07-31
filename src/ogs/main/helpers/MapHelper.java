package ogs.main.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import ogs.main.map.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class MapHelper {
	
	private String PATH_TO_MAP = "/files/maps/6.json";
	HashMap<Integer, Map> maps;
	
	public MapHelper() {
		maps = new HashMap<>();
		try {
			int index = maps.size();
			Map pepe = new Map(PATH_TO_MAP, index);
			maps.put(index, pepe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, Map> getMaps() {
		return maps;
	}
	
}
