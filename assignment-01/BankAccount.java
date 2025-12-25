import java.util.Scanner;


/* -------- Bank Account Class -------- */
class BankAccount {

    private String accountHolderName;
    private int accountNumber;
    private double balance;

    BankAccount(String name, int accNo, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = accNo;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        balance += amount;
        System.out.println("✅ Deposit successful");
    }

    void withdraw(double amount)  {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (amount > balance) {
            System.out.println(" Insufficient balance");
        }
        balance -= amount;
        System.out.println("✅ Withdrawal successful");
    }

    double getBalance() {
        return balance;
    }

    void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : ₹" + balance);
    }
}

/* -------- Main Class -------- */
public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" Welcome to Bank Management System");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        account.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        System.out.println("💰 Current Balance: ₹" + account.getBalance());
                        break;

                    case 4:
                        account.displayAccountDetails();
                        break;

                    case 5:
                        System.out.println("👋 Thank you for banking with us");
                        break;

                    default:
                        System.out.println("❌ Invalid choice");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}





