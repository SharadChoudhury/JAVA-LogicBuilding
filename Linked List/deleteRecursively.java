package linked_List;

public class deleteRecursively {
		
	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    	//Time:O(n) 		  Space:O(n)
		
        if(head==null)		//this condition should be placed first because if head=null,we
            return head;	//cannot return head.next
        
        if(pos==0)
            return head.next;
        
        head.next=deleteNodeRec(head.next,pos-1);
        return head;
	}
	
}
