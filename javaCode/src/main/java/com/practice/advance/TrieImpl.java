package com.practice.advance;
import java.util.*;

class TrieImpl{

  TrieNode root;

  TrieImpl(){
    root = new TrieNode(' ');
  }

  //Updates the trie with new nodes if required
  //So that all the prefixes are searchable
  public void insert(String word){
    if(word == null || word.length() < 1){
     return; 
    }
    insert(word, root);
  }

  void insert(String word, TrieNode node){
    if(word.length() == 0){
      node.isWord = true;
      return;
    }

    char c = word.charAt(0);
    TrieNode child = node.children.get(c);
    if(child == null){
      child = new TrieNode(c);
      node.children.put(c, child);
    }
    insert(word.substring(1), child);
  }

  public boolean search(String word){
    return search(word, true);
  }

  public boolean search(String word, boolean isPrefix){
    if(word == null || word.length() < 1){
      return true;
    }
    return search(word, root, isPrefix);
  }

  boolean search(String word, TrieNode node, boolean isPrefix){
    if(word.length() == 0){
     return true; 
    }

    char c = word.charAt(0);
    TrieNode child = node.children.get(c);
    if(child == null){
      return false;
    }
    return search(word.substring(1), child, isPrefix);
  }

  public void print(){
    print(root, "");
  }

  void print(TrieNode node, String prefix){
    if(node == null){
      System.out.println("\n");
      return;
    }
    System.out.printf("%s, ", prefix + node.nodeChar);
    if(node.children.size() == 0){
      System.out.println("\n");
    }
    for(TrieNode child: node.children.values()){
      print(child, prefix + node.nodeChar);
    }
  }
}
