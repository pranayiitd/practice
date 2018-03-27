import java.util.*;


class node implements Comparable<node>{
	int value;
	node left;
	node right;
	node(int v ){
		value =v;
	}

	@Override
	public int compareTo(node n){
		return this.value - n.value;
 
	}

}

class Btree{
	node root;
	

	Btree(int v){
		root = new node(v);
	}

	public void insert(int v){
		root = insert(v,root);
	}

	private node insert(int v, node n){
		if(n==null)
			return new node(v);
		else{
			if(n.value < v)
				n.right = insert(v,n.right);
			else
				n.left = insert(v,n.left);

			return n;
		}
	}
	
	public void traverse(node n){
		if(n==null)
			return;
		else{
			traverse(n.left);
			System.out.println(n.value);	
			traverse(n.right);
		}
		
	}

	public void delete(int v){
		root = delete(v,root);
	}

	private node delete(int v, node n){
		if(n==null)
			return null;
		else{
			if(n.value > v)
				n.left = delete(v, n.left);
			if(n.value < v)
				n.right = delete(v, n.right);
			if(n.value == v){
				if(n.left==null)
					return n.right;
				else if(n.right==null)
					return n.left;
				else{
					int temp = find_delete_succ(n.left, n , 0);
					n.value = temp;
					
				}
			}

			return n;
		}
	}

	private int find_delete_succ(node n, node parent, int side){
		//Found the succ
		if(n.right==null){
			if(side==0)
				parent.left = n.left;
			if(side==1)
				parent.right = n.left;

			return n.value;
		}
		else
			return find_delete_succ(n.right, n, 1);
	}




	public static void main(String arg[]){
		Btree b = new Btree(1);
		b.insert(1);
		b.insert(-2);
		b.insert(13);
		b.insert(0);
		b.traverse(b.root);
		
		b.delete(1);
		b.traverse(b.root);
		
		node[] arr = new node[3];
		arr[0]= new node(10);
		arr[1]= new node(5);
		arr[2]= new node(2);
		Arrays.sort(arr);
		System.out.println(arr[0].value);
		HashMap[] arr1 = new HashMap[1];


	}

}