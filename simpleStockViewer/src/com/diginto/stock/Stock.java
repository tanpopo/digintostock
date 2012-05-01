package com.diginto.stock;

public class Stock {
	String name;
	int currentValue;

	Stock(String name, int currentValue) {
		this.name = name;
		this.currentValue = currentValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

}
