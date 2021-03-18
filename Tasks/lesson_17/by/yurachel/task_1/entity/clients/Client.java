package tasks.lesson_17.by.yurachel.task_1.entity.clients;

import tasks.lesson_17.by.yurachel.task_1.entity.books.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;


public class Client implements Runnable {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Client(List<Book> books) {
        this.books = books;
        new Thread(this).start();
    }

    public void run() {
        Random random = new Random();
        Book book = books.get(random.nextInt(books.size()));


        synchronized (book) {
            if (!book.isForTakingHome()) {
                System.out.println("The client " + Thread.currentThread().getName() + " is reading " + book.getBookName() + " right here in the library.");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("The book has already taken.");
                }
                System.out.println("The client " + Thread.currentThread().getName() + " is returning " + book.getBookName() + " to the library.");
            } else {
                System.out.println("The client " + Thread.currentThread().getName() + " taking the book " + book.getBookName() + " to home for reading.");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The client " + Thread.currentThread().getName() + " is returning book to the library.");
            }
        }
    }
}
