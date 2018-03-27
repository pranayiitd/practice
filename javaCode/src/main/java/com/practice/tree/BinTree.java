class node{
	
	int data;
	node left;
	node right;
	
	node(int v){
		data = v;
	}
}

class BinTree{
	node root;

	BinTree(int v){
		root = new node(v);
	}

	public void insert( int v){
		root = insert(v, root);
	}

	private node insert(int v, node n){
		if(n==null)
			return new node(v);
		else{
			if(v <= n.data)
				n.left = insert(v, n.left);
			else
				n.right = insert(v, n.right);
			return n;
		}
	}

	public void traverse(){
		traverse(root);
		System.out.println("----");
	}
	
	private void traverse(node n){
		if(n == null)
			return;
		traverse(n.left);
		System.out.println(n.data);
		traverse(n.right);

	}

	public void delete(int v){
		root = delete(v, root);
	}

	private node delete(int v, node n){
		if(v < n.data)
			n.left = delete(v, n.left);
		if(v > n.data)
			n.right = delete(v, n.right);
		if(v == n.data){
			if(n.left == null)
				return n.right;
			else if(n.right == null)
				return n.left;
			// Both children not null
			else{
				n.data = get_succ(n.left, n, 0);
			}
		}
		
		return n;

	}

	private int get_succ(node n, node parent, int side){
		if(n.right == null){
			// The first left child is the answer.
			if(side == 0){
				parent.left = n.left;
				return n.data;
			}
			else{
				parent.right = n.left;
				return n.data;
			}
				
		}
		else
			return get_succ(n.right, n, 1);
	}

	public int get_lca(int a, int b){
		return get_lca(a, b, root);
	}
	
	private int get_lca(int a, int b, node n){
		if(n == null)
			return -1;
		else if(a <= n.data && b >= n.data)
			return n.data;
		else if(n.data > b)
			return get_lca(a, b, n.left);
		else 
			return get_lca(a, b, n.right);
		
	}


public static void main(String arg[]){
	BinTree b = new BinTree(1);
	b.insert(1);
	b.insert(-2);
	b.insert(13);
	b.insert(0);
	b.insert(-3);
	b.traverse();
	System.out.println(b.get_lca(-3, 0));

	// b.delete(1);
	// b.traverse();


}

}