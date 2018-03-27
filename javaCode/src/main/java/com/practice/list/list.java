class node{
	int data;
//	node left;
//	node right;
	node next;

	node(int v){
		data =v;
//		left = null;
//		right =null;
		node next;
	}
}

class list{
	
	node head;
	node tail;
	
	list(int v){
		head = new node(v);
		tail = head;
	}

	void insert(int v){
		if(head==null){
			head = new node(v);
			tail = head;
		}
		else{
			tail.next = new node(v);
			tail = tail.next;
		}
			
	}

	int delete(){
		if(head==null)
			return -1;
		else{
			int ret = head.data;
			head = head.next;
			if(head==null)
				tail =null;
			return ret;
		}
			
	}


	boolean find(int v){
		boolean  tf = false;
		node temp = head;
		while(temp!=null){
			if(temp.data == v){
				tf = true;
				break;
			}
			temp = temp.next;
		}
		return tf;
	}

	void print(){
		node temp = head;
		while(temp!=null){
			System.out.format("%d,",temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String arg[]){
		list l = new list(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.print();
		l.delete();
		l.delete();
		l.print();
		l.insert(6);
		l.insert(7);
		l.print();
		System.out.println(l.find(5));
		System.out.println(l.find(17));
	}

}



















