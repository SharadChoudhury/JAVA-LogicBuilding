package linked_List;

/*Approach:
 * 1. write down initial position of all nodes
 * 2. take 4 pointers: p1, c1 and p2, c2
 * 3. c1 and c2 point the nodes to be swapped and p1 and p2 point to previous nodes respectively
 * 4. draw the final position of nodes after swapping
 * 5. check the changed links and write them using the 4 pointers comparing the states
 * 		before and after swapping
 * 6. Four cases are possible:
 * 		a. any one node is the head and other node is next node of head(successive nodes)
 * 		i==0||j==0  && |i-j|==1
 * 
 * 		b. any one node is head
 * 		c. successive nodes
 * 		d. all other cases
 * 7. handle each case separately
 */

public class swapTwoNodes {
	//time: O(n)     space:O(1)
	
	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		
        if(head==null || head.next==null || i==j)
            return head;
        
        int m=0, n=0;
        
        LinkedListNode<Integer> p1= null;
        LinkedListNode<Integer> c1= head;
        LinkedListNode<Integer> p2= null;
        LinkedListNode<Integer> c2= head;
        LinkedListNode<Integer> temp= null;
        
        while( m<i && c1!=null ){
            p1=c1;
            c1 = c1.next;
            m++;
        }
        
        while(n< j && c2!=null ){
            p2=c2;
            c2= c2.next;
            n++;
        }
        
        if( (i==0 || j==0 ) && Math.abs(i-j)==1 ){
            c1.next = c2.next;
            c2.next = c1;
            return c2;
        }
        
        else if( Math.abs(i-j) == 1 ){
            p1.next= c2;
            c2.next= c1;
            c1.next= c2.next;
            return head;
        }
        
        else if( i==0 || j==0 ){
            temp = c2.next;
            c2.next= c1.next;
            p2.next=c1;
            c1.next=temp;
            return c2;
        }
        else{
            p1.next=c2;
            p2.next=c1;
            temp=c1.next;
            c1.next=c2.next;
            c2.next= temp;
            
            return head;            
        }
        
    }
	
}
