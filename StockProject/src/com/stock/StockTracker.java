package com.stock;
import java.util.Scanner;

public class StockTracker {
	static Scanner userInput = new Scanner(System.in);
	static Stock userStock;

	public static void main(String[] args) {
		
		
		boolean cont = true;
		
		printIntro();
		StockAccount userAccountA = collectAccountInfo();
		printAccountSummary(userAccountA);
		while (cont == true){
			
			System.out.println("Enter 1 to buy stock, 2 to sell, 3 to deposit, or 4 to withdraw: ");
			
			int userIntChoice = userInput.nextInt();
			
			switch (userIntChoice){
			case 1:{
				System.out.println("Now you're going to buy stock! ");
				userStock = collectStockInfo();
				userAccountA.buyStock(userStock);
				printAccountSummary(userAccountA);
				System.out.println("Would you like to continue buying or selling? Enter 1 to cotinue or 2 to quit: ");
				
				int contIntChoice = userInput.nextInt();
				if (contIntChoice == 1){
					cont = true;
				}
				else {
					cont = false;
				}
				break;
			}
			case 2:{
				System.out.println("You'll now be selling stock! ");
				Stock userStock2 = collectStockInfo();
				userAccountA.sellStock(userStock2);
				printAccountSummary(userAccountA);
				System.out.println("Would you like to continue buying or selling? Enter 1 to cotinue or 2 to quit: ");
				
				int contIntChoice = userInput.nextInt();
				if (contIntChoice == 1){
					cont = true;
				}
				else {
					cont = false;
				}
				break;
			}
			case 3:{
				System.out.println("How much would you like to deposit? ");
				userAccountA.setBalance(userAccountA.getBalance() + userInput.nextDouble());
				System.out.println("Your balance is now: " + userAccountA.getBalance());
				System.out.println("Would you like to continue buying or selling? Enter 1 to cotinue or 2 to quit: ");
				
				int contIntChoice = userInput.nextInt();
				if (contIntChoice == 1){
					cont = true;
				}
				else {
					cont = false;
				}
				break;
			}
			case 4:{
				System.out.println("How much would you like to withdraw? ");
				userAccountA.setBalance(userAccountA.getBalance() - userInput.nextDouble());
				System.out.println("Your balance is now: " + userAccountA.getBalance());
				System.out.println("Would you like to continue buying or selling? Enter 1 to cotinue or 2 to quit: ");
				
				int contIntChoice = userInput.nextInt();
				if (contIntChoice == 1){
					cont = true;
				}
				else {
					cont = false;
				}
				break;
			}
			default: System.out.println("Error: invalid choice of number." );
			
			}
		}
		userInput.close();
	}
	
	private static Stock collectStockInfo(){
		//Scanner userInput = new Scanner(System.in);
		//Stock userStock;
		System.out.println("Is this stock a dividend stock? Enter 1 for yes or 2 for no: ");
		if (userInput.nextInt() == 1){
			userInput.nextLine();
			System.out.println("What is the stock symbol, the number of shares you want to buy/sell, the price of the stock you want to buy/sell, and the amount of the dividend:  ");
			String userSymbol = userInput.nextLine();
			int userStockCount = userInput.nextInt();
			double userStockCost = userInput.nextDouble();
			userInput.nextLine();
			double dividendAmount = userInput.nextDouble();
			userInput.nextLine();
			return new DividendStock(userSymbol, userStockCount, userStockCost, dividendAmount);
			
		}
		else {
			System.out.println("Please enter the stock symbol, the number of shares you want to buy/sell, and the price of the stock you want to buy/sell:  ");
			String userSymbol = userInput.nextLine(); 
			int userStockCount = userInput.nextInt(); 
			double userStockCost = userInput.nextDouble();
			userStock = new Stock(userSymbol, userStockCount, userStockCost);
			}
		return userStock;
	}

	private static StockAccount collectAccountInfo() {
		//Scanner userInput = new Scanner(System.in);
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
			System.out.println("Symbol: " + userAccountA.getLinkedStock().getStockSymbol());
			System.out.println("Number of Shares: " + userAccountA.getLinkedStock().getNumberOfShares());
			System.out.println("Cost per Share: " + userAccountA.getLinkedStock().getPriceOfStock());	
		}
	}

	private static void printIntro() {
		System.out.println("Welcome to the StockTrader Class!");
		System.out.println("Please enter your first name, last name, and then your account balance: ");
	}

}
