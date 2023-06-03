package model.repository;

import model.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO implements CarDAORead, CarDAOWrite {
    static List<Car> carList = new ArrayList<>();

    @Override
    public void save(Car car) {
        carList.add(car);
    }

    @Override
    public Car findById(long id) {

        for (Car foundCar : carList) {
            if (foundCar.getId() == id) {
                return foundCar;
            }
        }
        return null;
    }

    @Override
    public List<Car> findByAll(){
        return carList;
    }

    @Override
    public void delete(long id) {
        carList.remove(findById(id));
    }

    @Override
    public void update(Car car) {
        Car carUpdate = findById(car.getId());
        carUpdate.setModel(car.getModel());
    }

}
