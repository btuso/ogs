package ogs.main.helpers;

import java.io.IOException;
import java.io.InputStream;

import ogs.main.map.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class MapHelper {
	
	private String PATH_TO_MAP = "/files/maps/6.json";
	
	public MapHelper() {
		try {
			Map pepe = new Map(PATH_TO_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
