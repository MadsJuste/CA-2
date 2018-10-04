/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import ca2control.CityinfoDTO;
import ca2control.HobbyDTO;
import ca2control.PhoneDTO;
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
    
    public List<Person> getAllPersonFromHobby(String name){
        HobbyDTO hm = new HobbyDTO();
        
        List<Person> persons = hm.getAllPeople(name);
        
        return persons;
    }
    
    public List<Person> getAllPersonByCity(int zip)
    {
        CityinfoDTO cim = new CityinfoDTO();
      
        List<Person> persons = cim.getAllPeople(zip);;
               
        return persons;
      
        
    }
    
    public Person getPersonByPhone(String number){
        PhoneDTO pm = new PhoneDTO();
        Person p = pm.getPerson(number);
        return p;
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
