package tasks.lesson_15.by.yurachel.methodichka_34.main;


import tasks.lesson_15.by.yurachel.methodichka_34.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.showNumbers(service.findNumbersInFile());

        System.out.println("\n\nSum: " + service.sumOfNumbers(service.findNumbersInFile()));

        service.showNumbers(service.noEqualsNumbers(service.findNumbersInFile()));
    }
}
