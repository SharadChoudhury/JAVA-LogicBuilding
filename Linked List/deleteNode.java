package linked_List;

public class deleteNode {
	
	public static LinkedListNode<Integer> delete_Node(LinkedListNode<Integer> head, int pos) {
		//	time:	O(min(pos,n))
		//	space:	O(1)
        int i =0;
        LinkedListNode<Integer> temp= head;
        
        if(head==null)		//very important case, otherwise if list is empty
        	// and pos=0, then null pointer exception
            return head;
        
        if(pos==0){
            return head.next;
        }
        
        while(i<pos-1 && temp!=null){
            i++;
            temp = temp.next;
        }
        
        if(temp!=null && temp.next != null){
            temp.next=temp.next.next;
        }
        
        return head;
	}
	
}
