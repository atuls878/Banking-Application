package com.sample.app;

import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount b = new BankAccount("Atul Singh", "1403103");
		b.showMenu();
	}
}

class BankAccount {
	String cName;
	String cId;
	int balance;
	int pt;

	BankAccount(String cName, String cId) {
		this.cName = cName;
		this.cId = cId;
	}

	void deposit(int amount) {
		if (amount != 0 ) {
			balance =balance + amount;
			pt = amount;
			System.out.println("Balance= "+balance);
		}
		
	}

	void withdraw(int amount) {
		if (amount != 0 && balance-amount>0  ) {
			balance = balance-amount;
			pt = -amount;
			System.out.println("Balance= "+balance);
		}
		else 
		{
			System.out.println("Not Enough Funds");
		}
			
	}

	void getPreviousTransaction() {
		if (pt > 0) {
			System.out.println("Deposit: " + pt);
		} else if (pt < 0) {
			System.out.println("Withdraw: " + Math.abs(pt));
		} else if (pt > 0) {
			System.out.println("No Transaction Found");
		}
	}

	void showMenu() {
		int option = 0;
		System.out.println("Welcome: " + cName);
		System.out.println("Your Id is: " + cId);
		Scanner s = new Scanner(System.in);
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Previous Transaction");
		System.out.println("4. Check Balance");
		System.out.println("5. Exit");

		do {
			System.out.print("Enter Option: ");
			option = s.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter Amount to be Deposited");
				int amount = s.nextInt();
				deposit(amount);
				break;
			case 2:
				System.out.println("Enter Amount");
				int amount1 = s.nextInt();
				withdraw(amount1);
				break;
			case 3:
				getPreviousTransaction();
				break;
			case 4:
				System.out.println("Balance: " + balance);
				break;
			}

		} while (option != 5);
		System.out.println("Thankyou For Using Our Services");

		s.close();

	}
}
