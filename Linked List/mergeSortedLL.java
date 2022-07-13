package linked_List;

public class mergeSortedLL {
		
	public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //	time:	O(n1+n2)	n1=length of LL1 , n2= length of LL2
		//  space: O(1)
        LinkedListNode<Integer> t1= head1;
        LinkedListNode<Integer> t2= head2;
        LinkedListNode<Integer> h3= null;
        LinkedListNode<Integer> t3= null;
        
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        
        while(t1!=null && t2!=null){
            
        	if(t1.data <= t2.data){
        		if(h3==null){
        			h3= t1;
        			t3= t1;
        		} 
        		else {
        			t3.next = t1;
        			t3=t1;
        		}
        		t1=t1.next;
        	}	
        	
        	else{
        		if(h3==null){
        			h3= t2;
        			t3= t2;
        		} 
        		else {
        			t3.next = t2; 
        			t3 = t2;
        		}
        		t2=t2.next;
        	}  
            
        }
        
        if(t1==null)
        	t3.next = t2;
        else
            t3.next = t1;
        
        return h3;
    }
	
}
