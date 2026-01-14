import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteCivil2024 {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Nishita"
            );

            Statement stmt = con.createStatement();

            String query =
                    "DELETE FROM Students " +
                    "WHERE year_of_passing = 2024 AND branch = 'Civil'";

            int rows = stmt.executeUpdate(query);

            System.out.println(" Deleted records: " + rows);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
