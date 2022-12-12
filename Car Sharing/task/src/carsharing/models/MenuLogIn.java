package carsharing.models;

import carsharing.models.menucompany.MenuCompanyCreate;
import carsharing.models.menucompany.MenuCompanyList;

import static java.lang.System.*;

public class MenuLogIn extends Menu{

    public MenuLogIn(Display display) {
        super(display);
    }

    @Override
    protected void onNext(int option) {
        switch (option) {
            case 0: {
                onBack();
                break;
            }
            case 1: {
                display.setDisplay(new MenuCompanyList(display));

                break;
            }
            case 2: {
                display.setDisplay(new MenuCompanyCreate(display));

                break;
            }
            default:
                throw new IllegalArgumentException("No such menu option");
        }
    }

    @Override
    protected void onBack() {
        display.setDisplay(new MenuStart(display));
    }

    @Override
    protected void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Company list\n" +
                "2. Create a company\n" +
                "0. Back\n" +
                ">  ");
        out.print(sb);
        int choice = scanner.nextInt();
        out.println();
        onNext(choice);
    }
}
