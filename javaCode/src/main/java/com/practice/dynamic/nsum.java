class nsum{
	static int sum =10;
	static int num =5;
	static int [] a = {1,2,3,4,5};
	static int[][] matrix =new int[5][16];

public static boolean sum(int n,int s){
	System.out.format("%d %d\n",n,s);
	if(matrix[n][s]==1 || (a[n]==s)){
		System.out.format("%d ",a[n]);
		matrix[n][s]=1;
		return true;
	}
	else{
		boolean ret = false;
		for(int i =n-1;i>-1;i--){
			if(s-a[n]<0)
				continue;
			else{
				if(sum(i,s-a[n]) || sum(i,s)){
					ret =true;
					System.out.format("%d ",a[n]);
					matrix[i][s-a[n]] =1;
					//break;
				}
					
			}
		}
		return ret;	
	}
	
}
public static void main(String arg[]){
	
	matrix[0][a[0]] =1;
	sum(4,3);

}
}