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
        private SqlInitialQueries(){}

        public static final String CREATE_COMPANY_TABLE =
                "CREATE TABLE IF NOT EXISTS company " +
                        "(" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(128) NOT NULL UNIQUE" +
                        ")";

        public static final String CREATE_CAR_TABLE =
                "CREATE TABLE IF NOT EXISTS car " +
                        "(" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(128) NOT NULL UNIQUE" +
                        "company_id INT NOT NULL" +
                        "FOREIGN KEY (company_id) REFERENCES Company(id)" +
                        ")";
    }

    public static final class SqlCompanyQueries{
        private SqlCompanyQueries(){}

        public static final String CREATE_COMPANY =
                "INSERT INTO company (name) " +
                        "VALUES (?)";

        public static final String GET_ALL_COMPANIES =
                "SELECT name FROM company " +
                        "ORDER BY id ASC ";

        public static final String GET_COMPANY_BY_ID =
                "SELECT name FROM company " +
                        "WHERE id = ? ";

    }

    public static final class SqlCarQueries{
        private SqlCarQueries(){}

        public static final String CREATE_CAR =
                "INSERT INTO car (name, company_id) " +
                "VALUES (?, ?)";

        public static final String GET_ALL_CARS =
                "SELECT name FROM car " +
                        "ORDER BY id ASC ";

        public static final String GET_ALL_CARS_BY_COMPANY =
                "SELECT name FROM car " +
                        "WHERE company_id = ? " +
                        "ORDER BY id ASC ";
    }
}
