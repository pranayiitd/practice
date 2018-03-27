import java.util.*;

class BTreeNode{
  int data;
  BTreeNode left;
  BTreeNode right;
  BTreeNode parent;

  BTreeNode(int v){
    this.data = v;
  }

  public static BTreeNode buildMinHeight(int [] arr, int start, int end){
    if(start > end)
      return null;
    int mid = (start + end)/2;
    int rootValue = arr[mid];
    BTreeNode root = new BTreeNode(rootValue);
    root.left = buildMinHeight(arr, start, mid - 1);
    root.right = buildMinHeight(arr, mid + 1, end);
    return root;
  }

  public static void inOrder(BTreeNode root){
    if(root == null)
      return;
    inOrder(root.left);
    System.out.println(root.data);
    inOrder(root.right);
  }

  public static int findLCA(BTreeNode root, int p, int q, ArrayList<BTreeNode> result){
    if(root == null)
      return 0;
    int l = findLCA(root.left, p, q, result);
    if(l == 3)
      return 3;
    int r = findLCA(root.right, p, q, result);
    if(r == 3)
      return 3;
    if(l == 1 && r == 1){
      result.add(root);
      return 3;
    }
    if(root.data == p || root.data == q){
      if(l + r == 1){
        result.add(root);
        return 3;
      }
      return l + r +1;
    }
    else{
      return l + r;
    }
  }

  public static BTreeNode findLCA_2(BTreeNode root, int p, int q){

    if(root == null)
      return null;

    if(root.data == p || root.data == q)
      return root;

    BTreeNode left = findLCA_2(root.left, p, q);
    BTreeNode right = findLCA_2(root.right, p, q);
    if(left != null && right != null){
      return root;
    }

    return (left == null) ? right : left;
  }



  public static void main(String arg[]){
    int [] arr = {1, 2, 3, 4, 5, 10};
    BTreeNode root = BTreeNode.buildMinHeight(arr, 0, arr.length -1);
    System.out.println(root.data);
    // System.out.println(root.right.data);
    // BTreeNode.inOrder(root);
    ArrayList<BTreeNode> result = new ArrayList<>();
    BTreeNode.findLCA(root, 5, 7, result);
    System.out.println(result.get(0).data);

    BTreeNode r = BTreeNode.findLCA_2(root, 5, 7);
    System.out.println(r.data);
  }
}