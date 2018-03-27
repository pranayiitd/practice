import java.util.*;

class Sort_quick{

	public static void sort(int [] arr, int left, int right){
		if(left >= right)
			return;
		else{
			int pivot = partition(arr, left, right);
			System.out.println(arr[pivot]);
			System.out.println(Arrays.toString(arr));

			sort(arr, left, pivot);
			sort(arr, pivot+1, right);
		}
	}

	public static int partition(int[] arr, int left, int right){
		Random r = new Random();
		int p = left + r.nextInt(right-left+1);

		swap_arr(arr, arr[p], left, right);

		return p;
	}


	public static void swap_arr(int[] arr, int p, int left, int right){
		if(left>=right)
			return;
		else{
			// 
			if(arr[left] < p )
				swap_arr(arr, p, left+1, right);
			else if(arr[right] > p)
					swap_arr(arr, p, left, right-1);
			else if(arr[left] == arr[right])
					return ;
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				swap_arr(arr, p, left+1, right-1);
			}
				
		
		}
	}

	public static void main(String arg[]){
		int[] arr = {23,12,24,5454,1,2,-12};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
}