/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import ca2control.CityinfoDTO;
import ca2control.HobbyDTO;
import ca2control.PersonDTO;
import ca2control.PhoneDTO;
import entity.Address;
import entity.Cityinfo;
//import entity.ContactDTO;
//import entity.PersonF;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
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

    public CA2Facade() {
    }
    
    
    
    
    
    public List<Person> getAllPerson()
    {
        PersonDTO p = new PersonDTO();
        
        List<Person> persons = p.getAllPerson();
               
        return persons;
    }
    public Person getFullPersonID(Long id)
    {
        PersonDTO p = new PersonDTO();
        
        Person person = p.getFullPersonID(id);
        
        return person;
    }
   /* public List<ContactDTO> getAllContact(){
        PersonDTO p = new PersonDTO();
        
        List<Person> persons = p.getAllPerson();
        
        List<ContactDTO> contacts = new ArrayList();
        for(Person pers : persons){
            contacts.add(new ContactDTO(pers));
        }
        return contacts;
    }
    
    
    
    public ContactDTO getContactID(Long id)
    {
        PersonDTO p = new PersonDTO();
        
        Person person = p.getFullPersonID(id);
        
        
        return new ContactDTO(person);
    }
   */ 
    public void createPerson(String mail, String fname, String lname, List<Hobby> hobby, Address address, List<Phone> phone){
        PersonDTO p = new PersonDTO();
        p.createPerson(mail, fname, lname, hobby, address, phone);
    }

    public List<Person> getAllPersonFromHobby(String name){
        HobbyDTO hm = new HobbyDTO();
        
        List<Person> persons = hm.getAllPeople(name);
        
        return persons;
    }
    
    public List<Person> getAllPersonByCity(int zip)
    {
        CityinfoDTO cim = new CityinfoDTO();
      
        List<Person> persons = cim.getAllPeople(zip);
               
        return persons;
      
        
    }
    
    public List<Person> getPersonByPhone(String number){
        PhoneDTO pm = new PhoneDTO();
        List<Person> p = pm.getPerson(number);
        return p;
    }
    
    public int getCountForHobby(String name)
    {
            return getAllPersonFromHobby(name).size();
    }
    
    public List<Cityinfo> getAllCities(){
        CityinfoDTO ci = new CityinfoDTO();
        
        List<Cityinfo> cities = ci.getAllCities();
        
       
        return cities;
        
    }    
}
