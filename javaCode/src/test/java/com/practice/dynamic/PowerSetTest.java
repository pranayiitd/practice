package com.practice.dynamic;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class PowerSetTest{
  @Test
  public void test(){
    String [][] arr = {{"a", "b", "c", "d"}};

    for(int i=0; i<arr.length; i++){
      ArrayList<Set<String>> sol = PowerSet.generate(arr[i]);
      System.out.println("sol size: " +  sol.size());
      System.out.println("sol : " +  sol);
    }
  }

  @Test
  public void testMakeChange(){
    int [] denoms = {1, 5, 10, 25};
    int n = 2000;
    int[][] map = new int[n+1][denoms.length];
    System.out.println(PowerSet.makeChange(n, 0, denoms, map));
  }
}
