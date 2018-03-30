/*
 Given a list of words, find out k most frequent words
*/
package com.practice.heap;
import java.util.*;

class Node implements Comparable<Node>{
  String word;
  int count;
  Node(String w, int c){
    this.word = w;
    this.count = c;
  }

  @Override
  public int compareTo(Node n){
    //decreasing order
    return this.count - n.count;
  }
}

class TopWords{
  public static ArrayList<String> find(String [] words, int k){
    ArrayList<String> sol = new ArrayList<>();
    HashMap<String, Integer> wordCount = new HashMap<>();

    if(words == null || words.length == 0){
      return sol;
    }
    for(String word : words){
      Integer currCount = wordCount.get(word);
      if(currCount == null){
        wordCount.put(word, 1);
      }
      else{
        wordCount.put(word, currCount + 1);
      }
    }

    PriorityQueue<Node> topK = new PriorityQueue<>();
    for(Map.Entry<String, Integer> e : wordCount.entrySet()){
      String w = e.getKey();
      int c = e.getValue();
      if(topK.size() < k){
        topK.add(new Node(w, c));
      }
      else{
        Node minWord = topK.peek();
        if(c > minWord.count){
          topK.poll();
          topK.add(new Node(w, c));
        }
      }
    }

    for(Node topWord: topK){
      sol.add(topWord.word);
    }

    return sol;
  }
}