package com.practice.advance;
import java.util.*;

class TrieNode{
  HashMap<Character, TrieNode> children;
  boolean isWord;
  char nodeChar;

  TrieNode(char c){
    isWord = false;
    children = new HashMap<>();
    nodeChar = c;
  }
}
