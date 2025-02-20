package ru.edu.module06.service;

import java.sql.SQLException;

public interface CarService {

    void addCar(String id, String model) throws SQLException;

    void editModel(String id, String model) throws SQLException;

    void deleteCar(String id) throws SQLException;

}
