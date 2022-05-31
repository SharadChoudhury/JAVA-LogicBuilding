package SearchingSorting;

public class SumoftwoArrays {
	
	public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
    	//time complexity= O(n)
		//space complexity= O(1)
				
		int i= arr1.length-1;
		int j= arr2.length-1;
		
		if(arr1.length>arr2.length) {
			int k = arr1.length;  //Since size of output array = arr1.length+1
			int carry=0;			
			while(j>=0) {
				output[k] = (carry + arr1[i] + arr2[j]) % 10;
				carry = (carry + arr1[i]+ arr2[j]) / 10;
				i--;
				j--;
				k--;
			}
			while(i>=0) {
				output[k]= (carry + arr1[i]) % 10;
				carry = (carry + arr1[i]) / 10;
				i--;
				k--;
			}
			output[k]=carry;
		}
		
		else {
			int k = arr2.length;  //Since size of output array = arr2.length+1
			int carry=0;			
			while(i>=0) {
				output[k] = (carry + arr1[i] + arr2[j]) % 10;
				carry = (carry + arr1[i]+ arr2[j]) / 10;
				i--;
				j--;
				k--;
			}
			while(j>=0) {
				output[k]= (carry + arr2[j]) % 10;
				carry = (carry + arr2[j]) / 10;
				j--;
				k--;
			}
			output[k]=carry;
		}		
		       
    }

	
	public static void main(String[] args) {
		int arr1[] = {9,4,5,6,2,3,9,5};
		int arr2[]= {1,3,4,2,5,0,0,0,0,0,0,0};
		
		int n1=arr1.length;
		int n2=arr2.length;
		int n3=Math.max(n1, n2)+1;
		
		int arr3[] = new int[n3];
		
		sumOfTwoArrays(arr1,arr2,arr3);
		
		for(int i:arr3)
			System.out.print(i+" ");
	}

}
