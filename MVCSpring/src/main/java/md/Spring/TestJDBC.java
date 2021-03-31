package md.Spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Babin Sergiu
 */

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/UdemyDB";
        String user = "postgres";
        String pass = "gts-5230";


        try {
            System.out.println("Connection to database:" + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection succesfull!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
