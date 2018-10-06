/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Juste
 */
public class PersonDTO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
    EntityManager em = emf.createEntityManager();

    public List<Person> getAllPerson() {
        List<Person> persons = null;

        persons = em.createQuery("SELECT p FROM Person p").getResultList();

        return persons;

    }

    public Person getFullPersonID(Long id) {
        Person person = em.find(Person.class, id);

        return person;
    }

    public void createPerson(String mail, String fname, String lname, List<Hobby> hobby, Address address, List<Phone> phone) {

        em.getTransaction().begin();
        Person p = new Person(mail, fname, lname, hobby, address, phone);
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
}
