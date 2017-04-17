package com.practice.lruCache;

class Node<K, V>{
  K key;
  V value;

  Node prev;
  Node next;
  
  Node(K k , V v){
    key = k;
    value = v;
  }
}
