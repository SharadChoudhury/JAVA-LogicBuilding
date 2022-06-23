package Recursion;
import java.util.*;
public class PrintSubsetsofArray {
	
	public static void printSubsets(int input[], int start, String outputSoFar) {
	//time: O(2^n)   		Space: O(2^n)
	//total calls= 2+ 2^2+ 2^3 + ....+2^n,  n = length of input (draw function call tree to understand)
	    if(start == input.length){
			System.out.println(outputSoFar);
			return;
		}
		// we choose not to include the first character
		printSubsets(input,start+1,outputSoFar);
		// we choose to include the first character
		printSubsets(input,start+1, outputSoFar+String.valueOf(input[start]+" "));
        
	}
    
	public static void printSubsets(int input[]) {
		// Write your code here
		printSubsets(input,0,"");
	}
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		printSubsets(input);
	}
		
}


	
