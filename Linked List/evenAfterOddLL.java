package linked_List;

/* approach:
 traverse the LL and keep appending odd nodes to odd list and even nodes to
 even list. Maintain 4 pointers: 
 1) odd head
 2) odd tail
 3) even head
 4) even tail
 
 in case only odds are present(even head=null) or only evens are present(odd head=null) 
 be careful with these pointers as some might be null so don't try to access them.
 
 if head=null, tail is obviously null
*/

public class evenAfterOddLL {
	//Time:O(n) 		  Space:O(1)
	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		//zero or no elements
        if(head==null  || head.next==null)
            return head;
        
        LinkedListNode<Integer> oddH = null;
        LinkedListNode<Integer> oddT = null;
        LinkedListNode<Integer> evenH = null;
        LinkedListNode<Integer> evenT = null;
        
        LinkedListNode<Integer> temp = head;
        
        while(temp!=null){
            //odd
            if(temp.data%2==1){
                if(oddH==null){
                    oddH=temp;
                    oddT=temp;
                }
                else{
                   	oddT.next=temp;
                    oddT=temp;
                }                
            }
            
            //even
            else{
                if(evenH==null){
                    evenH=temp;
                    evenT=temp;
                }
                else{
                  	evenT.next=temp;
                	evenT=temp;  
                }                
            }
            
           temp=temp.next;     
        }
        
        if(oddH==null){	//no odd
            evenT.next=null;
            return evenH;
        } 
            
        else if(evenH == null){ //no even
            oddT.next=null;
            return oddH;
        }
        
        else{
            oddT.next=evenH;
            evenT.next=null;
            return oddH;
        }
                           
	}
	
}
