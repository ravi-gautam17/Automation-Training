import java.util.Scanner;
import java.util.regex.Pattern;


/**
 *crated a class named RegexValidationApp that
 * Demonstrates the use of REGEX in Java for
 * input validation using a menu-driven program.
 */
public class RegexValidationApp {

    // REGEX patterns
    private static final String MOBILE_REGEX = "^[6-9][0-9]{9}$";
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{5,15}$";
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

    /* -------- Validation Methods -------- */

    public static boolean validateMobile(String mobile) {
        return Pattern.matches(MOBILE_REGEX, mobile);
    }

    public static boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean validateUsername(String username) {
        return Pattern.matches(USERNAME_REGEX, username);
    }

    public static boolean validatePassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    /* -------- Main Method -------- */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            while (true) {

                System.out.println("\n--- REGEX VALIDATION MENU ---");
                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        if (validateMobile(mobile)) {
                            System.out.println("Welcome! Valid Mobile Number");
                        } else {
                            System.out.println("Invalid Mobile Number");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();
                        if (validateEmail(email)) {
                            System.out.println("Welcome! Valid Email ID");
                        } else {
                            System.out.println("Invalid Email ID");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();
                        if (validateUsername(username)) {
                            System.out.println("Welcome! Valid Username");
                        } else {
                            System.out.println("Invalid Username");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();
                        if (validatePassword(password)) {
                            System.out.println("Welcome! Strong Password");
                        } else {
                            System.out.println("Invalid Password");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting Program. ");
                        sc.close();
                        return;

                    default:
                        System.out.println(" Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
            sc.close();
        }
    }
}