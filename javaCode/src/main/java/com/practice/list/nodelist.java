class node{
	int data;
	node next;
	node(int v){
		data =v;
		next=null;
	}
}
class nodelist{
	node head;
	node tail;
	
	nodelist(int v){
		head = new node(v);
		tail = head;
	}
	public void insert(int v){
		if(head==null){
			head = new node(v);
			tail = head;
		}
		else{
			tail.next = new node(v);
			tail = tail.next;
		}
	}

	public boolean find(int v){
		boolean ret = false;
		node temp = head;
		while(temp!=null){
			if(temp.data==v)
				ret=true;
			temp = temp.next;
		}
		return ret;
	}

	public void delete(int v){
		if(head==null)
			return;
		if(head.data==v){
			head = head.next;
			if(head==null)
				tail=null;
		}
		else{
			node temp = head;
			while(temp.next!=null){
				if(temp.next.data ==v){
					temp.next = temp.next.next;
					break;
				}
					
				temp = temp.next;
			}
		}
	}
	public static void traverse(nodelist root){
		node temp = root.head;
		while(temp!=root.tail){
			System.out.format("%d ",temp.data);
			temp = temp.next;
		}
		System.out.format("\n");
	}
	public static void main(String arg[]){
		nodelist root = new nodelist(5);
		root.insert(4);
		root.insert(44);
		root.insert(34);
		root.insert(24);
		traverse(root);
		System.out.println(root.find(444));
		root.delete(34);
		traverse(root);
	}

}