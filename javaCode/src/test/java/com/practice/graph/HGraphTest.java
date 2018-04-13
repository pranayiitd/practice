package com.practice.graph;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

import java.io.*;


public class HGraphTest{
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

  @Test
  public void test2(){
        // one graph with cycles
   String [] in = {"101:u,p:102,103,104", "102:x:105", "103:y:-1", "104:z:107",
                   "105:r:106", "109:u:106,107","104:p:106","107:p:108", "108:u:106"};
    // forest without cycle
   // String [] in = {"101:u,p:102,103,104", "102:x:105", "103:y:-1", "104:z:107",
   //                 "105:r:106", "109:u:106,107","107:p:108", "108:u:106", "108:u:end",
   //                 "1061:p:1027"};
    HGraph hg = new HGraph("u", "p");
    hg.buildGraph(in);
    System.out.println(hg.graphWeights.get("101"));
    hg.findAllPaths();
    hg.findTopOrder();
    System.out.println(hg.dijkstra("101"));
  }
} 