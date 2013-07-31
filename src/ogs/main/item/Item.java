package ogs.main.item;

import ogs.main.ClassType;

import org.json.JSONObject;

public class Item {

public String ITEM_ID = "ItemID";
public String ITEM_NAME = "ItemName";
public String ITEM_TYPE = "ItemType";
public String ITEM_STACKABLE = "ItemStackable";
public String ITEM_DESCRIPTION = "ItemDescription";
public String ITEM_BUY_PRICE = "ItemBuyPrice";
public String ITEM_SELL_PRICE = "ItemSellPrice";
public String ITEM_CLASS = "ItemClass";
public String ITEM_MODIFIERS = "ItemModifiers";
public String ITEM_EFFECT = "ItemEffect";
	
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
//		type
		stackable = holder.getBoolean(ITEM_STACKABLE);
		description = holder.getString(ITEM_DESCRIPTION);
		price = new Price(holder.getInt(ITEM_BUY_PRICE), holder.getInt(ITEM_SELL_PRICE));
//		class
		modifiers = new ItemModifiers(holder.getJSONObject(ITEM_MODIFIERS));
		effect = new ItemEffect(holder.getJSONObject(ITEM_EFFECT));
	}
	
	
	
	
	public int getItemId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}

