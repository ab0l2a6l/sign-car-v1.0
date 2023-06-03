package model.repository;

import model.entity.Car;

import java.sql.*;
import java.util.List;

public class CarDBDAO implements CarDAOWrite , CarDAORead{
    String url = "jdbc:mysql://localhost:3306/firstdb";
    String username = "root";
    String password = "Am311865186";

    Statement statement;
    Connection connection;

    @Override
    public void save(Car car) {
        try {
            connection = DriverManager.getConnection(url , username , password);
            System.out.println(connection + " connected");

            statement =connection.createStatement();

            String query = "insert into Car values ("+ car.getId() + ","+ car.getModel()+")";
            statement.executeUpdate(query);

            statement.close();
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Car car) {

    }

    @Override
    public Car findById(long id) {
        Car car = new Car();
        try {

            connection = DriverManager.getConnection(url , username , password);
            System.out.println(connection + " connected");

            statement = connection.createStatement();

            String query = "select * from car ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    long tempId = resultSet.getInt("id");
                    String model = resultSet.getString("model");
                    car.setId(tempId);
                    car.setModel(model);
                }
            }
            statement.close();
            connection.close();
            System.out.println("disconnected");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return car;
    }

    @Override
    public List<Car> findByAll() {
        return null;
    }
}
