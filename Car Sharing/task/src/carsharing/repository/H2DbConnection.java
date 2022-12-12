package carsharing.repository;

import carsharing.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.*;

public class H2DbConnection {
    private static H2DbConnection h2DbConnectionInstance;
    private Connection connection;
    private static final String FILE_PATH = Constants.H2FileDb.FILE_PATH;
    private static final String DB_URL = Constants.H2FileDb.DB_PREFIX_URL + FILE_PATH;
    private static final String DB_USER = Constants.H2FileDb.DB_USER;
    private static final String DB_PASSWORD = Constants.H2FileDb.DB_PASSWORD;

    private H2DbConnection(){

    }

    public Connection getConnection() {
        return connection;
    }

    public void h2Connect(){
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            this.connection.setAutoCommit(true);
            out.println("Connection to database successful");
        } catch (SQLException sqlException) {
            err.println("An Error occurred while connecting to database!");
            sqlException.printStackTrace();
        }
    }

    public void h2Disconnect(){
        try {
            this.connection.close();
            out.println("Connection to database closed.");
        } catch (SQLException sqlException) {
            err.println("An Error occurred while disconnecting from database!");
            sqlException.printStackTrace();
        }
    }

    public static H2DbConnection getInstance() {
        if (h2DbConnectionInstance == null) {
            h2DbConnectionInstance = new H2DbConnection();
        }
        return h2DbConnectionInstance;
    }
}
