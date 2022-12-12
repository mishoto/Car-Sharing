package carsharing.repository.company;

import carsharing.models.Company;
import carsharing.repository.H2DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private final H2DbConnection h2DbConnection;

    public CompanyRepository() {
        this.h2DbConnection = H2DbConnection.getInstance();
    }

    public List<Company> getAllCompanies() {
        List<Company> companyList = new ArrayList<>();
        try(Statement statement = h2DbConnection.getConnection().createStatement()){
            String sql = "SELECT * FROM COMPANY";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                companyList.add(resultSet.getObject(1, Company.class));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return companyList;
    }




}
