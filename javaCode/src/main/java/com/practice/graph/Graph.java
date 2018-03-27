import java.util.*;
import java.io.*;

class Graph{
  
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

  public static void main(String argv[]){
    try {
      File f = new File("data/graph.txt");
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