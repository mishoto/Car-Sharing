package carsharing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.*;

public final class DbUtils {

    private DbUtils() {
    }

    public static void connectToH2FileDb() {
        final String filePath = Constants.H2FileDb.FILE_PATH;
        final String dbURL = Constants.H2FileDb.DB_PREFIX_URL + filePath;
        final String user = Constants.H2FileDb.DB_USER;
        final String password = Constants.H2FileDb.DB_PASSWORD;

        try (Connection conn = DriverManager.getConnection(dbURL, user, password);
             Statement statement = conn.createStatement()) {
            conn.setAutoCommit(true);
            statement.execute(Constants.SqlInitialQueries.CREATE_COMPANY_TABLE);

            out.println("Connection to database successful");

        } catch (SQLException sqlException) {
            err.println("An Error occurred while connecting to database!");
            sqlException.printStackTrace();
        }
    }
}
