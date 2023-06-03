package model.repository;

import model.entity.Car;

public interface CarDAOWrite {
    void save(Car car);

    void delete(long id);

    void update(Car car);
    void close();
}
