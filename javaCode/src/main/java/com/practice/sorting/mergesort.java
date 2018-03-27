import java.util.*;


class mergesort{

	public static int[] sort(int []a){
		if(a.length==1)
			return a;
		else{
			int [] x = Arrays.copyOfRange(a,0,a.length/2);
			int [] y = Arrays.copyOfRange(a,a.length/2,a.length);
			return merge(sort(x),sort(y));
			//return a;
		}

	}
	
	public static int[] merge(int []x ,int[] y){
		if(x.length==0)
			return y;
		if(y.length==0)
			return x;
		else{
			int i=0,j=0;
			int [] ans = new int[x.length+y.length];
			int index =0;
			while(i<x.length && j<y.length){
				if(x[i]<=y[j]){
					ans[index] = x[i];
					i++;index++;					
				}
				else{
					ans[index] =y[j];
					j++;index++;
				}
			}
			while(i<x.length){
				ans[index] =x[i];
				index++;i++;
			}
			while(j<y.length){
				ans[index]=y[j];
				j++;index++;
			}
			return ans;
		}
		
	}
	public static void traverse(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.format(" %d",a[i]);
		}
		System.out.format("\n");
	}
	
	public static void main(String argv[]){
		int [] a = {10,2,3,4,4,5,5};
		a = sort(a);
		traverse(a);
		int [] x = Arrays.copyOfRange(a,0,3);
		System.out.println(x[2]);
		//sort(a);
		ArrayList al = new ArrayList(Arrays.asList(1,2,2,2,2));
		System.out.println(al);

	}
}