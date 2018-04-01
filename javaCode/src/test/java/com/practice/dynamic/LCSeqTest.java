package com.practice.dynamic;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class LCSeqTest{
  @Test
  public void test(){
    String [] arr = {"1a2b3cd", "abcdef", "1a2b3c4def"};
    String [] brr = {"xaybzc", "abcdef", "abc9d9e87f"};

    for(int i=0; i<arr.length; i++){
      String ret = LCSeq.find(arr[i], brr[i]);
      System.out.println("sol: " +  ret);
    }

  }
}
