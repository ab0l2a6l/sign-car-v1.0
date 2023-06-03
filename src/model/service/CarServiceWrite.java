package model.service;

import model.entity.Car;

public interface CarServiceWrite {
    void save(Car car);

    void delete(long id);

    void update(Car car);


}
