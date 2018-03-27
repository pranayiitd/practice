import java.util.*;
class Dynamic{

// Longest common substring in s1 and s2.
	public static String Lcs(String s1, String s2){
		int n = s1.length();
		int m = s2.length();

		int [][] matrix = new int[m][n];
		
		for(int i=0;i<n;i++){
			if(s1.charAt(i) == s2.charAt(0))
				matrix[0][i] = 1;
		}

		for(int j =0;j< m; j++){
			if(s2.charAt(j) == s1.charAt(0))
				matrix[j][0] =1;
		}

		
		for(int i =1; i< n; i++){
			for(int j =1; j< m; j++){
				if(s1.charAt(i) != s2.charAt(j))
					matrix[j][i] =0;
				else
					matrix[j][i] = 1+ matrix[j-1][i-1];
			}
		}
		int x =0;int y =0;
		int max = matrix[x][y];
		for(int a =0; a < m; a++)
			for(int b =0; b < n; b++){
				if(matrix[a][b] > max){
					max = matrix[a][b];
					x = a;
					y = b;
				}

			}

		//System.out.println();

		return s1.substring(y-max+1, y+1) ;
	}


// Longest common subsequence in s1 and s2.
	public static int lcss(String s1, String s2){
		int n = s1.length();
		int m = s2.length();
		int [][] matrix = new int[n][m];
		int [][] X = new int[n][m];
		int [][] Y = new int[n][m];
		
		// Intializing for the first char of both string.
		for(int i =0;i < n ; i++){
			if((s1.charAt(i) == s2.charAt(0)))
				matrix[i][0] = 1;
			else if(i > 0 && matrix[i-1][0] ==1)
				matrix[i][0] = 1;
		}

		for(int i=0; i< m ;i++){
			if((s1.charAt(0) == s2.charAt(i)))
				matrix[0][i] =1;
			else if(i>0 && matrix[0][i-1] == 1)
				matrix[0][i] = 1;
		}

		int gmax =0;
		int gx =0;
		int gy =0;
		for (int i=1; i< n; i++ ) {
			for (int j=1; j<m; j++) {
				if(s1.charAt(i) == s2.charAt(j)){
					matrix[i][j] = 1+ matrix[i-1][j-1];
					X[i][j] = i-1;
					Y[i][j] = j-1;
					if(gmax < matrix[i][j]){
						gmax = matrix[i][j];
						gx = i;
						gy =j;
					}
						
				}
					
				else{
					
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
					
					X[i][j] = i-1;
					Y[i][j] = j;
					
					if(matrix[i][j-1] > matrix[i-1][j]){
						X[i][j] = i;
						Y[i][j] = j-1;
					}
					
				}
					
				
				
			}
			
		}

		String ans = "";
		while(gx >= 0 && gy >=0 ){
			if(s1.charAt(gx) == s2.charAt(gy))
				ans = s1.charAt(gx)+ans;
			if(gx == X[gx][gy] && gy == Y[gx][gy])
				break;
			
			gx = X[gx][gy];
			gy = Y[gx][gy];
			// System.out.println(ans);	
		}
		System.out.println(ans);

		return gmax;
	}

	public static void main(String arg[]){
		String s1 = "GeeksforGeeeks";
		String s2 = "GeeeksQuiz";
		System.out.println(Lcs(s1, s2));
		s1 = "ABCDGH";
		s2 = "AEDFHR";

		System.out.println(lcss(s1, s2));
		s1 = "AGGTAB";
		s2 = "GXTXAYB";
		System.out.println(lcss(s1, s2));
		

	}
}