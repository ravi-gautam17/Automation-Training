/**
 * created  a class named  Bank Application that
 * Demonstrates multiple interface implementation in Java
 * with proper exception handling for banking operations.
 * All classes, interfaces, and exceptions are defined
 * in a single file.
 */

/* ================= INTERFACES ================= */

/**
 * Interface for banking-related operations.
 */
interface BankingOperations {

    void deposit(double amount)  throws InvalidAmountException;
    void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException;

    double getBalance();

}

/**
 * Interface for customer-related operations.
 */
interface CustomerOperations {

    void showCustomerDetails();
}

/* ================= CUSTOM EXCEPTIONS ================= */

/**
 * Exception thrown when amount is invalid.
 */
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when balance is insufficient.
 */
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

/* ================= IMPLEMENTATION CLASS =============================== */

/**
 * BankAccount class implementing multiple interfaces.
 */
class BankAccount implements BankingOperations, CustomerOperations {

    private String customerName;
    private int accountNumber;
    private double balance;

    public BankAccount(String customerName, int accountNumber, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }

        balance += amount;
        System.out.println("Deposited Amount: " + amount);
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        balance -= amount;
        System.out.println("Withdrawn Amount: " + amount);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void showCustomerDetails() {
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

/* ================= MAIN CLASS ================= */

/**
 * Main class to test banking application.
 */
public class BankApplication {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(
                "Sarthak",
                1001,
                5000
        );

        try {
            account.showCustomerDetails();

            account.deposit(2000);
            System.out.println("Balance After Deposit: " + account.getBalance());

            account.withdraw(3000);
            System.out.println("Balance After Withdrawal: " + account.getBalance());

            
            // account.withdraw(10000);

        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}