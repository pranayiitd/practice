class node{
	node next;
	char value;
	node(char c){
		value =c;
		next =null;
	}
}

class pali{
	node head;
	pali(String s){
		char c = s.charAt(0);
		head = new node(c);
		node temp = head;
		for(int i=1;i<s.length();i++){
			temp.next = new node(s.charAt(i));
			temp = temp.next;
		}
	}

	void print(){
		node temp = head;
		while(temp!=null){
			System.out.format("%c -> ",temp.value);
			temp = temp.next;
		}

	}

	void printRev(node n){
		if(n.next==null)
			System.out.format("%c -",n.value);
		else{
			printRev(n.next);
			System.out.format("%c -",n.value);
		}
	}

	
	public static void main(String arg[]){
		pali l = new pali("Pranay Agarwal\n");
		l.print();
		l.printRev(l.head);
	}

}