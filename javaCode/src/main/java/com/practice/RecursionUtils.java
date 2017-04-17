import java.util.*;

class RecursionUtils{
  public static void powerSet(int [] arr, int i, ArrayList<ArrayList<Integer>> al){
    if(i == arr.length)
      return;
    ArrayList<ArrayList<Integer>> alNew = new ArrayList<>();
    for(ArrayList<Integer> s : al){
      // This is right way to clone
      // NOTE: s.clone() is NOT the right way
      ArrayList<Integer> sClone = new ArrayList<Integer>(s);
      sClone.add(arr[i]);
      alNew.add(sClone);
    }
    al.addAll(alNew);
    powerSet(arr, i+1, al);
  }
  public static void runPowerSet(){
   int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      ArrayList<ArrayList<Integer>> al = new ArrayList<>();
      al.add(new ArrayList<Integer>());
      powerSet(arr, 0, al);
      for(ArrayList<Integer> e : al){
        System.out.println(e);
      }
      System.out.println(al.size());
  }

  /**** Generate all perumatation of a String with unique chars ****/
  public static ArrayList<String> permute(String s, char c){
    if(s == null || c == ' ')
      return null;
    ArrayList<String> al = new ArrayList<>();
    for(int i=0; i<= s.length(); i++){
      StringBuilder sb = new StringBuilder(s);
      sb.insert(i, c);
      al.add(sb.toString());
    }
    return al;
  }
  public static ArrayList<String> permuteString(String s, int i){
    if(i < 0){
      ArrayList<String> al = new ArrayList<>();
      al.add("");
      return al;
    }
    ArrayList<String> alPre = permuteString(s, i-1);
    ArrayList<String> al = new ArrayList<>();
    char c = s.charAt(i);
    for(String sPre : alPre){
      al.addAll(permute(sPre, c));
    }
    return al;
  }

  /** Generate all permutation of a String with duplicate chars ***/
  public static HashMap<Character, Integer> buildMap(String s){
    HashMap<Character, Integer> frequenyMap = new HashMap<>();
    for(char c :  s.toCharArray()){
      if(frequenyMap.containsKey(c)){
        int count = frequenyMap.get(c);
        frequenyMap.put(c, count + 1);
      }
      else{
        frequenyMap.put(c, 1);
      }
    }
    return frequenyMap;
  }
  
  public static void permuteAll(String prefix, HashMap<Character, Integer> fMap,
                         int len, ArrayList<String> result){
    if(len == 0){
      result.add(prefix);
      return;
    }
    for(char c : fMap.keySet()){
      if(fMap.get(c) > 0){
        int count = fMap.get(c);
        fMap.put(c, count -1);
        permuteAll(prefix + c, fMap, len -1, result);
        fMap.put(c, count);
      }
    }

  }


  /** count ways to make change from infinite set of smaller denoms **/
  // denoms sorted ascending
  public static int makeChange(int n, int i, int [] denoms, int [][] map){
    if(i >= denoms.length)
      return 0;
    if(n == 0)
      return 1;
    if(map[n][i] > 0)
      return map[n][i];
    int ways = 0;
    int k = 0;
    while(n >= denoms[i] && (n - k * denoms[i] >= 0)){
      ways += makeChange(n - k * denoms[i], i + 1, denoms, map);
      k++;
    }
    map[n][i] = ways;
    return ways;
  }


  public static void main(String arg[]){
    // runPowerSet();
    // System.out.println(permute("abc", 'd'));
    // System.out.println(permute("", 'd'));
    // System.out.println(permuteString("abcde", 4));
    // System.out.println(permuteString("abcde", 4).size());
    // int [] denoms = {1, 5, 10, 25};
    // int n = 2000;
    // int[][] map = new int[n+1][denoms.length];
    // System.out.println(makeChange(n, 0, denoms, map));
    String s = "aab";
    HashMap<Character, Integer> fMap = buildMap(s);
    ArrayList<String> result = new ArrayList<>();
    permuteAll("", fMap, s.length(), result);
    System.out.println(result);
    System.out.println(permuteString(s, s.length()-1));

    // for(Map.Entry<Character, Integer> et : map.entrySet()){
    //   System.out.format("%s : %s\n", et.getKey(), et.getValue());
    // }


   }
 }