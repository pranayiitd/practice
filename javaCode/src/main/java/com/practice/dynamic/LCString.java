package com.practice.dynamic;

import java.util.*;

/*
  Finding longest common substring in 2 given strings.
*/
class LCString{

  /*
  Below is top bottom approaching, hoping that recursion call will build the
  matrix.
  */
  public static int find(String s1, String s2, int i, int j, int[][] matrix, int [] sol){
    if(i < 0 || j < 0){
      return 0;
    }

    if(matrix[i][j] != -1){
      return matrix[i][j];
    }

    if(s1.charAt(i) != s2.charAt(j)){
      matrix[i][j] = 0;
    }
    else{
      matrix[i][j] = 1 + find(s1, s2, i-1, j-1, matrix, sol);
    }
    int ret = matrix[i][j];
    if(ret > sol[0]){
      sol[0] = ret;
      sol[1] = i;
    }
    return ret;

  }

  public static String find(String s1, String s2){
    if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
      return "";
    }
    int [][] matrix = new int[s1.length()][s2.length()];
    for(int i=0; i< matrix.length; i++){
      for(int j=0; j < matrix[0].length; j++){
        matrix[i][j] = -1;
      }
    }

    //len, position for s1
    int[] sol = {-1, -1};
    for(int i = s1.length()-1; i >=0; i--){
      for(int j = s2.length()-1; j>=0; j--){
        //We have to call for all i, j, because just calling for n, m will
        // not necessarily give the solution of the whole problem
        find(s1, s2, i, j, matrix, sol);
      }
    }

    return s1.substring(sol[1]-sol[0]+1, sol[1]+1);
  }

  /*
    Better approach in this case
    This is bottom top approach, where we calculate all the results from bottom. 
  */
  public static String findBT(String s1, String s2){
    if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
      return "";
    }
    int [][] matrix = new int[s1.length()][s2.length()];
    int maxLen = 0;
    int s1PosEnd = -1;

    for(int i=0; i< matrix.length; i++){
      for(int j=0; j < matrix[0].length; j++){
        if(i == 0 || j == 0){
          matrix[i][j] = (s1.charAt(i) == s2.charAt(j)) ? 1 : 0;
        }
        else{
          if(s1.charAt(i) == s2.charAt(j)){
            //The way we are building matrix, we know that i-1, j-1 will be ready
            matrix[i][j] = 1 + matrix[i-1][j-1];   
          }
          else{
            matrix[i][j] = 0;
          }
        }
        if(maxLen < matrix[i][j]){
          maxLen = matrix[i][j];
          s1PosEnd = i;
        }
      }
    }

    return s1.substring(s1PosEnd - maxLen + 1 , s1PosEnd + 1);
  }
}