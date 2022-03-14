package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String url = "jdbc:mysql://localhost:3306/shop?serverTime=CET";
    private final String user = "root";
    private final String password = "malina123";

    private Connection connection;

    public DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
