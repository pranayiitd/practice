package com.practice.dynamic;

import java.util.*;

class PowerSet{

  public static void generate(ArrayList<Set<String>> sol, String[] arr, int i){
    if(i >= arr.length){
      return;
    }
    String curr = arr[i];
    int currLen = sol.size();
    for(int j=0; j< currLen; j++){
      Set<String> oldSet = sol.get(j);
      Set<String> newSet = new HashSet<>(oldSet);
      newSet.add(curr);
      sol.add(newSet);
    }
    generate(sol, arr, i+1);

  }

  public static ArrayList<Set<String>> generate(String [] arr){
    ArrayList<Set<String>> sol = new ArrayList<>();
    sol.add(new HashSet());
    generate(sol, arr, 0);
    return sol;
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

}