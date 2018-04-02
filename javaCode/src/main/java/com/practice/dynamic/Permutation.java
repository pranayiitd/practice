package com.practice.dynamic;

import java.util.*;


class Permutation{

  public static ArrayList<String> generateUnique(String str, ArrayList<String> sol, int i){
    if(i >= str.length()){
      return sol;
    }
    char c = str.charAt(i);
    ArrayList<String> sol2 = new ArrayList<>();
    for(String word: sol){
      for(int j=0; j<= word.length(); j++){
        StringBuilder  sb = new StringBuilder(word);
        sb.insert(j, c);
        sol2.add(sb.toString());
      }
    }

    return generateUnique(str, sol2, i+1);
  }

  /*
  generate all the perm of str, n! where it has unique chars
  */
  public static ArrayList<String> generateUnique(String str){
    ArrayList<String> sol = new ArrayList<>();
    if(str == null || str.length() < 1){
      return sol;
    }
    sol.add("" + str.charAt(0));
    return generateUnique(str, sol, 1);
  }


  public static HashMap<Character, Integer> buildCharMap(String str){
    HashMap<Character, Integer> countMap = new HashMap<>();
    for(char c : str.toCharArray()){
      Integer count = countMap.get(c);
      if(count == null){
        countMap.put(c, 1);
      }
      else{
        countMap.put(c, count+1);
      }
    }
    return countMap;
  }

  public static void generate(
    String str, 
    String prefix, 
    HashMap<Character, Integer> countMap,
    ArrayList<String> sol){
    if(prefix.length() >= str.length()){
      sol.add(prefix);
    }
    for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
      char c = entry.getKey();
      int count = entry.getValue();
      if(count > 0){
        countMap.put(c, count-1);
        generate(str, prefix + c, countMap, sol);
        countMap.put(c, count);
      }
    }
  }

  /*
  generate all the perm of str, n! where it has may have duplicate chars
  One approach is above and then do unique.
  Below little more optimized
  */
  public static ArrayList<String> generate(String str){
    HashMap<Character, Integer> countMap = buildCharMap(str);
    ArrayList<String> sol = new ArrayList<>();
    generate(str, "", countMap, sol);
    return sol;
  }
}