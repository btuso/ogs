package ogs.main.item;

public enum ItemType {
	CONSUMABLE(0),
	QUEST(1),
	WEAPON(2),
	ARMOR(3),
	SHIELD(4),
	HELM(5),
	EXTRA(6);
	
	private int type;
	
	private ItemType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
}
