package ogs.main.item;

import ogs.main.entity.Attributes;
import ogs.main.entity.Attributes.Attribute;

import org.json.JSONObject;

public class ItemEffect {

	private String AMOUNT = "Amount";
	
	private EffectType type;
	private Attribute targetAttribute;
	private int amount;
	
	public ItemEffect(JSONObject jsonObject) {
		setEffectType(jsonObject.getInt(Item.ITEM_EFFECT));
		setTargetAttribute(jsonObject.getInt(Attributes.ATTRIBUTE));
		amount = jsonObject.getInt(AMOUNT);
	}

	
	
	private void setEffectType(int type) {
		EffectType[] values = EffectType.values();
		for(int i = 0; i < values.length; i++){
			if(values[i].getType() == type){
				this.type = values[i];
			}
		}
	}
	
	private void setTargetAttribute(int attribute) {
		Attribute[] values = Attribute.values();
		for(int i = 0; i < values.length; i++){
			if(values[i].getAttribute() == attribute){
				this.targetAttribute = values[i];
			}
		}
	}
}
