/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

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

public class PhoneDTO {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager();

    public String getNumber(long id){        
        Phone p = em.find(Phone.class, id);
        return p.getNumber();
    }
    public void setNumber(String number, long id){
        Phone p = em.find(Phone.class, id);
        em.getTransaction().begin();
        p.setNumber(number);
        em.getTransaction().commit();
        em.clear();
    }
    public String getDescription(long id){ 
        Phone p = em.find(Phone.class, id);
        return p.getDescription();
    }
    public void setDescription(String description, long id){
        Phone p = em.find(Phone.class, id);
        em.getTransaction().begin();
        p.setNumber(description);
        em.getTransaction().commit();
        em.clear();
    }
    
    public Person getPerson(String number){
        Person p = null;
        Query query = em.createQuery("SELECT p FROM Person p JOIN p.phone ph WHERE ph.number = :number");
        query.setParameter("number", number);
        p = (Person) query.getSingleResult();
        return p;
    }
 
}
