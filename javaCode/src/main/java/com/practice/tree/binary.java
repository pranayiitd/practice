import java.util.*;

class node{
	int data;
	node left;
	node right;
	boolean visited;
	node(int v){
		data =v;
		left =null;
		right=null;
		visited =false;
	}
}

class binary{
	node root;
	
	binary(int v){
		root = new node(v);
	}

	public void insert(int v){
		root = insert(v,root);
	}
	private node insert(int v,node n){
		if(n==null)
			n = new node(v);
		else{
			if(n.data>=v)
				n.left = insert(v,n.left);
			else
				n.right = insert(v,n.right);
		}
		return n;
	}
	public boolean find(int v){
		return find(v,root);
		}
	
	private boolean find(int v,node n){
		if(n == null)
			return false;
		else{
			if(n.data==v)
				return true;
			else{
				if(n.data>= v)
					return find(v,n.left);
				else
					return find(v,n.right);
			}

		}
	}

	public static boolean findS(int v,node n){
		if(n == null)
			return false;
		else{
			if(n.data==v)
				return true;
			else{
				if(n.data>= v)
					return findS(v,n.left);
				else
					return findS(v,n.right);
			}

		}
	}


	public static int getNode(node parent,node child){
		if(child.left==null){
			int v = child.data;
			if(parent.left==child)
				parent.left =child.right;
			else
				parent.right=child.right;
			return v;
		}
		else
			return getNode(child,child.left);
	}

	public void delete(int v){
		delete(v,null,root);
	}

	private static void delete(int v,node parent,node n){

		if(n==null)
			return;

		//Found the value to be deleted.
		if(n.data ==v){
			if(n.right!=null)
				n.data = getNode(n,n.right);
			else{
				if(parent!=null){
					int i =0;
					if(parent.right==n)
						i=1;			
					
					if(i==0)
						parent.left = n.left;
					else
						parent.right = n.left;
				}
				else{
					n.data = n.left.data;
					n.right = n.left.right;
					n.left = n.left.left;
				}
			}
		
		/*
		if(parent!=null){
			
			int i =0;
			if(parent.right==n)
				i=1;

			//no left child
			if(n.left==null){
				if(i==0)
					parent.left = n.right;
				else
					parent.right = n.right;
			}
			//no right child
			else if(n.right==null){
				if(i==0)
					parent.left = n.left;
				else
					parent.right = n.left;
			}	
			//both children present
			else{
				n.data = getNode(n,n.right);//Get the least value on right subtree of node n and delete that node.
			}	
			
			}
			else{//parent == null,root is to be deleted.
				if(n.right!=null)
					n.data = getNode(n,n.right);
				else{
					n.data = n.left.data;
					n.right = n.left.right;
					n.left = n.left.left;
				}
			}
				if(n.left==null){
					if(n.right!=null){
						n.data = n.right.data;	
						n.left =  n.right.left;
						n.right = n.right.right;
					}
					else{
						n.left =null;
						n.right=null;
						n.data =-1;
					}
					
				}
					
				else{//left is not null
					n.right = n.left.right;
					n.left =  n.left.left;
					n.data = n.left.data;	
				}
			*/		
			

		}
		else{ //search further
			if(n.data>=v)
				delete(v,n,n.left);
			else
				delete(v,n,n.right);

		}
		
		}


	public static int distance(node n,int v){
		if(n.data ==v)
			return 0;
		else{
			if(n.data>=v)
				return 1+distance(n.left,v);
			else
				return 1+distance(n.right,v);
		}
	}

	public static int lca(int a,int b,node root){
		node temp = root;
		while(temp!=null){
			if(temp.data >=a && temp.data<=b){
				return distance(temp,a)+distance(temp,b)+1;
				//return temp.data;
			}
				
			else{
				if(temp.data > b)
					temp = temp.left;
				else
					temp = temp.right;
			}
		}
		return -1;
	}	

	public boolean checkBst(){
		return checkBst(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}

	private boolean checkBst(node n,int max,int min){
		if(n==null)
			return true;
		if(n.data >=min && n.data<max)
			return checkBst(n.left,n.data,min) && checkBst(n.right,max,n.data);
		else
			return false;

	}

	public static void traversal(node n){
		if(n==null){
			return;
		}
			
		else{
			traversal(n.left);
			System.out.format("%d ",n.data);
			traversal(n.right);
		}
	}

	public static void traverse_stack(node n){
		ArrayList<node> stack = new ArrayList<node>();
		stack.add(n);
		n.visited =true;
		while(!stack.isEmpty()){
			int l = stack.size()-1;
			node temp = stack.get(l);
		
			if(temp.left==null || temp.left.visited){
				System.out.format("%d ",stack.remove(l).data);
				if(temp.right!=null && !temp.right.visited){
					temp.right.visited =true;
					stack.add(temp.right);
				}
					
			}
			else{
				if(!temp.left.visited){
					stack.add(temp.left);
					temp.left.visited =true;
				}
			}

		}
	}
	
	
	public static void findPairs(int k,node n){
		if(n==null)
			return;
		else{
			findPairs(k-n.data,n.left);
			if(k-n.data > n.data){
				if(findS(k-n.data,n.right))
					System.out.format("%d,%d\n",n.data,k-n.data);
				findPairs(k,n.right);
			}
			else{
				if(findS(k-n.data,n.left))
					System.out.format("%d,%d\n",n.data,k-n.data);
				findPairs(k,n.left);
			}

		}
	}


	public static void main(String arg[]){
		binary b = new binary(1);
		b.insert(3);
		b.insert(2);
		b.insert(10);
		b.insert(5);
		b.insert(6);
		b.insert(11);
		b.insert(12);
		//b.root.left = new node(10);
		traversal(b.root);
		System.out.format("\n");
		//b.delete(42);
		//b.delete(1);
		//System.out.println(lca(1,12,b.root));
		b.delete(3);
		traversal(b.root);
		System.out.format("\n");
		traverse_stack(b.root);
		
		System.out.format("\n");
		
		System.out.println(b.checkBst());
		findPairs(16,b.root);

	}

}
