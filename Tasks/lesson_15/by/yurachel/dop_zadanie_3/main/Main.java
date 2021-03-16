package tasks.lesson_15.by.yurachel.dop_zadanie_3.main;

import tasks.lesson_15.by.yurachel.dop_zadanie_3.service.Service;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        List<String> sentences = service.getSentence();
        List<String> blackList = service.blackList();
        service.censored(sentences, blackList);


    }

}
