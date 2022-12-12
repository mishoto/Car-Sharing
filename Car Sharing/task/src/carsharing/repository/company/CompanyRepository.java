package carsharing.repository.company;

import carsharing.models.Company;
import carsharing.repository.H2DbConnection;
import carsharing.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private final H2DbConnection h2DbConnection;

    public CompanyRepository() {
        this.h2DbConnection = H2DbConnection.getInstance();
    }

    public List<Company> getAllCompanies() {
        List<Company> companyList = new ArrayList<>();
        h2DbConnection.h2Connect();
        try(PreparedStatement statement = h2DbConnection.getConnection().prepareStatement(Constants.SqlCompanyQueries.GET_ALL_COMPANIES)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                companyList.add(new Company(resultSet.getString("name")));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        h2DbConnection.h2Disconnect();
        return companyList;
    }

    public void createCompany(String name){
        h2DbConnection.h2Connect();
        try(PreparedStatement statement = h2DbConnection.getConnection().prepareStatement(Constants.SqlCompanyQueries.CREATE_COMPANY)){
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        h2DbConnection.h2Disconnect();
    }

    public Company getCompany(int id){
        Company company = null;
        h2DbConnection.h2Connect();
        try(PreparedStatement statement = h2DbConnection.getConnection().prepareStatement(Constants.SqlCompanyQueries.GET_COMPANY_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                company = new Company(resultSet.getString("name"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        h2DbConnection.h2Disconnect();
        return company;
    }
}
