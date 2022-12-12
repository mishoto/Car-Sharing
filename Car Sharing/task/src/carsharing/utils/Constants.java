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
                "CREATE TABLE IF NOT EXISTS company (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(128) NOT NULL UNIQUE" +
                ")";
    }

    public static final class SqlCompanyQueries{
        private SqlCompanyQueries(){}

        public static final String CREATE_COMPANY =
                "INSERT INTO company (name) " +
                        "VALUES (?)";

        public static final String GET_ALL_COMPANIES_PAGINATED =
                "SELECT name FROM company " +
                        "ORDER BY id ASC ";

    }
}
