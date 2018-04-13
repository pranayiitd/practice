package com.practice.tree;


import org.junit.*;
import org.junit.Assert.*;
import java.util.*;

public class BSTUtilsTest{

  @Test
  public void test(){
    int [] arr = {11, 1, -111, 2000, 20, 25, 11, 11};
    Arrays.sort(arr);
    BNode root = BSTUtils.buildMinHeight(arr, 0, arr.length-1);
    BSTree bt = new BSTree(root);
    bt.print();
    bt.inorder();
  }
}