package linked_List;

public class bubbleSortLL {

	// way 1:
	public static LinkedListNode<Integer> bubbleSort1(LinkedListNode<Integer> head) {
		
		//time: O(n^2) 		space:O(1)
		
		if(head==null || head.next==null)
            return head;
        
        LinkedListNode<Integer> end= null;		//no of comparisons decrease by 1 at 
//each iteration, so keep decreasing end till it reaches the 2nd node of LL(head.next)
        
        LinkedListNode<Integer> p= null;		//previous
        LinkedListNode<Integer> c= head;		//current
        LinkedListNode<Integer> n= null;		//next
        LinkedListNode<Integer> temp= null;
          
    	for (end =null ; end!= head.next ; end= c)
    	{ // if elements from 2nd node till last of LL are sorted, then the list
    		//is fully sorted so break
    		
            for ( p = c= head; c.next!= end ; p=c, c=c.next ) 
            {	// iterate till current pointer is just before end (list is 
            	//sorted from end till last of LL
            	
               	n= c.next;  
                if (c.data > n.data)
                {
                    c.next= n.next;
                    n.next= c;
                    
                    if(c== head)
                        head = n;
                    else
                        p.next= n;   
                    
                    temp= n;
                    n= c;
                    c= temp;
                }

            }
            // now 'c' points to the node just before 'end'
            // so decrement 'end' to point to 'c' now, i.e,  end = c

    	}
	       
        return head;     

	}
	
	
	//way 2:
	public static int length(LinkedListNode<Integer> head){
        int len=0;
        while(head!= null){
            len++;
            head = head.next;
        }
        return len;
	}
	
	
	public static LinkedListNode<Integer> bubbleSort2(LinkedListNode<Integer> head){
		
		//time: O(n^2) 		space:O(1)
		
		int n= length(head);
		
		int i=0,j=0;
		
		for(i=0; i< n-1 ; i++) {		//won't even enter the loop if n=0 or n=1
			//in each pass, comparisons start from the head
			LinkedListNode<Integer> prev= null;
			LinkedListNode<Integer> curr = head;
			
			for(j=0; j<n-i-1 ; j++) {
				
				if(curr.data <= curr.next.data) {
					prev=curr;
					curr=curr.next;
				}
				else {	
					
					if(prev==null) {
						LinkedListNode<Integer> temp= curr.next;
						head=head.next;
						curr.next=temp.next;	
						temp.next=curr;//this line should be followed by above line
                        //otherwise loop is formed i.e , curr.next points to itself
						prev = temp;   
						//curr is not changed because after the swapping , curr pointer
						// is at its right position
					}					
					else {
						LinkedListNode<Integer> temp = curr.next;
						prev.next= temp;						
						curr.next=temp.next;
                        temp.next=curr;		//this line should be followed by above line
                        //otherwise loop is formed i.e , curr.next points to itself
						prev= temp;		
						//curr is not changed because after the swapping, curr
						// is at its right position
					}
					
				}
				
			}
			
		}
		
		return head;
	}
	
	
}
