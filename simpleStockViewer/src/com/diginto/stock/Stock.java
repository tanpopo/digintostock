package com.diginto.stock;

public class Stock {
	String id;
	String market;//Tokyo, NY, ...
	String name;
	int currentValue;
	int diffValue;
	float diffRate;

	Stock(String id, String market, String name) {
		this.id = id;
		this.market = market;
		this.name = name;
	}

	//diffRate
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}

	public String getIdWithMarket() {
		return (id + "/" + market);
	}

	//diffValue
	public int getDiffValue() {
		return diffValue;
	}
	public void setDiffValue(int diffValue) {
		this.diffValue = diffValue;
	}

	//diffRate
	public float getDiffRate() {
		return diffRate;
	}
//	public void setDiffRate(float diffRate) {
//		this.diffRate = diffRate;
//	}

	//currentValue
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

}
