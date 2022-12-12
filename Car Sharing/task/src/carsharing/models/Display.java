package carsharing.models;

public class Display {
    Menu menu;

    public Display() {
        this.menu = new MenuStart(this);
    }

    public void setDisplay(Menu menu) {
        this.menu = menu;
        menu.print();
    }

    public void show(){
        menu.print();
    }
}
