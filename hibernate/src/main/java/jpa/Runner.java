package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {

        Laptop laptop2 = new Laptop(); // Fetch into a database
        laptop2.setId(60);
        laptop2.setPrice(214);
        laptop2.setBrand("Sony");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.persist(laptop2);
        em.getTransaction().commit();

//        Laptop laptop = em.find(Laptop.class, 5); // Getting from db
//        System.out.println(laptop);
    }
}
