package tasks.lesson_15.by.yurachel.methodichka_35.main;

import tasks.lesson_15.by.yurachel.methodichka_35.service.Service;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        System.out.println(service.average(service.readFromFile()));

    }
}
