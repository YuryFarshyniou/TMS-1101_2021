package tasks.lesson_17.by.yurachel.task_1.entity.books;

import java.util.List;
import java.util.Objects;

public class Book {
    private String bookName;
    private List<Author> authors;
    private Genre genre;
    private int price;
    private int numberOfPages;
    private boolean forTakingHome;
    private boolean wasItTakenAway;


    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getBookName() {
        return bookName;
    }

    public Genre getGenre() {
        return genre;
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

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isForTakingHome() {
        return forTakingHome;
    }

    public void setForTakingHome(boolean forTakingHome) {
        this.forTakingHome = forTakingHome;
    }

    public boolean isWasItTakenAway() {
        return wasItTakenAway;
    }

    public void setWasItTakenAway(boolean wasItTakenAway) {
        this.wasItTakenAway = wasItTakenAway;
    }

    public Book() {

    }

    public Book(String bookName, List<Author> authors, Genre genre, int price, int numberOfPages, boolean forTakingHome) {
        this.bookName = bookName;
        this.authors = authors;
        this.genre = genre;
        this.price = price;
        this.numberOfPages = numberOfPages;

        this.forTakingHome = forTakingHome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && numberOfPages == book.numberOfPages &&
                Objects.equals(bookName, book.bookName) && Objects.equals(authors, book.authors) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, authors, genre, price, numberOfPages);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < authors.size(); i++) {
            if (authors.size() > 1 && i != authors.size() - 1) {
                stringBuilder.append(authors.get(i)).append(",");
            } else {
                stringBuilder.append(authors.get(i));
            }
        }
        return "BookName: " + bookName + ", Authors: " + stringBuilder + ", Genre "
                + genre + ", Price: " + price + "$, NumberOfPages: " + numberOfPages +
                ", For taking home: " + forTakingHome;
    }
}
