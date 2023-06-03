package model.service;

import model.entity.Car;
import model.repository.CarDAO;
import model.repository.CarDAORead;
import model.repository.CarDAOWrite;
import model.repository.CarDBDAO;

import java.util.List;

public class CarService implements CarServiceRead, CarServiceWrite {
    CarDAOWrite carDAOWrite;
    CarDAORead carDAORead;
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
    public Car findById(long id) {
        Car byId;
        try {
            carDAORead = new CarDBDAO();
            byId = carDAORead.findById(id);
            carDAORead.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return byId;
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
