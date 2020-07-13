package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    public static final String dbDriver= "com.mysql.jdbc.Driver";
    public static String dbURL = "jdbc:mysql://localhost:3306/";
    public static String dbName = "studio?useUnicode=true&" +
            "serverTimezone=UTC&useSSL=true&" +
            "verifyServerCertificate=false&" +
            "characterEncoding=UTF-8";
    public static final String dbUsername = "MainUser";
    public static final String dbPassword = "admin";
 
    public static Connection initializeDatabase() {
        Connection connection = null;

        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);
            System.out.println("Connection ON.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR.");
        }
        return connection;
    }
} 