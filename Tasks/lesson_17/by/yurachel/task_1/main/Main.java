package tasks.lesson_17.by.yurachel.task_1.main;

import tasks.lesson_17.by.yurachel.task_1.entity.Librarian;
import tasks.lesson_17.by.yurachel.task_1.entity.books.Book;
import tasks.lesson_17.by.yurachel.task_1.entity.books.Library;
import tasks.lesson_17.by.yurachel.task_1.service.DOMParser;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        Library library = new Library();
        DOMParser parser = new DOMParser();
        List<Book> libraryList = parser.writeBooksFromXML();

        Librarian librarian = new Librarian("First librarian", libraryList);
        Librarian librarian2 = new Librarian("Second librarian", libraryList);
        librarian.start();
        Thread.sleep(100);
        librarian2.start();
    }
}
