import java.util.*;
import java.lang.*;
import java.io.*;

class VarunTest {
    
    public static int[] findSub(int [] arr, int start, int end, int currSum, int target){
        if(start >= arr.length || end >= arr.length)
            return null;
        if(currSum == target){
            int [] sol = {start, end};
            return sol;
        }
        if(currSum > target){
            currSum = currSum - arr[start];
            start++;
            if(start >= arr.length)
                return null;
            if(start > end){
                end = start;
                currSum = arr[start];
            }
            return findSub(arr, start, end, currSum, target);
        }
        else{
            
            end++;
            if(end >= arr.length)
                return null;
            currSum += arr[end];
            return findSub(arr, start, end, currSum, target);
        }
    }
    
  public static void main (String[] args) {
    try {
        File f = new File("data/varunTest.txt");
        Scanner sc = new Scanner(f);

        int t = sc.nextInt();
        for(int i=0; i<t;i++){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int [] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = sc.nextInt();
            }
            int [] sol = findSub(arr, 0, 0, arr[0], s);
            if(sol == null){
                System.out.println("-1");
            }
            else{
                for(int e: sol){
                    System.out.print((e+1)+ " ");
                }
                System.out.println();
            }
        }
    }
    catch(Exception e){

    }
  }
}