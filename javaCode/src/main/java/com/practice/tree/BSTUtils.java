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

}