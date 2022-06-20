package Recursion;
import java.util.*;
public class CountZeros {

	// First try to think how you usually count zeros in a number (num).
	// we do num%10 (and num=num/10) repetitively and update count if num%10==0
	// this is a recursive task. So break into smaller tasks
	//in each recursive step find the modulo of num and update count if it's equal to 0
		
	private static int countZerosRec(int input, int count){	
	//time : O(logn) [base 10]; 	space: O(logn) 
		if(input==0)
			return count;		
		if(input%10==0)			
			count+=1;		
		return countZerosRec(input/10,count);		
	}	
	
	public static int countZerosRec(int input){
		if(input==0)
			return 1;
		else 
			return countZerosRec(input,0);
	}
	
	//alternative
	public static int countZeros(int input) {
	//time : O(logn) [base 10]; 	space: O(logn) 
		if(input<10) {
			if(input==0)
				return 1;
			else
				return 0;
		}
		
		if(input%10==0)
			return countZeros(input/10) + 1;
		else
			return countZeros(input/10);
	}
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
        System.out.println(countZerosRec(n));

	}
}
