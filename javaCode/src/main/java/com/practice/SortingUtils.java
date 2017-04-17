import java.io.*;
import java.util.*;

public class SortingUtils {

  public static void foo(){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int [] arr = new int[n];
      HashMap<Integer, ArrayList> rMap = new HashMap<Integer, ArrayList>();
      for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();
        int r = arr[i] % k;
        if (rMap.containsKey(r)){
          rMap.get(r).add(arr[i]);
        }
        else{
         ArrayList<Integer> al = new ArrayList<Integer>();
         al.add(arr[i]);
         rMap.put(r, al);
        }
      } 
     int sol = 0;
     for(int i=0; i<k; i++){
         
       int l1 = 0;
       int l2 = 0;
       if (rMap.containsKey(i))
         l1 = rMap.get(i).size();
       if(i == 0){
         sol += Math.min(1, l1);
         continue;
       }
       if (rMap.containsKey(k-i))
         l2 = rMap.get(k-i).size();
       sol += Math.max(l1, l2);
     }
     System.out.println(sol/2);}
  
  // Search in sorted array, which has been rotated unknown number of times.
  public static int bSearchRot(int [] arr, int e, int start, int end) {
    if(start > end)
      return -1;
    int mid = (start + end)/2;
    if(arr[mid] == e){
      return mid;
    }
    // System.out.format("%s, %s, %s\n", start, mid, end);

    // mid On the right side increasing
    if(arr[mid] < arr[end]){
      if(e > arr[mid] && e <= arr[end])
        return bSearchRot(arr, e, mid + 1, end);
      else
        return bSearchRot(arr, e, start, mid -1);
    }
    // mid on the left side increasing
    else if (arr[mid] > arr[end]){
      if(e < arr[mid] && e >= arr[start]){
        return bSearchRot(arr, e, start, mid -1);
      }
      else{
        return bSearchRot(arr, e, mid+1, end);
      }
    }
    // mid to end is all same, and all useless
    else{
      return bSearchRot(arr, e, start, mid -1);
    }
  }

  public static void main(String[] args) {
    Integer [] arr = {15, 16, 19, 20, 25, 25, 25, 1, 3, 4, 5, 7, 10, 14};
    // int [] arr = {25, 25, 25, 25, 25, 25, 25, 1, 1, 14, 15};
    // System.out.println(Arrays.toString(arr));
    // int [] input = {-1, 100, 20, 1, 19, 25, 14, 15};
    // for(int e : input){
    //   System.out.format("e : %s, pos: %s\n", 
    //                     e,
    //                     bSearchRot(arr, e, 0, arr.length -1));
    // }

    ArrayList<Integer> al = new ArrayList<>();
    for(int e : arr)
      al.add(e);
    System.out.println(al);
    ArrayList<Integer> bl = (ArrayList<Integer>)al.clone();
    bl.add(-1);
    System.out.println(bl);
    Integer[]  brr = bl.toArray(new Integer[0]);
    // Integer[]  brr = bl.toArray();
    System.out.println(Arrays.toString(brr));

  }
}