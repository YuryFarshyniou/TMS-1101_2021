package tasks.lesson_18.by.yurachel.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String fullName;
    private List<Book> bookList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Author() {
    }

    public Author(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Author's name: " + fullName;
    }
}
