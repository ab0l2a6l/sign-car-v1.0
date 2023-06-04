package model.service;

import model.entity.Car;
import model.repository.CarDAORead;
import model.repository.CarDAOWrite;
import model.repository.CarDBDAO;

import java.util.List;

public class CarService implements CarServiceRead, CarServiceWrite {
    private CarDAOWrite carDAOWrite;
    private CarDAORead carDAORead;
    @Override
    public void save(Car car) {

        try {
            carDAOWrite = new CarDBDAO();
            carDAOWrite.save(car);
            carDAOWrite.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try {
            carDAOWrite = new CarDBDAO();
            carDAOWrite.delete(id);
            carDAOWrite.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Car car) {
        try {
            carDAOWrite = new CarDBDAO();
            carDAOWrite.update(car);
            carDAOWrite.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car findById(String id) {

        try {
            Car byId = new Car();
            carDAORead = new CarDBDAO();
            byId = carDAORead.findById(id);
            carDAORead.close();
            return byId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Car> findByAll() {
        List<Car> byAll;
        try {
            carDAORead = new CarDBDAO();
            byAll = carDAORead.findByAll();
            carDAORead.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return byAll;
    }
}
