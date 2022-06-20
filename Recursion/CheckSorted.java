package Recursion;


public class CheckSorted {
//recursive approach is better as time:O(n) and space:O(1)	[ compare adjacent elements and
	//return false if arr[i]>arr[i+1] 
	
	public static boolean checkSorted(int input[]){
		//time : O(n^2)
		//space: O(n^2)
			if(input.length <= 1){
				return true;
			}
			if(input[0] > input[1]){
				return false;
			}
			 
			int smallInput[] = new int[input.length - 1];
			for(int i = 1; i < input.length; i++){
				smallInput[i - 1] = input[i];
			}
			boolean smallAns = checkSorted(smallInput);
			return smallAns;
	
	}
	
	public static boolean checkSortedBetter(int input[],int startIndex){
		// shifting window method
		//time: O(n)
		//space: O(n), k space for each call, so k*n space for n calls
		if(startIndex >= input.length - 1){
			return true;
		}
		if(input[startIndex] > input[startIndex + 1]){
			return false;
		}
		boolean smallAns = checkSortedBetter(input, startIndex + 1);
		return smallAns;
		
	}

	public static void main(String[] args) {
		int input[] = {8,9,2,3};
		System.out.println(checkSorted(input));

	}

}
