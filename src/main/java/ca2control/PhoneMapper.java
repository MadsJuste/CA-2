/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import entity.Hobby;
import entity.Person;
import entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Juste
 */
public class PhoneMapper {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2PU");
    EntityManager em = emf.createEntityManager(); 
    public static void main(String[] args) {

       
    }
    
    public String getNumber(int id){
        Query query = em.createQuery("Select e FROM Phone e WHERE e.id = :id");
        query.setParameter("id", id);
        Phone result = (Phone) query.getSingleResult();  
        return result.getNumber();
    }
    public void setNumber(String number, String oldnumber){
        Query query = em.createQuery("UPDATE Phone e SET e.number = :number WHERE e.number = :oldnumber");
        query.setParameter("number", number);
        query.setParameter("oldnumber",oldnumber);
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    public int getID(){
        return 0;
    }
    public String getDescription(int id){ 
        Query query = em.createQuery("Select e FROM Phone e WHERE e.id = :id");
        query.setParameter("id", id);
        Phone result = (Phone) query.getSingleResult();  
        return result.getDescription();
    }
    public void setDescription(String newDescription, String oldDiscription){
        Query query = em.createQuery("UPDATE Phone e SET e.description = :newDescription WHERE e.description = :oldDiscription");
        query.setParameter("newDescription", newDescription);
        query.setParameter("oldDiscription",oldDiscription);
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
 
}
