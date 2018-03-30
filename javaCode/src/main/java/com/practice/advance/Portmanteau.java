/*
  Brangelia = Brad + Angelina
*/

package com.practice.advance;
class Portmanteau{

  public static boolean isPortmanteau(String word, TrieImpl prefixTree, TrieImpl reverseSuffixTree){
    if(word == null || word.length() < 2){
      return false;
    }
    for(int i =1; i < word.length(); i++){
      String prefix = word.substring(0, i);
      String suffix = word.substring(i);
      // System.out.printf("debug: %s + %s = %s\n", prefix, suffix, word);
      if(!prefixTree.search(prefix)){
        return false;
      }
      String reverseSuffix = new StringBuffer(suffix).reverse().toString();
      if(reverseSuffixTree.search(reverseSuffix)){
        System.out.printf("%s + %s = %s\n", prefix, suffix, word);
       return true; 
      }
    }
    return false;
  }
}