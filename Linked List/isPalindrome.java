package linked_List;

public class isPalindrome {
	 
	public static boolean is_Palindrome(LinkedListNode<Integer> head) {
		
//		time:	O(n) 			space:	O(1)
		
        if(head==null)
            return true;
        
        int len = LinkedListUse.length(head);
        int i= 1;
        LinkedListNode<Integer> temp = head;
        while(i < len/2){
            temp = temp.next;
            i++;
        }
        
        LinkedListNode<Integer> head2 = temp.next;
        temp.next=null;
        
        head2= reverseLL.reverse_Iterative(head2);
        
        while(head!=null && head2!=null){
            if(head.data!=head2.data){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
	}
	
}
