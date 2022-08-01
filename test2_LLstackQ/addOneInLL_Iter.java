package test2_LLstackQ;

public class addOneInLL_Iter {
//time:O(n)		space:O(1)
	
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head){
        head = reverse(head);
        head = next(head);
        return reverse(head);
	}
	
	public static LinkedListNode<Integer> next(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> res = head;
        LinkedListNode<Integer> temp = null;
 
        int carry = 1, sum;
 
        while (head != null) // while both lists exist
        {
            sum = carry + head.data;
 
            carry = (sum >= 10) ? 1 : 0;

            sum = sum % 10;
 
            head.data = sum;
 
            temp = head;
            head = head.next;
        }
 
        if (carry > 0)
            temp.next = new LinkedListNode<Integer>(carry);
 
        return res;
	}
	
	static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> prev = null;
       	LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
	
}
