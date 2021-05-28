package cashing.two_level_cache_with_query;

import cashing.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Runner {
    public static void main(String[] args) {
        Alien alien = null;
        Configuration conf = new Configuration().configure()
                .addAnnotatedClass(Alien.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();

        Query query = session.createQuery("from Alien where id=2 ");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();

        System.out.println(alien);
        session.getTransaction().commit();
        session.close();

        Session session2 = factory.openSession();
        session2.beginTransaction();
        Query query2 = session2.createQuery("from Alien where id=2 ");
        query2.setCacheable(true);

        alien = (Alien) query2.uniqueResult();
        System.out.println(alien);
        session2.getTransaction().commit();
        session2.close();
    }
}
