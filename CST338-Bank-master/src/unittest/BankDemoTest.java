package unittest;

import static org.junit.Assert.*;

import bank.*;

import org.junit.Test;

public class BankDemoTest {

	@Test
	public void testCreateAccounts() {
		Bank bank = new Bank();
		assertEquals(true,  bank.openAccount("Chris", "123 Love Drive", 1234, 1000, 1, 1000));
	}
	
	@Test
	public void testDuplicateAccounts() {
		Bank bank = new Bank();
		bank.openAccount("Chris", "123 Love Drive", 1234, 1000, 1, 1000);
		assertEquals(false, bank.openAccount("Chris", "123 Love Drive", 1234, 1000, 1, 1000));
	}
	
	
	@Test
	public void testUpdateBalnce() {
		Bank bank = new Bank();
		bank.openAccount("Chris", "123 Love Drive", 1234, 1000, 1, 1000);
		assertTrue(bank.updateBalance(1000, 200));
	}
	
	@Test
	public void testClosingAccount() {
		Bank bank = new Bank();
		bank.openAccount("Chris", "123 Love Drive", 1234, 1000, 1, 1000);
		bank.closeAccount(1000);
		assertFalse(bank.closeAccount(1000));
	}

}
