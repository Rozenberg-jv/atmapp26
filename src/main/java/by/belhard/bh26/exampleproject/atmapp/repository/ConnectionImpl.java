package by.belhard.bh26.exampleproject.atmapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImpl {

    private static final String url = "jdbc:mysql://localhost:3306/exampleproj26?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
