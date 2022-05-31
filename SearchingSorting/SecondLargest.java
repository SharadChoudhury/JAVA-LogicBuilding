package SearchingSorting;

public class SecondLargest {

	public static void main(String[] args) {
		
		int[] arr= {9,9,8,8,6,20,5,3};
        int n= arr.length;
        
     // time complexity: O(n)
     // Space complexity: O(1)
        
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
        	
            if(arr[i]>largest){
                secondlargest = largest;
                largest = arr[i];
            }
            
            if(arr[i]<largest && arr[i]>secondlargest) {
            	secondlargest=arr[i];
            }
        }
        System.out.println(secondlargest);
	   
	}

}
