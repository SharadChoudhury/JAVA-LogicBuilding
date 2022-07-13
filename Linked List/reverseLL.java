package linked_List;

public class reverseLL {
	
	public static LinkedListNode<Integer> reverse_recursive(LinkedListNode<Integer> head){
        //recursive
//		time:	O(n) 			space:	O(n)
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        
        LinkedListNode<Integer> prev= reverse_recursive(head.next);
        head.next.next = head; //making the next node of current pointer point to current node
        head.next=null; //making current node point to null
        return prev;
        
    }
	
	public static LinkedListNode<Integer> reverse_Iterative(LinkedListNode<Integer> head){

        //iterative:
//		time:	O(n) 			space:	O(1)
         LinkedListNode<Integer> prev = null;
         LinkedListNode<Integer> current = head;
         LinkedListNode<Integer> next = null;
         while (current != null) {
             next = current.next;
             current.next = prev;
             prev = current;
             current = next;
         }
         head = prev;
         return head;
    }
	
}
