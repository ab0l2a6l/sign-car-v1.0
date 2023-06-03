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
    }

    @Override
    public void delete(long id) {
        carDAOWrite = new CarDBDAO();
        carDAOWrite.delete(id);
    }

    @Override
    public void update(Car car) {
        carDAOWrite = new CarDBDAO();
        carDAOWrite.update(car);
    }

    @Override
    public Car findById(long id) {
        carDAORead = new CarDBDAO();
        return carDAORead.findById(id);
    }

    @Override
    public List<Car> findByAll() {
        carDAORead = new CarDBDAO();
        return carDAORead.findByAll();
    }
}
