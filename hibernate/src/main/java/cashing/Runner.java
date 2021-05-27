package cashing;

//Alien alien1 = new Alien();
//        alien1.setId(1);
//        alien1.setName("Yura");
//        alien1.setColor("Blue");
//        Alien alien2 = new Alien();
//        alien2.setId(2);
//        alien2.setName("Vik");
//        alien2.setColor("Blac");
//
//        Alien alien3 = new Alien();
//        alien3.setId(3);
//        alien3.setName("Boba");
//        alien3.setColor("White");
//session.save(alien1);
//        session.save(alien2);
//        session.save(alien3);

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
        alien = session.get(Alien.class, 1);
        System.out.println(alien);
        session.getTransaction().commit();
        session.close();
        Session session2 = factory.openSession();

        session2.beginTransaction();
        alien = session2.get(Alien.class, 1);
        System.out.println(alien);
        session2.getTransaction().commit();
        session2.close();
    }
}
