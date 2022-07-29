package queue;
import java.util.*;
public class reverseFirstK_Q {
	
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		//Time:  O(n) 				Space:	O(k)
        
        Stack<Integer> stack= new Stack<>();
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0; i<k; i++){
            stack.push(input.poll());
        }
        
        for(int i=0;i<k;i++){
            q.add(stack.pop());
        }
        

        int temp= input.size();
        
        for(int i=0;i<temp;i++){  //cannot use i<input.size() directly as after each poll, input.size() changes
            q.add(input.poll());
        }
        
        return q;
	}
	
}
