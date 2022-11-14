package priorityQueue;
import java.util.*;

public class runningMedian {
	
	public static void findMedian(int arr[])  {
        //Time: O(n*logn)		space:O(n)
		
		/* 	Dividing the array of integers into 2 halves:
		 * 	if arr size is odd : one heap will have more elements, return its root
		 * 	if arr size is even : median is the avg of largest element of 1st half and smallest element of 2nd half
		 */
		
		//1st half is max heap
        PriorityQueue<Integer> max1 = new PriorityQueue<>(Collections.reverseOrder());
        //2nd half is min heap
        PriorityQueue<Integer> min2 = new PriorityQueue<>();
        
        int median = 0;
        
        for(int i = 0; i<arr.length ; i++){
            //   insertion
            if(max1.size() == 0 && min2.size() == 0)
                max1.add(arr[i]);
            else if(arr[i] <= max1.peek())
                max1.add(arr[i]);
            else
                min2.add(arr[i]);
            
    /*
     * balancing and finding median
     * 1.	Always maintain both heap sizes such that their difference in size is <= 1
     * 2.	if size difference == 2 , then dequeue from the heap with larger size and add 
     * 		this element to smaller heap after which both heaps become of equal sizes
     * 3.	when both heap sizes are equal, the median is the average of roots of two heaps
     * 4.	when one heap size is greater (difference in heap size == 1), then median is the
     * 		root of heap with larger size
     * 
     * It is called running median because we are finding the median at each step treating the array as a stream 
     * of integers
     */
            
            if(max1.size() == min2.size()){
                median = (max1.peek()+min2.peek())/2;
            }
            else if(max1.size() - min2.size() == 2){
                min2.add(max1.poll());
                median = (max1.peek() + min2.peek())/2;
            }
            else if(max1.size() - min2.size() == 1){
               median = max1.peek(); 
            }
            else if(min2.size() - max1.size() == 2){
                max1.add(min2.poll());
                median = (max1.peek() + min2.peek())/2;
            }
            else if(min2.size() - max1.size() == 1){
                median = min2.peek();
            }
            
            System.out.print(median +" ");
        }
        
	}
	
}	
