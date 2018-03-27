/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashset;
import java.util.*;
/**
 *
 * @author Utkarsh
 */
public class JavaHashSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet<String> set = new HashSet<String>();
        System.out.println("Adding One: " + set.add("One"));
        System.out.println("Adding null: " + set.add(null));
        System.out.println("Adding One again: " + set.add("One"));
        System.out.println("Adding one: " + set.add("one"));
        System.out.println("Adding two: " + set.add("two"));
        
        System.out.println("Conatins one?" + set.contains("one"));
        System.out.println("Removing one: " + set.remove("one"));
        System.out.println("Removing one again: " + set.remove("one"));
        System.out.println("Conatins one?" + set.contains("one"));
        
        Iterator<String> it = set.iterator();
        System.out.println("Set values:");
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        
    }
    
}
