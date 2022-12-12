package carsharing.models;

import java.util.Scanner;

public abstract class Menu {
    protected Display display;
    protected Scanner scanner = new Scanner(System.in);

    protected Menu(Display display) {
        this.display = display;
    }

    protected abstract void onNext(int option);
    protected abstract void onBack();
    protected abstract void print();
}
