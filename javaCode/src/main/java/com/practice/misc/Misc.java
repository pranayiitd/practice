import java.util.*;


class Misc{

	public static void find_k(int[] arr, int k){
		Arrays.sort(arr);
		int i =0;
		int j = arr.length -1;
		while(i<j){
			if(arr[i]+arr[j] == k){
				System.out.format("(%d, %d)\n",arr[i],arr[j]);
				i++;j--;
			}
				
			else if(arr[i]+arr[j] > k)
				j--;
			else if(arr[i]+arr[j] < k)
				i++;
		}

	}


//  Longest substring in s without repeat of char.
	public static String lswr(String s){
		// HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		HashMap h = new HashMap();
		int gmax =0;
		int index =0;

		int max = 0;
		for(int i =0;i < s.length(); i++){
			char c = s.charAt(i);
			if(h.containsKey(c)== false){
				max++;
				h.put(c, i);
				if(max > gmax){
					gmax = max;
					index = i;
				}
			}
			else{
				int j = (Integer)h.get(c);
				h.put(c, i);

				max = i-j;
				Iterator it = h.entrySet().iterator();
				
				while(it.hasNext()){	
					Map.Entry et = (Map.Entry)it.next();
					char key = (Character)et.getKey();
					int k = (Integer)et.getValue();
					if(k < j)
						it.remove();
						// h.remove(key);

				}


			}

		}

		return s.substring(index-gmax+1, index+1);



	}


	public static void main(String arg[]){
		// int [] arr = {1,2,23,23,3434,34,1,2,23,0,23,22};
		// int k = 24;
		// find_k(arr, k);
		System.out.println(lswr("GEEKSFORGEEKS"));

	}
}