import java.util.*;
import java.lang.*;

class One_Stack_q{

	Stack<Integer> s = new Stack<Integer>();

	public void push(int v){
		s.push(v);

	}

	public int pop_elem(){
		
		return pop_elem(s);
	}

	private int pop_elem(Stack s){
		
		// int v = new Integer(s.pop()).intValue();
		int v = (Integer)s.pop();
		if(s.isEmpty())
			return v;
		else{
			int ans = pop_elem(s);
			s.push(v);
			return ans;

		}
	}

	public void traverse(){
		while(!s.isEmpty())
			System.out.println(pop_elem());
	}


	public static void main(String arg[]){
		One_Stack_q sq = new One_Stack_q();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.traverse();
		
		// Stack s = new Stack();
		// s.push(1);
		// s.push(2);
		// s.push(4);
		// // int v = new Integer(s.pop());
		// System.out.println(v);


	}
}