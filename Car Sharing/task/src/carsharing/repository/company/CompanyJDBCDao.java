package carsharing.repository.company;

import carsharing.models.Company;
import carsharing.repository.Dao;

import java.util.List;
import java.util.Optional;

public class CompanyJDBCDao implements Dao<Company> {
    private final CompanyRepository companyRepository;

    public CompanyJDBCDao() {
        this.companyRepository = new CompanyRepository();
    }

    @Override
    public Optional<Company> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void update(Company company, String[] params) {

    }

    @Override
    public void delete(Company company) {

    }
}
