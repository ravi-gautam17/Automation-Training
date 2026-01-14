import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplaySemester7EC {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "nishita"
            );

            Statement stmt = con.createStatement();

            String query =
                    "SELECT * FROM Students " +
                    "WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println(" EC Students (Semester 7):");

            while (rs.next()) {
                System.out.println(  rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getDouble("percentage"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
