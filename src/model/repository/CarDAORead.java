package model.repository;

import model.entity.Car;

import java.util.List;

public interface CarDAORead {
    Car findById(String id) throws Exception;
    List<Car>findByAll() throws Exception;

    void close() throws Exception;
}
