package Recursion;

public class All_indexesImproved {
	
	private static int[] allIndexes(int input[], int x,int start) {
		//time: O(n^2)
		//space: O(n)
		if(start == input.length) {
			int out[] = new int[0];
			return out;
		}
		int smallout[]= allIndexes(input,x,start+1);
		if(input[start] == x) {
			int out[] = new int[smallout.length+1];
			out[0] = start;
			for(int i=0;i<smallout.length;i++) {
				out[i+1]= smallout[i];
			}
			return out;
		}
		else {
			return smallout;
		}
	}
	
	public static int[] allIndexes(int input[] ,int x) {
		return allIndexes(input,x,0);
	}
	
	
	public static void main(String[] args) {
		int input[] = {8,5,2,5,2,5};
		int[] res= allIndexes(input,5);
		for(int k:res)
			System.out.print(k+" ");

	}

}
