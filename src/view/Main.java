package view;

import common.StaticScanner;
import controler.CarControler;
import model.entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = StaticScanner.getData();
        CarControler carControler = new CarControler();

        for (; ; ) {
            menu();
            int requsetForSwitch = input.nextInt();
            input.nextLine();

            switch (requsetForSwitch) {
                case 1 -> {
                    Car car = new Car();

                    System.out.print("insert model: ");
                    car.setModel(input.nextLine());
                    System.out.print("insert id: ");
                    car.setId(input.nextLong());

                    carControler.save(car);
                }

                case 2 -> {
                    System.out.print("inset id for search: ");
                    Car car = carControler.findById(input.nextLong());
                    System.out.println(car);

                }

                case 3 -> {
                    System.out.print("insert id for delete: ");
                    carControler.delete(input.nextLong());
                }

                case 4 -> {
                    Car car = new Car();

                    System.out.println("insert id for update: ");
                    car.setId(input.nextLong());
                    input.nextLine();
                    System.out.print("insert new model: ");
                    car.setModel(input.nextLine());

                    carControler.update(car);
                }

                case 5 -> {
                    List<Car> carList = new ArrayList<>();
                    carList = carControler.findByAll();
                    carList.forEach(item ->
                            {
                                System.out.println("id: " + item.getId());
                                System.out.println("model: " + item.getModel());
                            }
                    );
                }

                case 6 -> {
                    return;
                }

            }

        }


    }

    private static void menu() {
        System.out.println("1.insert");
        System.out.println("2.search");
        System.out.println("3.delete");
        System.out.println("4.update");
        System.out.println("5.show all");
        System.out.println("6.exit");
    }
}
