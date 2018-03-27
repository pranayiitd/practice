import java.util.*;

class Jheap{

	public static void main(String arg[])	{
		PriorityQueue p = new PriorityQueue(3);
		p.add(1);
		p.add(2);
		p.add(-2);
		p.add(22);
		// System.out.println(p.peek());
		// p.remove(1);
		while(p.size()!=0)
			System.out.println(p.remove());
		
	Queue qe = new LinkedList();
	qe.offer(1);
	qe.offer(2);
	qe.offer(-2);
	qe.offer(22);
	// qe.offer(22);
	// System.out.println(qe.peek()) ;//just see the first value
	// System.out.println(qe.poll()) ;//Remove and return first value
	// System.out.println(qe.size()) ;	
	while(qe.size()!=0)
			System.out.println(qe.remove());
	}
}