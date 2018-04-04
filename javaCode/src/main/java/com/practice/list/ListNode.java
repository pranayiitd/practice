package com.practice.list;

class ListNode{
  int value;
  ListNode next;
  ListNode prev;

  ListNode(int v){
    this.value = v;
  }

  ListNode(int v, ListNode n){
    this.value = v;
    this.next = n;
  }

  ListNode(int v, ListNode n, ListNode p){
    this.value = v;
    this.next = n;
    this.prev = p;
  }
}