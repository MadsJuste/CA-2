/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import ca2control.CityinfoMapper;
import ca2control.HobbyMapper;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        HobbyMapper hm = new HobbyMapper();
        
        List<Person> persons = hm.getAllPeople(id);
        
        return persons;
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
