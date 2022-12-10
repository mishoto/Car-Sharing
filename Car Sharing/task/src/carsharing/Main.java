package carsharing;

import carsharing.utils.DbUtils;

public class Main {
    static final String FILE_PATH = "D:\\0_SoftServe_Academy\\Car Sharing\\Car Sharing\\task\\src\\carsharing\\db\\carsharing";
    static final String DATABASE_URL = "jdbc:h2:" + FILE_PATH;

    public static void main(String[] args) {

        DbUtils.connectToDB(DATABASE_URL, "", "");

    }
}