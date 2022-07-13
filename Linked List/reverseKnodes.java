package linked_List;

public class reverseKnodes {
	
	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		//Time: O(k* n/k)= O(n)
		//space: O(n/k)
		
		//recursive
		if(k==0)
			return head;

		LinkedListNode<Integer> newH= null;
		LinkedListNode<Integer> newT= null;
		LinkedListNode<Integer> temp= head;
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> next = null;
		int i=0;
		
		while(curr!=null) {
			i=0;
			while(i<k-1 && temp.next!=null) {
				temp=temp.next;
				i++;
			}
	
			next= temp.next;
			temp.next=null;
			
			if(newH==null) {
				newH= reverseLL.reverse_Iterative(curr);
				newT=curr;
			}
			else {
				newT.next=reverseLL.reverse_Iterative(curr);
			}
			
			curr=next;
		}
		
		return newH;
	}

	/*  	iterative:

		if(k==0 || k==1)
			return head; 
		 
		LinkedListNode<Integer> newH= null; 
		LinkedListNode<Integer> newT= null; 
		LinkedListNode<Integer> temp= head; 
		LinkedListNode<Integer> curr = head; 
		LinkedListNode<Integer> next = null; 
		int i=0; 
		
		while(curr!=null) { 
		
			i=0; 	
		
			while(i<k-1 && temp.next!=null) { 
				temp=temp.next; i++; 
			} 
		
			next= temp.next;
			temp.next=null; 
		
			if(newH==null) { 
				newH= reverse_Iterative(curr); 
				newT=curr; 
			} 
			else { 
				newT.next=reverse_Iterative(curr);
				newT=curr;
			 } 
		
			curr=next; 
			temp=curr;
		 } 
		
		return newH;
	 */
	
}
