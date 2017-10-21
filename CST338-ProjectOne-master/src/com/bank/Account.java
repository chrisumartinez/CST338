package com.bank;

import java.util.ArrayList;

public class Account implements Comparable<Account>{
	private Customer accountHolder;
	private int accountNum;
	private ArrayList<Transaction> listOfTransactions;
	private String SSN;
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public ArrayList<Transaction> getListOfTransactions() {
		return listOfTransactions;
	}
	public void setListOfTransactions(ArrayList<Transaction> listOfTransactions) {
		this.listOfTransactions = listOfTransactions;
	}
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String toString(){
		String str = "Name:  " + accountHolder.getName() + " \n";
		str += "Account Info: " + "Account Number: " + accountNum + "\n";
		if(accountType == 2){
			str += "Savings Account \n";
		}
		else{
			str += "Checking Account \n";
		}
		str += "Balance: $" + balance;
		return str;
	}
	private int accountType;
	private double balance;
	@Override
	public int compareTo(Account o) {
		if(accountNum < o.getAccountNum()){
			return -1;
		}
		else if(accountNum > o.getAccountNum()){
			return 1;
		}
		else{
			return 0;
		}
		
	}
}
