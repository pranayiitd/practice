/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaqueue;
import java.util.*;

/**
 *
 * @author Utkarsh
 */
public class JavaQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue<String> q = new LinkedList<>(); // default q, has stack methods as well
        System.out.println("Adding one: " + q.add("one"));// could throw exception use offer instead to avoid exception
        System.out.println("Adding two: " + q.add("two"));
        System.out.println("Adding three: " + q.add("three"));
        System.out.println("Adding 4: " + q.add("4"));
        System.out.println("Adding one again: " + q.add("one"));// is ok
        System.out.println("Peeking: " + q.peek());
        System.out.println("Polling: " + q.poll());
        System.out.println("Removing: " + q.remove());// throw if q empty
        System.out.println("Element: " + q.element());
        System.out.println("Polling: " + q.poll());
        System.out.println("Peeking: " + q.peek());
        System.out.println("Polling: " + q.poll());// safe remove call
        System.out.println("Peeking: " + q.peek());
        System.out.println("Polling: " + q.poll());
        System.out.println("Peeking: " + q.peek());// safe element call
        System.out.println("Element: " + q.element());// throw exeception if q empty
    }
    
}
