package com.practice.graph;

import java.util.*;
import java.io.*;

class Graph{
  

  // Count of vertices
  int V;
  // Count of edges
  int E;
  // List of vertices
  Node adj [];
  // private LinkedList<Integer> adj[];

  // Initialize graph of v nodes, no edges
  // Nodes indexed 0 to v-1
  public Graph(int v){
    adj = new Node[v];
    for(int i=0; i<v; i++){
      adj[i] = new Node(i);
    }
  }

  // Assuming non-directional graph
  // adding edges both ways
  public void addEdge(int v, int u){
    // Can add some validation code here but meh.
    Node nv = adj[v];
    Node nu = adj[u];
    adj[v].add(nu);
    adj[u].add(nv);
  }

  public ArrayList<Node> getNeighbors(int v){
    return adj[v].getNeighbors();
  }

  public void print(){
    for(Node v : adj){
      v.print();
    }
  }

}