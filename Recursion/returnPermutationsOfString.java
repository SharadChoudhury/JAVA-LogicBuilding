package Recursion;

public class returnPermutationsOfString {

	//method-1
	public static String[] permutation1(String input){
		if(input.length()==0)
			return new String[] {""};
		
		String[] res= new String[fact(input.length())];
		
		int k=0;
		for(int i=0;i<input.length();i++) {
			String[] out= permutation1(input.substring(0,i)+input.substring(i+1));
			for(int j=0;j<out.length;j++) {
				res[k] = input.charAt(i) + out[j];
				k++;
			}
		}	
		return res;
		
	}

	//method -2
	public static String[] permutation2(String input) {
		if(input.length()==1)
			return new String[] {input};
		
		String[] res= new String[fact(input.length())];
		
		int k=0;
		String[] out= permutation2(input.substring(1));	
		
		for(int i=0;i<out.length;i++) {
			for(int j=0;j<input.length();j++) {
				res[k]= out[i].substring(0,j) +input.charAt(0) +out[i].substring(j);
				k++;
			}
		}
		
		return res;
	}
	
	public static int fact(int n) {
		if(n==0 || n==1) 
			return n;
		
		return n*fact(n-1);
	}

	
	//main 
	public static void main(String[] args) {		
		String arr[]= permutation2("abdc");
		for(String s: arr) {
			System.out.print(s+" ");
		}
	}

}
