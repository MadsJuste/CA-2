/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import ca2control.CityinfoMapper;
import ca2control.HobbyMapper;
import ca2control.PhoneMapper;
import entity.Cityinfo;
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
    
    public Person getPersonByPhone(String number){
        PhoneMapper pm = new PhoneMapper();
        Person p = pm.getPerson(number);
        return p;
    }
    
    public int getCountForHobby(long id)
    {
            return getAllPersonFromHobby(id).size();
    }
    
    public List<Cityinfo> getAllCities(){
        EntityManager em = emf.createEntityManager();

        List<Cityinfo> cities = null;
        
        try
        {
            em.getTransaction().begin();
            cities = em.createQuery("SELECT c FROM Cityinfo c").getResultList();
            em.getTransaction().commit();
            return cities;
        }
        finally
        {
            em.close();
        }
    }    
}
