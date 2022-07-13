package linked_List;

public class midpoint_of_LL {
	
	public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        //Time:	O(n)		Space:	O(1)
        
        if(head==null)
            return head;
        LinkedListNode<Integer> slow= head;
        LinkedListNode<Integer> fast= head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
}
