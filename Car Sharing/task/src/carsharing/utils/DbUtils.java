package carsharing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbUtils {

    private DbUtils() {
    }

    public static void connectToH2FileDb() {
        final String FILE_PATH = "D:\\0_SoftServe_Academy\\Car Sharing\\Car Sharing\\task\\src\\carsharing\\db\\carsharing";
        final String DATABASE_URL = "jdbc:h2:" + FILE_PATH;
        try (Connection conn = DriverManager.getConnection(DATABASE_URL, "", "");
             Statement statement = conn.createStatement()) {
            conn.setAutoCommit(true);
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS COMPANY (" +
                            "ID INT auto_increment primary key," +
                            "NAME VARCHAR(128) NOT NULL UNIQUE" +
                            ")");


            if (conn != null) {
                System.out.println("Connection to database successful");
            }

        } catch (SQLException sqlException) {
            System.err.println("An Error occurred while connecting to database!");
            sqlException.printStackTrace();
        }
    }
}
