import java.util.Scanner;

/**
 * Entry point of the Bank Management System.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        service.loadAccount();

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Account Number: ");
                    int acc = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    service.createAccount(acc, name, bal);
                }
                case 2 -> {
                    System.out.print("Amount: ");
                    service.deposit(sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Amount: ");
                    service.withdraw(sc.nextDouble());
                }
                case 4 -> {
                    System.out.println("Balance: ₹" + service.hasAccount());
                }
                case 5 -> service.showDetails();
                case 6 -> {
                    System.out.println("Thanks for using the system 👋");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
