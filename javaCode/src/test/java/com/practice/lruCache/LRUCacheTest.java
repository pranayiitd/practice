package com.practice.lruCache;

import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class LRUCacheTest{

  @Test
  public void testCache(){
    LRUCache<String, String> cache = new LRUCache<>(2);
    cache.put("pranay", "agarwal");
    cache.put("pranay1", "agarwal1");

    cache.put("pranay2", "agarwal2");
    cache.put("pranay3", "agarwal3");
    cache.put("pranay4", "agarwal4");
    String val = cache.get("pranay");
    assertEquals(null, val);

    val = cache.get("pranay3");
    assertEquals("agarwal3", val);


    assertEquals(2, cache.size());
  }  

  @Test
  public void testFake(){
    System.out.println("run one test method");
  }
}