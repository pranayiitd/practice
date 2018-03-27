import java.util.*;
//import java.Scanner.*;

class stringIO{

	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			System.out.format("s :%s\n",s);
			String [] a = s.split(",");
			//System.out.println(Arrays.toString(a));
			int x = Integer.parseInt(a[0])+1;
			//System.out.format("%d ",x);
			String ss = x+",";
			System.out.format("x :%s \n",ss);
			System.out.format("concant x+s %s \n",ss.concat(s));
			System.out.format("index of x %d \n",s.indexOf(ss));
			s =s.replaceAll(ss,"pranay");
			System.out.format("replaced %s \n",s);
			System.out.format("s ==x ? %b \n",s.equals(x));
			/*
			important reverse.
			*/
			String reverse = new StringBuffer(s).reverse().toString();
			System.out.format(reverse+"\n");
			/*
			Sorting.
			*/
			char [] c = s.toCharArray();
			Arrays.sort(c);
			System.out.format(new String(c)+"\");
			
			
			break;
		}	
	}
	
}
