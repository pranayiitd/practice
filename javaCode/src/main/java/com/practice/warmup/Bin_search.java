class Bin_search{

	public static int find(int[] arr1, int i1, int i2, int[] arr2, int j1, int j2, int k){

		System.out.format("i1 :%d i2:%d  j1:%d j2:%d  k:%d\n",i1,i2,j1,j2,k);
		// if(k==1)
			// return -1;
		int l1 = 1+(i2-i1)/2;
		int l2 = 1+(j2-j1)/2;
		if(l1+l2==k){
			int ans = arr1[i1+l1-1];
			if(ans < arr2[j1+l2-1])
				ans = arr2[j1+l2-1];
			return ans;
		}
		if(k==l1+l2-1){
			int ans = arr1[i1+l1-1];
			if(ans > arr2[j1+l2-1])
				ans = arr2[j1+l2-1];
			return ans;
		}
		else{
			if(l1+l2<k)
				return find(arr1, i1+l1, i2, arr2, j1+l2, j2, k-l1-l2);
			else
				return find(arr1, i1, i2-l1, arr2, j1, j2-l2, k);

		}
	}

	public static int find_k(int [] arr1 ,int [] arr2, int k){

		int i= -1;int j= -1;
		int count =0;
		int ans = -1;
		while(i<arr1.length-1 && j <arr2.length-1){
			if(arr1[i+1] < arr2[j+1]){
				count++;i++;
				if(count==k){
					ans = arr1[i];
					break;
				}
					

			}

			if(arr1[i+1] > arr2[j+1]){
				count++;j++;
				if(count==k){
					ans = arr2[j];
					break;
				}
					
			}


		}

		return ans;

	}


	public static void main(String arg[]){
		int [] arr1 = {1,2,32,33};
		int [] arr2 = {11,12,132,133};
		// int ans = find(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1, 2);
		int ans = find_k(arr1, arr2, 3);
		System.out.println(ans);
		for(int elem : arr1)
			System.out.print(elem);
	}
}