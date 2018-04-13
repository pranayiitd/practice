package com.practice.graph;

import java.util.*;

class Node{
  int label;
  ArrayList<Node> neighbors;
  public Node(int i){
    label = i;
    neighbors = new ArrayList<Node>();
  }

  public void add(Node v){
    neighbors.add(v);
  }

  public ArrayList<Node> getNeighbors(){
    return neighbors;
  }

  public void print(){
    System.out.format("%s:", label);
    for(Node n : neighbors){
      System.out.format("%s,", n.label);
    }
    System.out.println();

  }
}