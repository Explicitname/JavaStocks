package com.stock;
import java.util.Scanner;

public class StockTracker {

	public static void main(String[] args) {
		
		printIntro();
		StockAccount userAccountA = collectAccountInfo();
		printAccountSummary(userAccountA);
		Stock userStock = collectStockInfo();
		userAccountA.buyStock(userStock);
		printAccountSummary(userAccountA);

	}
	
	private static Stock collectStockInfo(){
		System.out.println("Now you're going to buy stock! ");
		System.out.println("Please enter the stock symbol, the number of shares you want to buy, and the price of the stock you want to buy:  ");
		Scanner stockInput = new Scanner(System.in);
		//String userSymbol = stockInput.nextLine(); 
		//int userStockCount = stockInput.nextInt(); 
		//double userStockCost = stockInput.nextDouble();
		Stock userStock = new Stock(stockInput.nextLine(), stockInput.nextInt(), stockInput.nextDouble());
		
		
		return userStock;
	}

	private static StockAccount collectAccountInfo() {
		Scanner userInput = new Scanner(System.in);
		StockAccount userAccountA = new StockAccount(userInput.nextLine(), userInput.nextLine(), userInput.nextDouble());
		
		
		if (userAccountA.getBalance() <= 0){
			userAccountA = new StockAccount(userAccountA.getAccountFirstName(), userAccountA.getAccountLastName());
		}
		
		return userAccountA;
				
		
	}

	private static void printAccountSummary(StockAccount userAccountA) {
		System.out.println("Your account details are: ");
		System.out.println("First Name: " + userAccountA.getAccountFirstName());
		System.out.println("Last Name: " + userAccountA.getAccountLastName());
		System.out.println("Balance: " + userAccountA.getBalance());
		if(userAccountA.getLinkedStock() == null){
			System.out.println("You don't yet own any stock... :( ");
		}
		else{
			userAccountA.printLinkedStock();
		}
	}

	private static void printIntro() {
		System.out.println("Welcome to the StockTrader Class!");
		System.out.println("Please enter your first name, last name, and then your account balance: ");
	}

}
