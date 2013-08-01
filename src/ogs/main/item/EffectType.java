package ogs.main.item;

public enum EffectType {
	POINTS_RESTORE(0,1),
	ATTRIBUTE_INCREASE(1,1),
	POISON(2,-1);
	
	private int type;
	private int multiplier;
	
	private EffectType(int type, int multiplier) {
		this.type = type;
		this.multiplier = multiplier;
	}
	
	public int getType() {
		return type;
	}
	
	public int getMultiplier() {
		return multiplier;
	}
}
