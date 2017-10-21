package com.bank;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank("CSUMB");
		System.out.println("======== READ DATA =========");
		bank.readText("bank.txt");
		System.out.println("======== DONE ============");
		bank.updateBank();
		System.out.println("==== BANK INFORMATION ======");
		bank.bankInfo();
		System.out.println("==== ACCOUNT INFORMATION =====");
		bank.accountInfo(1000);
		bank.deposit(1000, 150.25);
		System.out.println("======= ACCOUNT INFORMATION =====");
		bank.accountInfo(1000);
		bank.withdraw(1000, 100);
		System.out.println("======= ACCOUNT INFORMATION ======");
		bank.accountInfo(1000);
		System.out.println("======= ACCOUNT CLOSE ========");
		if(bank.closeAccount(1000)){
			System.out.println("Account Closed.");
		}
		System.out.println("Done.");
		
	}

}
