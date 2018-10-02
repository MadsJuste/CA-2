/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;


import entity.Cityinfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class CityinfoMapper {
  
    public int getZip(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager(); 
        Cityinfo c = em.find(Cityinfo.class, id);
        return c.getZip();
    }

    public void setZip(int zip, long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager(); 
        Cityinfo c = em.find(Cityinfo.class, id);
        em.getTransaction().begin();
        c.setZip(zip);
        em.getTransaction().commit();
        em.clear();
    }

    public String getCity(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager(); 
        Cityinfo c = em.find(Cityinfo.class, id);
        return c.getCity();
    }

    public void setCity(String city, long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager(); 
        Cityinfo c = em.find(Cityinfo.class, id);
        em.getTransaction().begin();
        c.setCity(city);
        em.getTransaction().commit();
        em.clear();
    }
}
