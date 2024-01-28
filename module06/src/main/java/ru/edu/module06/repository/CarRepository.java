package ru.edu.module06.repository;

import ru.edu.module06.model.Car;

import java.sql.SQLException;
import java.util.Set;

public interface CarRepository extends Repository<Car, String> {
    Set<Car> findByModel(String model) throws SQLException;
}
