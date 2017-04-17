import java.util.*;

class JavaGeneric{
  interface HashMapCustomInterface<K, V>{
    // returns the value for a given key
    public V get(K k);
    // Puts/creates mapping k -> v
    public void put(K k, V v);
  } 


  // Note: Only generic class can implement generic interface
  // Below will compile to Error:
  // class HashMapCustom implements HashMapCustomInterface<K, V>{
  // Below will work:
  // class HashMapCustom implements HashMapCustomInterface<String, String>{
  class HashMapCustom<K, V> implements HashMapCustomInterface<K, V>{
    class Node{
      K key;
      V value;
      Node(K k, V v){
        key = k;
        value = v;
      }
    }
    ArrayList<ArrayList<Node>> map = new ArrayList<>();
    int max_size;
    HashMapCustom(int size){
      max_size = size;
      for(int i = 0; i < size; i++){
        map.add(null);
      }
    }

    // Convert any key type into integer index
    public int getHash(K k){
      return k.hashCode() % max_size;
    }

    public V get(K k){
      int key_index = getHash(k);
      ArrayList<Node> val = map.get(key_index);
      if(val != null){
        for(Node n: val){
          if(n.key == k){
            return n.value;
          }
        }
      }
      return null;
    }

    public void put(K k, V v){
      int key_index = getHash(k);
      ArrayList<Node> val = map.get(key_index);
      Node n = new Node(k, v);
      if(val == null){
        val = new ArrayList<Node>();
        val.add(n);
        map.set(key_index, val);
      }
      else{
        for(Node e : val){
          if(e.key == k){
            e.value = v;
            return;
          }
        }
        val.add(n);
      }
    }
  }

  // ******************************************* //
  HashMapCustom hashMap;
  JavaGeneric(int size){
    hashMap = new HashMapCustom<String, String>(size);
  }


 public static void main(String arg[]){
  JavaGeneric jc = new JavaGeneric(2);
  jc.hashMap.put("1", "One");
  jc.hashMap.put("2", "Two");
  jc.hashMap.put("3", "Three");
  jc.hashMap.put("4", "Four");
  System.out.println(jc.hashMap.get("1"));
  System.out.println(jc.hashMap.get("2"));
  System.out.println(jc.hashMap.get("3"));
  System.out.println(jc.hashMap.get("4"));
  System.out.println(jc.hashMap.map.get(0));
  // HashMapCustom h = new HashMapCustom();
 }
}