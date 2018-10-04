/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import ca2control.CityinfoMapper;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
    
    
    
    public List<Person> getAllPerson()
    {
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("SELECT p FROM Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }
    
    public List<Person> getAllPersonFromHobby(Long id){
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p, h FROM Person p, Hobby h WHERE h.id =:id");
            query.setParameter("id", id);
            persons = query.getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }
    
    public List<Person> getAllPersonByCity(int zip)
    {
        CityinfoMapper cim = new CityinfoMapper();
      
        List<Person> persons = cim.getAllPeople(zip);;
               
        return persons;
      
        
    }
    
    public int getCountForHobby()
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            
            em.getTransaction().commit();
            return 1;
        }
        finally
        {
            em.close();
        }
    }
    

    
    
}
