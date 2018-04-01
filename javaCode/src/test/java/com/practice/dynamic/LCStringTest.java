package com.practice.dynamic;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class LCStringTest{
  @Test
  public void test(){
    String ret = LCString.find("1abc3", "2abc4");
    System.out.println("sol: " + ret);
    ret = LCString.findBT("1abc3", "2abc4");
    System.out.println("solBT: " + ret);

    ret = LCString.find("1abc31111", "2abc4");
    System.out.println("sol: " + ret);
    ret = LCString.findBT("1abc31111", "2abc4");
    System.out.println("solBT: " + ret);

    ret = LCString.find("1abc31111", "2abc311");
    System.out.println("sol: " + ret);
    ret = LCString.findBT("1abc31111", "2abc311");
    System.out.println("solBT: " + ret);

    ret = LCString.find("abc", "abc");
    System.out.println("sol: " + ret);
    ret = LCString.findBT("abc", "abc");
    System.out.println("solBT: " + ret);

    ret = LCString.find("01abc31111", "01abc");
    System.out.println("sol: " + ret);
    ret = LCString.findBT("01abc31111", "01abc");
    System.out.println("solBT: " + ret);

  }
}