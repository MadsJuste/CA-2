/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */

public class PhoneMapper {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
        EntityManager em = emf.createEntityManager();

    public String getNumber(long id){        
        Phone p = em.find(Phone.class, id);
        return p.getNumber();
    }
    public void setNumber(String number, long id){
        Phone p = em.find(Phone.class, id);
        em.getTransaction().begin();
        p.setNumber(number);
        em.getTransaction().commit();
        em.clear();
    }
    public String getDescription(long id){ 
        Phone p = em.find(Phone.class, id);
        return p.getDescription();
    }
    public void setDescription(String description, long id){
        Phone p = em.find(Phone.class, id);
        em.getTransaction().begin();
        p.setNumber(description);
        em.getTransaction().commit();
        em.clear();
    }
 
}
