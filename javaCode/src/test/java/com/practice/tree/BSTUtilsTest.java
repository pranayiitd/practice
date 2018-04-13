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

  @Test
  public void testFindLCA(){
    int [] arr = {11, 1, 111, 2000, 20, 25, 12, 13};
    // Arrays.sort(arr);
    BNode root = BSTUtils.buildMinHeight(arr, 0, arr.length-1);
    BSTree bt = new BSTree(root);
    bt.print();
    // bt.inorder();
    System.out.printf("lca of (%s, %s) = %s\n", 12, 20, BSTUtils.findLCA(root, 12, 20).value);
    System.out.printf("lca of (%s, %s) = %s\n", 13, 20, BSTUtils.findLCA(root, 13, 20).value);
    System.out.printf("lca of (%s, %s) = %s\n", 11, 13, BSTUtils.findLCA(root, 11, 13).value);
    System.out.printf("lca of (%s, %s) = %s\n", 11, 113, BSTUtils.findLCA(root, 11, 113));
  }
}