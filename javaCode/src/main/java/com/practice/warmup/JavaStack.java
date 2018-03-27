/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastack;
import java.util.*;
/**
 *
 * @author Utkarsh
 */
public class JavaStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<String> stack = new Stack<>();
        System.out.println("Pushing one: " + stack.push("one"));
        System.out.println("Pushing two: " + stack.push("two"));
        System.out.println("Pushing three: " + stack.push("three"));
        System.out.println("Poping three: " + stack.pop());
        System.out.println("Peeking: " + stack.peek());
        System.out.println("Poping two: " + stack.pop());
        System.out.println("Peeking: " + stack.peek());
        System.out.println("Poping one: " + stack.pop());
        System.out.println("empty?: " + stack.empty());
        System.out.println("isempty?: " + stack.isEmpty());
        System.out.println("Peeking: " + stack.peek()); // will throw
        System.out.println("Poping one: " + stack.pop()); // will throw
    }
    
}
