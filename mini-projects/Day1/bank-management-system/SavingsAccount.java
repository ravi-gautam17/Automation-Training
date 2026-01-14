/**
 * SavingsAccount class inherits BankAccount.
 */
public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid or insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
    }
}
