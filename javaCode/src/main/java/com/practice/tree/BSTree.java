/*
class Node{
  int data;
  Node left;
  Node right;
  int space;

  public Node(int data){
    this.data = data;
  }
}
// Good source code to take a look
// http://algs4.cs.princeton.edu/32bst/BST.java.html
class BSTree{
  Node root;

  public void insert(int v){
    root = insert(root, v);
  }
  private Node insert(Node n, int v){
    if(n == null)
      return new Node(v);
    if(v <= n.data){
      n.left = insert(n.left, v);
    }
    else{
     n.right = insert(n.right, v);
    }
    return n;
  }
  // Iterative
  public void insert_it(int v){
    Node new_n = new Node(v);
    if(root == null){
      root = new_n;
      return;
    }
    Node temp = root;
    Node parent = null;
    while(temp != null){
      parent = temp;
      if(v <= temp.data){
        temp = temp.left;
      }
      else{
        temp = temp.right;
      }
    }
    if(v <= parent.data)
      parent.left = new_n;
    else
      parent.right = new_n;

  }

  public Node find(int v){
    return find(root, v);
  }

  private Node find(Node n, int v){
    if(n == null)
      return null;
    if(v < n.data)
      return find(n.left, v);
    if(v > n.data)
      return find(n.right, v);
    return n;
  }

  public Node find_it(int v){
    if(root == null || root.data == v)
      return root;
    Node temp = root;
    while(temp != null && temp.data != v){
      if(v <= temp.data)
        temp = temp.left;
      else
        temp = temp.right;
    }
    return temp;
  }

  public void delete(int v){
   root = delete(root, v);
  }

  private Node delete(Node n, int v){
    if(n == null)
      return null;
    if(v < n.data){
      n.left = delete(n.left, v);
    }
    else if(v > n.data){
      n.right = delete(n.right, v);
    }
    else{
     if(n.left == null){
      return n.right;
     }
     if(n.right == null){
      return n.left;
     }
     // has 2 children
     Node succ = findMin(n.right);
     n.data = succ.data;
     // Important to update the right child
     n.right = delete(n.right, succ.data);
    }
     return n;
  }

/**********************************
  Utils methods
/**********************************

  
  public Node findMin(Node n){
    if(n == null || n.left == null)
      return n;
    return findMin(n.left);
  }
  public void inorder(){
    inorder(root);
    System.out.println();
  }

  private void inorder(Node n) {
    if(n == null)
      return;
    inorder(n.left);
    System.out.print(n.data + ",");
    inorder(n.right);
  }

  public void preorder(){
    preorder(root);
    System.out.println();
  }

  private void preorder(Node n){
    if(n == null)
      return;
    System.out.print(n.data + ",");
    preorder(n.left);
    preorder(n.right);
  }

  public int getHeight(Node n){
    if(n == null)
      return -1;
    int l = getHeight(n.left);
    int r = getHeight(n.right);
    return 1 + Math.max(l, r);
  }

  public static void main(String arg []){
    BSTree bst = new BSTree();
    int [] arr = {10 , 1 , 23, 11, -1, 0, 0, 1, 1, 1, 14, 12, 15, 25};
    for(int i : arr){
      bst.insert_it(i);
    }
    // bst.preorder();
    bst.inorder();
    // Node n = bst.find_it(-1);
    // bst.inorder(n);
    bst.delete(23);
    bst.inorder();
  }
}
*/