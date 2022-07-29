package queue;

import java.util.Queue;

public class reverseQ {

	public static void reverseQueue(Queue<Integer> input) {
		//Time:  O(n)				space:  O(n)
		
        if(!input.isEmpty()){
            int temp= input.poll();
            reverseQueue(input);
            input.add(temp);
        }
	}

	
}
