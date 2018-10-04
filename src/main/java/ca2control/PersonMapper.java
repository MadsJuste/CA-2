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
import javax.persistence.Query;

/**
 *
 * @author Juste
 */
public class PersonMapper {
    public static void main(String[] args) {
        run();
    }
    
    public static void run(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpapu" );
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        //NamedQuery
        Query Nquery = em.createNamedQuery("findAllPersonsByHobby");
        Nquery.setParameter("hobby_id", 152); 
        List<Person> persons = Nquery.getResultList(); 
        for(Person p:persons)
        {
            System.out.println("Person with hobby 152 : " + p);
        }
        em.getTransaction().commit();        
        em.close();
    }
        
}
