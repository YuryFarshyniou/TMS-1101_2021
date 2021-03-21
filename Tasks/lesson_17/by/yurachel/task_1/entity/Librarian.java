package tasks.lesson_17.by.yurachel.task_1.entity;

import tasks.lesson_17.by.yurachel.task_1.entity.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Librarian extends Thread {
    private List<Book> library;
    private List<Client> clients;
    private Random random = new Random();
    private ReentrantLock lock = new ReentrantLock();

    public List<Book> getLibrary() {
        return library;
    }

    public void setLibrary(List<Book> library) {
        this.library = library;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Librarian(String name, List<Book> library) {
        super(name);
        this.library = library;
        clients = new ArrayList<>();
        for (int i = 0; i < random.nextInt(8) + 2; i++) {
            clients.add(new Client("Client " + (i + 1)));
        }
        System.out.println(clients.size());
    }

    @Override
    public void run() {
        for (Client client : clients) {
            List<Book> books = new ArrayList<>();

                synchronized (books) {
                    for (int i = 0; i < random.nextInt((library.size() - 1)) + 1; i++) {
                        Book book = library.get(random.nextInt(library.size()));
                        if (book.isWasItTakenAway()) {
                            System.out.printf("The %s of %s, we're sorry,but the book %s was taken.%s", client.getName(), Thread.currentThread().getName(),
                                    book.getBookName(), "\n");
                        } else {

                            book.setWasItTakenAway(true);
                            books.add(book);
                        }
                    }
                    client.takeBookForReading(books);
                }
        }
    }
}
