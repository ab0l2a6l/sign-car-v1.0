package model.service;

import model.entity.Car;

import java.util.List;

public interface CarServiceRead {

    Car findById(String id);

    List<Car> findByAll();
}
