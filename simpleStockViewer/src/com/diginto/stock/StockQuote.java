package com.diginto.stock;

public class StockQuote {
	String symbol;
	double LastTradePrice; //いわゆる現在の株価？
	double Ask; //買値
	double Bid; //売値
	double DaysLow; //安値
	double DaysHigh; //高値
	int Volume; //出来高

	double ChangeRealtime;//ChangeRealtime: 前日終値からの差分
	double ChangePercent; //PercentChange: 前日終値からの差分(%)

	public StockQuote() {
	}
	public StockQuote(String symbol) {
		this.symbol = symbol;
	}
	public String toString() {
		return new String("symbol=" + this.getSymbol() + " LastTrade=" + Double.toString(this.getLastTradePrice()));
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getLastTradePrice() {
		return LastTradePrice;
	}
	public void setLastTradePrice(double lastTradePrice) {
		LastTradePrice = lastTradePrice;
	}

	public double getAsk() {
		return Ask;
	}
	public void setAsk(double ask) {
		Ask = ask;
	}

	public double getBid() {
		return Bid;
	}
	public void setBid(double bid) {
		Bid = bid;
	}
	public double getDaysLow() {
		return DaysLow;
	}
	public void setDaysLow(double daysLow) {
		DaysLow = daysLow;
	}
	public double getDaysHigh() {
		return DaysHigh;
	}
	public void setDaysHigh(double daysHigh) {
		DaysHigh = daysHigh;
	}
	public int getVolume() {
		return Volume;
	}
	public void setVolume(int volume) {
		Volume = volume;
	}
	public double getChangeRealtime() {
		return ChangeRealtime;
	}
	public void setChangeRealtime(double changeRealtime) {
		ChangeRealtime = changeRealtime;
	}
	public double getChangePercent() {
		return ChangePercent;
	}
	public void setChangePercent(double changePercent) {
		ChangePercent = changePercent;
	}


}
