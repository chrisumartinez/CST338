package bank;
import java.util.*;

public class Bank {
	private String name;
	private ArrayList<Account> listOfAccounts;
	
	public Bank(String name){
		this.name = name;
		listOfAccounts = new ArrayList<Account>();
	}
	public Bank(){
		listOfAccounts = new ArrayList<Account>();
	}
	/**
	 * opens an account in the bank. returns false if there is already an existing accountNumber
	 * or returns true if there is unexisting one.
	 * @param name
	 * @param address
	 * @param ssn
	 * @param accountNum
	 * @param accountType
	 * @param balance
	 * @return
	 */
	public boolean openAccount(String name, String address, int ssn, int accountNum, int accountType, double balance){
		boolean flag = false;
		Customer newCust = new Customer();
		newCust.setName(name);
		newCust.setAddress(address);
		newCust.setSsn(ssn);
		Account account = new Account();
		account.setAccountHolder(newCust);
		account.setAccountNum(accountNum);
		account.setAccountType(accountType);
		account.setBalance(balance);
		for(int i = 0; i < listOfAccounts.size(); i++){
			if(listOfAccounts.get(i) == account){
				return flag;
			}
			else{
				if(listOfAccounts.get(i).getAccountHolder().getSsn() == account.getAccountHolder().getSsn()){
					return flag;
				}
			}
		}
		listOfAccounts.add(account);
		flag = true;
		return flag;
	}
	/**Closes the account. Returns false if there is no accountNumber that matches the argument.
	 * @param accountNum
	 * @return
	 */
	public boolean closeAccount(int accountNum){
		boolean flag = false;
		for(int i = 0; i < listOfAccounts.size(); i++){
			if(listOfAccounts.get(i).getAccountNum() == accountNum){
				listOfAccounts.remove(i);
				flag = true;
				return flag;
			}
		}
		return flag;
	}
	/**updates the address. returns false if there is no matching accountNumber.
	 * @param accountNum
	 * @param address
	 * @return
	 */
	public boolean updateAddress(int accountNum, String address){
		boolean flag = false;
		for(int i = 0; i < listOfAccounts.size(); i++){
			if(listOfAccounts.get(i).getAccountNum() == accountNum){
				listOfAccounts.get(i).getAccountHolder().setAddress(address);
				flag = true;
				return flag;
			}
		}
		return flag;
	}
	/**Updates the balance. Returns false if no matching accountNumber.
	 * @param accountNum
	 * @param balance
	 * @return
	 */
	public boolean updateBalance(int accountNum, double balance){
		boolean flag = false;
		for(int i = 0; i < listOfAccounts.size(); i++){
			if(listOfAccounts.get(i).getAccountNum() == accountNum){
				listOfAccounts.get(i).setBalance(balance);
				flag = true;
				return flag;
			}
		}
		return flag;
	}
	/**prints out accountInfo. Returns false if accountNumber isnt found.
	 * @param accountNum
	 * @return
	 */
	public boolean accountInfo(int accountNum){
		boolean flag = false;
		for(int i = 0; i < listOfAccounts.size(); i++){
			if(listOfAccounts.get(i).getAccountNum() == accountNum){
				System.out.println(listOfAccounts.get(i));
				flag = true;
				return flag;
			}
		}
		return flag;
	}
	/**
	 * shows the accounts in the bank, along with the bank's balance.
	 */
	public void bankInfo(){
		double balance = 0;
		for(int i = 0; i < listOfAccounts.size(); i++){
			System.out.println(listOfAccounts.get(i));
			balance += listOfAccounts.get(i).getBalance();
		}
		System.out.println("Bank's Balance: " + balance);
	}
}
