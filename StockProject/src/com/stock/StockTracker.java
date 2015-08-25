package com.stock;
import java.util.Scanner;

public class StockTracker {

	public static void main(String[] args) {
		
		
		
		printIntro();
		
		
		
		printAccountSummary(collectAccountInfo());
		

	}

	private static StockAccount collectAccountInfo() {
		Scanner userInput = new Scanner(System.in);
		StockAccount userAccountA = new StockAccount(userInput.nextLine(), userInput.nextLine(), userInput.nextDouble());
		userInput.close();
		
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
	}

	private static void printIntro() {
		System.out.println("Welcome to the StockTrader Class!");
		System.out.println("Please enter your first name, last name, and then your account balance: ");
	}

}
