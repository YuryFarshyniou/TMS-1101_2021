package tasks.lesson_15.by.yurachel.methodichka_33.main;

import tasks.lesson_15.by.yurachel.methodichka_33.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        System.out.println(service.countWords());
        System.out.println(service.countPunctuationMarks());
    }
}
