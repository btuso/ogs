package ogs.main.item;

import org.json.JSONObject;

public class ItemModifiers {

	public String ITEM_MODIFIER_POWER = "ItemModifierPower";
	public String ITEM_MODIFIER_INTELLIGENCE = "ItemModifierIntelligence";
	public String ITEM_MODIFIER_DEFENSE = "ItemModifierDefense";
	public String ITEM_MODIFIER_ENDURANCE = "ItemModifierEndurance";
	
	private int defense;
	private int endurance;
	private int intelligence;
	private int power;
	
	
	public ItemModifiers(JSONObject jsonObject) {
		this.defense = jsonObject.getInt(ITEM_MODIFIER_DEFENSE);
		this.endurance = jsonObject.getInt(ITEM_MODIFIER_ENDURANCE);
		this.intelligence = jsonObject.getInt(ITEM_MODIFIER_INTELLIGENCE);
		this.power = jsonObject.getInt(ITEM_MODIFIER_POWER);
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
