package com.stock;

public class StockAccount {
	private String accountFirstName;
	private String accountLastName;
	private double balance;
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

}
