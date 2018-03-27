class Fib{


	public static int fib(int n, int x , int y){
		if(n==1)
			return x;
		else 
			return fib(n-1, x+y, x);
	}

	public static void main(String arg[]){
		for(int i=1;i<10;i++)
			System.out.println(fib(i, 1 , 0));
	}
}