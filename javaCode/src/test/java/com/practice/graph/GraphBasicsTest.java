package com.practice.graph;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

// import java.io.File;
import java.io.*;
// import java.util.Scanner;


public class GraphBasicsTest{
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
      System.out.printf("V: %s, E: %s\n", n, e);
      GraphBasic g = new GraphBasic(n);
      for(int i = 0; i < e; i++){
        int v = sc.nextInt();
        int u = sc.nextInt();
        g.addEdge(u, v);
      }
      //Source of the graph or staring point.
      int s = sc.nextInt();
      ArrayList<Integer> output = new ArrayList<>();

      System.out.println("BFS");
      g.bfs(s, output);
      System.out.println(output);
      output.clear();


      System.out.println("DFS");

      boolean[] visited = new boolean[n];
      g.dfs(s, visited, output);
      System.out.println(output);

    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
  }
} 