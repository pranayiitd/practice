import java.util.*;


class Anagram{
	public static boolean ana(String s){
		int i =0;
		int j = s.length()-1;
		boolean tf = true;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				tf= false;
				break;
			}
			i++;
			j--;
		}
		return tf;
	}
	
	public static ArrayList<String> pali(String s){
		ArrayList<String> arr = new ArrayList<String>();
		if(s.length()==1){
			arr.add(s);
		}
		else{
			ArrayList<String> temp = pali(s.substring(0,s.length()-1));
			char c = s.charAt(s.length()-1);

			for(int i=0;i<temp.size();i++){
				String word = temp.get(i);
				for(int j=0;j<=word.length();j++){
					String word_new = word.substring(0,j)+c+word.substring(j,word.length());
					arr.add(word_new);
				}
			}

		}
		return arr;
	}

	public static boolean anapali(String s){
		boolean tf = false;
		ArrayList<String> arr = pali(s);
		for(int i=0;i<arr.size();i++){
			if(ana(arr.get(i))){
				tf = true;
				break;
			}
		}
		return tf;
	}

	public static void main (String arg[]){
		Scanner sc = new Scanner(System.in);
		String s  = sc.nextLine();
		while(s!=""){
			System.out.println(anapali(s));
	//		System.out.println(s.substring(s.length(),s.length()));
			s  = sc.nextLine();
		}
	}
}