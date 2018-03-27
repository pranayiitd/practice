import java.util.*;

class node implements Comparable<node>{
	int data;
	int row;
	int col;

	node(int d,int r,int c){
		data =d;
		row =r;
		col =c;
	}
	
	@Override
	public int compareTo(node n){
		return this.data-n.data;

	}
}

class amazonheap{
	static int[][] mat = {{1,2,3,5,6},{2,3,4,34,35},{7,8,9,10,11},
					  {4,5,5,6,7},{9,10,11,12,14}
						};

	static PriorityQueue<node> pq = new PriorityQueue<node>();
	static ArrayList a = new ArrayList();

	public static void sort(){
		for(int i=0;i<mat.length;i++){
			pq.add(new node(mat[i][0],i,0));
		}
		while(pq.size()!=0){
			node temp = pq.remove();
			if(temp.col!=mat[0].length-1)
				pq.add(new node(mat[temp.row][temp.col+1],temp.row,temp.col+1));
			a.add(temp.data);
		}
		System.out.println(a);
		System.out.println(a.get(0));
		a.set(0,10);
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.indexOf(10));

	}

	public static void main(String arg[]){
		sort();
	}

}
