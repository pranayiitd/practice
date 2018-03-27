import java.util.*;
//import java.lang.Math;

class facebook{
	
	static int mf =11;// x = columns
	static int nf =17;// y = rows
	static int[][] matrix = new int[nf+1][mf+1];

	//called with (x,y) pair.
	public static int minHops(int m,int n){
		if(m<1 || n <1)
			return Integer.MAX_VALUE;
		else{
			if(matrix[n][m]!=0){
				String v = (m==1)?"Up":"Right";
				System.out.format("%s %d\n",v,matrix[n][m]);
				return matrix[n][m];
			}
				
			else{
				int x = Integer.MAX_VALUE;
				int y = Integer.MAX_VALUE;

				if(n-m>0)
					x = minHops(m,n-m);
				if(m-n>0)
					y = minHops(m-n,n);
				
				if(x < y)
					System.out.format("Up %d\n",m);
				else
					System.out.format("Right %d\n",n);

				matrix[n][m] = Math.min(x, y)+1;
				return matrix[n][m];
			}
		}
	}

	public static void main(String arg[]){
		
		for(int i=1;i<matrix[0].length;i++){
			matrix[1][i] = i-1;
		}
		for(int j=1;j<matrix.length;j++){
			matrix[j][1] = j-1;
		}

		System.out.println(minHops(mf,nf));


	}
}