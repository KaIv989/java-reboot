package ru.edu.module06.repository;


import ru.edu.module06.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CarDbRepositoryImpl implements CarRepository {
    private final Connection connection;
    private static final String CREATE_CAR_SQL = "INSERT INTO car (id, model) VALUES (?,?)";
    private static final String UPDATE_CAR_SQL = "UPDATE car SET model = ? WHERE id = ?";
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE id = ?";
    private static final String SELECT_All_CAR = "SELECT * FROM car";
    private static final String SELECT_CAR_MODEL_ID = "SELECT * FROM car WHERE model = ?";

    private final PreparedStatement createPreStmt;
    private final PreparedStatement updatePreStmt;
    private final PreparedStatement findByIdPreStmt;
    private final PreparedStatement findAllPreStmt;
    private final PreparedStatement findByModelPreStmt;

    public CarDbRepositoryImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.createPreStmt = connection.prepareStatement(CREATE_CAR_SQL);
        this.updatePreStmt = connection.prepareStatement(UPDATE_CAR_SQL);
        this.findByIdPreStmt = connection.prepareStatement(SELECT_CAR_BY_ID);
        this.findAllPreStmt = connection.prepareStatement(SELECT_All_CAR);
        this.findByModelPreStmt = connection.prepareStatement(SELECT_CAR_MODEL_ID);
    }

    @Override
    public Car createOrUpdate(Car car) throws SQLException {
        Optional<Car> optCar = findById(car.getId());
        if (optCar.isEmpty()) {
            createPreStmt.setString(1, car.getId());
            createPreStmt.setString(2, car.getModel());
            createPreStmt.executeUpdate();
        } else {
            updatePreStmt.setString(1, car.getModel());
            updatePreStmt.setString(2, car.getId());
            updatePreStmt.executeUpdate();
        }
        return car;
    }

    @Override
    public Set<Car> createAll(Collection<Car> cars) {
        cars.stream().forEach(car -> {
            try {
                createOrUpdate(car);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return new HashSet<>(cars);
    }

    @Override
    public Set<Car> findAll() throws SQLException {
        ResultSet resultSet = findAllPreStmt.executeQuery();
        HashSet <Car> setCar = new HashSet<>();
        while (resultSet.next()) {
            setCar.add(new Car(resultSet.getString(1), resultSet.getString(2)));
        }
        return setCar;
    }

    @Override
    public Optional<Car> findById(String id) throws SQLException {
        // validation
        int rowsCount = countRowsById(id);
        if (rowsCount > 1) {
            throw new RuntimeException("Car with id = " + id + " was found many times (" + rowsCount + ").");
        } else if (rowsCount == 0) {
            return Optional.empty();
        }

        findByIdPreStmt.setString(1, id);
        ResultSet resultSet = findByIdPreStmt.executeQuery();

        resultSet.next();
        Car car = new Car(resultSet.getString(1), resultSet.getString(2));
        return Optional.of(car);
    }

    @Override
    public Boolean deleteById(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM car WHERE id = ?");
        preparedStatement.setString(1, id);
        int res = preparedStatement.executeUpdate();
        return res > 0;
    }

    @Override
    public Boolean deleteAll() throws SQLException {
        HashSet <Car> setCar = (HashSet<Car>) findAll();
        setCar.stream().forEach(car -> {
            try {
                deleteById(car.getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return true;
    }

    private int countRowsById(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM car where id = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount = resultSet.getInt(1);
        }
        return rowCount;
    }

    private int countRowsByModel(String Model) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM car where model = ?");
        preparedStatement.setString(1, Model);
        ResultSet resultSet = preparedStatement.executeQuery();
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount = resultSet.getInt(1);
        }
        return rowCount;
    }

    @Override
    public Set<Car> findByModel(String model) throws SQLException {
        // validation
        int rowsCount = countRowsByModel(model);
        if (rowsCount > 1) {
            throw new RuntimeException("Car with model = " + model + " was found many times (" + rowsCount + ").");
        } else if (rowsCount == 0) {
            return new HashSet<>();
        }

        findByModelPreStmt.setString(1, model);
        ResultSet resultSet = findByModelPreStmt.executeQuery();

        resultSet.next();
        Car car = new Car(resultSet.getString(1), resultSet.getString(2));
        HashSet <Car> setCar = new HashSet<>(1);
        setCar.add(car);

        return setCar;
    }
}
