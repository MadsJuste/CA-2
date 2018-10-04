/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Juste
 */
public class HobbyMapper {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
    EntityManager em = emf.createEntityManager(); 
    
    
     public List<Person> getAllPeople(Long id){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT p FROM Person p JOIN p.hobby h WHERE h.id = :id");
        query.setParameter("id", id);
        List<Person> person = query.getResultList();
        return person;
    }
}
