package com.stock;

public class Stock {
	
	private String stockSymbol;
	private int numberOfShares;
	private double priceOfStock;
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public double getPriceOfStock() {
		return priceOfStock;
	}
	public void setPriceOfStock(double priceOfStock) {
		this.priceOfStock = priceOfStock;
	}

}
