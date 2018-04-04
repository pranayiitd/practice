package com.practice.list;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class SListTest{

  @Test
  public void test(){
    int [] arr = {1, 2, 10, 11, 13};

    SList slist = new SList(0);
    for(int i=0; i<arr.length; i++){
      slist.insert(arr[i]);
    }
    slist.print();

    slist.delete();
    slist.delete();
    slist.print();

    System.out.printf("%s present? : %s\n", 5, slist.find(5));
    System.out.printf("%s present? : %s\n", 11, slist.find(11));

    slist.delete(1);
    slist.print();

    slist.delete(11);
    slist.print();

    slist.delete(13);
    slist.print();
    
    slist.delete(2);
    slist.print();


    slist.delete(10);
    slist.print();

  }
}
