package priorityQueue;

public class checkMaxHeap {
	
	public static boolean checkmaxHeap(int arr[]) {
		//time : O(n)    space: O(1)
        for(int i=0; 2*i+1 < arr.length ; i++){  //while left child exists in heap
            int parent = i;
            int left = 2*i + 1 ;
            int right = 2*i + 2;

            if(arr[parent] < arr[left])
                return false;
            if(right < arr.length && arr[parent] < arr[right])
                return false;

        }
        
        return true;
	}
    
	
}
