package com.practice.list;

class SList{
  ListNode head;
  ListNode tail;

  SList(int v){
    head = new ListNode(v);
    tail = head;
  }

  //Insert the value at the end of the list
  public void insert(int v){
    if(head == null){
      head = new ListNode(v);
      tail = head;
    }
    else{
      tail.next = new ListNode(v);
      tail = tail.next;
    }
  }

  //Delete elem from the front of the list
  public int delete(){
    if(head == null){
      return -1;
    }
    int ret = head.value;
    head = head.next;

    //If we are deleting the last elem, then make the tail null as well.
    if(head == null){
      tail = null;
    }
    return ret;
  }

  //delete node with value v if present (just delete the first occurance)
  public boolean delete(int v){
    return delete(v, head, null);
  }

  boolean delete(int v, ListNode curr, ListNode prev){
    if(curr == null){
      return false;
    }
    if(curr.value == v){
      //head needs to deleted
      if(prev == null){
        head = head.next;
        if(head == null){
          tail = null;
        }
        return true;
      }
      if(curr.next == null){
        prev.next = null;
        tail = prev;
        return true;
      }
      prev.next = curr.next;
      return true;
    }
    return delete(v, curr.next, curr);
  }

  public boolean find(int v){
    return find(v, head);
  }

  boolean find(int v, ListNode n){
    if(n == null){
      return false;
    }
    if(n.value == v){
      return true;
    }
    return find(v, n.next);
  }

  public void print(){
    print(head);
    String headStr = (head == null ? "null" : head.value + "");
    String tailStr = (tail == null ? "null" : tail.value + "");
    System.out.printf("head: %s\n", headStr);
    System.out.printf("tail: %s\n", tailStr);
  }

  void print(ListNode n){
    if(n == null){
      System.out.println();
      return;
    }
    System.out.printf("%s->", n.value);
    print(n.next);
  }
}