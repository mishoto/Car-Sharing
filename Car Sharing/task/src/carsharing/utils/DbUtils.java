package carsharing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbUtils {

    private DbUtils() {
    }

    public static void connectToDB(String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement statement = conn.createStatement()) {
            conn.setAutoCommit(true);
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS COMPANY (" +
                            "ID INT auto_increment primary key," +
                            "NAME VARCHAR(128) NOT NULL" +
                            ")");


            if (conn != null) {
                System.out.println("Connection to database successful");
            }
//            conn.commit();
        } catch (SQLException sqlException) {
            System.err.println("An Error occurred while connecting to database!");
            sqlException.printStackTrace();
        }
    }
}
