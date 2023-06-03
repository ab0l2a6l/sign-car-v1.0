package model.repository;

import model.entity.Car;

public interface CarDAOWrite {
    void save(Car car) throws Exception;

    void delete(long id) throws Exception;

    void update(Car car) throws Exception;
    void close() throws Exception;
}
