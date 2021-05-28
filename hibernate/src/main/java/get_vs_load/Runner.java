package get_vs_load;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Laptop.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();

//        Laptop laptop2 = session.load(Laptop.class,6); load will give us the proxy object.

        Laptop laptop = session.get(Laptop.class, 6);
        System.out.println(laptop);

        session.getTransaction().commit();
    }
}
