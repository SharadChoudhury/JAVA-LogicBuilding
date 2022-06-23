package Recursion;

public class PrintSubsequences {

	public static void printSubsequences(String input, String outputSoFar){
	//time: O(2^n)   		Space: O(2^n)
	//total calls= 2+ 2^2+ 2^3 + ....+2^n,  n = length of input (draw function call tree to understand)
		if(input.length() == 0){
			System.out.println(outputSoFar);
			return;
		}
		// we choose not to include the first character
		printSubsequences(input.substring(1), outputSoFar);
		// we choose to include the first character
		printSubsequences(input.substring(1), outputSoFar + input.charAt(0));		
	}
	
	public static  void printSubsequences(String input){		
		printSubsequences(input, "");
	}
	
	public static void main(String[] args) {
		printSubsequences("xty");
	}

}
