package tasks.lesson_18.by.yurachel.library.service;

import tasks.lesson_18.by.yurachel.library.entity.Author;
import tasks.lesson_18.by.yurachel.library.entity.Book;
import tasks.lesson_18.by.yurachel.library.entity.Genre;
import tasks.lesson_18.by.yurachel.library.entity.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Utils {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Выводим список книг.

    public void showBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("");
    }

    // Выводим список жанров.

    public void showGenre(Set<Genre> genres) {
        for (Genre genre : genres) {
            System.out.println(genre);
        }
    }

    // Сортируем книги по цене.

    public List<Book> sortByPrice(List<Book> library, boolean isAscending) {
        List<Book> sortedByPrice = new ArrayList<>(library);
        if (isAscending) {
            sortedByPrice.sort((book1, book2) -> book1.getPrice() - book2.getPrice());
        } else {
            sortedByPrice.sort((book1, book2) -> book2.getPrice() - book1.getPrice());
        }
        return sortedByPrice;
    }

    // Сортируем книги по названию.

    public List<Book> sortByBookName(List<Book> books, boolean isAscending) {
        List<Book> sortedBooks = new ArrayList<>(books);
        if (isAscending) {
            sortedBooks.sort((book1, book2) -> book1.getBookName().compareToIgnoreCase(book2.getBookName()));
        } else {
            sortedBooks.sort((book1, book2) -> book2.getBookName().compareToIgnoreCase(book1.getBookName()));
        }
        return sortedBooks;
    }


    // Книги определенного жанра.

    public List<Book> booksByGenre(List<Book> library) throws IOException {
        List<Book> booksList = new ArrayList<>();
        boolean match = false;
        do {
            System.out.println("Enter the genre or \"back\", if you want to return to the menu: ");
            String genre = reader.readLine();
            if (genre.equalsIgnoreCase("back")) {
                break;
            } else {
                for (Book book : library) {
                    for(String bookGenre: book.getGenre())
                    if (genre.equalsIgnoreCase(bookGenre)) {
                        booksList.add(book);
                        match = true;
                    }
                }
                if (!match) {
                    System.out.println("We don't have books with a such genre.Try to choose another genre. ");
                }
            }
        } while (!match);

        return booksList;
    }

    // Книги определенного автора

    public List<Book> booksByAuthor(Library library, String authorName) {
        for (Author author : library.getAuthors()) {
            if (authorName.equalsIgnoreCase(author.getFullName())) {
                return author.getBookList();
            }
        }
        return null;
    }

    // Ищет книгу по названию.

    public Book bookName(List<Book> library, String bookName) {
        Book searchingBook = null;
        for (Book book : library) {
            if (bookName.equalsIgnoreCase(book.getBookName())) {
                searchingBook = book;
            }
        }
        return searchingBook;
    }

    // Удаляем книгу.

    public void removeBook(List<Book> books, String bookName) {
        books.removeIf(book -> book.getBookName().equalsIgnoreCase(bookName));
    }

    // Ищем книгу по ID.

    public Book findBookByID(List<Book> books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
