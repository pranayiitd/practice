import java.util.*;

class QuickSort{

	public static void sort(int[] arr, int left, int right){
		if(left >= right)
			return;
		else{
			System.out.format("left %d right %d \n", left, right);
			System.out.println(Arrays.toString(arr));
			
			
			boolean tf = false;
			for(int i = left; i < right; i++){
				if(arr[i]!=arr[i+1])
					tf = true;
			}
			if(!tf)
				return;
						
			int p = partition(arr, left, right);
			sort(arr, left, p);
			sort(arr, p+1, right);
		}
	}

	public static int partition(int []arr, int left, int right){

		Random rand = new Random();
		int pivot = arr[left+rand.nextInt(right-left+1)];
		int i =left; int j = right;
		// int index = left;
		
		
		while(i<j){
			while(i <= right && arr[i]<=pivot)
				i++;
			while(j >= left && arr[j]>pivot)
				j--;

			// System.out.format("i : %d j :%d \n",i, j);
			
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		System.out.format("pivot %d index %d \n",pivot, i-1);
		return i-1;
	}


	public static void main(String arg[]){
		// int [] arr = {2,2,3,12,23,12,1,0};
		int [] arr = {1, 1, 1, 1};
		// Set s = new HashSet(Arrays.asList(arr));
		// System.out.println(s.size());
		sort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}
}