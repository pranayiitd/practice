package com.practice.heap;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class TopWordsTest{

  @Test
  public void testSanityInput(){
    String [] words = {};
    ArrayList<String> sol = TopWords.find(words, 3);
    Assert.assertEquals(0, sol.size());

    sol = TopWords.find(null, 3);
    Assert.assertEquals(0, sol.size());
  }

  @Test
  public void testSimpleCase(){
    String [] words = {"w1",  "w1", "w1", "w1", "w2", "w3", "w4", "w5", "w6", "w6", "w7", "w4"};
    ArrayList<String> sol = TopWords.find(words, 3);
    Assert.assertEquals(3, sol.size());
  }
}