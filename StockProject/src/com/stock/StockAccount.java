package com.stock;

public class StockAccount {
	private String accountFirstName;
	private String accountLastName;
	private double balance;
	private Stock linkedStock;
	private static final int DEFAULT_BALANCE = 1000;
	
	public StockAccount(String accountFirstName, String accountLastName, double balance){
		super();
		this.accountFirstName = accountFirstName;
		this.accountLastName = accountLastName;
		this.balance = balance;
	}
	
	public StockAccount(String accountFirstName, String accountLastName){
		super();
		this.accountFirstName = accountFirstName;
		this.accountLastName = accountLastName;
		this.balance = DEFAULT_BALANCE;
		
	}
	
	public void buyStock(Stock userStock){
		if (this.balance < userStock.getNumberOfShares() * userStock.getPriceOfStock()){
			System.out.println("You cannot buy that much of this stock due to insufficient funds!");
		}
		
		else{
			if ((linkedStock != null) && (userStock.getStockSymbol().equals(linkedStock.getStockSymbol())) ){
			this.balance = this.balance - userStock.getNumberOfShares() * userStock.getPriceOfStock();
			this.linkedStock = userStock;
			System.out.println("You have purchased: " + userStock.getNumberOfShares() + " of " + userStock.getStockSymbol());
			System.out.println("At a cost of: " + userStock.getPriceOfStock() + " per stock.");
			}
			else{
				if (linkedStock == null){
					this.balance = this.balance - userStock.getNumberOfShares() * userStock.getPriceOfStock();
					this.linkedStock = userStock;
					System.out.println("You have purchased: " + userStock.getNumberOfShares() + " of " + userStock.getStockSymbol());
					System.out.println("At a cost of: " + userStock.getPriceOfStock() + " per stock.");
				}
				else{
					if (!(linkedStock.getStockSymbol().equals(userStock.getStockSymbol()))){
						System.out.println("You can only buy one type of stock!");
					}
				}
				
			}
		}
		
	}
	
	public String getAccountFirstName() {
		return accountFirstName;
	}
	public void setAccountFirstName(String accountFirstName) {
		this.accountFirstName = accountFirstName;
	}
	public String getAccountLastName() {
		return accountLastName;
	}
	public void setAccountLastName(String accountLastName) {
		this.accountLastName = accountLastName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Stock getLinkedStock() {
		return linkedStock;
	}
	
	public void sellStock(Stock sellThisStock){
		if (!(sellThisStock.getStockSymbol().equals(linkedStock.getStockSymbol()))){
			System.out.println("You don't own any shares of that stock.");
		}
		else{
			if (sellThisStock.getNumberOfShares() > linkedStock.getNumberOfShares()){
				System.out.println("You don't own that many shares, crazy!");
			}
			else{
				balance = balance + (sellThisStock.getNumberOfShares() * sellThisStock.getPriceOfStock());
				linkedStock.setNumberOfShares(linkedStock.getNumberOfShares() - sellThisStock.getNumberOfShares());
				linkedStock.setPriceOfStock(sellThisStock.getPriceOfStock());
				System.out.println("You sold " + sellThisStock.getNumberOfShares() + " of " + sellThisStock.getStockSymbol() + " for " + (sellThisStock.getNumberOfShares() * sellThisStock.getPriceOfStock()) + ".");
				
			}
		}
	}

}
