/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author Juste
 */
public class PersonDTO {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager();

        
      public List<Person> getAllPerson(){
             List<Person> persons = null;
            em.getTransaction().begin();
            persons = em.createQuery("SELECT p FROM Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        
        }
}
