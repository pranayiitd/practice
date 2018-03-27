import java.util.*;

class node implements Comparable<node>{
	int data;
	int row;int col;

	node(int v,int r,int c){
		data =v;
		row =r;
		col =c;
	}

	@Override
	public int compareTo(node n){
		return this.data-n.data;
	}
}

class queue{
	static PriorityQueue q = new PriorityQueue(12,Collections.reverseOrder());
	static PriorityQueue<node> qn = new PriorityQueue<node>();
	static ArrayList a = new ArrayList();
	static int[][] mat = {{1,2,3,5,6},{2,3,4,34,35},{7,8,9,10,11},
						  {4,5,5,6,7},{9,10,11,12,14}
							};
	
	
	public static void sort(){
		for(int i=0;i<mat.length;i++){
			qn.add(new node(mat[i][0],i,0));
		}
		while(qn.size()!=0){
			node temp = qn.remove();
			System.out.format("%d ",temp.data);
			if(temp.col!=(mat[0].length-1)){
				node t = new node(mat[temp.row][temp.col+1],temp.row,temp.col+1);
				qn.add(t);
			}
		}
	}

	public static void main(String arg[]){
		q.add(2);
		q.add(1);
		q.add(22);
		q.add(12);
		System.out.format("%b ",q.remove(22));
		 while(q.size()!=0){
			System.out.format("%d ",q.remove());
		 }

		 //System.out.println(q);
		 //System.out.println(q.peek());
		 //System.out.println(q.size());

		 qn.add(new node(1,2,2));
		 qn.add(new node(11,2,2));
		 qn.add(new node(5,2,2));
		 while(qn.size()!=0){
			System.out.format("%d ",qn.remove().data);
		 }
		 System.out.println();
		 sort();
		 System.out.println();
	}


}