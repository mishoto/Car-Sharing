package carsharing.models.menucompany;

import carsharing.models.Company;
import carsharing.models.Display;
import carsharing.models.Menu;
import carsharing.models.MenuLogIn;
import carsharing.repository.Dao;
import carsharing.repository.company.CompanyJDBCDao;

import java.util.Iterator;

import static java.lang.System.*;

public class MenuCompanyList extends Menu {
    private final Dao<Company> companyDao;

    public MenuCompanyList(Display display) {
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
        if(companyDao.getAll().isEmpty()){
            out.println("The company list is empty!");
            out.println();
            onBack();
        }else{
            Iterator<Company> companyIterator = companyDao.getAll().iterator();
            int idx = 1;
            while(companyIterator.hasNext()){
                out.println(idx + ". " + companyIterator.next().getName());
                idx++;
            }
            out.println();
            onNext(0);
        }
    }
}
