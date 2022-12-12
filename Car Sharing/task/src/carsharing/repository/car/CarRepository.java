package carsharing.repository.car;

import carsharing.models.Car;
import carsharing.models.Company;
import carsharing.repository.H2DbConnection;
import carsharing.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository{

    private final H2DbConnection h2DbConnection;

    public CarRepository() {
        this.h2DbConnection = H2DbConnection.getInstance();
    }

    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        h2DbConnection.h2Connect();
        try(PreparedStatement statement = h2DbConnection.getConnection().prepareStatement(Constants.SqlCarQueries.GET_ALL_CARS)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                carList.add(new Car(resultSet.getString("name")));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        h2DbConnection.h2Disconnect();
        return carList;
    }

    public void createCar(Car car){
        h2DbConnection.h2Connect();
        try(PreparedStatement statement = h2DbConnection.getConnection().prepareStatement(Constants.SqlCarQueries.CREATE_CAR)){
            statement.setString(1, car.getName());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        h2DbConnection.h2Disconnect();
    }
}
