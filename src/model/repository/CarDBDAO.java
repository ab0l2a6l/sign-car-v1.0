package model.repository;

import model.entity.Car;

import java.sql.*;
import java.util.List;

public class CarDBDAO implements CarDAOWrite, CarDAORead {
    final String url = "jdbc:mysql://localhost:3306/firstdb";
    final String username = "root";
    final String password = "Am311865186";
    private String query;


    private Connection connection;
    private Statement statement;


    @Override
    public void save(Car car) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");
            statement = connection.createStatement();

            query = "insert into Car values (" + car.getId() + "," + car.getModel() + ")";
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
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");
            statement = connection.createStatement();

            query = "delete from car where id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Car car) {
        try {


            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");
            statement = connection.createStatement();

            //update firstdb.car
            // set model = 'pride'
            // where id = 222

            query = "update car set model =" + car.getModel() + " where id = "+ car.getId();
            statement.executeUpdate(query);


            statement.close();
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Car findById(long id) {
        Car car = new Car();
        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");

            statement = connection.createStatement();

            query = "select * from car ";
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

        try {


            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");
            statement = connection.createStatement();

            query = "select * from car";
            ResultSet resultSet = statement.executeQuery(query);

//            while (resultSet.next()) {
//                System.out.println("id: " + resultSet.getInt("id"));
//                System.out.println("model: " + resultSet.getString("model"));
//            }


            statement.close();
            connection.close();
            System.out.println("disconnected");

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
