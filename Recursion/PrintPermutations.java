package Recursion;

public class PrintPermutations {
	
	public static void FindPermutations(String input, String output) {
	//time : O(N!)     Space: O(N)
		if(input.length()==1){
			System.out.println(output+input);
        	return;
        }
		
		for(int i=0;i<input.length();i++) {
			FindPermutations( input.substring(0,i)+input.substring(i+1) , output+input.charAt(i) );
		}
	// input.substring(0,i) returns the permutations of string from start till (i-1)th character
	// input.substring(i+1) returns the permutations from (i+1)th character till end
	// so we fix the ith char in the output string and pass rest of chars in input string to
	// next function call and find their permutations and append output string to these permutations

	}

	public static void FindPermutations(String input){
		FindPermutations(input,"");
	}
	
	public static void main(String[] args) {
		FindPermutations("cat");

	}

}
