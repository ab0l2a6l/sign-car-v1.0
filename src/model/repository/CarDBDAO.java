package model.repository;

import model.entity.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CarDBDAO implements CarDAOWrite , CarDAORead{
    String url = "jdbc:mysql://localhost:3306/firstdb";
    String username = "root";
    String password = "Am311865186";

    @Override
    public void save(Car car) {
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            System.out.println(connection + " connected");

            Statement statement =connection.createStatement();

            String query = "insert into Car values ("+ car.getId() + ","+ car.getModel()+")";
            statement.executeUpdate(query);

            statement.close();
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        return null;
    }

    @Override
    public List<Car> findByAll() {
        return null;
    }
}
