package com.practice.graph;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

import java.io.*;


public class GraphTest{
  @Test
  public void test(){
    // /Get file from resources folder
  String fileName = "graph.txt";

  ClassLoader classLoader = getClass().getClassLoader();
  File f = new File(classLoader.getResource(fileName).getFile());
  try {
     Scanner sc = new Scanner(f);
      int n = sc.nextInt();
      int e = sc.nextInt();
      Graph g = new Graph(n);
      for(int i = 0; i < e; i++){
        int v = sc.nextInt();
        int u = sc.nextInt();
        g.addEdge(u, v);
      }
      g.print();

    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
  }
} 