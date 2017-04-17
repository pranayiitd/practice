package com.practice.Testing;
import java.util.*;

class Node{
    int x;
    int y;
    Node(int a, int b){
        x = a;
        y = b;
    }
    public boolean equals(Node n){
        return (n.x == this.x) && (n.y == this.y);
    }
}
public class Test {
    
    public static void main(String arg[]){

        ArrayList<Node> al = new ArrayList<>();

        al.add(new Node(1, 2));
        al.add(new Node(3, 4));
        System.out.println(al);
        Node x = new Node(1, 2);
        System.out.println(" x == get(0): " + x.equals(al.get(0)));
        System.out.println(" al contains x: " + al.contains(x));
        al.remove(x);
        System.out.println(al);

    }
}
