package linked_List;

public class reverseDoubleNode {
	
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head){
        return reverse(head).head;
    }
    
	 public static DoubleNode reverse(LinkedListNode<Integer> head){
		// 	Time:  O(n)			Space:  O(n)	
		//	if zero elements or one element only in LL, then no need to reverse
		if(head==null || head.next==null)
			return new DoubleNode(head, head);

		DoubleNode small= reverse(head.next);
		small.tail.next=head;
		head.next= null;
		return new DoubleNode(small.head, head);
		
	}
	 
}

class DoubleNode{
	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;
	
	DoubleNode(LinkedListNode<Integer> h, LinkedListNode<Integer> t){
		head=h;
		tail=t;
	}
}