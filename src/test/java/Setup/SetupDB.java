/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import Facade.CA2Facade;
import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Phone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class SetupDB {
     public static void main(String[] args)
    {
        HashMap<String, Object> puproperties = new HashMap<>();
        
        puproperties.put("javax.persistence.sql-load-script-source", "script/CleanDB.sql");
        Persistence.generateSchema("ca2PU", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");   
        Persistence.generateSchema("ca2PU", puproperties);
        
        
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
 
    }
}
