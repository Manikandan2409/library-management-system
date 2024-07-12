package demon.library.db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static Connection connection = null;

    private DBConfig() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            synchronized (DBConfig.class) {
                if (connection == null) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/library", "root", "");
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                        throw new SQLException("Unable to establish a database connection.", e);
                    }
                }
            }
        }
        return connection;
    }
}
