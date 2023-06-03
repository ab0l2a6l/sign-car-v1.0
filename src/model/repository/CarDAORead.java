package model.repository;

import model.entity.Car;

import java.util.List;

public interface CarDAORead {
    Car findById(long id);
    List<Car>findByAll();

    void close();
}
