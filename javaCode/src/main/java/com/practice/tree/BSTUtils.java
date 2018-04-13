package com.practice.tree;

import java.util.*;

class BSTUtils{

   //Inclusive of both the indices  
   public static BNode buildMinHeight(int [] arr, int start, int end){
    if(start > end)
      return null;
    int mid = (start + end)/2;
    int rootValue = arr[mid];
    BNode root = new BNode(rootValue);
    root.left = buildMinHeight(arr, start, mid - 1);
    root.right = buildMinHeight(arr, mid + 1, end);
    return root;
  }

  public static BNode findLCA(BNode root, int p, int q){
    ArrayList<Integer> nodes = new ArrayList<>();
    BNode lca = findLCA(root, p, q, nodes);

    if(nodes.contains(p) && nodes.contains(q)){
      return lca;
    }
    return null;
  }

  public static BNode findLCA(BNode root, int p, int q, ArrayList<Integer> nodes){
    if(root == null){
      return null;
    }
    if(root.value == p){
      nodes.add(root.value);
      return root;
    }
    if(root.value == q){
      nodes.add(root.value);
      return root;
    }

    BNode leftLCA = findLCA(root.left, p, q, nodes);
    BNode rightLCA = findLCA(root.right, p, q, nodes);
    if(leftLCA != null && rightLCA != null){
    // System.out.printf("root: %s, left: %s, right: %s\n", root.value, leftLCA.value, rightLCA.value);
      return root;
    }

    return (leftLCA != null) ? leftLCA : rightLCA;
  }

}