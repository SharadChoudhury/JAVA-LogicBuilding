package stacks;

public class StackUsingArray {
	// in Array implementation, size is determined by top index
	//all operations affected by top
	
	private int data[];
	private int top; // is the index of topmost element of stack
	
	public StackUsingArray() { // if capacity not mentioned
		data = new int[10];
		top = -1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public  boolean isEmpty(){
		return (top == -1);
	}
	
	public int size(){
		return top + 1;	
		}
	
	public int top() throws StackEmptyException{//returns element at top if stack not empty		
		if(isEmpty()){
			//StackEmptyException
			throw new StackEmptyException();
		}
		return data[top];
	}
	
	public void push(int elem) throws StackFullException{
		if(size() == data.length){  // top= data.length-1
//			throw new StackFullException();
			doubleCapacity();  // create new array with double capacity			
		}
		top++;
		data[top] = elem;
	}

	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		for(int i = 0; i <= top; i++){
			data[i] = temp[i];
		}
		
	}

	public int pop() throws StackEmptyException{//returns the element at top and deletes it
		if(size() == 0){
			//StackEmptyException
			throw new StackEmptyException();
		}
		int temp = data[top];
		top--;
		return temp;
		
	}
		
	
}
