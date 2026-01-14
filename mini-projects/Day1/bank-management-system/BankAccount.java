import java.io.Serializable;

/**
 * Abstract base class for all bank accounts.
 */
public abstract class BankAccount implements Serializable {

    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Abstract methods (runtime polymorphism)
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // Concrete method
    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
    }
}
