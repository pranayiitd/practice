
import java.util.*;


class node{
	int data;
	node left;
	node right;
	boolean tf = false;
	
	node(int v){
		data = v;
		left = null;
		right=null;
	}

}

// class nod{
	
// 	node dot;
// 	boolean left = false;
	
// 	nod(node n){
// 		dot = n;
// 	}
// }

class B_test{
	node root;

	public void insert(int v){
		root = insert(v, root);
	}

	private node insert(int v, node n){
		if(n==null)
			return new node(v);
		else{
			if(n.data >= v)
				n.left = insert(v, n.left);
			else
				n.right = insert(v, n.right);

			return n;
		}
	}

	public void traverse(){
		traverse(root);
	}

	private void traverse(node n){
		if(n.left!=null)
			traverse(n.left);
		System.out.println(n.data);
		if(n.right!=null)
			traverse(n.right);
	}

	public boolean find(int v){
		return find( v, root);

	}

	private boolean find(int v, node n){
		if(n==null)
			return false;
		else if(n.data == v)
				return true;
		else if(n.data >= v)
				return find(v, n.left);
		else
			return find(v, n.right);
	}


	public void delete(int v){
		root = delete(v, root);
	}

	private node delete(int v, node n){
		if(n==null)
			return null;
		else if(n.data > v){
				n.left = delete(v, n.left);
				return n;
				}
			
		else if (n.data < v){
				n.right = delete(v, n.right);
				return n;
			}

		else{
			//delete the node n
			if(n.left ==null)
				return n.right;
			else if(n.right ==null)
					return n.left;
			else{
				n.data = get_delete_succ(n.left, n, 0);
				return n;	
			}
			
		}

	}

	private int get_delete_succ(node n, node parent, int side){
		if(n.right==null){
			if(side==0)
				parent.left = n.left;
			else
				parent.right = n.left;
			
			return n.data;
		}
		else
			return get_delete_succ(n.right, n, 1);

	}



	public void traverse_it(){
		
		System.out.println("iterative traverse");
		
		ArrayList<node> l = new ArrayList<node>();
		l.add(root);
		while(l.size()!=0){
			node temp = l.get(0);
			if(temp.left==null || temp.tf){
				System.out.println(temp.data);
				l.remove(0);
				if(temp.right!=null)
					l.add(0,temp.right);
			}
			else{
				if(!temp.tf){
					l.add(0,temp.left);
					temp.tf = true;
				}
			}

		}

	}




	public static void main(String arg[]){
		B_test b = new B_test();

		b.insert(1);
		b.insert(11);
		b.insert(4);
		b.insert(5);
		b.insert(41);
		b.insert(-4);
		b.insert(54);
		// b.traverse();

		// System.out.println(b.find(1));
		// System.out.println(b.find(54));
		b.delete(11);
		// b.delete(-5);
		b.traverse();
		b.traverse_it();

	}
}