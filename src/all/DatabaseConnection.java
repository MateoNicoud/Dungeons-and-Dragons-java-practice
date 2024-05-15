package all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/dd";
    private static final String DATABASE_USER = "dd";
    private static final String DATABASE_PASSWORD = "dd";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
            return null;
        }
    }
}