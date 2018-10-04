/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;



import entity.Cityinfo;
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
public class CityinfoMapper {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager(); 
   
    public int getZip(long id) {
        Cityinfo c = em.find(Cityinfo.class, id);
        return c.getZip();
    }
    

    public void setZip(int zip, long id) {
        Cityinfo c = em.find(Cityinfo.class, id);
        em.getTransaction().begin();
        c.setZip(zip);
        em.getTransaction().commit();
        em.clear();
    }

    public String getCity(long id) {
        Cityinfo c = em.find(Cityinfo.class, id);
        return c.getCity();
    }

    public void setCity(String city, long id) {
        Cityinfo c = em.find(Cityinfo.class, id);
        em.getTransaction().begin();
        c.setCity(city);
        em.getTransaction().commit();
        em.clear();
    }
    
    public List<Person> getAllPeople(int zip){
        
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT p FROM Person p JOIN p.address a WHERE a.cityinfo.zip = :zip");
        query.setParameter("zip", zip);
        List<Person> person = query.getResultList();
        return person;
    }
}
