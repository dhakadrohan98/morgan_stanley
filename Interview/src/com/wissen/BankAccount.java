package com.wissen;

//deposit
//withdraw
//checkBalance
public class BankAccount {
	
	int totalAmount = 0;
	
	public int checkBalance() {
		return totalAmount;
	}
	
	public void deposit(int amount) {
		totalAmount += amount;
		System.out.println("total amount - " + totalAmount);
	}
	
	public void withdraw(int withDrawnAmount) {
		if(totalAmount >= withDrawnAmount) {
			totalAmount -= withDrawnAmount;
			System.out.println("Withdrawn was successful");
			System.out.println("total amount - " + totalAmount);
		} else {
			System.out.println("Withdrawn is not possible due to low balance in the account."
					+ " Total balance in the account is " + totalAmount);
		}
	}
	
	public static void main(String[] args) {
		BankAccount customer1  = new BankAccount();
		customer1.deposit(1000);
		customer1.withdraw(200);
		int bankBalance = customer1.checkBalance();
		System.out.println(bankBalance);
		customer1.withdraw(2000);
	}

}
