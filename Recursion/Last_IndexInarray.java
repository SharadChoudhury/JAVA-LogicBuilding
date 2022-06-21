package Recursion;

public class Last_IndexInarray {
//to find last index where x was found in input array	
	
	public static int lastIndex(int input[], int x) {
		int start= 0;
        int found= -1;
        return lastIndex(input, x ,start,found);
	}
    
    private static int lastIndex(int input[],int x, int start, int found) {
    //	time: O(n) 	;	 Space: O(n)  ; n= size of input
        if(input[start]==x)
            found=start;
      
        if(start >= input.length-1)
            return found;
        
        return lastIndex(input,x,start+1,found);
    }
	
	public static void main(String[] args) {
		int input[] = {8,9,2,3,2};
		System.out.println(lastIndex(input,5));
	}

}
