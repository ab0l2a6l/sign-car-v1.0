package model.repository;

import model.entity.Car;

import java.sql.*;
import java.util.List;

public class CarDBDAO implements CarDAOWrite, CarDAORead{
    private final String url = "jdbc:mysql://localhost:3306/firstdb";
    private final String username = "root";
    private final String password = "Am311865186";
    private String query;


    private Connection connection;
    private Statement statement;

    public CarDBDAO() throws Exception {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Car car) throws Exception{
        try {
            query = "insert into Car values (" + car.getId() + "," + car.getModel() + ")";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) throws Exception {
        try {
            query = "delete from car where id = " + id;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Car car) throws Exception{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection + " connected");
            statement = connection.createStatement();

            //update firstdb.car
            // set model = 'pride'
            // where id = 222

            query = "update car set model = " + car.getModel() + " where id = "+ car.getId();
            statement.executeUpdate(query);
    }

    @Override
    public Car findById(long id) throws Exception {
        Car car = new Car();
            query = "select * from car ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    car.setId(resultSet.getInt("id"));
                    car.setModel(resultSet.getString("model"));
                }
            }

        return car;
    }

    @Override
    public List<Car> findByAll() throws Exception {

            query = "select * from car";
            ResultSet resultSet = statement.executeQuery(query);

//            while (resultSet.next()) {
//                System.out.println("id: " + resultSet.getInt("id"));
//                System.out.println("model: " + resultSet.getString("model"));
//            }



        return null;
    }

    public void close() throws Exception{

            statement.close();
            connection.close();
            System.out.println("disconnected");
    }


}
