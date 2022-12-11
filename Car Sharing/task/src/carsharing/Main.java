package carsharing;

import carsharing.models.Display;
import carsharing.utils.DbUtils;

public class Main {

    public static void main(String[] args) {

        DbUtils.connectToH2FileDb();
        Display display = new Display();
        display.show();

    }
}