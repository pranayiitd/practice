class node{
	int data;
	node next;
	node(int v){
		data =v;
		next=null;
	}
}
class dnode{
	int data;
	dnode left;
	dnode right;
	dnode(int v){
		data =v;
		left =null;
		right=null;
	}
}

class revNode{
	static node head = new node(1);
	static dnode dhead = new dnode(0);

	public static void insertD(int v){
		dhead = insertD(v,dhead);
	}
	
	private static dnode insertD(int v,dnode n){
		if(n==null)
			return new dnode(v);
		else{
			dnode temp = insertD(v,n.right);
			n.right = temp;
			temp.left = n;
			return n;
		}
	}

	public static void insert(int v){
		head = insert(v,head);

	}
	private static node insert(int v,node n){
		if(n==null)
			return new node(v);
		else{
			n.next = insert(v,n.next);
			return n;
		}

	}

	public static node forward(int k,node n){

		while(n!=null && k>0){
			System.out.format("%d ,",n.data);
			n = n.next;
			k--;
		}
		return n;
	}

	public static node backward(int k,node n){
		if(n!=null && k>0){
			node temp = backward(k-1,n.next);
			System.out.format("%d ,",n.data);
			return temp;
		}
		else
			return n;

	}

	public static void travel(){
		dnode temp = dhead;
		dnode last = new dnode(0);
		while(temp!=null){
			System.out.format("%d,",temp.data);
			if(temp.right==null)
				last = temp;
			temp = temp.right;
		}
		System.out.format("\n now reverse \n");
		while(last!=null){
			System.out.format("%d,",last.data);
			last = last.left;
		}

	}

	public static node swap(node n){
		if(n==null)
			return null;
		else{
			if(n.next==null)
				return n;
			else{
				node t = n.next.next;
				node t1 = n;
				node t2 = n.next;
				t2.next = t1;
				t1.next = swap(t);
				return t2;
			}
		}

	}

	public static void main(String arg[]){
		
		int k = 3;
		
//		insert(1);
		insert(2);
		insert(3);
		insert(4);
		insert(5);

		dnode dtemp = dhead;
		insertD(1);
		insertD(2);
		insertD(3);
		insertD(4);
		insertD(5);

		head = swap(head);
		boolean f = true;
		node temp = head;

		while(temp!=null){
			if(f){
				temp =forward(k,temp);
				f =false;
			}
			else{
				temp = forward(k,temp);
				f=true;
			}
		}
		
		travel();


	}
}