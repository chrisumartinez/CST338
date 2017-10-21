/*
 * Title: BankDemo.java
 * Abstract: Creating a bank class that opens, closes, and prints accounts, tracks and makes
 * sure that no duplicates accounts are allowed, or added.
 * Author: Christian Martinez
 * Date: 9/20/2016
 */
package bank;

public class BankDemo {

	public static void main(String[] args) {
		System.out.println("Hello, Welcome to the Bank!");
		Bank bank =  new Bank("CSUMB");
		System.out.println("New Account");
		System.out.println("3 New Accounts!: ");
		bank.openAccount("Christian Martinez", "1234 Privet Drive", 1234, 1000, 1, 0);
		bank.openAccount("IronMan", "411 Surrey Way",  1222, 2000, 2, 100.50);
		bank.openAccount("Yessy Jimenez", "699 Shimara Drive", 9222, 3000, 1, 75.43);
		System.out.println(bank.openAccount("SADJALKSDJ" , "ASKDNASKLD", 1234, 1000, 2, 0));
		System.out.println("Bank Info: ");
		bank.bankInfo();
		System.out.println("CLOSING ACCOUNTS: ");
		System.out.println(bank.closeAccount(1000));
		System.out.println(bank.closeAccount(7000));
		System.out.println("Account Info: ");
		bank.accountInfo(2000);
		System.out.println(bank.accountInfo(9000));
		
	}
}
