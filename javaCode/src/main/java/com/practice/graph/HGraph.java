import java.util.*;

class HGraph{

  HashMap<String, HashSet<String>> graph = new HashMap<>();
  HashMap<String, HashMap<String, Integer>> graphWeights = new HashMap<>();
  HashSet<String> srcList = new HashSet<>();
  HashSet<String> destList = new HashSet<>();
  String srcAuth;
  String destAuth;

  HGraph(String src, String dest){
    srcAuth = src;
    destAuth = dest;
  }

  public void addNode(String u){
    if(!graph.containsKey(u)){
      HashSet<String> neighbors = new HashSet<>();
      graph.put(u, neighbors);

    }
    if(!graphWeights.containsKey(u)){
      HashMap<String, Integer> neighbors = new HashMap<>();
      graphWeights.put(u, neighbors);
    }
  }

  public void addEdge(String u, String v){
    addNode(u);
    addNode(v);
    graph.get(u).add(v);
    graphWeights.get(u).put(v, Integer.parseInt(v) % 4);
  }

  public void buildEnds(String paperId, String [] authors){
   for(String auth : authors){

    if(auth.equals(srcAuth)){
      srcList.add(paperId);
    }

    if(auth.equals(destAuth)){
      destList.add(paperId);
    }
   }
  }

  public void buildEdges(String paperId, String [] refs){
    for(String ref: refs){
      if(ref.equals("-1")){
        continue;
      }
      addEdge(paperId, ref);
    }
  }

  public void buildGraph(String [] in){    
    for(String s : in){
      String [] paperDetails = s.split(":");
      String paperId = paperDetails[0];
      String [] authors = paperDetails[1].split(",");
      String [] refs = paperDetails[2].split(",");

      buildEnds(paperId, authors);
      buildEdges(paperId, refs);
    }
  }
  /******** FIND ALL PATH USING DFS ************/
  public void findPath(String paperId, HashSet<String> visited, ArrayList<String> result, String path){
    // Already visited or not a node in the graph
    if(visited.contains(paperId) || !graph.containsKey(paperId))
      return;
    visited.add(paperId);
    if(destList.contains(paperId)){
      result.add(path);
    }
    for(String ref : graph.get(paperId)){
      if(!visited.contains(ref)){
        findPath(ref, visited, result, path + "->" + ref);
      }
    }
    visited.remove(paperId);
  }

  public void findAllPaths(){
    ArrayList<String> result = new ArrayList<>();
   for(String srcPaper : srcList){
    HashSet<String> visited = new HashSet<>();
    findPath(srcPaper, visited, result, srcPaper + ":");
   }
   System.out.println(result);
  }
  /******** TOPOLOGICAL SORTING ************/
  public boolean findTopOrder(String node, ArrayList<String> order, HashMap<String, String> visited){
    if(visited.containsKey(node) && visited.get(node).equals("visited")){
      return true;
    }
    if(visited.containsKey(node) && visited.get(node).equals("visiting")){
      // order.clear();
      return false;
    }
    visited.put(node, "visiting");
    for(String child : graph.get(node)){
      if(!findTopOrder(child, order, visited)){
        // order.clear();
        return false;
      }
    }
    visited.put(node, "visited");
    order.add(node);
    return true;
  }

  public void findTopOrder(){
    ArrayList<String> order = new ArrayList<>();
    HashMap<String, String> visited = new HashMap<>();
    for(String n : graph.keySet()){
      if(!findTopOrder(n, order, visited)){
        System.out.println("Cycle.");
        break;
      }
    }
    Collections.reverse(order);
    System.out.println(order);
  }

  /******** DIJKSTRA SHORTED PATH ************/
  class Node implements Comparable<Node>{
    String vertex;
    int dist;
    Node(String v, int d){
        vertex = v;
        dist = d;
    }
    @Override
    public int compareTo(Node n){
        return this.dist - n.dist;
    }
  }

  public HashMap<String, Integer> dijkstra(String src){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    HashMap<String, Integer> minDist = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    for(String node : graph.keySet()){
        pq.add(new Node(node, Integer.MAX_VALUE));
        minDist.put(node, Integer.MAX_VALUE);
    }
    pq.add(new Node(src, 0));
    while(!pq.isEmpty()){
      Node curr = pq.poll();
      if(visited.contains(curr.vertex)){
        continue;
      }
      visited.add(curr.vertex);
      minDist.put(curr.vertex, curr.dist);
      for(String neigh : graph.get(curr.vertex)){
        int new_dist = curr.dist + graphWeights.get(curr.vertex).get(neigh);
        if(new_dist < minDist.get(neigh)){
          pq.add(new Node(neigh, new_dist));
        }
      }
    }
    return minDist;
  }


  public static void main(String arg[]){
    // one graph with cycles
   String [] in = {"101:u,p:102,103,104", "102:x:105", "103:y:-1", "104:z:107",
                   "105:r:106", "109:u:106,107","104:p:106","107:p:108", "108:u:106"};
    // forest without cycle
   // String [] in = {"101:u,p:102,103,104", "102:x:105", "103:y:-1", "104:z:107",
   //                 "105:r:106", "109:u:106,107","107:p:108", "108:u:106", "108:u:end",
   //                 "1061:p:1027"};
    HGraph hg = new HGraph("u", "p");
    hg.buildGraph(in);
    // System.out.println(hg.graphWeights.get("101"));
    // hg.findAllPaths();
    // hg.findTopOrder();
    System.out.println(hg.dijkstra("101"));
  }
}