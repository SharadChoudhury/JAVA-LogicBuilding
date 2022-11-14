package priorityQueue;
import java.util.*;
public class kLargestElements {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		//	Time:O(n*logk)	space:O(k)
		
		//Implementation using Inbuilt PriorityQueues.
		PriorityQueue<Integer> pq= new PriorityQueue<>();  
		//min of heap keep appearing at the root of min heap and is removed each time and replaced
		//with a larger element and in the end k largest elements are left in the heap
	    int i =0;
	    for(; i < k ;i++){
	        pq.add(input[i]);
	    }
	    
	    for(;i<input.length;i++){
	        if(input[i] > pq.peek()){
	            pq.poll();
	            pq.add(input[i]);
	        }
	    }
	    
	    ArrayList<Integer> ans = new ArrayList<>();
		
	    //in the end we are left with k largest elements in the pq, with kth largest element at
		// the root of heap, so we dequeue while this heap is not empty an after every deletion
		// the heap re-heapifies itself such that minimum of heap is at the root, so the polled
		//elements come out in sorted order
	    while(!pq.isEmpty()){
	        ans.add(pq.poll());
	    }
	    
	    return ans;
		
		
//	    //Actual internal Implementation: Using ArrayLists
//        ArrayList<Integer> ans = new ArrayList<>();
//        
//        for(int i=0; i < k ; i++){
//        	//insert first k elements and heapify after every insertion
//            ans.add(input[i]);
//            int child = ans.size()-1;
//            int parent = (child-1)/2 ;
//            
//            while(child > 0){  		//up-heapify
//                if(ans.get(child) < ans.get(parent)){
//                    int temp = ans.get(parent);
//                    ans.set(parent,ans.get(child));
//                    ans.set(child,temp);
//                    child = parent;
//                    parent = (child -1)/2;
//                }
//                else
//                    break;
//            }
//        }
//        
//        for(int i=k ; i < input.length; i++){
//        	
//            if(input[i] > ans.get(0)){ 
//            //if ith element is greater than root of heap, then replace root with ith element
//            //and down heapify
//                ans.set(0,input[i]); 
//                
//                int parent = 0;
//                int left = 1;
//                int right = 2;
//                int minIndex;
//                
//                while(left < k){  //k is the size of the heap
//                    minIndex = parent;
//                    if(ans.get(left) < ans.get(minIndex))
//                        minIndex = left;
//                    if(right < k && ans.get(right) < ans.get(minIndex))
//                        minIndex = right;
//                    if(minIndex != parent){   //swap
//                        int temp = ans.get(parent);
//                        ans.set(parent,ans.get(minIndex));
//                        ans.set(minIndex,temp);
//                        
//                        parent = minIndex;
//                        left = 2*parent + 1;
//                        right = 2*parent + 2;
//                    }
//                    else
//                        break;
//            	}
//            }
//        }
//        
//        return ans;
		
	}
    
}
