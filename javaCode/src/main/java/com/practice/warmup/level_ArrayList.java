	import java.util.*;

class level_ArrayList{
	static HashMap<Integer,ArrayList> h = new HashMap<Integer,ArrayList>();
	
	public static void main(String arg[]){
		ArrayList a = new ArrayList(Arrays.asList(23,1));
		System.out.println(a);
		// int [] arr = Arrays.asList(23,1);
		// 		System.out.println(Arrays.toString(arr));
		//a.add(42);
		//a.add(5);
		h.put(3,a);
		//int[] a = Arrays.asList(2,2);
		
		// Int[] array to ArrayList
		Integer [] b = {10,1};
		List al = new ArrayList();
		Collections.addAll(al,b);

		System.out.println(al);
		
		// Useful operations on ArrayList
		System.out.println(al.indexOf(10));
		al.add(1,23);
		System.out.println(al);
		
		System.out.println("asdasdasdadad\n");
		
		
		al.add(23);
		al.get(0);
		al.set(0,12);
		al.remove(0);
		System.out.println(al);
		System.out.println(al.size());
		//Useful funs of Collections
		Collections.sort(al);
		System.out.println(al);
		Collections.reverse(al);
		System.out.println(al);
		//Collections.shuffle(al);
		System.out.println(al);
		System.out.println(Collections.max(al));
		System.out.println(Collections.binarySearch(al,23));
		System.out.println(al.equals(a));
		

		System.out.println(al);
		System.out.println(a);
		//ArrayList to Array
		System.out.println(Arrays.toString(al.toArray()));

		//System.out.println(Arrays.toString(b));
		//System.out.println(h.get(3));
		Collections.sort(h.get(3),Collections.reverseOrder());
		//System.out.println(h.has_key(4));
	}
}
