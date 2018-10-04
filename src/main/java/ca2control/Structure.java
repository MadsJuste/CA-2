/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2control;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class Structure {
    public static void main(String[] args)
    {
        HashMap<String, Object> puproperties = new HashMap<>();
        
        puproperties.put("javax.persistence.sql-load-script-source", "script/CleanDB.sql");
        Persistence.generateSchema("ca2PU", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");   
        Persistence.generateSchema("ca2PU", puproperties);
    }
}
