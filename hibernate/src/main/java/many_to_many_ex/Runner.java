package many_to_many_ex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setId(1);
        laptop.setName("HP");

        Student student = new Student();
        student.setMark("56");
        student.setId(1);
        student.setName("name");
        student.getLaptop().add(laptop);

        laptop.getStudent().add(student);

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(laptop);
        session.save(student);
        session.getTransaction().commit();
    }
}
