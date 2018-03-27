import java.util.*;
import java.lang.*;

class Node{
	int value;
	int min;

	Node(int v){
		value =v;
		min = 0;

	}
}


class MinStack{
	ArrayList<Node> stack = new ArrayList<Node>();

	public void push(int v){
		int min = v;
		if(stack.size()!=0 && stack.get(0).min < v)
			min = stack.get(0).min;
		Node n = new Node(v);
		n.min = min;
		stack.add(0,n);
	}
	
	public int pop(){
		if(stack.size()!=0){
			Node n = stack.remove(0);
			return n.value;
		}
			
		else
			return -1;
	}

	public int get_min(){
		if(stack.size()!=0)
			return stack.get(0).min;
		else
			return -1;
	}

	public void print_stack(){
		while(stack.size()!=0)
			System.out.println(stack.remove(0).value);
	}

	public static void main(String arg[]){
		MinStack m = new MinStack();
		m.push(110);
		m.push(11);
		m.push(111);
		m.push(21);
		m.push(1);
		System.out.println(m.get_min());
		m.print_stack();
	}
}