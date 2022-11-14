package priorityQueue;
import java.util.*;

public class kthLargest {
	
	public static int kthlargest(int n, int[] input, int k) {
		//Time: O(n*logk)  		space:O(k)
        
       PriorityQueue<Integer> pq= new PriorityQueue<>();
       int i =0;
       for(; i < k; i++){
           pq.add(input[i]);
       }

       for(;i<input.length;i++){
           if(input[i] > pq.peek()){
               pq.poll();
               pq.add(input[i]);
           }
       }

       return pq.peek();

	}
	
}
