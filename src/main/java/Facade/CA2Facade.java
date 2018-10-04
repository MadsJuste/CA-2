/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;

/**
 *
 * @author Juste
 */
public class CA2Facade {
        
     EntityManagerFactory emf;
    
    public CA2Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public Person getPerson(String number)
    {
        EntityManager em = emf.createEntityManager();

        Person p = null;
        
        try
        {
            em.getTransaction().begin();
         //   p = em.find(Person.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }    
    }
    
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }
}
