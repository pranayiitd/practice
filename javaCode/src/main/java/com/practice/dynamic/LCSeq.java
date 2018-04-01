package com.practice.dynamic;

import java.util.*;

/*
  Find the longest common subsequence in the 2 given strings.
*/
class LCSeq{

  public static int find(String s1, String s2, int[][] matrix, int i, int j){
    if(i < 0 || j < 0){
      return 0;
    }
    if(matrix[i][j] != -1){
      return matrix[i][j];
    }

    if(s1.charAt(i) == s2.charAt(j)){
      matrix[i][j] = 1 + find(s1, s2, matrix, i-1, j-1);
    }
    else{
      int l1 = find(s1, s2, matrix, i, j-1);
      int l2 = find(s1, s2, matrix, i-1, j);
      matrix[i][j] = Math.max(l1, l2);
    }

    return matrix[i][j];

  }

  public static void generate(StringBuilder sb, int[][] matrix, int i, int j, String s1, String s2){
    if(i < 0 || j < 0){
      return;
    }
    if(s1.charAt(i) == s2.charAt(j)){
      sb.insert(0, s1.charAt(i));
      generate(sb, matrix, i-1, j-1, s1, s2);
      return;
    }
    else{
      if(i <= 0){
        generate(sb, matrix, i, j-1, s1, s2);
        return;
      }
      if(j <= 0){
        generate(sb, matrix, i-1, j, s1, s2);
        return;
      }

      int l1 = matrix[i-1][j];
      int l2 = matrix[i][j-1];
      if(l1 > l2){
        generate(sb, matrix, i-1, j, s1, s2);
        return;
      }
      else{
        generate(sb, matrix, i, j-1, s1, s2);
        return;
      }
    }
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
    int ret = find(s1, s2, matrix, s1.length()-1, s2.length()-1);
    StringBuilder sb = new StringBuilder();

    generate(sb, matrix, s1.length()-1, s2.length()-1, s1, s2);

    return sb.toString();
  }
}