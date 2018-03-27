class BitUtils{

  public static int countSetBits(int n){
    int count = 0;
    // loop will run number of times there are set bits
    while(n > 0){
      count++;
      // Unset ONLY right most set bit
      n = n & (n-1);
    }
    return count;
  }

  public static void findUniqueTwo(int [] arr){
    int allXor = 0;
    for(int e : arr){
        allXor = allXor ^ e;
    }
    // This bit only set in one of the dup.
    // So, can be used seprate them in two groups
    int onlySetBit = allXor & ~(allXor -1);
    System.out.printf("%s %s\n", allXor, onlySetBit);
    int x =0;
    int y =0;
    for(int e: arr){
        if(0 != (e & onlySetBit)){
          System.out.printf("1: %s\n", e);
           x = x ^ e;    
        }
        else{
          System.out.printf("0: %s\n", e);
            y = y ^ e;
        }
    }
    System.out.printf("%s %s\n",Math.min(x, y), Math.max(x,y) );
  }
    

  public static void main(String arg[]){
    // System.out.println(countSetBits(8));
    // System.out.println(countSetBits(1024));
    // int [] arr = {1, 1, 2, 2, 3, 4, 3, 4, 19, 199};
    int [] arr = {1, 2,  3,  2, 1, 4, 3, 4, 19, 111};
    findUniqueTwo(arr);
  }
}
