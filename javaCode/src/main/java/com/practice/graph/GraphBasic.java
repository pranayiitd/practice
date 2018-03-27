import java.util.*;
import java.io.*;
// #####################################################
// # The Assumption is that it's all int based node
//    each node has int as index, and node doesn't contain any more
//    information.
// #Author: Pranay Agarwal agarwalpranaya@gmail.com
// #####################################################
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
  public void dfs(int s, boolean [] visited){
    if(visited[s])
      return;
    System.out.println(s);
    visited[s] = true;
    LinkedList<Integer> children = getNeighbors(s);
    for(Integer c : children){
      if(!visited[c])
        dfs(c, visited);
    }
  }

  // print a BFS traversal from source s
  public void bfs(int s){
    ArrayList<Integer> bfsList = new ArrayList<>();
    boolean [] visited = new boolean[V];
    bfsList.add(s);
    while(!bfsList.isEmpty()){
      int n = bfsList.remove(0);
      visited[n] = true;
      System.out.println(n);
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

  public static void main(String argv[]){
    try {
      File f = new File("data/graph.txt");
      Scanner sc = new Scanner(f);
      int n = sc.nextInt();
      int e = sc.nextInt();
      GraphBasic g = new GraphBasic(n);
      for(int i = 0; i < e; i++){
        int v = sc.nextInt();
        int u = sc.nextInt();
        g.addEdge(u, v);
      }
      int s = sc.nextInt();
      boolean[] visited = new boolean[n];
      System.out.println("BFS");
      g.bfs(s);
      System.out.println("DFS");
      g.dfs(s, visited);

    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
  }
}