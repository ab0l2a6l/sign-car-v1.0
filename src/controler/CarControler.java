package controler;

import model.entity.Car;
import model.service.CarService;
import model.service.CarServiceRead;
import model.service.CarServiceWrite;

import java.util.List;

public class CarControler {
    private final CarServiceWrite carServiceWrite = new CarService();
    private final CarServiceRead carServiceRead = new CarService();

    public void save(Car car) {
        carServiceWrite.save(car);
    }

    public void delete(long id) {
        carServiceWrite.delete(id);
    }

    public void update(Car car) {
        carServiceWrite.update(car);
    }

    public Car findById(String id) {
        return carServiceRead.findById(id);
    }

    public List<Car> findByAll() {
        return carServiceRead.findByAll();
    }
}