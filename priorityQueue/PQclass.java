package priorityQueue;
import java.util.*;

public class PQclass {

	private ArrayList<Integer> heap;

	public PQclass() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException{
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
        if(isEmpty())
            throw new PriorityQueueException();
        
        int ans = heap.get(0);
        heap.set( 0 , heap.get(heap.size()-1) );
        heap.remove(heap.size()-1);
        
        int parent = 0;
        int leftchild = 1;
        int rightchild = 2;
        
        while(leftchild < heap.size() && rightchild < heap.size()){            
            int min = Math.min( heap.get(parent) , Math.min( heap.get(leftchild) , heap.get(rightchild) ) );            
            if(heap.get(parent) == min)
                break;
            else if(heap.get(leftchild) == min){
                int temp = heap.get(leftchild);
                heap.set(leftchild, heap.get(parent));
                heap.set(parent, temp);
                parent = leftchild;
                leftchild = 2*parent + 1;
                rightchild = 2*parent + 2;
            }
            else{
                int temp = heap.get(rightchild);
                heap.set(rightchild, heap.get(parent));
                heap.set(parent, temp);
                parent = rightchild;
                leftchild = 2*parent + 1;
                rightchild = 2*parent + 2;
            }
        }
        
        return ans;
	}
}

class PriorityQueueException extends Exception {
	private static final long serialVersionUID = 1L;
}