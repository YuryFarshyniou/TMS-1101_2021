package tasks.lesson_15.by.yurachel.dop_zadanie_4.service;

import tasks.lesson_15.by.yurachel.dop_zadanie_4.entity.Car;

import java.io.*;

public class Service {

    public static final String FILE_PATH = "resources\\dop_zadanie_4\\Car.txt";

    public void writeToFile(Car car) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            oos.writeObject(car);
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public Car readFromFile() {
        Car car = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            car = (Car) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("File not found");
        }
        return car;
    }
}
