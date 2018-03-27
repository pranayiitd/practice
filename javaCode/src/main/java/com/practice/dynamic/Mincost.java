import java.util.*;

class Mincost{

	public static void get_cost(int[][] total, int[][] cost){

		// The first row
		for(int i=0;i<total[0].length;i++){
			int prev =0;
			if(i>0)
				prev = total[0][i-1];
			total[0][i] = prev + cost[0][i];
		}

		for(int j=0;j < total.length; j++){
			int prev =0;
			if(j>0)
				prev = total[j-1][0];
			total[j][0] = cost[j][0]+prev;
		}

		for(int i=1;i<total.length;i++){
			for(int j=1;j<total[0].length;j++){
				 int c = Math.min(total[i-1][j],total[i-1][j]);
				 c = Math.min(c,total[i-1][j-1]);
				 total[i][j] =c+cost[i][j];
			}
		}
	

	}

	public static void main(String arg[]){
		int[][] cost ={
						{1,2,3},
						{4,8,2},
						{1,5,3},
						};

		int [][] total = new int[cost.length][cost[0].length];
		get_cost(total, cost);
		System.out.println(Arrays.toString(total[0]));
		System.out.println(Arrays.toString(total[1]));
		System.out.println(Arrays.toString(total[2]));
		System.out.println(total[2][2]);

	}
}