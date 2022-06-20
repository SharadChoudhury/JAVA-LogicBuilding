package Recursion;

public class FirstIndex {
	
	public static int firstIndex(int input[], int x) {
		int start=0;
        return firstIndex(input, x ,start);
	}
    
    private static int firstIndex(int input[],int x, int start) { // helper function
    //time : O(n)
    //space: O(n)
    	
        if(input[start]==x)
            return start;
        if(start >= input.length-1) //this is when start=input.length-1 and input[start]!=x
            return -1;
        return firstIndex(input,x,start+1);

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {8,9,2,3};
		System.out.println(firstIndex(input,2));
	}

}
