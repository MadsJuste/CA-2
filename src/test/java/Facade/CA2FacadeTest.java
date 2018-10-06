/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juste
 */
public class CA2FacadeTest {
    
    public CA2FacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllPerson method, of class CA2Facade.
     */
    @Test
    public void testGetAllPerson() {
        System.out.println("getAllPerson");
        CA2Facade instance = new CA2Facade();
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
        Person p = new Person("Mail@Mail.com", "Bob", "Builder",hobby,a,phone);
        List<Person> expResult = new ArrayList();
        p.setId(1L);
        expResult.add(p);
        p = new Person("Mads@Mail.com", "Mads", "Justesen",hobby,a,phone);
        p.setId(51L);
        expResult.add(p);
        
        List<Person> result = instance.getAllPerson();
        assertEquals(expResult, result);

    }

    /**
     * Test of createPerson method, of class CA2Facade.
     */
    @Test
    public void testCreatePerson() {
        System.out.println("createPerson");
        String mail = "Mads@mail.com";
        String fname = "Mads";
        String lname = "Justesen";
        List<Hobby> hobby = new ArrayList();
        Address address = null;
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
        
        CA2Facade instance = new CA2Facade();
        instance.createPerson(mail, fname, lname, hobby, address, phone);
    }

    /**
     * Test of getAllPersonFromHobby method, of class CA2Facade.
     */
    @Test
    public void testGetAllPersonFromHobby() {
        System.out.println("getAllPersonFromHobby");
        String name = "Mtg";
        CA2Facade instance = new CA2Facade();
        
        List<Person> expResult = new ArrayList();
        
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
        Person p = new Person("Mail@Mail.com", "Bob", "Builder",hobby,a,phone);
          p.setId(1L);
        expResult.add(p);

        
        p = new Person("Mads@Mail.com", "Mads", "Justesen",hobby,a,phone);
        p.setId(51L);
        expResult.add(p);
        List<Person> result = instance.getAllPersonFromHobby(name);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAllPersonByCity method, of class CA2Facade.
     */
    @Test
    public void testGetAllPersonByCity() {
        System.out.println("getAllPersonByCity");
        int zip = 2850;
        CA2Facade instance = new CA2Facade();
        List<Person> expResult = new ArrayList();
        
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
        Person p = new Person("Mail@Mail.com", "Bob", "Builder",hobby,a,phone);
          p.setId(1L);
        expResult.add(p);
        List<Person> result = instance.getAllPersonByCity(zip);
        assertEquals(expResult, result);

    }

    /**
     * Test of getPersonByPhone method, of class CA2Facade.
     */
    @Test
    public void testGetPersonByPhone() {
        System.out.println("getPersonByPhone");
        String number = "12345678";
        CA2Facade instance = new CA2Facade();
        List<Person> expResult = new ArrayList();
        
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
        Person p = new Person("Mail@Mail.com", "Bob", "Builder",hobby,a,phone);
          p.setId(1L);
        expResult.add(p);

        
        p = new Person("Mads@Mail.com", "Mads", "Justesen",hobby,a,phone);
        p.setId(51L);
        expResult.add(p);
        List<Person> result = instance.getPersonByPhone(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCountForHobby method, of class CA2Facade.
     */
    @Test
    public void testGetCountForHobby() {
        System.out.println("getCountForHobby");
        String name = "";
        CA2Facade instance = new CA2Facade();
        int expResult = 0;
        int result = instance.getCountForHobby(name);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAllCities method, of class CA2Facade.
     */
   @Test
    public void testGetAllCities() {
        System.out.println("getAllCities");
        CA2Facade instance = new CA2Facade();
        
        Cityinfo c = new Cityinfo(2850,"Nærum");
        c.setId(3L);
        List<Cityinfo> expResult = new ArrayList();
        expResult.add(c);
        List<Cityinfo> result = instance.getAllCities();
        assertEquals(expResult, result);

    }
   
}
