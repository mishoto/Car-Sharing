package carsharing.utils;

import carsharing.repository.H2DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.*;

public final class DbUtils {

    private static final H2DbConnection h2DbConnection = H2DbConnection.getInstance();

    private DbUtils() {}

    public static void dbInitialize(){
        h2DbConnection.h2Connect();
        try(Statement statement = h2DbConnection.getConnection().createStatement()){
            statement.execute(Constants.SqlInitialQueries.CREATE_CAR_SHARING_SCHEMA);
            out.println("Initialize CAR_SHARING schema");
            statement.execute(Constants.SqlInitialQueries.CREATE_COMPANY_TABLE);
            out.println("Initialize CAR_SHARING.COMPANY table");
        }catch (SQLException sqlException){
            err.println("An Error occurred while connecting to database!");
            sqlException.printStackTrace();
        }
        h2DbConnection.h2Disconnect();
    }
}
