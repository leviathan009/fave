public class db {
    
}

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 14.02.2019
 * @author
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class aufgabe2_2019_2_jahr {

    public static void main(String[] args) {
        System.out.println("qweqweqw");
        String connectionUrl = "jdbc:mysql://10.0.2.3:3306/nwik?user=www&password=www";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT menuid, menu from cms__menu";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    } // end of main

} // end of class aufgabe_7