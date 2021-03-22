package tasks.lesson_18.by.yurachel.library.entity;

import java.util.*;

public class Library {
    private List<Book> library = new ArrayList<>();
    private Set<Author> authors = new HashSet<>();
    private Set<Genre> genres = EnumSet.allOf(Genre.class);

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public List<Book> getLibrary() {
        return library;
    }

    public void setLibrary(List<Book> library) {
        this.library = library;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }


    // Добавляем новую книгу в список книг.

    public void addBookToLibrary(Book book) {
        this.library.add(book);
    }

    // Для добавления авторов в классе DOMParser.

    public void addAuthors(Author author) {
        authors.add(author);
    }
}
