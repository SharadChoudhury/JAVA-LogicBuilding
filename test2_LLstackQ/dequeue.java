package test2_LLstackQ;

public class dequeue {

    int  arr[];
    int  front;
    int  rear;
    int  size;
     
    public dequeue(int size)		//constructor
    {
        arr = new int[size];
        front = -1;
        rear = -1;
        this.size = size;
    }
  
    
    boolean isFull(){
        return ( (front == 0 && rear == size-1) || front == rear+1);
    }
  
    boolean isEmpty (){
        return (front == -1);
    }
  

    void insertFront(int key){
        // check whether Deque if  full or not
        if (isFull())
            System.out.println("-1");

        // If queue is initially empty
        if (front == -1){
            front = 0;
            rear = 0;
        }        
        // front is at first position of queue
        else if (front == 0)
            front = size - 1 ; 		//previous index of 0 is size-1 in a circular array  
        // decrement front end by '1'
        else 
            front = front-1;
  
        // insert current element at front index
        arr[front] = key ;
    }
  

    void insertRear(int key){
    	// check if full
        if (isFull())
            System.out.println("-1");
  
        // If queue is initially empty
        if (front == -1){
            front = 0;
            rear = 0;
        }
        else
        	rear = (rear + 1) % size ;
//        // rear is at last position of queue
//        else if (rear == size-1)
//            rear = 0;			//next index to size-1 is 0 in a circular array
//  
//        // increment rear end by '1'
//        else
//            rear = rear+1;
         
        // insert current element into Deque
        arr[rear] = key ;
    }
  

    int deleteFront(){
        // check whether Deque is empty or not
        if (isEmpty())
            return -1 ;
 		
        int temp = arr[front];        
        
        if (front == rear){				// Deque has only one element
            front = -1;
            rear = -1;
        }
        else{       					// back to initial position                            
//            if (front == size -1)
//                front = 0;               
//            else 						// increment front by '1' to remove current
//            	front = front+1;		// front value from Deque   
        	front = (front + 1) % size;
        }
        
        return temp;
    }
  

    int deleteRear(){
        if (isEmpty())
            return -1;
	
        int temp= arr[rear];
        
        // Deque has only one element        
        if (front == rear){	// single element case has to be handled in both deleteFront        	
            front = -1;			// and deleteRear
            rear = -1;
        }
        else if (rear == 0)
            rear = size-1;
        else
            rear = rear-1;
        
        return temp;
    }
  

    int getFront(){
        // check whether Deque is empty or not
        if (isEmpty())
            return -1 ;

        return arr[front];
    }
  

    int getRear(){
        // check whether Deque is empty or not
        if(isEmpty() || rear < 0)
            return -1 ;

        return arr[rear];
    }
    
}