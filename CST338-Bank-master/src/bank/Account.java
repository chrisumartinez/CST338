package bank;

public class Account implements Comparable<Account> {
	private int accountNum;
	private int accountType;
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String toString(){
		String str = "Name:  " + accountHolder.getName() + " \n";
		str += "Account Info: " + "Account Number: " + accountNum + "\n";
		if(accountType == 1){
			str += "Savings Account \n";
		}
		else{
			str += "Checking Account \n";
		}
		str += "Balance: $" + balance;
		return str;
	}
	private Customer accountHolder;
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
