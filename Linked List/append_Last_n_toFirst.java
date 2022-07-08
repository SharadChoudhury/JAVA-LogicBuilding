package linked_List;

public class append_Last_n_toFirst {
	//time:		O(n)
	//space:	O(1)

	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        int i=0;          
        if(head==null)
            return head; 
        
        if(n == 0)
            return head;
        
        int len = LinkedListUse.length(head); 

        if(n == len)
            return null;
        
        if(n < len){        	
           	LinkedListNode<Integer> temp = head;
            while(i < len-n-1 ){
                i++;
                temp= temp.next;
            }			
            if(temp!=null){ //always take care if temp has not become null
                LinkedListNode<Integer> shiftIndx = temp.next;
                temp.next=null;
                temp = shiftIndx; 

                while(temp.next!=null){
                    temp=temp.next;
                }

                temp.next = head;
                head = shiftIndx;
            }           
            return head; 
        }
        
        return head;        
	}
	
}
