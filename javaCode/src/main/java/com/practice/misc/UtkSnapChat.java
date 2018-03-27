import java.util.*;

class Node{
  String name;
  ArrayList<Node> children;
  Node(String n){
    name = n;
    children = new ArrayList<>();
  }

  void addChild(Node n ){
    children.add(n);
  }
}

class Test{

  public static int findBoss(String emp1, String emp2, Node parent, Node root, ArrayList<Node> result){
    if(root == null){
      return -1;
    }
    int sol1 = 0;
    if(root.name == emp1 || root.name == emp2){
      sol1 = 1;
    }
    int sol2 = 0;
    for(Node c : root.children){
      int childSol = findBoss(emp1, emp2, root, c, result);
      if(childSol == 3){
        return 3;
      }
      if(childSol != -1){
        sol2 += childSol;
      }
    }
    if(sol2 == 2){
      result.add(root);
      return 3;
    }
    if(sol1 == 1 && sol2 == 1){
      result.add(parent);
      return 3;
    }

    return sol2 + sol1;

  }

  public static void main(String arg[]){
    Node evan = new Node("evan");
    Node mike = new Node("mike");
    Node dave = new Node("dave");
    Node alex = new Node("alex");
    evan.addChild(mike);
    evan.addChild(dave);
    evan.addChild(alex);

    Node pranay = new Node("pranay");
    Node utk = new Node("utk");
    Node ravee = new Node("ravee");
    Node ram = new Node("ram");
    mike.addChild(pranay);
    dave.addChild(utk);
    dave.addChild(ravee);
    alex.addChild(ram);
    ArrayList<Node> result = new ArrayList<>();
    findBoss("evan", "mike", null, evan, result);
    System.out.println(result.get(0).name);

  }
}