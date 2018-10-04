/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import Facade.CA2Facade;
import entity.Person;
import java.util.List;

import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class FacadeControl {
     public static void main(String[] args)
    {
        CA2Facade caf = new CA2Facade( Persistence.createEntityManagerFactory( "ca2PU" ) );
            
       List<Person> persons = caf.getPersonByHobby();
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
    }
}
