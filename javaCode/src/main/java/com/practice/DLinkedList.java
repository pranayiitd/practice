class DNode<K, V>{
  K key;
  V value;
  DNode prev;
  DNode next;

  DNode(K k, V v){
    key = k;
    value = v;
    // prev = p;
    // next = n;
  }
}
class DLinkedList{
  int size;
  DNode<Integer, Integer> head;
  DNode<Integer, Integer> tail;

  public void add(int k, int v){
    DNode<Integer, Integer> newNode = new DNode<>(k, v);
    if(size == 0){
      head = newNode;
      tail = newNode;
    }
    else{
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    size++;
  }

  public void print(){
    DNode temp = head;
    while(temp != null){
      System.out.printf("(%s, %s), ", temp.key, temp.value);
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String arg[]){
    int [] arr = {1, 2, 3, 4, 5, 6};
    DLinkedList dlist = new DLinkedList();
    for(int e : arr){
      dlist.add(e, e*e);
    }
    dlist.print();
  }
}