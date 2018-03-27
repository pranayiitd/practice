import java.util.*;

class Sub_set{

	public static void solve_subset(int [] arr, int[][] matrix, int[][] pos){
		// The first row can sum only arr[0]
		matrix[0][arr[0]] =1;
		
		for(int i=1;i<arr.length;i++)
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i-1][j] == 1){
					matrix[i][j] =1;
					pos[i][j] = j;
				}
					
				else if( j-arr[i]>=0 && matrix[i-1][j-arr[i]]==1){
					matrix[i][j] =1;
					pos[i][j] = j-arr[i];
				}
					
			}
	}

	public static void get_seq(int[][] pos,int[] arr, int sum){
		int i = arr.length-1;
		int j = sum;
		while(i>0 && j>0){
			// System.out.format(" i: %d j:%d pos[i][j] %d\n",i, j, pos[i][j]);
			if(pos[i][j]!= j)
				System.out.println(arr[i]);
			
			j = pos[i][j];
			i = i-1;
			// System.out.format(" i: %d j:%d pos[i][j] %d\n",i, j, pos[i][j]);
		}
	}

	public static void main(String arg[]){
		int arr [] = {0,1,2,3,3,4,4};
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		int[][] matrix = new int[arr.length][sum+1];
		int[][] pos = new int[arr.length][sum+1];
		
		solve_subset(arr, matrix, pos);
		// System.out.println(Arrays.toString(matrix[arr.length-1]));
		// System.out.println(Arrays.toString(pos[arr.length-2]));
		// System.out.println(Arrays.toString(pos[arr.length-1]));
		get_seq(pos, arr, 11);
	}
}