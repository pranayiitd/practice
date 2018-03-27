class node{
	int value=0;
	node left;
	node right;

	node(int v){
		value =v;
		left =null;
		right=null;
	}
}


class B{

public static int count_visible(node n, int max){
	if(n==null)
		return 0;
	else{
		if(n.value >=max)
			return count_visible(n.left, n.value)+ count_visible(n.right,n.value)+1;
		else
			return count_visible(n.left, max)+ count_visible(n.right,max);
	}
}

public static void main(String arg[]){
	node root = new node(0);
	node l1 = new node(1);
	node l2 = new node(1);
	node l3 = new node(2);
	root.left = l1;
	l1.left = l2;
	l1.right = l3;
	node r1 = new node(3);
	node r2 = new node(2);
	node r3 = new node(2);
	root.right = r1;
	r1.left = r2;
	r1.right = r3;

	System.out.println(count_visible(root, 1));

}

}