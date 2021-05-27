package dao;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Dao {
    private SessionFactory sessionFactory;

    public void init() {

        // A sessionFactory is set up once for an application

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()  // configures settings from hibernate.cfg.xml.
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new Error("impossible to continue ", e);
        }
    }

    public void save(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
    public Book get(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = session.get(Book.class,2L);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Book", Book.class)
                .list();
    }
}
