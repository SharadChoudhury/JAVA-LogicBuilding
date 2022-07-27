package stacks;

public class StackUsingLL<T> { //since node is generic, Stack should also be generic
//size is initialized to 0 by constructor and increased at each push
// all operations are affected by head
//For efficient implementation: elements are inserted from the head side	
	
    //Define the data members
    private Node<T> head;
    private int size;


    public StackUsingLL() {
        //Implement the Constructor
        head=null;
        size=0;
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() { 
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return (head==null);
    }

    public void push(T element) {
        //Implement the push(element) function
        Node<T> newNode= new Node<T>(element);
        newNode.next=head;
        head=newNode;
        size+=1;
    }

    public T pop() throws StackEmptyException{
        //Implement the pop() function
        if(isEmpty())
            throw new StackEmptyException();
        Node<T> temp=head;
        head=head.next;
        temp.next=null;
        size--;
        return temp.data;
    }

    public T top() throws StackEmptyException {
        //Implement the top() function
        if(isEmpty())
            throw new StackEmptyException();
        return head.data;
    }
}