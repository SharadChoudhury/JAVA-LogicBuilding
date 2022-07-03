package timeComplexity;

import java.util.Arrays;

public class PairSumInArray {

	public static int pairSum(int[] arr, int num) {
		Arrays.sort(arr);
		
		int i=0,j=arr.length-1;
		int res=0;
		
		while(i<j) {
			
			if(arr[i]+arr[j]< num) {				// sum < num
				i++;
			}
			
			else if(arr[i] + arr[j] > num) { 		// sum > num
				j--;
			}
			
			else { 									// sum = num
				int startEle= arr[i];
				int endEle = arr[j];
				
				if(startEle == endEle) {  //if both elements are same 
					int numEleStartToend= j-i+1;  //count of elements from i to j
					res += numEleStartToend * (numEleStartToend-1)/2;
					return res;
				}
				
				int temp_i= i+1;
				int temp_j= j-1;
				
				while(temp_i<=temp_j && arr[temp_i]==startEle) {
					temp_i++;
				}
				while(temp_j>=temp_i && arr[temp_j]==endEle) {
					temp_j--;
				}
				
				int eleFromStart = temp_i - i ;  	//count of same elements as at i
				int eleFromEnd = j - temp_j ;		// count of same elements as at j
				
				res+= eleFromStart*eleFromEnd;	
				
				i=temp_i;
				j=temp_j;
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		int arr[]= {2,2,2,2};
		System.out.println(pairSum(arr, 4));
	}

}
