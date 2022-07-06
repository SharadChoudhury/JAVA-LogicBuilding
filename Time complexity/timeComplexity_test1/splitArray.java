package timeComplexity_test1;

import java.util.*;

public class splitArray {

	public static boolean splitArray(int input[],int start, int sum1, int sum2) {
		if(start==input.length)
			return sum1==sum2;
		
		if(input[start]%5==0)
			sum1 += input[start];
		else if(input[start]%3==0)
			sum2 += input[start];
		else {
			// or(||) is used because even if one way is possible according to 
			//to the conditions, ans should be true
			return splitArray(input, start+1, sum1+input[start], sum2)
			|| splitArray(input, start+1, sum1, sum2+input[start]);
		}
		
		return splitArray(input, start+1, sum1, sum2);
	}
	
	public static boolean splitArray(int input[]) {
		return splitArray(input, 0, 0, 0);
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(splitArray(input));
	}

}
