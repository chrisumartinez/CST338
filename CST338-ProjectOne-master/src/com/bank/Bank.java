package com.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bank {
	private ArrayList<Account> listOfAccounts;
	private ArrayList<Transaction> listOfTransactions;
	private ArrayList<Customer> listOfCustomers;
	private String name;

	public Bank(String name) {
		listOfAccounts = new ArrayList<Account>();
		listOfTransactions = new ArrayList<Transaction>();
		listOfCustomers = new ArrayList<Customer>();
		this.name = name;
	}

	public Bank() {
		listOfAccounts = new ArrayList<Account>();
		listOfTransactions = new ArrayList<Transaction>();
		listOfCustomers = new ArrayList<Customer>();
	}

	// TODO: Finish this function
	public void readText(String URL) {
		File openFile = new File(URL);
		try {
			Scanner fileScanner = new Scanner(openFile);
			while(fileScanner.hasNextLine()){
				int number = Integer.parseInt(fileScanner.nextLine());
				for(int i = 0; i < number; i++){
					String[] newCustomer = fileScanner.nextLine().split(",");
					String name = newCustomer[0];
					String address = newCustomer[1];
					int zipCode = Integer.parseInt(newCustomer[2]);
					String SSN = newCustomer[3];
					newCustomer(name, address, zipCode, SSN);
				}
				int numOfAccounts = Integer.parseInt(fileScanner.nextLine());
				for(int j = 0; j < numOfAccounts; j++){
					String[] newAccount = fileScanner.nextLine().split(",");
					String SSN = newAccount[0];
					int accountNumber = Integer.parseInt(newAccount[1]);
					int accountType = Integer.parseInt(newAccount[2]);
					double balance = Double.parseDouble(newAccount[3]);
					newAccount(SSN, accountNumber, accountType, balance);
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new Customer into the bank. Returns false if there is an existing
	 * customer.
	 * 
	 * @param name
	 * @param address
	 * @param zipCode
	 * @param SSN
	 * @return
	 */
	public boolean newCustomer(String name, String address, int zipCode, String SSN) {
		boolean flag = false;
		Customer newCustomer = new Customer();
		newCustomer.setName(name);
		newCustomer.setAddress(address);
		newCustomer.setZipCode(zipCode);
		newCustomer.setSSN(SSN);
		for (int i = 0; i < listOfCustomers.size(); i++) {
			if (newCustomer.getSSN() == listOfCustomers.get(i).getSSN()) {
				System.out.println("Sorry, Already an Existing Customer.");
				return flag;
			}
		}
		listOfCustomers.add(newCustomer);
		flag = true;
		return flag;

	}

	/**
	 * Creates a new account for a customer with the given SSN. returns false if
	 * there is an existing account, or if the customer does not exist.
	 * 
	 * @param SSN
	 * @param accountNum
	 * @param accountType
	 * @param balance
	 * @return
	 */
	public boolean newAccount(String SSN, int accountNum, int accountType, double balance) {
		boolean flag = false;
		Account newAccount = new Account();
		Customer customer = new Customer();
		for (int j = 0; j < listOfCustomers.size(); j++) {
			if (listOfCustomers.get(j).getSSN() == SSN) {
				customer = listOfCustomers.get(j);
			}

		}
		if (customer == null) {
			return flag;
		}
		newAccount.setAccountHolder(customer);
		newAccount.setAccountNum(accountNum);
		newAccount.setAccountType(accountType);
		newAccount.setBalance(balance);
		newAccount.setSSN(SSN);
		for (int i = 0; i < listOfAccounts.size(); i++) {
			if (listOfAccounts.get(i).getAccountNum() == accountNum) {
				return flag;
			}
		}
		listOfAccounts.add(newAccount);
		flag = true;
		return flag;
	}

	/**
	 * prints out the customer info with the given SSN to the console.
	 * 
	 * @param halfSSN
	 */
	public void customerInfoWithSSN(String halfSSN) {
		for (int i = 0; i < listOfCustomers.size(); i++) {
			String subSSN = listOfCustomers.get(i).getSSN().substring(7, listOfCustomers.get(i).getSSN().length());
			if (subSSN.compareTo(halfSSN) == 0) {
				System.out.println(listOfCustomers.get(i));
			}
		}

	}

	/**
	 * Removes the account from listOfAccounts. returns false if account does
	 * not exist.
	 * 
	 * @param accountNum
	 * @return
	 */
	public boolean closeAccount(int accountNum) {
		boolean flag = false;
		for (int i = 0; i < listOfAccounts.size(); i++) {
			if (listOfAccounts.get(i).getAccountNum() == accountNum) {
				listOfAccounts.remove(i);
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	/**
	 * Removes the customer with the given SSN. returns false if customer does
	 * not exist.
	 * 
	 * @param SSN
	 * @return
	 */
	public boolean removeCustomer(String SSN) {
		boolean flag = false;
		for (int i = 0; i < listOfCustomers.size(); i++) {
			if (listOfCustomers.get(i).getSSN().compareTo(SSN) == 0) {
				listOfCustomers.remove(i);
				flag = true;
				return flag;
			}
		}
		return flag;

	}

	/**
	 * function that deposits money through the given account. returns false if
	 * accountNumber doesnt exist.
	 * 
	 * @param accountNum
	 * @param d
	 * @return
	 */
	public boolean deposit(int accountNum, double d) {
		boolean flag = false;
		for (int i = 0; i < listOfAccounts.size(); i++) {
			if (listOfAccounts.get(i).getAccountNum() == accountNum) {
				listOfAccounts.get(i).setBalance(listOfAccounts.get(i).getBalance() + d);
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	/**
	 * withdraws the money from the given account Number. returns false if the
	 * account number does not exist.
	 * 
	 * @param accountNum
	 * @param d
	 * @return
	 */
	public boolean withdraw(int accountNum, double d) {
		boolean flag = false;
		for (int i = 0; i < listOfAccounts.size(); i++) {
			if (listOfAccounts.get(i).getAccountNum() == accountNum) {
				listOfAccounts.get(i).setBalance(listOfAccounts.get(i).getBalance() - d);
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	/**
	 * Prints out the transaction info with the given accountNumber.
	 * 
	 * @param accountNum
	 */
	public void transactionInfo(int accountNum) {
		for (int i = 0; i < listOfAccounts.size(); i++) {
			if (listOfAccounts.get(i).getAccountNum() == accountNum) {
				System.out.println(listOfAccounts.get(i).getListOfTransactions());
			}
		}
	}

	/**
	 * shows the accounts in the bank, along with the bank's balance.
	 */
	public void bankInfo(){
		double balance = 0;
		updateBank();
		System.out.println("Bank Name: " + name);
		System.out.println("Number of Customers: " + listOfCustomers.size());
		System.out.println("Number of Accounts: " + listOfAccounts.size());
		for(int i = 0; i < listOfAccounts.size(); i++){
			System.out.println(listOfAccounts.get(i));
			balance += listOfAccounts.get(i).getBalance();
		}
		System.out.println("Bank's Balance: " + balance);
	}
	/**
	 * prints out accountinfo into the console.
	 * 
	 * @param accountNum
	 */
	public void accountInfo(int accountNum) {
		for (int i = 0; i < listOfAccounts.size(); i++) {
			if (accountNum == listOfAccounts.get(i).getAccountNum()) {
				System.out.println(listOfAccounts.get(i));

			}
		}
	}
	/**
	 * updates the link between the SSN of an accountNumber and the customer.
	 */
	public void updateBank(){
		for(int i = 0; i < listOfAccounts.size(); i++){
			String SSN = listOfAccounts.get(i).getSSN();
			for(int j = 0; j < listOfCustomers.size(); j++){
				String custSSN = listOfCustomers.get(j).getSSN();
				if(SSN.compareTo(custSSN) == 0){
					listOfAccounts.get(i).setAccountHolder(listOfCustomers.get(j));
				}
			}
		}
	}
}
