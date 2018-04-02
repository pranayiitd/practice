package com.practice.dynamic;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class PermutationTest{

  @Test
  public void testUnique(){
    String []arr = {"abcde"};

    for(int i=0; i<arr.length; i++){
      ArrayList<String> sol = Permutation.generateUnique(arr[i]);
      System.out.println("sol size: " +  sol.size());
      System.out.println("sol : " +  sol);
    }
  }

  @Test
  public void testDuplicate(){
    String []arr = {"abca"};

    for(int i=0; i<arr.length; i++){
      ArrayList<String> sol = Permutation.generate(arr[i]);
      System.out.println("sol size: " +  sol.size());
      System.out.println("sol : " +  sol);
    }
  }
}
