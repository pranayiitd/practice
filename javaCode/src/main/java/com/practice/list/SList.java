class node{
	
	int data;
	node next = null;
	
	node(int v){
		data =v;
	}
}

class SList{
	node head =null;

	public void insert(int v){
		head = insert(v, head);
	}


	private node insert(int v, node n){
		if(n==null)
			return new node(v);
		else{
			n.next = insert(v, n.next);
			return n;
		}
	}


	public void delete(int v) {
		head = delete(v, head);
	}

	private node delete(int v, node n){
		if(n==null)
			return null;
		else{
			if(n.data == v )
				return n.next;
			else{
				n.next = delete(v, n.next);
				return n;
			}
		}
	}

	public void traverse(){
		node n = head;
		while(n!=null){
			System.out.format("%d,",n.data);
			n = n.next;
		}
		System.out.format("\n");

	}


	public static void main(String arg[]){
		SList l = new SList();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.traverse();
		l.delete(1);
		l.traverse();
	}

}