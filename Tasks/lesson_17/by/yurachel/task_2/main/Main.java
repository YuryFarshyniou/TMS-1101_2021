package tasks.lesson_17.by.yurachel.task_2.main;

import tasks.lesson_17.by.yurachel.task_2.entity.ExchangeOffice;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        List<ExchangeOffice> offices = new ArrayList<>();
        ExchangeOffice exchangeOffice = new ExchangeOffice("First office");
        ExchangeOffice exchangeOffice2 = new ExchangeOffice("Second office");
        ExchangeOffice exchangeOffice3 = new ExchangeOffice("Third office");
        offices.add(exchangeOffice);
        offices.add(exchangeOffice2);
        offices.add(exchangeOffice3);
        for (ExchangeOffice exchangeOffice1 : offices) {
            exchangeOffice1.start();
            Thread.sleep(100);
        }
    }
}
