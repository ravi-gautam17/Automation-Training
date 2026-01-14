import java.util.Scanner;

public class LoginService {
    private final String USER = "admin";
    private final String PASS = "admin123";

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        return USER.equals(u) && PASS.equals(p);
    }
}
