package Recursion;

public class SumOfArray {
	
	public static int sum(int[] input) {
		if(input.length==1)
			return input[0];
		
		int[] input_small= new int[input.length-1];
		for(int i=1 ; i<input.length; i++) {
			input_small[i-1] = input[i];
		}
		
		return input[0]+ sum(input_small);
	}
	
	public static void main(String[] args) {
		int[] arr= {6,4,7};
		System.out.println(sum(arr));
	}

}
