package com.practice.lruCache;

interface LRUCacheInterface<K, V>{
  public V get(K k);

  // return 0 if cache size remains same.
  // return 1 if the cache size increament by 
  public int put(K k, V v);
}