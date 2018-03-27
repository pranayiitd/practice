class node{

	int data;
	node next;

	node(int v){
		data =v;
	}

	public void insert(int v){
		node n = this;
		while(n.next!=null)
			n = n.next;
		n.next = new node(v);
	}


	public void traverse(){
		node n = this;

		while(n!=null){
			System.out.println(n.data);
			n = n.next;
		}
			
	}
}

class Swapk{

	// node start;

	public static node swap(node n, int k){
		if(n==null)
			return null;

		node p1 = n;
		node p2 = n.next;
		node p_next = null;
		int i =k;
		
		while(i > 0){
			if(p2 == null){
				n.next = null;
				return p1;
			}
				
			
			p_next = p2.next; 
			p2.next = p1;
			p1 = p2;
			p2 = p_next;
			i--;
		}

		n.next = swap(p2, k);
		return p1;
	}

	public static void main(String arg[]){
		node head = new node(1);
		head.insert(2);
		head.insert(3);
		head.insert(4);
		head.insert(5);
		head.insert(6);
		head.insert(7);
		head.insert(8);
		// head.traverse();

		node h = swap(head, 4);
		h.traverse();

	}
}