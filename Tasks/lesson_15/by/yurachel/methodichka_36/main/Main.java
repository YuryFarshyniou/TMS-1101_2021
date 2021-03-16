package tasks.lesson_15.by.yurachel.methodichka_36.main;

import tasks.lesson_15.by.yurachel.methodichka_36.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.showDirectory(service.showCatalog());
        service.showFiles(service.showCatalog());
    }
}
