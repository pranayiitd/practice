class node{
	int data;
	node next;
	node(int v){
		data =v;
	}
}

class kreverse{
	node head;
	node tail;
	kreverse(){
		head =tail=null;
	}
	void insert(int v){
		node temp = new node(v);
		if(tail==null){
			head = temp;	
			tail = head;
		}
		else{
			tail.next = temp;
			tail = temp;
		}
	}
	void print(){
		node temp = head;
		while(temp!=null){
			System.out.format("%d,",temp.data);
			temp = temp.next;
		}
	}
	void reversePrint(int k){
		node temp = head;
		while(temp!=null){
			temp = kprint(temp,k);
		}

	}
	
	node kprint(node n,int k){
		node temp =null;
		if(n==null) return null;
		else{
			if(k==1){
			System.out.format("%d,",n.data);
			//return n.next;
			temp = n.next;
		}
		else{
			// n = n.next;
			temp = kprint(n.next,k-1);
			System.out.format("%d,",n.data);
		}	
		return temp;
		}
		
	}

	node rKNode(int k){
		node temp = head;
		while(temp!=null){
			node end = reverseNode(k,temp);
			int i =k;
		    while(i>0 && temp!=null){
		    	temp = temp.next;
		    	i--;
		    }
			end.next = reverseNode(k,temp);
		}
		return temp;
	}

	node reverseNode(int k,node n){
		if(k==1){
			if(n.next==null)
				return new node(n.data);
			else{
				n.next = reverseNode(3,n.next);
				return n.next;
			}
		}
		else{
			node prev = reverseNode(k-1,n.next);
			node temp = new node(n.data);
			prev.next = temp;
			return temp;
		}
		
	}

	node reverseInPlace(int k ,node head){
		int i =0;
		node curr = head;
		node next = null;
		node prev = null;
		while(i<k && curr!=null){
			next = curr.next;
			curr.next = prev;
			prev =curr;
			curr = next;
			//next = next.next;
			i++;
		}
		if(curr!=null){
			//System.out.format("%d curr\n",curr.data);
			head.next = reverseInPlace(k,curr);
		}
		//System.out.format("%d prev\n",prev.data);	
		return prev;
	}
	public static void main(String arg[]){
		kreverse l = new kreverse();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insert(6);
		//l.print();
		l.reversePrint(3);
		System.out.println();
		kreverse m = new kreverse();
		m.head = l.reverseInPlace(3,l.head);
		m.print();
	}
}