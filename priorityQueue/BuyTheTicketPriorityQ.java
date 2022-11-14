package priorityQueue;
import java.util.*;

public class BuyTheTicketPriorityQ {
	
	public static int buyTicket(int input[], int k) {
		//time: O(n*logn)    space:O(n)
		
        PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<Integer>();
        
        //adding elements to pq so that they get stored there with max element at top
        //adding indexes to q so that we can compare wrt k
        for(int i=0; i<input.length; i++){
            pq.add(input[i]);
            q.add(i);
        }
		
        int time = 0;
        while(!q.isEmpty()){
        	//when person standing at first of q has highest priority then remove it from both
        	//queues and increase time by 1 sec
            if( pq.peek() == input[q.peek()] ){
                time++;
                pq.poll();
                //if first element in q was at index k, break. Even if this condition is not true
                //the first element of q gets deleted as soon as we call q.poll()
                if(q.poll() == k)
                    break;
            }
            else{
            	//make the first person in q stand at the end of q
                q.add(q.poll());
            }
        }
        
        return time;
	}
	
}
