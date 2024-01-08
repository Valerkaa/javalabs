# Simplified Banking System

This project implements a simplified banking system in Java. The system includes features such as creating accounts, financial transactions, and account summaries. The goal is to ensure the program gracefully handles various types of errors without breaking.

## Classes

### 1. BankAccount.java
   - Description: Represents a bank account with attributes such as account number, account name, and balance.
   - Methods:
     - `getAccountNumber()`: Returns the account number.
     - `getAccountName()`: Returns the account owner's name.
     - `getBalance()`: Returns the current account balance.
     - `deposit(double amount)`: Deposits money into the account.
     - `withdraw(double amount)`: Withdraws money from the account.
     - `getAccountSummary()`: Returns a summary of the account, including the number, name, and balance.

### 2. NegativeAmountException.java
   - Description: Custom exception thrown when a negative amount is provided during deposit or withdrawal.

### 3. InsufficientFundsException.java
   - Description: Custom exception thrown when there are insufficient funds for a specified withdrawal.

### 4. AccountNotFoundException.java
   - Description: Custom exception thrown when an account is not found during a search.

### 5. Bank.java
   - Description: Manages a collection of BankAccount objects and provides methods for creating accounts, finding accounts, and transferring money.
   - Methods:
     - `createAccount(String accountName, double initialDeposit)`: Creates a new account with a specified name and initial deposit.
     - `findAccount(int accountNumber)`: Finds an account by its number.
     - `transferMoney(int fromAccountNumber, int toAccountNumber, double amount)`: Transfers money between accounts.

### 6. Main.java
   - Description: Main class of the program, containing a menu for interacting with the banking system. Calls methods of the Bank class to perform operations.

### 7. BankTest.java
   - Description: Test suite for checking the functionality of the BankAccount class.
