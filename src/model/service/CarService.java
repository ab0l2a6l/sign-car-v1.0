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

        carDAOWrite = new CarDBDAO();
        carDAOWrite.save(car);
        carDAOWrite.close();
    }

    @Override
    public void delete(long id) {
        carDAOWrite = new CarDBDAO();
        carDAOWrite.delete(id);
        carDAOWrite.close();
    }

    @Override
    public void update(Car car) {
        carDAOWrite = new CarDBDAO();
        carDAOWrite.update(car);
        carDAOWrite.close();
    }

    @Override
    public Car findById(long id) {
        carDAORead = new CarDBDAO();
        Car byId = carDAORead.findById(id);
        carDAORead.close();
        return byId;
    }

    @Override
    public List<Car> findByAll() {
        carDAORead = new CarDBDAO();
        List<Car> byAll = carDAORead.findByAll();
        carDAORead.close();
        return byAll;
    }
}
