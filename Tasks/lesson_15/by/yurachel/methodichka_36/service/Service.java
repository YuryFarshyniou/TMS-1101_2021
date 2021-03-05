package tasks.lesson_15.by.yurachel.methodichka_36.service;

import java.io.File;

public class Service {

    public File[] showCatalog() {
        File file = new File("F:\\Downloads");
        return file.listFiles();
    }

    public void showDirectory(File[] list) {
        for (File file : list) {
            if (file.isDirectory()) {
                System.out.println(file.toString());
            }
        }
    }

    public void showFiles(File[] list) {
        for (File file : list) {
            if (file.isFile()) {
                System.out.println(file);
            }
        }
    }
}
