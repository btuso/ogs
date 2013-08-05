package ogs.main.game.player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import ogs.main.item.Item;
import ogs.main.item.ItemModifiers;
import ogs.main.item.ItemType;

public class Equipment {
	
	HashMap<ItemType, Item> items;
	private int defense = 0;
	private int endurance = 0;
	private int intelligence = 0;
	private int power = 0;
	
	
	public Equipment() {
		items = new HashMap<>();
	}
	
	private void equipItem(Item item) {
		if(items.containsKey(item.getType())){
			unequipItem(item);
		}
		items.put(item.getType(), item);
		updateModifiers();
		SEND THE FUCKING MESSAGE
	}
	
	private void unequipItem(Item item) {
		if(items.containsValue(item)){
			items.remove(item);
			updateModifiers();
			SEND THE FUCKING MESSAGE
		}
	}
	
	private void updateModifiers() {
		Collection<Item> col = items.values();
		Iterator<Item> it = col.iterator();
		while(it.hasNext()){
			Item item = it.next();
			ItemModifiers modifiers = item.getModifiers(); 
			this.defense += modifiers.getDefense();
			this.endurance += modifiers.getEndurance();
			this.intelligence += modifiers.getIntelligence();
			this.power += modifiers.getPower();
		}
	}

	public int getDefense() {
		return defense;
	}

	public int getEndurance() {
		return endurance;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getPower() {
		return power;
	}
}
