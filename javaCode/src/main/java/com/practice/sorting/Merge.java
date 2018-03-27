import java.util.*;
import java.lang.*;

class Merge{
	

	public static long sort(int [] arr, int[] helper, int left, int right){
		if(left >=right)
			return 0;
		else{
			int mid = left + (right-left)/2;
			long x = sort(arr, helper, left, mid);
			long y = sort(arr, helper, mid+1,right);
			long z = merge(arr, helper, left, right, mid+1);
			return x+y+z;
		}
	}

	public static long merge(int[] arr, int[] helper, int left, int right, int index){
		
		int i = left;
		int j = index;
		int k = left;
		
		long inv =0;

		while(i<index && j <= right){
			// inversion
			if(arr[i] <= arr[j]){
				helper[k++] = arr[i++];
			}
			else{
				inv += index-i;
				helper[k++] = arr[j++];
			}
				
		}
		while(i<index){
			helper[k++] = arr[i++];
		}
			
		while(j<=right)
			helper[k++] = arr[j++];
		
		for(int x =left;x<=right;x++)
			arr[x] = helper[x];

		return inv;

	}


	public static void main(String arg[]){

		Scanner sc = new Scanner(System.in);
        int t = new Integer(sc.nextLine()).intValue();
        for(int i=0;i<t;i++){
     		int n = new Integer(sc.nextLine()).intValue();
            String [] ain = sc.nextLine().split(" ");
            int[] arr = new int[n];
            int [] helper  = new int[n];
       
            for(int j=0;j<n;j++)
                arr[j] = new Integer(ain[j]).intValue();
            
            System.out.println(sort(arr, helper, 0, arr.length-1));
     
        }
       

	}

}