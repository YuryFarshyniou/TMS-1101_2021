package tasks.lesson_17.by.yurachel.task_1.entity.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library implements Cloneable {
    private List<Book> library = new ArrayList<>();

    public List<Book> getLibrary() {
        return library;
    }

    public void setLibrary(List<Book> library) {
        this.library = library;
    }

    // Добавляем новые книги в список книг.

    public void addBookToLibrary(Book... book) {
        this.library.addAll(Arrays.asList(book));
    }
}
