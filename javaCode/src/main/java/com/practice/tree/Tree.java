class Node{
  int data;
  Node left;
  Node right;
}
class Tree{

  Node root;

  // Traversals
  void inOrder(Node root) {
    if(root == null)
      return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  void preOrder(Node root) {
      if(root == null)
        return;
      System.out.print(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }

  void postOrder(Node root) {
      if(root == null)
        return;
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data + " ");
    }

  int getHeight(Node root) {
    if (root == null)
      return -1;
    int l = getHeight(root.left);
    int r = getHeight(root.right);
    return 1 + Math.max(l, r);
    }

  void LevelOrder(Node root){
    if (root == null)
      return;
    ArrayList<Node> al = new ArrayList<>();
    al.add(root);
    while(!al.isEmpty()){
     Node temp = al.remove(0);
     System.out.print(temp.data + " ");
     if(temp.left != null)
       al.add(temp.left);
     if(temp.right != null)
       al.add(temp.right);
    } 
  }

}