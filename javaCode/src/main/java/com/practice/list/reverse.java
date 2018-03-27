class node{
	int data;
	node next;
	node(int v){
		data =v;
		next=null;
	}
	public void insert(int v){
		node temp = this;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = new node(v);
	}
}


class reverse{
	
	public static void traverse(node n){
		while(n!=null){
			System.out.format("%d ",n.data);
			n = n.next;
		}
	}

	public static node reverse(node n){
		if(n.next==null)
			return new node(n.data);
		else{
			node temp = reverse(n.next);
			temp.insert(n.data);
			return temp;
		}
	}
	public static boolean compare(node rev,node head){
		if(rev==null && head==null)
			return true;
		else{
			if(rev==null || head==null)
				return false;
			else if(rev.data!=head.data)
				return false;
			else
				return  compare(rev.next,head.next);	
		}
		 
	}

	public static void main(String arg[]){
		node head = new node(1);
		head.insert(2);
		head.insert(1);
		traverse(head);
		node rev = reverse(head);
		System.out.println(compare(rev,head));
	}
}