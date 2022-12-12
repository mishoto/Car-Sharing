package carsharing.utils;

public final class Constants {

    private Constants() {
    }

    public static final class H2FileDb{
        private H2FileDb() {
        }
        public static final String FILE_PATH = "D:\\0_SoftServe_Academy\\Car Sharing\\Car Sharing\\task\\src\\carsharing\\db\\carsharing";
        public static final String DB_PREFIX_URL = "jdbc:h2:";
        public static final String DB_USER = "";
        public static final String DB_PASSWORD = "";
    }

    public static final class SqlInitialQueries{
        private SqlInitialQueries(){};
        public static final String CREATE_CAR_SHARING_SCHEMA =
                "CREATE SCHEMA IF NOT EXISTS car_sharing";

        public static final String CREATE_COMPANY_TABLE =
                "CREATE TABLE IF NOT EXISTS car_sharing.company (" +
                "ID INT auto_increment primary key," +
                "NAME VARCHAR(128) NOT NULL UNIQUE" +
                ")";
    }
}
