package ogs.main.item;

import java.lang.reflect.Array;

import ogs.main.ClassType;

import org.json.JSONObject;

public class Item {

public static String ITEM_ID = "ItemID";
public static String ITEM_NAME = "ItemName";
public static String ITEM_TYPE = "ItemType";
public static String ITEM_STACKABLE = "ItemStackable";
public static String ITEM_DESCRIPTION = "ItemDescription";
public static String ITEM_BUY_PRICE = "ItemBuyPrice";
public static String ITEM_SELL_PRICE = "ItemSellPrice";
public static String ITEM_CLASS = "ItemClass";
public static String ITEM_MODIFIERS = "ItemModifiers";
public static String ITEM_EFFECT = "ItemEffect";
	
	private int id;
	private String name;
	private ItemType type;
	private boolean stackable;
	private String description;
	private Price price;
	private ClassType classType;
	private ItemModifiers modifiers;
	private ItemEffect effect;
	
	public Item(JSONObject holder) {
		id = holder.getInt(ITEM_ID);
		name = holder.getString(ITEM_NAME);
		setItemType(holder.getInt(ITEM_TYPE));
		stackable = holder.getBoolean(ITEM_STACKABLE);
		description = holder.getString(ITEM_DESCRIPTION);
		price = new Price(holder.getInt(ITEM_BUY_PRICE), holder.getInt(ITEM_SELL_PRICE));
//		TODO itemclasses~
		if(holder.getJSONObject(ITEM_MODIFIERS) != null){
			modifiers = new ItemModifiers(holder.getJSONObject(ITEM_MODIFIERS));
		} else if(holder.getJSONObject(ITEM_EFFECT) != null){
			effect = new ItemEffect(holder.getJSONObject(ITEM_EFFECT));
		}
	}
	
	private void setItemType(int type) {
		ItemType[] values = ItemType.values();
		for(int i = 0; i < values.length; i++){
			if(values[i].getType() == type){
				this.type = values[i];
			}
		}
	}
	
	
	public int getItemId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}

