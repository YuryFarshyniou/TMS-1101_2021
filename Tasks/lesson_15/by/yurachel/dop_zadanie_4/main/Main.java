package tasks.lesson_15.by.yurachel.dop_zadanie_4.main;

import tasks.lesson_15.by.yurachel.dop_zadanie_4.entity.Car;
import tasks.lesson_15.by.yurachel.dop_zadanie_4.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Car bmw = new Car("X-6", 15000, 240);
        service.writeToFile(bmw);
        Car merce = service.readFromFile();
        System.out.println(merce);

    }
}
