package com.stock;

public class DividendStock extends Stock {
	
	private double dividendPaidByStock;

	public DividendStock(String stockSymbol, int numberOfShares,
			double priceOfStock, double dividendPaidByStock) {
		super(stockSymbol, numberOfShares, priceOfStock);
		this.setStockSymbol(stockSymbol);
		this.setNumberOfShares(numberOfShares);
		this.setPriceOfStock(priceOfStock);
		this.setDividendPaidByStock(dividendPaidByStock);
		// TODO Auto-generated constructor stub
	}

	public double getDividendPaidByStock() {
		return dividendPaidByStock;
	}

	public void setDividendPaidByStock(double dividendPaidByStock) {
		this.dividendPaidByStock = dividendPaidByStock;
	}

}
