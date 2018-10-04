/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import Facade.CA2Facade;
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
public class FacadeControl {
     public static void main(String[] args)
    {
        CA2Facade caf = new CA2Facade( Persistence.createEntityManagerFactory( "ca2PU" ) );
            
       List<Person> persons = caf.getAllPerson();
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
       
       
       persons = caf.getAllPersonByCity(3333);
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
       
       persons = caf.getAllPersonFromHobby(2L);
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
       
       Person person = caf.getPersonByPhone("nummer!");
       
       System.out.println("eger af telefon er "+person.getFname() +" " + person.getLname() + " Mail er " + person.getMail() + " addresse er "+person.getAddress());
    
    }
}
