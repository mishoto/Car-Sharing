package carsharing.models;

import carsharing.repository.Dao;
import carsharing.repository.company.CompanyJDBCDao;

import static java.lang.System.*;

public class MenuCompanyCreate extends Menu{
    private final Dao<Company> companyDao;

    public MenuCompanyCreate(Display display) {
        super(display);
        companyDao = new CompanyJDBCDao();
    }

    @Override
    void onNext(int option) {
        onBack();
    }

    @Override
    void onBack() {
        display.setDisplay(new MenuLogIn(display));
    }

    @Override
    void print() {
        out.println("Enter the company name:");
        Company newCompany = new Company(scanner.nextLine().trim());
        companyDao.save(newCompany);
        out.println();
        onNext(0);
    }
}
