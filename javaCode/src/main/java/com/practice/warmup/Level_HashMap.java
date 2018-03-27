import java.util.*;

class node{
	int data;
	node left;
	node right;
	int h;
	node(int v){
		data =v;
		left = null;
		right =null;
		h =0;
	}
}

class binary{
	
	node root;
	binary(int v){
		root = new node(v);
	}

	public void insert(int v){
		root = insert(root,v);
	}

	private node insert(node n,int v){
		if(n==null)
			return new node(v);
		else{
			if(v <= n.data)
				n.left = insert(n.left,v);
			else
				n.right = insert(n.right,v);
			return n;
		}
	}

	public void traverse(){
		traverse(root);
	}

	private void traverse(node n){
		if(n==null)
			return;
		else{
			traverse(n.left);
			System.out.format("%d ",n.data);
			traverse(n.right);
		}
	}
}
	
class Level_HashMap{
	static ArrayList<node> level = new ArrayList<node>();
	static binary b = new binary(4);
	static HashMap<Integer,ArrayList> has = new HashMap<Integer,ArrayList>();
		
	public static void traverse(){
		level.add(b.root);
		while(!level.isEmpty()){
			node temp = level.remove(0);
			System.out.format("%d ",temp.data);

			if(has.containsKey(temp.h))
				has.get(temp.h).add(temp.data);
			else{
				ArrayList a = new ArrayList();
				a.add(temp.data);
				has.put(temp.h,a);
			}


			if(temp.left!=null){
				temp.left.h = temp.h+1;
				level.add(temp.left);
			}
			if(temp.right!=null){
				temp.right.h = temp.h+1;
				level.add(temp.right);
			}
			if(!level.isEmpty() && temp.h!=level.get(0).h)
				System.out.format("\n");
				
		}
		System.out.format("\n");
	}

	public static void traHash(){
		int i=0;
		while(has.containsKey(i)){
			System.out.println(has.get(i));	
			i++;
		}
		
	}

	public static void traHashRec(){
		Iterator it = has.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry et = (Map.Entry)it.next();
			System.out.println(et.getValue());
		}
	}

	public static void main(String arg[]){
		b.insert(522);
		b.insert(62);
		b.insert(7);
		b.insert(2);
		b.traverse();
		System.out.format("\n");
		traverse();
		traHash();
		traHashRec();
	}
}
