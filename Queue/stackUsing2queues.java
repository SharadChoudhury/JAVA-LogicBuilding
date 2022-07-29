package queue;
import java.util.*;
public class stackUsing2queues {
	
	Queue<Integer> q1 ;
    Queue<Integer> q2 ;

    public stackUsing2queues() {
        //Implement the Constructor 
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }


    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return q1.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return q1.isEmpty();
    }

    public void push(int element) {		 // time : O(1)
        //Implement the push(element) function
        q1.add(element);      
    }

    public int pop() {					// time : O(n)
        //Implement the pop() function
        if( !q1.isEmpty()){
            while(q1.size() > 1){
            	q2.add( q1.poll() );
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return q2.poll();  
        }
        return -1;       
    }

    public int top() {					// time : O(n)
        //Implement the top() function
        
        if( !q1.isEmpty()){
            while(q1.size() > 1){
            	q2.add( q1.poll() );
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            q1.add( q2.peek() );
        	return q2.poll();  
        }
      	 return -1; 
    }
	
}
