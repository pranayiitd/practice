package com.practice.advance;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class PortmanteauTest{

  @Test
  public void testSimpleCase(){
    String [] dict = {"Brad", "Angelina", "Bollywood", "Fun", "FinTech"};
    String [] words = {"Brangelina", "Bollyfun", "bollyTech", "bollyTech1", "Bollylina"};
    TrieImpl prefixTree = new TrieImpl();
    TrieImpl reverseSuffixTree = new TrieImpl();

    for(String word: dict){
      prefixTree.insert(word.toLowerCase());
      reverseSuffixTree.insert(new StringBuffer(word.toLowerCase()).reverse().toString());
    }

    // prefixTree.print();
    // reverseSuffixTree.print();

    for(String w: words){
     boolean tf = Portmanteau.isPortmanteau(w.toLowerCase(), prefixTree, reverseSuffixTree);
    }
  }
}