package tasks.lesson_18.by.yurachel.library.entity;

import java.util.List;
import java.util.Objects;

public class Book {
    private int id;
    private String bookName;
    private List<Author> authors;
    private List<String> genre;
    private int price;
    private int numberOfPages;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    public Book() {

    }

    public Book(int id, String bookName, List<Author> authors, List<String> genre, int price, int numberOfPages) {
        this.bookName = bookName;
        this.authors = authors;
        this.genre = genre;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.id = id;
    }

    public Book(int id, String bookName, List<String> genre, int price, int numberOfPages) {
        this.id = id;
        this.bookName = bookName;
        this.genre = genre;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && price == book.price && numberOfPages == book.numberOfPages
                && Objects.equals(bookName, book.bookName) && Objects.equals(authors, book.authors) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, authors, genre, price, numberOfPages);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilderAuthor = new StringBuilder("");
        StringBuilder stringBuilderGenre = new StringBuilder("");
        for (int i = 0; i < authors.size(); i++) {
            if (authors.size() > 1 && i != authors.size() - 1) {
                stringBuilderAuthor.append(authors.get(i)).append(",");
            } else {
                stringBuilderAuthor.append(authors.get(i));
            }
        }

        for (int i = 0; i < genre.size(); i++) {
            if (genre.size() > 1 && i != genre.size() - 1) {
                stringBuilderGenre.append(genre.get(i)).append(",");
            } else {
                stringBuilderGenre.append(genre.get(i)).append(".");
            }
        }

        return "Id: " + id + " BookName: " + bookName + ", Authors: " + stringBuilderAuthor + ", Genre: "
                + stringBuilderGenre + ", Price: " + price + "$, NumberOfPages: " + numberOfPages;
    }
}
