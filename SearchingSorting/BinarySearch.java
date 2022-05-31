package SearchingSorting;

public class BinarySearch {
	// time complexity: O(logn)
	// Space complexity: O(1)
	
	public static int binarySearch(int[] arr, int x) {
        
        int n = arr.length;
        int start=0, end=n-1 ,mid;
        
        while(start<=end){   
        	
            mid=(start+end)/2;            
            if(x==arr[mid])
            	return mid;
            else if(x > arr[mid])
            	start=mid+1;
            else
            	end = mid-1;           
        }
        
        return -1;
        
    }

	public static void main(String[] args) {
		int[] arr= {1, 3, 7, 9, 11, 12, 45};
		System.out.println(binarySearch(arr,9));
	}

}
