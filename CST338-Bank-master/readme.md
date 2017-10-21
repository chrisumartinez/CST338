# Unit Testing

## Testing for Certain Properties of the Program:

### testCreateAccounts()
+ Tests the Case of Adding a New Account. It should return true, due to being a brand new bank
and it just has one unique account.

### testDuplicateAccounts()
+Tests the case of adding accounts with duplicate info. The test should return false, with duplicate
accounts not being permitted in the bank.

### testUpdateBalnace()
+Test if the account is being updated with the balance. It should return false if the account is not
found.

### testClosingAccount()
+Test if the account is closed. Returns false if the account no longer exists. Returns true if it is there.