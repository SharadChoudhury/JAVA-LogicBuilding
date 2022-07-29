package queue;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class QueueLL {
	
	private Node front;
    private Node rear;
    private int size;

	public QueueLL() {
		//Implement the Constructor
        front=null;
        rear=null;
        size=0;
	}
	


	/*----------------- Public Functions of Stack -----------------*/


	public int getSize() { 
		//Implement the getSize() function
        return size;
    }


    public boolean isEmpty() { 
    	//Implement the isEmpty() function
        return (size==0) ;
    }


    public void enqueue(int data) {
    	//Implement the enqueue(element) function
        Node n= new Node(data);
        if(size==0){
           	front= n;
        	rear= n;
        }
        else{
            rear.next=n;
            rear = n;
        }
        size++;
        
    }


    public int dequeue() {
    	//Implement the dequeue() function
        if(front==null)
            return -1;
        int temp= front.data;
        front=front.next;
        size--;
        return temp;
    }


    public int front() {
    	//Implement the front() function
        if(front==null)
            return -1;
        return front.data;
    }
	
}
