package com.practice.lruCache;

class NodeDlist{
  Node head;
  Node tail;

  public void add(Node n){
    if(head == null){
      head = n;
      tail = n;
      return;
    }
    n.next = head;
    head.prev = n;
    head = n;
  }

  public void remove(Node n){
    if(n == head){
      head = n.next;
    }
    if(n == tail){
      tail = n.prev;
    }
    if(n.next != null){
      n.next.prev = n.prev;
    }
    if(n.prev != null){
      n.prev.next = n.next;
    }
  }

  public void moveToFront(Node n){
    remove(n);
    add(n);
  }

  public Node removeFromLast(){
    Node temp = tail;
    System.out.println(head.value);
    System.out.println(tail.value);
    // remove(tail);
    tail = tail.prev;
    return temp;
  }
}