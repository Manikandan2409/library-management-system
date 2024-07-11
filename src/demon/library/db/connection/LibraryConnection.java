package demon.library.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public interface LibraryConnection {
   
        String URL = "jdbc:mysql://localhost:3306/library"; 
        String USERNAME = "root"; 
        String PASSWORD = ""; 
    
        static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
   
}
