package com.practice.tree;

import java.util.*;

// Good source code to take a look
// http://algs4.cs.princeton.edu/32bst/BST.java.html
public class BSTree{
  BNode root;
  int count;

  BSTree(BNode r){
    this.root = r;
  }

  BSTree(int v){
    root = new BNode(v);
    count = 1;
  }

  public boolean insert(int v){
    root = insert(root, v);
    count++;
    return true;
  }

  BNode insert(BNode node, int v){
    if(node == null){
      return new BNode(v);
    }
    if(v <= node.value){
      node.left = insert(node.left, v);
    }
    else{
      node.right = insert(node.right, v);
    }

    return node;
  }

  public void insert_it(int v){
    BNode newNode = new BNode(v);
    if(root == null){
      root = newNode;
    }

    BNode parent = null;
    BNode curr = root;
    while(curr != null){
      parent = curr;
      if(v > curr.value){
        curr = curr.right;
      }
      else{
        curr = curr.left;
      }
    }
    if(v <= parent.value){
      parent.left = newNode;
    }
    else{
      parent.right = newNode;
    }
  }

  public boolean find(int v){
    return find(root, v);
  }

  boolean find(BNode node, int v){
    if(node == null){
      return false;
    }
    if(node.value == v){
      return true;
    }
    if(v > node.value){
      return find(node.right, v);
    }
    return find(node.left, v);
  }

  public boolean find_it(int v){
   BNode temp = root;
   while(temp != null){
    if(v > temp.value){
      temp = temp.right;
    }
    else if(v < temp.value){
      temp = temp.left;
    }
    else{
     return true;
    }
   }
   return false;
  }

  public void delete(int v){
    root = delete(root, v);
  }

  BNode delete(BNode n, int v){
    if(n == null){
      return null;
    }
    if(v > n.value){
      n.right = delete(n.right, v);
    }
    else if(v < n.value){
      n.left = delete(n.left, v);
    }
    else{
      //We found the node to be deleted.
      if(n.left == null){
        return n.right;
      }
      if(n.right == null){
        return n.left;
      }
      //Both children present.
      BNode temp = n;

      //updating node with it's succ
      n = findMin(temp.right);

      //Below call free up succ node with it's old parent
      n.right = deleteMin(temp.right);
      n.left = temp.left;
    }
    return n;
  }

  //Make sure it's not called with null n
  BNode findMin(BNode n){
    if(n.left == null){
      return n;
    }
    return findMin(n.left);
  }

  //Make sure it's not called with null n
  BNode deleteMin(BNode n){
   if(n.left == null){
    return n.right;
   }
   n.left = deleteMin(n.left);
   return n;
  }

  public void inorder(){
    inorder(root);
    System.out.println();
  }

  void inorder(BNode node){
    if(node == null){
      return;
    }
    inorder(node.left);
    System.out.printf(node.value + ", ");
    inorder(node.right);
  }


  /*
  Some printing Utils, effort to print Tree like outpout.
  */
  public void print(){
    HashMap<Integer, ArrayList<BNode>> treeMap = new HashMap<>();

    print(treeMap, root, 0, 50);
    for(Map.Entry<Integer, ArrayList<BNode>> entry : treeMap.entrySet()){
      int depth = entry.getKey();
      ArrayList<BNode> elems = entry.getValue();
      String[] output = new String[100];
      // System.out.printf("%s : %s\n", depth, elems);
      for(BNode e : elems){
        String l = (e.left == null) ? "" : e.left.value + "";
        String r = (e.right == null) ? "" : e.right.value + "";

        output[e.pos] = e.value + String.format("[%s, %s]", l, r);
      }
      System.out.println(printArr(output));
    }
  }

  String printArr(String[] arr){
    StringBuilder sb = new StringBuilder();
    for(String o : arr){
      if(o != null){
        sb.append(o);
      }
      sb.append(" ");
    }
    return sb.toString();
  }

  void print(HashMap<Integer, ArrayList<BNode>> treeMap, BNode node, int depth, int weidth){
    if(node == null){
      return;
    }
    ArrayList<BNode> elems = treeMap.get(depth);
    if(elems == null){
      elems = new ArrayList<>();
    }
    node.pos = weidth;
    elems.add(node);
    treeMap.put(depth, elems);

    print(treeMap, node.left, depth + 1, weidth - 10);
    print(treeMap, node.right, depth + 1, weidth + 10);
  }

}