package ogs.main.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

import ogs.main.item.Item;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class ItemHelper {
	private String PATH_TO_ITEMS = "/files/items/items.json";

	private HashSet<Item> itemList;
	
	public ItemHelper(){
		itemList = new HashSet<>();
		try {
		InputStream is = MapHelper.class.getResourceAsStream(PATH_TO_ITEMS);
		String itemsString = IOUtils.toString(is);
		JSONArray itemsArray = new JSONArray(itemsString);
		for(int a = 0; a < itemsArray.length(); a++){
			Item item = new Item(itemsArray.getJSONObject(a));
			itemList.add(item);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}







/*
{
	   "fItemID":"",
	   "ItemName":"",
	   "ItemType":"",
	   "ItemStackable":"",
	   "ItemDescription":"",
	   "ItemBuyPrice":"",
	   "ItemSellPrice":"",
	   "ItemClass":"",
	   "ItemModifierPower":"",
	   "ItemModifierIntelligence":"",
	   "ItemModifierDefense":"",
	   "ItemModifierEndurance":"",
}
*/	
		