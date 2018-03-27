import java.util.*;

class UtkTest{

  public static ArrayList<ArrayList<Integer>> getFactors(int n){
    ArrayList<ArrayList<Integer>> allFac = new ArrayList<ArrayList<Integer>>();
    if(n < 2)
      return allFac;
    for(int i =2; i<= 1+n/2; i++){
      if(n % i != 0){
        continue;
      }
      ArrayList<ArrayList<Integer>> partialFac = getFactors(n/i);
      for(ArrayList<Integer> oneFac : partialFac){
        oneFac.add(i);
        Collections.sort(oneFac);
      }
      allFac.addAll(partialFac);
    }
    // if(allFac.size() == 0){
      ArrayList<Integer> firstFac = new ArrayList<>(Arrays.asList(n));
      allFac.add(firstFac);
    // }
    return allFac;
  }

  public static void main(String arg[]){
    int n = 48;
    ArrayList<Integer> firstFac = new ArrayList<>(Arrays.asList(1, n));
    ArrayList<ArrayList<Integer>> factors = getFactors(n);
    factors.add(firstFac);
    HashSet<ArrayList<Integer>> factorsUniq = new HashSet<ArrayList<Integer>>(factors);
    System.out.println(factorsUniq);
  }
}