package com.practice.tree;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class BSTreeTest{

  @Test
  public void test(){
    BSTree bt = new BSTree(10);
    BSTree bt2 = new BSTree(10);
    int [] arr = {11, 1, -111, 2000, 20, 25, 11, 11};
    for(int e: arr){
        bt.insert(e);
        bt2.insert_it(e);
    }
    bt.print();
    bt.inorder();
    bt2.inorder();
    bt2.print();

    System.out.printf("%s present? : %s\n", 1, bt.find(1));
    System.out.printf("%s present? : %s\n", 1, bt.find_it(1));

    System.out.printf("%s present? : %s\n", 111, bt.find(111));
    System.out.printf("%s present? : %s\n", 111, bt.find_it(111));

    System.out.printf("%s present? : %s\n", -11, bt.find(-11));
    System.out.printf("%s present? : %s\n", -11, bt.find_it(-11));

    System.out.printf("%s present? : %s\n", 25, bt.find(25));
    System.out.printf("%s present? : %s\n", 25, bt.find_it(25));

    bt.delete(11);
    bt.print();
    bt.inorder();
  }
}
