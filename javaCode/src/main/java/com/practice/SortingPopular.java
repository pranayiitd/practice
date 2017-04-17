import java.util.*;
/* 
 Author: Pranay Agarwal agarwalpranaya@gmail.com
 Collection of major sorting algorithms.
 */
class SortingPopular{

// ****** MergeSort *******
  public static int[] mergeSort(int [] arr){
    if(arr == null || arr.length < 2)
      return arr;
    int [] helper = new int[arr.length];
    mergeSort(arr, helper, 0, arr.length -1);
    return arr;
  }

  // Sort arr, from start, to end (both inclusive)
  public static int[] mergeSort(int[] arr, int[] helper, int start, int end){
    // If one elem in the range, arr already sorted
    if(start < end){
      int mid = (start + end)/2;
      mergeSort(arr, helper, start, mid);
      // Note that mid can be same as start, hence make sure we
      // don't make infinite recursion, by calling recursive subroutine with same args
      mergeSort(arr, helper, mid + 1, end);
      merge(arr, helper, start, mid + 1, end);
    }
    return arr;
  }

  // arr sorted from start, mid AND mid +1 to end
  public static void merge(int [] arr, int [] helper, int start, int mid, int end){
    for(int i=start; i <= end; i++){
      helper[i] = arr[i];
    }
    int leftP = start;
    int rightP = mid;
    int pos = start;
    while(leftP < mid && rightP <= end){
      if(helper[leftP] <= helper[rightP]){
        arr[pos] = helper[leftP];
        leftP++;
      }
      else{
        arr[pos] = helper[rightP];
        rightP++;
      }
      pos++;
    }
    // We ONLY need copy from left side as the right side is already there
    while(leftP < mid){
      arr[pos] = helper[leftP];
      pos++;
      leftP++;
    }
  }

// ****** QuickSort *******
  public static int [] quickSort(int [] arr){
    if(arr == null || arr.length < 2)
      return arr;
    quickSort(arr, 0, arr.length -1);
    return arr;
  }

  // Sort arr including start and end
  public static void quickSort(int [] arr, int start, int end){
    // One element is already sorted (if start >= end)
    if(start < end){
      // partition returns p such that arr[p] is in it's final correct position
      int p = partition(arr, start, end);
      quickSort(arr, start, p-1);
      quickSort(arr, p + 1, end);
    }
  }

  public static void swap(int [] arr, int i, int j){
   int temp = arr[i];
   arr[i] = arr[j];
   arr[j] = temp;
  }

  // returns index p in arr. Such that :
  // arr[start..p-1] <= a[p] <= arr[p+1..end] 
  // either of left/right part could be empty
  public static int partition(int [] arr, int start, int end){
    int m = end ;
    int pivot = arr[m];
    int pos = start -1;
    for(int j = start; j < end; j++){
      if(arr[j] <= pivot){
        pos++;
        swap(arr, pos, j);
      }
    }
    //After below swappping, pivot will be in correct position
    swap(arr, pos+1, end);
    return pos+1;
  }

  /** BinarySearch **/
  public static int binarySearch(int [] arr, int start, int end, int x){
    if(start > end)
      return -1;
    int mid = (start + end)/2;
    if(arr[mid] == x){
      return mid;
    }
    else if (arr[mid] > x){
      return binarySearch(arr, start, mid-1, x);
    }
    else{
      return binarySearch(arr, mid +1, end, x);
    }
  }

  /***** Counting Sort ****/
  // Sort the arr of integers based on ith digit of element from right
  // i =0, sort them based on least sig digit
  public static int[] countingSort(int [] arr, int index){
    int div = (int)Math.pow(10, index);
    int [] countArr = new int[10];
    for(int e : arr){
      int r = (e/div) % 10;
      countArr[r] += 1;
    }

    for(int i =1; i < countArr.length; i++){
      countArr[i] += countArr[i-1] ;
    }
    int [] sol = new int[arr.length];
    for(int i = arr.length-1; i >=0; i--){
      int r = (arr[i]/div) % 10;
      int pos = countArr[r];
      sol[pos-1] = arr[i];
      countArr[r]--;
    }
    return sol;
  }

  /*** Radix Sort ***/
  public static int [] radixSort(int [] arr){
    if(arr == null || arr.length < 2)
      return arr;
    for(int d =0; d <3; d++){
      arr = countingSort(arr, d);
    }
    return arr;
  }


  public static void main(String [] args){
    int [] [] arr = {{10, 1, 1, 1, 1, 100, 12},
                     {12, 10, 11},
                     {1},
                     {1, 1, 6,  1},
                     {3, 2, 1, 6},
                     {1, 2, 5, 6, 0},
                     {1, 2, 5, 5, 2, 6, 5, 5, 5, 0}
                 };
    for(int [] a : arr){
     System.out.format("input: %s\n", Arrays.toString(a));
     System.out.format("Radix Sort: %s \n", Arrays.toString(SortingPopular.radixSort(a.clone())));
     System.out.format("Counting Sort: %s \n", Arrays.toString(SortingPopular.countingSort(a.clone(), 0)));
     System.out.format("MergeSort: %s \n", Arrays.toString(SortingPopular.mergeSort(a.clone())));
     System.out.format("QuickSort: %s \n", Arrays.toString(SortingPopular.quickSort(a)));
     System.out.format("binarySearch: %s \n", binarySearch(a, 0, a.length-1, 6));
     System.out.format("Bsearch: %s \n", Arrays.toString(SortingPopular.quickSort(a)));
    }
  }

}