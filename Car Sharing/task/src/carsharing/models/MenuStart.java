package carsharing.models;

import static java.lang.System.*;

public class MenuStart extends Menu {

    public MenuStart(Display display) {
        super(display);
    }

    @Override
    void onNext(int option) {
        switch (option) {
            case 1:
                display.setDisplay(new MenuLogIn(display));
                break;
            case 0:
                onBack();
                break;
            default:
                throw new IllegalArgumentException("No such option!");
        }
    }

    @Override
    void onBack() {
        System.exit(0);
    }

    @Override
    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Log in as a manager\n" +
                "0. Exit\n" +
                ">  ");
        out.print(sb);
        int choice = scanner.nextInt();
        out.println();
        onNext(choice);
    }
}
