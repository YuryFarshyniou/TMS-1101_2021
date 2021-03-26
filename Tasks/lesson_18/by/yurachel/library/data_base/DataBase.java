package tasks.lesson_18.by.yurachel.library.data_base;

import tasks.lesson_18.by.yurachel.library.entity.Author;
import tasks.lesson_18.by.yurachel.library.entity.Book;
import tasks.lesson_18.by.yurachel.library.entity.Genre;
import tasks.lesson_18.by.yurachel.library.entity.Library;

import java.sql.*;
import java.util.*;

public class DataBase {

    public void connectionToDB(Library library) throws SQLException, ClassNotFoundException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library",
                "Yurachel", "17092015GhjcnjRbrbhtr1823")) {

            insertBooks(connection, library.getLibrary());

            addAllBooks(connection);


//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from book");
//
//            while (rs.next()) {
//                Book book = new Book(rs.getInt(1),
//                        rs.getString(2), Genre.FANTASY, rs.getInt(4), rs.getInt(5));
//                PreparedStatement ps = connection.prepareStatement("select * from book_author where book_id = ?");
//                ps.setInt(1, book.getId());
//                ResultSet set = ps.executeQuery();
//                List<Author> authorList = new ArrayList<>();
//                while (set.next()) {
//                    authorList.add(addAuthor(rs.getInt(1), connection));
//                }
//                book.setAuthors(authorList);
//
//                System.out.println(book);
//
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private Author addAuthor(int authorId, Connection connection) throws SQLException {
//        PreparedStatement ps = connection.prepareStatement("select * from authors where id = ?");
//        ps.setInt(1, authorId);
//        ResultSet rs = ps.executeQuery();
//        List<Author> authors = new ArrayList<>();
//        while (rs.next()) {
//            authors.add(new Author(rs.getInt(1), rs.getString(2)));
//        }
//        return !authors.isEmpty() ? authors.get(0) : null;
//    }

    private void addAllBooks(Connection connection) throws SQLException {

        String sql = "select b.id, b.book_name, b.genre, b.price, b.number_of_pages, a.id, a.full_name\n" +
                "from book b" +
                "         left join book_author ba on b.id = ba.book_id" +
                "         left join authors a on ba.author_id = a.id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        Map<Book, List<Author>> books = new HashMap<>();
        while (rs.next()) {
            int bookId = rs.getInt(1);
            Optional<Book> bookOpt = books.keySet().stream().filter(book -> book.getId() == bookId).findFirst();
            if (bookOpt.isPresent()) {
                bookOpt.ifPresent(book -> book.getAuthors().add(createAuthor(rs)));
            } else {

                Book book = new Book(bookId, rs.getString(2), new ArrayList<>(Arrays.asList(createAuthor(rs))), Genre.COMEDY,
                        rs.getInt(4), rs.getInt(5));

                books.put(book, book.getAuthors());
            }
        }
        System.out.println(books.keySet());

    }

    private Author createAuthor(ResultSet rs) {
        try {
            return new Author(rs.getInt(6), rs.getString(7));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Author();
    }

    private void insertBooks(Connection connection, List<Book> books) throws SQLException {
        String sqlResetIdBooks = "alter table book auto_increment = 1";
        String sqlResetIdAuthors = "alter table authors auto_increment = 1";
        String sqlInsertAuthors = "insert into authors (full_name) values(?)";
        String sqlInsertBooks = "insert into book(book_name,genre,price,number_of_pages) values(?,?,?,?)";
        String sqlInsertBookAuthor = "insert into book_author (book_id,author_id) values(?,?)";

        PreparedStatement st = connection.prepareStatement(sqlResetIdBooks);
        st.executeUpdate();
        PreparedStatement psAuthors = connection.prepareStatement(sqlResetIdAuthors);
        psAuthors.executeUpdate();
        for (Book book : books) {
            List<Author> authors = book.getAuthors();
            List<Integer> authorsKeys = new ArrayList<>();

            for (Author author : authors) {
                PreparedStatement pc1 = connection.prepareStatement(sqlInsertAuthors, Statement.RETURN_GENERATED_KEYS);
                pc1.setString(1, author.getFullName());
                pc1.executeUpdate();
                ResultSet rs = pc1.getGeneratedKeys();
                if (rs.next()) {
                    authorsKeys.add(rs.getInt(1));
                }
            }


            PreparedStatement pc = connection.prepareStatement(sqlInsertBooks, Statement.RETURN_GENERATED_KEYS);
            pc.setString(1, book.getBookName());
            pc.setString(2, book.getGenre().toString());
            pc.setInt(3, book.getPrice());
            pc.setInt(4, book.getNumberOfPages());

            pc.executeUpdate();
            int bookId = 0;
            ResultSet rs = pc.getGeneratedKeys();
            if (rs.next()) {
                bookId = rs.getInt(1);
            }


            for (Integer key : authorsKeys) {
                PreparedStatement psForConnectionTable = connection.prepareStatement(sqlInsertBookAuthor);
                psForConnectionTable.setInt(1, bookId);
                psForConnectionTable.setInt(2, key);
                psForConnectionTable.executeUpdate();
            }

        }
    }

}
