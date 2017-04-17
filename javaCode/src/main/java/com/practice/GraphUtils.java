import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
  public static void dfs(String[][] graph, boolean [][] visited, int row, int col, int n, int m){
      if(row >= n || row < 0 || col >= m || col < 0)
        return;
      if(visited[row][col] || !graph[row][col].equals("X"))
        return;
      visited[row][col] = true;
      dfs(graph, visited, row, col+1, n, m);
      dfs(graph, visited, row, col-1, n, m);
      dfs(graph, visited, row+1, col, n, m);
      dfs(graph, visited, row-1, col, n, m);
  }
  public static int countTree(String[][] graph, boolean [][] visited,
                              int n, int m){
      int count = 0;
      for(int row =0; row < n; row++){
          for(int col=0; col<m; col++){
              if(graph[row][col].equals("X") &&
                 !visited[row][col]){
                     count++;
                     dfs(graph, visited, row, col, n, m);
                     
                 }
          }
      }
      return count;
      }
  public static void main (String[] args) {
    /* Sample input
    2
    4 7
    OOOOXXO OXOXOOX XXXXOXO OXXXOOO
    10 3
    XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO
    */
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for(int i=0; i<t;i++){
        String [] dim = sc.nextLine().split(" ");
        int n = Integer.parseInt(dim[0]);
        int m = Integer.parseInt(dim[1]);
        String [] in = sc.nextLine().split(" ");
        
        boolean [][] visited = new boolean[n][m];
        String[][] graph = new String[n][m];
        
        for(int row=0; row<n;row++){
            String [] colArr = in[row].split("");
            for(int col=0; col<m;col++){
                graph[row][col] = colArr[col];
            }
        }
        System.out.println(countTree(graph, visited,n, m));
    }
  }
}