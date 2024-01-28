package ru.edu.module06;


import org.h2.tools.Server;
import ru.edu.module06.dbconnection.H2DbEmbedded;
import ru.edu.module06.repository.CarDbRepositoryImpl;
import ru.edu.module06.repository.CarRepository;
import ru.edu.module06.service.CarService;
import ru.edu.module06.service.CarServiceImpl;

import java.sql.ResultSet;
import java.sql.Statement;

public class CarBootstrap {
    public static void main(String[] args) throws Exception {
        Server server = Server.createTcpServer(args).start();
        H2DbEmbedded.initDb();

        try(H2DbEmbedded h2DbEmbedded = new H2DbEmbedded()) {
            CarRepository carRepository = new CarDbRepositoryImpl(H2DbEmbedded.getConnection());
            CarService carService = new CarServiceImpl(carRepository);

            carService.addCar("777", "Lada");

            // Test check start
            String readAllCarsSql = "SELECT * FROM car";
            Statement statement = H2DbEmbedded.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readAllCarsSql);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String model = resultSet.getString(2);
                System.out.println("id=" + id + "; model=" + model);
            }
            // Test end
        }
        server.stop();
    }
}
