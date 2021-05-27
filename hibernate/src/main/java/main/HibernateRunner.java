package main;

import dao.Dao;
import entity.Author;
import entity.Book;

public class HibernateRunner {
    public static void main(String[] args) {
        Dao dao = new Dao();

        Author author = new Author();
        author.setLastName("Last");
        author.setFirstName("FirstName");
        author.setMiddleName("MiddleName");

        Book book = new Book();
        book.setPrice(500);
        book.setTitle("Title");
        book.setAuthor(author);

        dao.init();
        dao.save(book);

//        List<Event> list = dao.getAll();
//        System.out.println(list);


    }
}
