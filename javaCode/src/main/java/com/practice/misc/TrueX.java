import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class TrueX {
  
  static class Node implements Comparable<Node>{
    String word;
    int count;

    @Override
    public int compareTo(Node n){
      //todo change order?
      return this.count - n.count;
    }
    
    Node(int c, String s){
     this.word = s;
     this.count = c;
    }
  }
  
  public static ArrayList<String> findTop(int k, String [] words){
    ArrayList<String> sol = new ArrayList<String>();
    if(words == null || words.length < 1){
      return sol;
    }
 
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    HashMap<String, Integer> wordCount = new HashMap<>();
    
    for(String word : words){
      
      if(wordCount.containsKey(word)){
        int oldCount = wordCount.get(word);
        wordCount.put(word, oldCount+1);
      }
      else{
       wordCount.put(word, 1);
      }
      
       
       for(Node n : pq){
        if(n.word.equals(word)){
          pq.remove(n);
        }
       }
        
       pq.add(new Node(wordCount.get(word), word)); 
      
      if(pq.size() < k){
       pq.add(new Node(wordCount.get(word), word));
       continue;
      }
      
      int minHeap = pq.peek().count;
      
      if(minHeap < wordCount.get(word)){
       pq.poll();
       pq.add(new Node(wordCount.get(word), word));
      }
      
    }
    
    while(pq.size() != 0){
     sol.add(pq.poll().word);
    }
     
    return sol;
  }
  
  
  public static void main(String[] args) {
//    ArrayList<String> strings = new ArrayList<String>("cat", "dog", "lizard", "cat", "bird", "lizard", "cow", "sheep");
    
    // find the top 5 most common appearing strings
    // ArrayList("lizard", "cat", "bird", "dog", "cow")
    
    String [] arr = {"cat", "dog", "lizard", "cat", "bird", "lizard", "cow", "sheep"};
    
    System.out.println(findTop(5, arr));

  
  }
}
