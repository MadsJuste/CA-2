/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import Facade.CA2Facade;
import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
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
           
       List<Hobby> hobby = new ArrayList();
       List<Phone> phone = new ArrayList();
       Hobby h = new Hobby("Mtg", "kortspil");
       hobby.add(h);
       Hobby h1 = new Hobby("DND", "Rollespil");
       hobby.add(h1);
       Phone ph = new Phone("12345678","bob1");
       phone.add(ph);
       Phone ph1 = new Phone("23456789","bob2");
       phone.add(ph1);
       Address a = new Address("Skodsborgvej 338", "Nærum");
       Cityinfo c = new Cityinfo(2850,"Nærum");
       a.setCityinfo(c); 
       
       caf.createPerson("Mail@Mail.com", "Bob", "Builder", hobby, a, phone);
 
         
       
       List<Person> persons = caf.getAllPerson();
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
       
       
       
      
       //Person person = caf.getFullPersonID(1L);
       
       //System.out.println("name of the person is : " + person.getFname() + " " +person.getLname() + "Address "+ person.getAddress().getStreet()+" hobby er: " +person.getHobby().toString());
        /*
       persons = caf.getAllPersonByCity(3333);
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
       
       persons = caf.getAllPersonFromHobby("Mtg");
       for(Person p:persons)
        {
            System.out.println("name of the person is : " + p.getFname() + " " +p.getLname());
        }
       
       Person person = caf.getPersonByPhone("nummer!");
       
       System.out.println("eger af telefon er "+person.getFname() +" " + person.getLname() + " Mail er " + person.getMail());
        */
    }
}
