package hibernate_obj_states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure()
                .addAnnotatedClass(Laptop.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();
        Laptop laptop = new Laptop(); // Transient state
        laptop.setId(50);
        laptop.setBrand("Apple");
        laptop.setPrice(657);

        session.save(laptop); // Persistence state

        session.detach(laptop); // Taking our object into a detach state.
        session.remove(laptop); // Taking our object into  a remove state.
        laptop.setPrice(549); // In our database,our laptop price  will be 549 ,not 657.


        session.getTransaction().commit();
        session.close();
    }
}

