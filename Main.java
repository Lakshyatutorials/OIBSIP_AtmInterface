import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (bankAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient funds or invalid amount.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter the amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (bankAccount.deposit(amount)) {
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Invalid deposit amount.");
                }

            } else if (choice.equals("3")) {
                System.out.println("Current Balance: $" + String.format("%.2f", bankAccount.checkBalance()));

            } else if (choice.equals("4")) {
                System.out.println("Exiting ATM. Thank you!");
                break;

            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial balance of your bank account: ");
        double initialBalance = Double.parseDouble(scanner.nextLine());

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);

        atmMachine.run();

        scanner.close();
    }
}
