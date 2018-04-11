class Island{
    
    public static int count(int[][] rect){
        if(rect == null || rect.length < 1){
            return 0;
        }
        
        int m = rect.length;
        int n = rect[0].length;
        int count = 0;
        
        //
        //boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j ++){
                if(rect[i][j] == 1){
                    count++;
                    traverse(rect, i, j);
                }
            }
        }
        
        return count;
    
    }
    
    public static void traverse(int[][] rect, int i, int j){
        if(i < 0 || j < 0 || i >= rect.length || j >= rect[0].length){
            return;
        }
        if(rect[i][j] == 0){
            return;
        }
        //System.out.println(i + ", " + j);
        //visited[i][j] = true;
        rect[i][j] = 0;
        traverse(rect, i+1, j);
        traverse(rect, i, j+1);
        traverse(rect, i-1, j);
        traverse(rect, i, j-1);
    }
    
    public static void main(String arg[]){
        
        int [] [] rect = {
                    {1, 0, 0, 0, 1, 0, 0},
                    {1, 1, 1, 1, 1, 0, 0}, 
                    {0, 0, 0, 0, 0, 1, 1},
                    {1, 1, 0, 0, 0, 1, 1}
                    };
        System.out.printf("Count of island: %s\n", count(rect));                    
    }
    
}