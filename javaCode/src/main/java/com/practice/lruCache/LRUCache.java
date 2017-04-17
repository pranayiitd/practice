package com.practice.lruCache;

import java.util.*;

class LRUCache<K, V> implements LRUCacheInterface<K, V>{
  HashMap<K, Node<K,V>> cacheMap;
  NodeDlist accessList; 
  int maxSize;


  LRUCache(int size){
    cacheMap = new HashMap<>();
    accessList = new NodeDlist();
    maxSize = size;
  }

  public int size(){
    return cacheMap.size();
  }

  public V get(K k){
    Node<K,V> val = cacheMap.get(k);
    if(val == null){
      return null;
    }
    accessList.moveToFront(val);
    return val.value;
  }

  public int put(K k , V v){
    Node<K, V> val = new Node<>(k, v);
    cacheMap.put(k, val);
    accessList.add(val);
    // Remove the least recently used
    if(cacheMap.size() > maxSize){
      System.out.println(cacheMap.size());
     Node<K, V> lru = accessList.removeFromLast();
     cacheMap.remove(lru.key);
     return 0;
    }
    return 1;
  }
}