// check return_SubsetsSumK.png in screenshots to understand special case for this question 
//that affects lines 13 to 22

// NOTE: IT IS NOT NECESSARY THAT ALL ELEMNTS WILL BE POSITIVE. THEY ARE INTEGERS.SO DON'T 
// TAKE THE CASE OF NEGATIVE K TO RETURN EMPTY ARRAY. IT CAN GIVE WRONG ANSWERS

// it's VERY important to reach the end of input ARRAY even if K IS NEGATIVE OR 0, BECAUSE
// IT'S POSSIBLE THAT TILL WE REACH THE END INDEX WE MIGHT FIND AN ELEMENT THAT GIVES
// SUM EQUAL TO K.

package Recursion;
import java.util.*;
public class SubsetsOfArraySumK {
	
// {{}} is a 2d array of size 1: this means there is one way possible
	
//{} is an empty array (irrespective of dimension): this means there is no way possible
	
	public static int[][] subsetsSumK(int input[],int start, int k) {
		if(start==input.length) {
			if(k==0)
				return new int[1][0];
	//even if the index=input.length, to achieve a sum=0, there is exactly one way, 
		// i.e, an empty array, the sum of elements in [] is 0; so return [[]] .
			else
				return new int[0][0]; // if you are at index=input.length, there is no way you
		// can achieve a sum>0.
							
		}

		int[][] small_1= subsetsSumK(input, start+1, k-input[start]);
		int[][] small_2= subsetsSumK(input, start+1, k);
		
		int size= small_1.length+ small_2.length;
		int[][] res= new int[size][];
		if(size==0)
			return res;
		
		int p=0;
		for(int i=0;i<small_1.length;i++) { // case when start element has to be appended
			res[p]= new int[small_1[i].length+1];
			res[p][0]=input[start];
			for(int j=0;j<small_1[i].length;j++) {
				res[p][j+1]=small_1[i][j];
			}
			p++;
		}
		
		for(int i=0;i<small_2.length;i++) {// in second case, arrays in small_2 can be added
	// to result array as it is
			res[p]= small_2[i];
			p++;
		}
		
		return res;
	}
	
	public static int[][] subsetsSumK(int input[],int k){
		return subsetsSumK(input,0, k);
	}
	
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		int output[][] = subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
