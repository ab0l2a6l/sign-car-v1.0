package model.repository;

import model.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDBDAO implements CarDAOWrite, CarDAORead {
    private final String url = "jdbc:mysql://localhost:3306/firstdb";
    private final String username = "root";
    private final String password = "Am311865186";
    private String query;

    private Connection connection;
    private Statement statement;

    public CarDBDAO() throws Exception {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection + " connected");
        statement = connection.createStatement();
    }

    @Override
    public void save(Car car) throws Exception {
        query = "insert into car values (" + car.getId() + ",\"" + car.getModel() + "\")";
        statement.executeUpdate(query);
    }

    @Override
    public void delete(long id) throws Exception {
        query = "delete from car where id = " + id;
        statement.executeUpdate(query);
    }

    @Override
    public void update(Car car) throws Exception {
        query = "update car set model = \"" + car.getModel() + "\" where id = " + car.getId();
        statement.executeUpdate(query);
    }

    @Override
    public Car findById(String id) throws Exception {
        Car car = new Car();
        query = "select * from car ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            if (id.equals(String.valueOf(resultSet.getInt("id")))) {
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
            }
        }
        return car;
    }

    @Override
    public List<Car> findByAll() throws Exception {
        List<Car> carList = new ArrayList<>();
        query = "select * from car";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getInt("id"));
            car.setModel(resultSet.getString("model"));
            carList.add(car);
        }
        return carList;
    }

    public void close() throws Exception {
        statement.close();
        connection.close();
        System.out.println("disconnected");
    }
}
