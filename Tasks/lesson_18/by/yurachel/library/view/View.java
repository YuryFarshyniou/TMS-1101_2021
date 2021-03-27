package tasks.lesson_18.by.yurachel.library.view;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import tasks.lesson_18.by.yurachel.library.entity.Author;
import tasks.lesson_18.by.yurachel.library.entity.Book;
import tasks.lesson_18.by.yurachel.library.entity.Genre;
import tasks.lesson_18.by.yurachel.library.entity.Library;
import tasks.lesson_18.by.yurachel.library.service.BookInserter;
import tasks.lesson_18.by.yurachel.library.service.Utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class View {
    private Utils utils;
    private Library library;
    private final List<Book> books;

    public Utils getUtils() {
        return utils;
    }

    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public View(Utils utils, Library library) {
        this.utils = utils;
        this.library = library;
        this.books = library.getLibrary();
    }

    public void applicationMenu() throws IOException, ParserConfigurationException, SAXException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.println("If you want to add a new book to the library,enter \"add\".\n" +
                        "If you want to edit the book,enter \"edit\".\n" +
                        "If you want to remove the book, enter \"remove\".\n" +
                        "If you want to see all the books, enter \"show\".\n" +
                        "If you want to see all author's books, enter \"author\".\n" +
                        "If you want to see all books in specific genre, enter \"genre\".\n" +
                        "If you want to see sorted book's list, enter \"sort\".\n" +
                        "If you want to find book by ID, enter \"id\".\n" +
                        "If you want to end work with application, enter \"exit\".\n");

                System.out.println("Enter an option:");
                String option = reader.readLine().toLowerCase(Locale.ROOT);
                List<Genre> genres = Arrays.asList(Genre.values());
                switch (option) {

                    case "add":
                        System.out.println("How many books you want to add?(enter a number)");
                        int amountOfBooks = Integer.parseInt(reader.readLine());

                        for (int i = 0; i < amountOfBooks; i++) {
                            System.out.println("Enter the book's name: ");
                            String bookName = reader.readLine();

                            System.out.println("Enter the number of authors: ");
                            int numberOfAuthors = Integer.parseInt(reader.readLine());
                            List<Author> authors = new ArrayList<>(numberOfAuthors);
                            for (int j = 0; j < numberOfAuthors; j++) {
                                System.out.printf("Enter the %d author: %s", i + 1, "\n");
                                Author author = new Author(reader.readLine());
                                authors.add(author);
                                library.addAuthors(author);
                            }

                            System.out.println("You have to enter one of these genres.You can write genre with lower case.");
                            utils.showGenre(library.getGenres());
                            List<String> bookGenres = new ArrayList<>();
                            boolean match = false;
                            do {
                                System.out.println("Enter the genre of this book, or enter\"exit\",if you already done writing genres: ");
                                String genre = reader.readLine();
                                if (genre.equalsIgnoreCase("exit")) {
                                    break;
                                } else {
                                    for (Genre genre2 : genres) {
                                        if (genre.equalsIgnoreCase(genre2.toString())) {
                                            bookGenres.add(genre);
                                            match = true;
                                            break;
                                        }
                                    }
                                    if (!match) System.out.println("You enter wrong genre.Try again.");
                                }
                            }
                            while (!match);


                            System.out.println("Enter price of the book: ");
                            int price = Integer.parseInt(reader.readLine());

                            System.out.println("Enter the number of pages: ");
                            int numberOfPages = Integer.parseInt(reader.readLine());

                            Book book = new Book((books.get(books.size() - 1).getId()) + 1, bookName, authors, bookGenres, price, numberOfPages);
                            library.addBookToLibrary(book);
                            for (Author author : authors) {
                                author.addBook(book);
                            }
                            System.out.printf("The book %s was added%s", book.getBookName(), "\n");
                        }
                        break;

                    case "edit":
                        System.out.println("Enter the book's name: ");
                        Book book = utils.bookName(books, reader.readLine());
                        if (book == null) {
                            System.out.println("Wrong book.");
                            break;
                        } else {
                            while (true) {
                                System.out.println("What do you want to edit?\nName - name\nAuthors - authors\n" +
                                        "Genre - genre\nPrice - price\nNumberOfPages - pages\n" +
                                        "If you want to return to the menu enter\"back\"");
                                String optionForBook = reader.readLine().toLowerCase(Locale.ROOT);
                                if (optionForBook.equalsIgnoreCase("back")) {
                                    break;
                                }

                                switch (optionForBook) {

                                    case "name":
                                        System.out.println("Enter the new book's name: ");
                                        book.setBookName(reader.readLine());
                                        break;

                                    case "authors":
                                        editBookAuthors(book, reader);
                                        break;

                                    case "genre":
                                        editBookGenre(book, reader);
                                        break;

                                    case "price":
                                        System.out.println("Enter new price of the book: ");
                                        int price = Integer.parseInt(reader.readLine());
                                        book.setPrice(price);
                                        break;

                                    case "pages":
                                        System.out.println("Enter the new number of pages: ");
                                        int numberOfPages = Integer.parseInt(reader.readLine());
                                        book.setNumberOfPages(numberOfPages);
                                        break;
                                }
                            }
                        }
                        break;


                    case "remove":
                        int initialSize = books.size();
                        boolean successRemoving = false;
                        while (!successRemoving) {
                            System.out.println("Enter the book name, or enter \"back\" to returned previous menu : ");
                            String bookName = reader.readLine();
                            if (bookName.equalsIgnoreCase("back")) {
                                break;
                            } else {
                                utils.removeBook(books, bookName);
                                if (initialSize != books.size()) {
                                    successRemoving = true;
                                } else {
                                    System.out.println("You enter wrong book name.Try again.");
                                }
                            }
                        }
                        break;

                    case "show":
                        utils.showBooks(books);
                        break;


                    case "author":
                        while (true) {
                            System.out.println("Enter the author or enter \"back\", if you want to return to the menu: ");
                            String authorName = reader.readLine();
                            if (authorName.equalsIgnoreCase("back")) {
                                break;
                            } else {
                                for (Author author : library.getAuthors()) {
                                    if (authorName.equalsIgnoreCase(author.getFullName())) {
                                        utils.showBooks(author.getBookList());
                                        break;
                                    }
                                }
                            }
                        }
                        break;


                    case "genre":
                        System.out.println("You have to enter one of these genres.You can write genre with lower case.");
                        utils.showGenre(library.getGenres());
                        List<Book> booksByGenre = utils.booksByGenre(books);
                        utils.showBooks(booksByGenre);
                        break;


                    case "sort":

                        System.out.println("Do you want to sort in ascending order? (true/false)");
                        boolean isAscending = Boolean.parseBoolean(reader.readLine());
                        List<Book> sortedBooks = utils.sortByBookName(books, isAscending);
                        utils.showBooks(sortedBooks);

                        break;

                    case "id":
                        try {
                            System.out.println("Enter book's id: ");
                            int id = Integer.parseInt(reader.readLine());
                            System.out.println(utils.findBookByID(books, id));
                        } catch (NumberFormatException e) {
                            System.out.println("You enter not an ID.Try again.");
                        } finally {
                            System.out.println("");
                        }
                        break;

                    case "exit":
                        DocumentBuilder docParser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        Document document = docParser.parse(new File("resources\\lesson_18\\Library.xml"));
                        BookInserter bookInserter = new BookInserter();
                        bookInserter.addBooksToXML(document, books);
                        return;

                    default:
                        System.out.println("You entered wrong command.\n");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editBookAuthors(Book book, BufferedReader reader) throws IOException {
        System.out.println("Authors of this book: ");
        showAuthors(book);
        System.out.println("\nIf you want to change authors of this book,enter \"edit\"\n" +
                "If you want to add new author,enter \"new\".\n" +
                "If you want to remove author,enter \"remove\".\n");

        String option = reader.readLine().toLowerCase(Locale.ROOT);

        switch (option) {
            case "edit":
                System.out.println("Enter an author,which you want to change: ");
                String oldAuthorFullName = reader.readLine();
                Integer authorIndex = null;
                Author authorRemoveFromAuthorsList = null;
                for (int x = 0; x < book.getAuthors().size(); x++) {
                    if (book.getAuthors().get(x).getFullName().equalsIgnoreCase(oldAuthorFullName)) {
                        authorIndex = x;
                        authorRemoveFromAuthorsList = book.getAuthors().get(x);
                        break;
                    }
                }
                System.out.println("Enter a new author's name: ");
                Author author = new Author(reader.readLine());
                library.addAuthors(author);
                book.getAuthors().set(authorIndex, author);
                author.addBook(book);
                Author finalAuthorRemoveFromAuthorsList = authorRemoveFromAuthorsList;
                library.getAuthors().removeIf(a -> a.getFullName().equalsIgnoreCase(finalAuthorRemoveFromAuthorsList.getFullName()));
                break;

            case "new":
                System.out.println("How many new authors you want to add?");
                int amountOfAuthors = Integer.parseInt(reader.readLine());
                for (int i = 0; i < amountOfAuthors; i++) {
                    System.out.println("Enter an author's name: ");
                    Author newAuthor = new Author(reader.readLine());
                    book.getAuthors().add(newAuthor);
                    library.addAuthors(newAuthor);
                    newAuthor.addBook(book);
                }
                break;

            case "remove":
                System.out.println("Authors of this book: ");
                System.out.println("Enter an author,which you want to remove: ");
                String removeAuthorName = reader.readLine();
                book.getAuthors().removeIf(s -> s.getFullName().equalsIgnoreCase(removeAuthorName));
                break;

            default:
                System.out.println("You entered wrong command.\n");
        }

    }

    private void editBookGenre(Book book, BufferedReader reader) throws IOException {
        System.out.println("Genres of this book: ");
        showGenres(book);
        System.out.println("\nIf you want to change genres of this book,enter \"edit\"\n" +
                "If you want to add new genre,enter \"new\".\n" +
                "If you want to remove genre,enter \"remove\".\n");
        String option = reader.readLine().toLowerCase(Locale.ROOT);

        switch (option) {
            case "edit":
                System.out.println("Enter a genre,which you want to change: ");
                String oldGenre = reader.readLine();
                Integer genreIndex = null;
                for (int x = 0; x < book.getGenre().size(); x++) {
                    if (book.getGenre().get(x).equalsIgnoreCase(oldGenre)) {
                        genreIndex = x;
                        break;
                    }
                }

                boolean genreExists = false;
                String newGenre = null;
                while (!genreExists) {
                    System.out.println("Enter a new genre.You must choose from this list of genres: ");
                    utils.showGenre(library.getGenres());
                    newGenre = reader.readLine();
                    for (Genre genre : library.getGenres()) {
                        if (newGenre.equalsIgnoreCase(genre.toString())) {
                            genreExists = true;
                            newGenre = genre.toString();
                            break;
                        }
                    }
                }
                book.getGenre().set(genreIndex, newGenre);
                break;

            case "new":
                System.out.println("How many new genres you want to add?");
                int amountOfGenres = Integer.parseInt(reader.readLine());
                for (int i = 0; i < amountOfGenres; i++) {
                    boolean genreExistsNewGenre = false;
                    while (!genreExistsNewGenre) {
                        System.out.println("Enter a new genre.You must choose from this list of genres: ");
                        utils.showGenre(library.getGenres());
                        String genre = reader.readLine();
                        for (Genre genres : library.getGenres()) {
                            if (genre.equalsIgnoreCase(genres.toString())) {
                                genre = genres.toString();
                                genreExistsNewGenre = true;
                            }
                        }
                        book.getGenre().add(genre);
                    }
                }
                break;

            case "remove":
                System.out.println("Enter a genre,which you want to remove: ");
                String removeGenre = reader.readLine();
                book.getGenre().removeIf(s -> s.equalsIgnoreCase(removeGenre));
                break;

            default:
                System.out.println("You entered wrong command.\n");
        }
    }

    private void showGenres(Book book) {
        for (String genre : book.getGenre()) {
            System.out.println(genre);
        }
        System.out.println("");
    }

    public void showAuthors(Book book) {
        for (Author author : book.getAuthors()) {
            System.out.println(author);
        }
        System.out.println("");
    }
}
