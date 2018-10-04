/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class Populate {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ca2PU" );
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Person p = new Person("Mads@mail.com", "Mads", "Justesen");
        em.persist(p);
        
        Hobby h = new Hobby("Mtg", "kortspil");
        p.addHobby(h);
        em.persist(h);
       
        p = new Person("Kim@mail.com", "Kim", "Novak");
        em.persist(p);
        
        Phone ph = new Phone("nummer!","kim nummer");
        p.setPhone(ph);
        em.persist(ph);
     
        p = new Person("Esben@mail.com", "Esben", "Göttsche");
        em.persist(p);
        
        Address a = new Address("Yellow Road 1", "Berlin");
        
        Cityinfo c = new Cityinfo(3333,"Berlin");
        a.setCityinfo(c);
        em.persist(c);
        
        p.setAddress(a);
        em.persist(a);  
        
        p = new Person("Magnus@mail.com","Magnus","Madsen");
        em.persist(p);
        
        a.setCityinfo(c);
        em.persist(c);
        
        p.setAddress(a);
        em.persist(a);  
        
        
        em.getTransaction().commit();
        em.close();
    }
}
