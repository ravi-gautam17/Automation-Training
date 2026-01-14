/**
 * Service class handling bank operations.
 */
public class BankService {

    private BankAccount account;

    public void createAccount(int accNo, String name, double balance) {
        account = new SavingsAccount(accNo, name, balance);
        FileUtil.saveAccount(account);
        System.out.println("Account created successfully.");
    }

    public void loadAccount() {
        account = FileUtil.loadAccount();
        if (account == null) {
            System.out.println("No existing account found.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        FileUtil.saveAccount(account);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
        FileUtil.saveAccount(account);
    }

    public void showDetails() {
        account.displayAccountDetails();
    }

    public boolean hasAccount() {
        return account != null;
    }
}
