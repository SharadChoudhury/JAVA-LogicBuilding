package timeComplexity;

import java.util.Arrays;

public class TripletSumArray {

	public static int tripletSum(int[] arr, int num) {
		Arrays.sort(arr);
        int count=0;
     	for(int i=0;i<arr.length-2;i++){
            count=count+ pairSum(arr,num-arr[i],i+1);
        }
        return count;
	}
	
	public static int pairSum(int[] arr, int num, int start) {
		Arrays.sort(arr);		
		int i=start,j=arr.length-1;
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
				
				if(startEle==endEle) {
					int numEleStartToend= j-i+1;
					res += numEleStartToend * (numEleStartToend-1)/2;
					return res;
				}
				
				int temp_i= i+1;
				int temp_j= j-1;
				
				while(temp_i<=temp_j && arr[temp_i]==startEle) {
					temp_i++;
				}
				while(temp_i<=temp_j && arr[temp_j]==endEle) {
					temp_j--;
				}
				
				int eleFromStart = temp_i - i ;
				int eleFromEnd = j - temp_j ;
				
				res+= eleFromStart*eleFromEnd;	
				
				i=temp_i;
				j=temp_j;
			}
		}
		return res;
	}
    
	
	public static void main(String[] args) {
		int arr[]= {0,0,2,2,4,5,5,5,7};
		System.out.println(tripletSum(arr, 7));		
	}

}
