class Div{

	public static int div(int n, int m, int kx){
		if(m*k == n)
			return k;
		else if(m*k > n)
			 return k-1;
		else
			return div(n, m, k+1);
	}











	public static void main(String arg[]){
		System.out.println(div(100, 3, 1));
	}
}