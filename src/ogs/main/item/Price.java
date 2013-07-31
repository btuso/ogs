package ogs.main.item;

public class Price {
	
	Integer buyPrice;
	Integer sellPrice;
	
	public Price(Integer buyPrice, Integer sellPrice) {
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public Integer getBuyPrice() {
		return buyPrice;
	}
	
	public Integer getSellPrice() {
		return sellPrice;
	}
}
