package model.service;

import model.entity.Car;
import model.repository.CarDAO;
import model.repository.CarDAORead;
import model.repository.CarDAOWrite;

import java.util.List;

public class CarService implements CarServiceRead, CarServiceWrite {
    CarDAORead carDAORead = new CarDAO();
    CarDAOWrite carDAOWrite = new CarDAO();

    @Override
    public void save(Car car) {
        carDAOWrite.save(car);
    }

    @Override
    public void delete(long id) {
        carDAOWrite.delete(id);
    }

    @Override
    public void update(Car car) {
        carDAOWrite.update(car);
    }

    @Override
    public Car findById(long id) {
        return carDAORead.findById(id);
    }

    @Override
    public List<Car> findByAll() {
        return carDAORead.findByAll();
    }
}
