package com.practice.graph;

import java.util.*;
import java.io.*;

class GraphBasic{
  int V;
  int E;
  // List of vertices
  LinkedList<Integer> [] adj;

  // Initialize graph of v nodes, no edges
  // Nodes indexed 0 to v-1
  public GraphBasic(int v){
    this.V = v;
    adj = new LinkedList[v];
    for(int i=0; i<v; i++){
      adj[i] = new LinkedList<Integer>();
    }
  }

  // Assuming non-directional graph
  // adding edges both ways
  // If direction then add only one way and treat as such
  public void addEdge(int v, int u){
    // Can add some validation code here but meh.
    this.E++;
    adj[v].add(u);
    adj[u].add(v);
  }

  public LinkedList<Integer> getNeighbors(int v){
    return adj[v];
  }

  public void print(){
    for(int i=0; i < adj.length; i++){
      System.out.format("%s :", i);
      LinkedList v = adj[i];
      System.out.println(v);
    }
    System.out.format("V: %s, E: %s\n", V, E);
  }

  // print a DFS traversal from source s
  public void dfs(int s, boolean [] visited, ArrayList<Integer> output){
    if(visited[s]){
      return;
    }
    // System.out.println(s);
    output.add(s);
    visited[s] = true;
    LinkedList<Integer> children = getNeighbors(s);
    for(Integer c : children){
      if(!visited[c]){
        dfs(c, visited, output);
      }
    }
  }

  // print a BFS traversal from source s
  public void bfs(int s, ArrayList<Integer> output){
    ArrayList<Integer> bfsList = new ArrayList<>();
    boolean [] visited = new boolean[V];
    bfsList.add(s);
    while(!bfsList.isEmpty()){
      int n = bfsList.remove(0);
      visited[n] = true;
      output.add(n);
      // System.out.println(n);
      LinkedList<Integer> children = getNeighbors(n);
      for(Integer c : children){
        if(!visited[c]){
          // So that this node not added again via other node edge
          visited[c] = true;
          bfsList.add(c);
        }
      }
    }
  }
}