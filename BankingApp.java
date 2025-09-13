// File: BankingApp.java
import java.util.Scanner;

// Main class for our application
public class BankingApp {

    public static void main(String[] args) {
        // Create a single account object for the user
        Account myAccount = new Account("12345", "Ravi Pravin", 50.00);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome, " + myAccount.getAccountHolderName() + "!");

        while (choice != 4) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: $" + myAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

// A simple class to represent a bank account
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accNumber, String holderName, double initialBalance) {
        this.accountNumber = accNumber;
        this.accountHolderName = holderName;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }
}