package fetch;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {
//        Alien alien1 = new Alien();
//        alien1.setId(1);
//        alien1.setName("Yura");
//        Alien alien2 = new Alien();
//        alien2.setId(2);
//        alien2.setName("Vik");
//        Alien alien3 = new Alien();
//        alien3.setId(3);
//        alien3.setName("Boba");
//        Laptop lap1 = new Laptop(1, "Hp", 500);
//        Laptop lap2 = new Laptop(2, "Dell", 600);
//        Laptop lap3 = new Laptop(3, "Samsung", 700);
//        Laptop lap4 = new Laptop(4, "Apple", 1000);
//        lap1.setAlien(alien1);
//        lap2.setAlien(alien3);
//        lap3.setAlien(alien1);
//        lap4.setAlien(alien1);
//        alien1.setLaps(new ArrayList<>(Arrays.asList(lap1, lap3, lap4)));
//        alien3.setLaps(new ArrayList<>(Arrays.asList(lap2)));

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();

//        session.save(lap1);
//        session.save(lap2);
//        session.save(lap3);
//        session.save(lap4);
//
//        session.save(alien1);
//        session.save(alien2);
//        session.save(alien3);
        Alien alien = session.get(Alien.class, 1);
        System.out.println(alien.getName());
//
//        Collection<Laptop> laptops = alien.getLaps();
//        laptops.forEach(System.out::println);
        session.getTransaction().commit();
    }

}
