import java.io.*;
import java.util.HashMap;

public class FileUtil {
    private static final String FILE_NAME = "employees.dat";

    public static void save(HashMap<Integer, Employee> map) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(map);
        } catch (IOException e) {
            System.out.println(" File write error");
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Employee> load() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<Integer, Employee>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
