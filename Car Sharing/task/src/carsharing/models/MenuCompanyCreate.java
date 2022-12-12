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
        out.println("Enter the company");
        String[] newCompanyInfo = scanner.nextLine().split(" ");
        Company newCompany = new Company(newCompanyInfo[0]);
        companyDao.save(newCompany);
        out.println();
        onNext(0);
    }
}
