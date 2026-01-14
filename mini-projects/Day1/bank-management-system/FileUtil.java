import java.io.*;

/**
 * Utility class for file operations.
 */
public class FileUtil {

    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccount(BankAccount account) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(account);

        } catch (IOException e) {
            System.out.println("Error saving account data.");
        }
    }

    public static BankAccount loadAccount() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (BankAccount) ois.readObject();

        } catch (Exception e) {
            return null;
        }
    }
}
