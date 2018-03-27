/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javahashmap;
import java.util.*;
/**
 *
 * @author Utkarsh
 */
public class JavaHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put(null, null);
        System.out.println("Conatins one ? " + hm.containsKey("one"));
        System.out.println("Value of one : " + hm.get("one"));
        System.out.println("Conatins ONE ? " + hm.containsKey("ONE"));
        System.out.println("Conatins value 2 ? " + hm.containsValue(2));
        System.out.println("Keys:");
        for(String key : hm.keySet())
        {
            System.out.println(key);
        }
        
        System.out.println("Values:");
        for(Integer value : hm.values())
        {
            System.out.println(value);
        }
        
        System.out.println("Removing key one: " + hm.remove("one"));
        System.out.println("Removing key ONE: " + hm.remove("ONE"));
        
    }
    
}
