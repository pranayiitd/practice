import java.util.*;

class LRUCache {
    int maxSize;
    int currSize;
    HashMap<Integer, Integer> cacheMap;
    LinkedList<Integer> useList;
    
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        this.maxSize = N;
        this.currSize = 0;
        this.cacheMap = new HashMap<>();
        this.useList = new LinkedList<>();
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       Integer k = new Integer(x);
       if(cacheMap.containsKey(k)){
           Integer v = cacheMap.get(k);
           useList.remove(k);
           useList.addFirst(k);
           return v.intValue();
       }
       else{
           //System.out.print(cacheMap.keySet());
           return -1;
       }
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        Integer k = new Integer(x);
        Integer v = new Integer(y);
        if(currSize < maxSize){
            //Increase the cache size only if a new key
            if(!cacheMap.containsKey(x)){
                currSize++;
            }
            useList.remove(k);
            useList.addFirst(k);
            cacheMap.put(k, v);    
            
            
        }
        else{
            if(!cacheMap.containsKey(x)){
                Integer lru = useList.removeLast();
                cacheMap.remove(lru);
            }
            
            useList.remove(k);
            useList.addFirst(k);
            cacheMap.put(k, v);
        }
        
       
    }
}

/*

class LRUCache{
  
  class Node{
    String value;
    String key;
    Node next;
    Node prev;
    Node(String k, String v){
      key = k;
      value = v;
    }
  }
  
  class Dlist{
    Node head;
    Node tail;
    Dlist(Node h, Node t){
      head = h;
      tail = t;
    }
    
    public add(String key, String value){
      Node temp = new Node(key, value);
      head.prev = temp;
      head = temp;
    }
    
    public remove(Node n){
      if(n.prev != null){
        n.prev.next = n.next;
      }
      if(n.next != null){
        n.next.prev = n.prev;
      }
    }
  }
  
  HashMap<String, Node> cacheMap;
  Dlist usedKeys;
  int maxSize;
  int currSize;
  
  public LRUCache(int size){
    maxSize = size;
    currSize = 0;
    cacheMap = new HashMap<>();
    usedKeys = new LinkedList<>();
  }
  
  // if not in cache then return null
  public String get(String k){
    Node value = cacheMap.get(k);
    if(value == null){
      return null;
    }
    
    // getting the key at the front.
    usedKeys.remove(value);
    usedKeys.add(k, value.value);
    
    return value.value;
  }
  
  // if the cache is full, then replace
  public void put(String k, String v){
    if(currSize < maxSize){
      if(!caheMap.containsKey(k)){
        currSize++;
      }        
      cacheMap.put(k, v);      
      usedKeys.remove(k);
      usedKeys.addFirst(k);
    }
    else{
      if(!cacheMap.containsKey(k)){
        String lru = usedKeys.removeLast();
        cacheMap.remove(lru);
      }
      cacheMap.put(k, v);
      usedKeys.remove(k);
      usedKeys.addFirst(k);      
      
    } 
  }
  
}
*/
