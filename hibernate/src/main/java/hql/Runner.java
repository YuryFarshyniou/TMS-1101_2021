package hql;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Runner {
    private static Random random = new Random();

    public static void main(String[] args) {

        Configuration conf = new Configuration().configure()
                .addAnnotatedClass(Student.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select name,marks from student where marks>60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Student> students = query.list();
        for (Object o : students) {
            Map map = (Map) o;

            System.out.println(map.get("name") + " : " + map.get("marks"));
        }
        session.getTransaction().commit();
        session.close();
    }
}


//    Query query = session.createQuery("from Student where marks > 50");
//    List<Student> students = query.list();
//        System.out.println(students.size());
//                students.forEach(System.out::println);


//                Query query = session.createQuery("Select id,name,marks from Student where id=10");
//                Object[] student = (Object[]) query.uniqueResult();
//        System.out.println(Arrays.toString(student));


//    Query query = session.createQuery("select id,name,marks from Student ");
//    List<Object[]> students = (List<Object[]>) query.list();
//        for (Object[] student : students) {
//                System.out.println(Arrays.toString(student));
//                }


//    Query query = session.createQuery("select sum(marks) from Student s where s.marks > 50");
//    Long students = (Long) query.uniqueResult();
//        System.out.println(students);


//    int number = 70;
//    Query query = session.createQuery("select sum(marks) from Student s where s.marks > :number");
//        query.setParameter("number", number);
//                Long students = (Long) query.uniqueResult();
//                System.out.println(students);

// Native Queries.
//    SQLQuery query = session.createSQLQuery("select * from student where marks>60");
//        query.addEntity(Student.class);
//        List<Student> students = query.list();
//        students.forEach(System.out::println);


//    SQLQuery query = session.createSQLQuery("select name,marks from student where marks>60");
//        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//                List<Student> students = query.list();
//        for (Object o : students) {
//        Map map = (Map) o;
//
//        System.out.println(map.get("name") + " : " + map.get("marks"));
//        }