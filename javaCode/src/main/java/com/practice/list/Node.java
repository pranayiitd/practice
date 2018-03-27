package com.practice;

import java.util.*;

// class Node implements Comparable<Node>{
class Node {
   
  int index;
  int value;

  Node(int i, int v){
    this.index = i;
    this.value = v;
  }

  // @Override
  public int compareTo(Node n){
    return this.value - n.value;
    // return n.value - this.value;
  }

  public static Node[] createNodeList(int [] arr){
    Node[] nodeArr = new Node[arr.length];
    for(int i=0; i < arr.length; i++){
      nodeArr[i] = new Node(i, arr[i]);
    }
    return nodeArr;
  }

  public static void print(Node [] arr){
    for(Node n : arr){
      System.out.printf("%s, ", n.value);
    }
    System.out.println();
  }
}

// class Test{
//   public static void main(String arg[]){
//     int [] arr = {1, 2, 3, 4, 5, 11};
//     Node[] nArr = Node.createNodeList(arr);
//     Comparator<Node> nc = new Comparator<Node>(){
//       @Override
//       public int compare(Node n1, Node n2){
//         return n1.value - n2. value;
//         // return n2.value - n1. value;
//       }
//     };
//     Arrays.sort(nArr, nc);
//     Node.print(nArr);
//   }
// }