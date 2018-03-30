package com.practice.advance;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class TrieImplTest{

  TrieImpl trie = new TrieImpl();

  @Before
  public void setup(){
   String [] dict = {"Brad", "Angelina", "Bollywood", "Fun", "FinTech", "Brat", "Fuck"};
    for(String w: dict){
      trie.insert(w);
    }
  }

  @Test
  public void testPresentPrefix(){
    Assert.assertTrue(trie.search("", false));
    Assert.assertTrue(trie.search("Bra", false));
    Assert.assertTrue(trie.search("Brad", false));
    Assert.assertTrue(trie.search("B", false));
    Assert.assertTrue(trie.search("Ange", false));
    Assert.assertTrue(trie.search("Bolly", false));
    Assert.assertTrue(trie.search("FinT", false));
  }


  @Test
  public void testAbsentPrefix(){
    Assert.assertFalse(trie.search("XBra", false));
    Assert.assertFalse(trie.search("Bradt", false));
    Assert.assertFalse(trie.search("Bz", false));
    Assert.assertFalse(trie.search("Angex", false));
  }

  @Test
  public void print(){
    trie.print();
  }
}