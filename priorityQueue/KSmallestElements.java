package priorityQueue;
import java.util.*;
public class KSmallestElements {

	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		//	Time:O(n*logk)	space:O(k)
		
		//max heap
		PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
		
		//max of heap keep appearing at the root of max heap and is removed each time and 
		//replaced with a smaller element and in the end k smallest elements are left in the heap
		
        int i =0;
        for(; i < k ;i++){
            pq.add(input[i]);
        }
        
        for(;i<input.length;i++){
            if(input[i] < pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        
        return ans;
	}
	
}
