package tasks.lesson_17.by.yurachel.task_1.main;

import tasks.lesson_17.by.yurachel.task_1.entity.books.Book;
import tasks.lesson_17.by.yurachel.task_1.entity.books.Library;
import tasks.lesson_17.by.yurachel.task_1.entity.clients.Client;
import tasks.lesson_17.by.yurachel.task_1.service.DOMParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        DOMParser parser = new DOMParser();
        List<Book> libraryList = parser.writeBooksFromXML();
        for (int i = 0; i < 10; i++) {
            Client client = new Client(libraryList);
        }

    }
}
