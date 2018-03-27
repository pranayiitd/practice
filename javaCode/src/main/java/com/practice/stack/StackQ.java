import java.util.*;

class StackQ{

	


	public static void main(String arg[]){
		Stack s = new Stack();
		s.push("1");
		s.push("2");
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);

		Queue<String> queue = new LinkedList<String>();
		LinkedList<String> l = new LinkedList<String>();
		l.add("1");l.add("2");l.add("3");
	    
	    queue.add( "bat" );
	    queue.add( "cat" );
	    queue.add( "dog" );
		System.out.println(queue);
		System.out.println(l.remove(1));
		System.out.println(l);	    

		PriorityQueue<String> pq = new PriorityQueue<String>();

		Iterator it1=l.iterator();
		Iterator it2=s.iterator();
		Iterator it3=queue.iterator();
		Iterator it4=pq.iterator();

		System.out.println(s.size());	    		

	}
}