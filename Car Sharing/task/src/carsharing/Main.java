package carsharing;

import carsharing.utils.DbUtils;

public class Main {

    public static void main(String[] args) {

        DbUtils.connectToH2FileDb();

    }
}