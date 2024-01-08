package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to the Simplified Banking System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Summary");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid choice (numeric).");
                scanner.nextLine();
                System.out.print("Enter your choice: ");
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(bank, scanner);
                    break;
                case 2:
                    viewAccountSummary(bank, scanner);
                    break;
                case 3:
                    depositMoney(bank, scanner);
                    break;
                case 4:
                    withdrawMoney(bank, scanner);
                    break;
                case 5:
                    transferMoney(bank, scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account name: ");
        String accountName = scanner.next();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        BankAccount account = bank.createAccount(accountName, initialDeposit);
        System.out.println("Account created successfully. Account number: " + account.getAccountNumber());
    }

    private static void viewAccountSummary(Bank bank, Scanner scanner) {
        try {
            System.out.print("Enter account number: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid account number (numeric).");
                scanner.nextLine();
                System.out.print("Enter account number: ");
            }

            int accountNumber = scanner.nextInt();

            BankAccount account = bank.findAccount(accountNumber);
            System.out.println(account.getAccountSummary());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid account number.");
        } catch (AccountNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void depositMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid account number (numeric).");
            scanner.nextLine();
            System.out.print("Enter account number: ");
        }

        int accountNumber = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        try {
            BankAccount account = bank.findAccount(accountNumber);
            account.deposit(amount);
            System.out.println("Deposit successful. Updated balance: $" + account.getBalance());
        } catch (AccountNotFoundException | NegativeAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void withdrawMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid account number (numeric).");
            scanner.nextLine();
            System.out.print("Enter account number: ");
        }

        int accountNumber = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        try {
            BankAccount account = bank.findAccount(accountNumber);
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Updated balance: $" + account.getBalance());
        } catch (AccountNotFoundException | NegativeAmountException | InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void transferMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter sender's account number: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid account number (numeric).");
            scanner.nextLine();
            System.out.print("Enter sender's account number: ");
        }

        int fromAccountNumber = scanner.nextInt();

        System.out.print("Enter receiver's account number: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid account number (numeric).");
            scanner.nextLine();
            System.out.print("Enter receiver's account number: ");
        }

        int toAccountNumber = scanner.nextInt();

        System.out.print("Enter transfer amount: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount (numeric).");
            scanner.nextLine();
            System.out.print("Enter transfer amount: ");
        }

        double amount = scanner.nextDouble();

        try {
            bank.transferMoney(fromAccountNumber, toAccountNumber, amount);
            System.out.println("Transfer successful.");
        } catch (AccountNotFoundException | InsufficientFundsException | NegativeAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
