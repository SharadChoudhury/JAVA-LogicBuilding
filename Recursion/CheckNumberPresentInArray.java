package Recursion;

public class CheckNumberPresentInArray {
	
	public static boolean checkNumber(int input[], int x, int start) {	
        //time: O(n)
		//space: O(n)  --> for local variables. input array is not considered because we
		// only consider any extra space taken in the function.
		if(start==input.length){
            return false;
        }
        
		else if(input[start]==x){
            return true;
        }
        
        else{
           return checkNumber(input,x,start+1);
        }
        
	} 
	
	public static boolean checkNumber(int input[], int x) {
		return checkNumber(input,x,0);
	}
	
	public static void main(String[] args) {
		int[] arr= {6,4,7};
		System.out.println(checkNumber(arr,9));
	}

	
}
