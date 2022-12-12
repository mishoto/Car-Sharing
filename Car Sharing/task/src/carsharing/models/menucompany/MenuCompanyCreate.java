package carsharing.models.menucompany;

import carsharing.models.Company;
import carsharing.models.Display;
import carsharing.models.Menu;
import carsharing.models.MenuLogIn;
import carsharing.repository.Dao;
import carsharing.repository.company.CompanyJDBCDao;

import static java.lang.System.*;

public class MenuCompanyCreate extends Menu {
    private final Dao<Company> companyDao;

    public MenuCompanyCreate(Display display) {
        super(display);
        companyDao = new CompanyJDBCDao();
    }

    @Override
    protected void onNext(int option) {
        onBack();
    }

    @Override
    protected void onBack() {
        display.setDisplay(new MenuLogIn(display));
    }

    @Override
    protected void print() {
        out.println("Enter the company name:");
        Company newCompany = new Company(scanner.nextLine().trim());
        companyDao.save(newCompany);
        out.println("The company was created!");
        onNext(0);
    }
}
