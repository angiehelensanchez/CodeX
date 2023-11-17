package CodeX.dbutilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utilidad {

    static {
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static final String URL = "jdbc:mysql://localhost:3306/dbOnlineShop";
    private static final String USER = "root";
    private static final String PASSWORD = "20iknos11";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
