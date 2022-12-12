package carsharing.repository.car;

import carsharing.models.Car;
import carsharing.models.Company;
import carsharing.repository.Dao;
import carsharing.repository.company.CompanyRepository;

import java.util.List;
import java.util.Optional;

public class CarJDBCDao implements Dao<Car> {
    private final CarRepository carRepository;
    private final CompanyRepository companyRepository;

    public CarJDBCDao() {
        this.carRepository = new CarRepository();
        this.companyRepository = new CompanyRepository();
    }

    @Override
    public Optional<Car> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Car> getAll() {;
        return carRepository.getAllCars();
    }

    @Override
    public void save(Car car) {

    }

    @Override
    public void update(Car car, String[] params) {

    }

    @Override
    public void delete(Car car) {

    }
}
