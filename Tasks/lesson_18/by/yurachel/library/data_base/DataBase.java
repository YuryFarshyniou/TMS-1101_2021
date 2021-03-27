package tasks.lesson_18.by.yurachel.library.data_base;

import tasks.lesson_18.by.yurachel.library.entity.Author;
import tasks.lesson_18.by.yurachel.library.entity.Book;
import tasks.lesson_18.by.yurachel.library.entity.Genre;
import tasks.lesson_18.by.yurachel.library.entity.Library;

import java.sql.*;
import java.util.*;

public class DataBase {
//    private static final Map<Integer, Genre> genres2 = new LinkedHashMap<>();
//
//    static {
//        int count = 1;
//        for (Genre genre : EnumSet.allOf(Genre.class)) {
//            genres2.put(count, genre);
//            count++;
//        }
//    }
//
//    public void connectionToDB(Library library)  {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library",
//                "Yurachel", "17092015GhjcnjRbrbhtr1823")) {
//
//            insertBooks(connection, library.getLibrary());
//
//            addAllBooks(connection);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void addAllBooks(Connection connection) throws SQLException {
//
//        String sql = "select b.id,b.book_name,b.price,b.number_of_pages,a.id,a.full_name,g.id, g.genres " +
//                "from book b" +
//                "         left join book_author ba on b.id = ba.book_id " +
//                "         left join book_genre bg on b.id = bg.book_id " +
//                "         left join authors a on ba.author_id = a.id " +
//                "         left join genre g on bg.genre_id = g.id";
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(sql);
//        Map<Book, List<Author>> books = new HashMap<>();
//        while (rs.next()) {
//            int bookId = rs.getInt(1);
//            Optional<Book> bookOpt = books.keySet().stream().filter(book -> book.getId() == bookId).findFirst();
//            if (bookOpt.isPresent()) {
//                bookOpt.ifPresent(book -> book.getAuthors().add(createAuthor(rs)));
//            } else {
//                Genre bookGenre = null;
//                for (Map.Entry entry : genres2.entrySet()) {
//                    if (entry.getKey() == (Integer) rs.getInt(7)) {
//                        bookGenre = (Genre) entry.getValue();
//                        break;
//                    }
//                }
//
//                Book book = new Book(bookId, rs.getString(2), new ArrayList<>(Arrays.asList(createAuthor(rs))), bookGenre,
//                        rs.getInt(3), rs.getInt(4));
//
//                books.put(book, book.getAuthors());
//            }
//        }
//        System.out.println(books.keySet());
//    }
//
//    private Author createAuthor(ResultSet rs) {
//        try {
//            return new Author(rs.getInt(5), rs.getString(6));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new Author();
//    }
//
//
//    private void insertBooks(Connection connection, List<Book> books) throws SQLException {
//        String sqlDeleteAllFromAuthors = "DELETE FROM authors";
//        String sqlDeleteAllFromBooks = "DELETE FROM book";
//        String sqlDeleteAllFromBookAuthor = "DELETE FROM book_author";
//        String sqlDeleteAllFromBookGenre = "DELETE FROM book_genre";
//
//        String sqlResetIdBooks = "alter table book auto_increment = 1";
//        String sqlResetIdAuthors = "alter table authors auto_increment = 1";
//
//        String sqlInsertAuthors = "insert into authors (full_name) values(?)";
//        String sqlInsertBooks = "insert into book(book_name,price,number_of_pages) values(?,?,?)";
//        String sqlInsertBookAuthor = "insert into book_author (book_id,author_id) values(?,?)";
//        String sqlInsertBookGenre = "insert into book_genre(book_id,genre_id) values(?,?)";
//
//
//        PreparedStatement psDeleteAllFromBookAuthor = connection.prepareStatement(sqlDeleteAllFromBookAuthor);
//        psDeleteAllFromBookAuthor.executeUpdate();
//        PreparedStatement psDeleteAllFromBookGenre = connection.prepareStatement(sqlDeleteAllFromBookGenre);
//        psDeleteAllFromBookGenre.executeUpdate();
//        PreparedStatement psDeleteAllFromAuthors = connection.prepareStatement(sqlDeleteAllFromAuthors);
//        psDeleteAllFromAuthors.executeUpdate();
//        PreparedStatement psDeleteAllFromBooks = connection.prepareStatement(sqlDeleteAllFromBooks);
//        psDeleteAllFromBooks.executeUpdate();
//
//
//        PreparedStatement st = connection.prepareStatement(sqlResetIdBooks);
//        st.executeUpdate();
//        PreparedStatement psAuthors = connection.prepareStatement(sqlResetIdAuthors);
//        psAuthors.executeUpdate();
//        for (Book book : books) {
//
//            List<Author> authors = book.getAuthors();
//            List<Integer> authorsKeys = new ArrayList<>();
//
//            // Заносим значения в таблицу authors.
//
//            for (Author author : authors) {
//                PreparedStatement pc1 = connection.prepareStatement(sqlInsertAuthors, Statement.RETURN_GENERATED_KEYS);
//                pc1.setString(1, author.getFullName());
//                pc1.executeUpdate();
//                ResultSet rs = pc1.getGeneratedKeys();
//                if (rs.next()) {
//                    authorsKeys.add(rs.getInt(1));
//                }
//            }
//
//            // Заносим значения в таблицу book.
//
//            PreparedStatement pc = connection.prepareStatement(sqlInsertBooks, Statement.RETURN_GENERATED_KEYS);
//            pc.setString(1, book.getBookName());
//            pc.setInt(2, book.getPrice());
//            pc.setInt(3, book.getNumberOfPages());
//            pc.executeUpdate();
//
//            // Ищем id книги.
//
//            int bookId = 0;
//            ResultSet rs = pc.getGeneratedKeys();
//            if (rs.next()) {
//                bookId = rs.getInt(1);
//            }
//
//            // Заносим значения в таблицу book_genre.
//
//            PreparedStatement psBookGenre = connection.prepareStatement(sqlInsertBookGenre);
//            psBookGenre.setInt(1, bookId);
//            int genreId = 0;
//            for (Map.Entry entry : genres2.entrySet()) {
//                if (book.getGenre().toString().equalsIgnoreCase(entry.getValue().toString())) {
//                    genreId = (int) entry.getKey();
//                    break;
//                }
//            }
//            psBookGenre.setInt(2, genreId);
//            psBookGenre.executeUpdate();
//
//            // Заносим значения в таблицу book_author.
//
//            for (Integer key : authorsKeys) {
//                PreparedStatement psForConnectionTable = connection.prepareStatement(sqlInsertBookAuthor);
//                psForConnectionTable.setInt(1, bookId);
//                psForConnectionTable.setInt(2, key);
//                psForConnectionTable.executeUpdate();
//            }
//        }
//    }
}
