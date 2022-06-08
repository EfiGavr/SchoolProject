package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtils {

    final static String url = "jdbc:mysql://localhost:3306/school";
    final static String username = "root";
    final static String password = "123456789efiEFI!";

    public static Connection getConnection() {

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
