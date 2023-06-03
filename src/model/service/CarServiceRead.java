package model.service;

import model.entity.Car;

import java.util.List;

public interface CarServiceRead {

    Car findById(long id);

    List<Car> findByAll();
}
