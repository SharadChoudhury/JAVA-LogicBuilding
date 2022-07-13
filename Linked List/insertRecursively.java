package linked_List;

public class insertRecursively {
	
	// Time:	O(n) 		Space:	O(n)
public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head,int pos,int ele){
	
//if ele to be inserted at 0th pos, create a new node with ele and point it's next to head
	
// this condition must be placed first otherwise when head=null and pos=0,ie, when we want
// to insert at the end of LL, it won't allow it and will return null as per line 22
// if head==null condition is placed first
	if(pos==0) {
		LinkedListNode<Integer> newNode= new LinkedListNode<Integer>(ele);
		newNode.next = head;
		return newNode;
	}
	
//if pos > len of LL ; null pointer exception might occur at line 29, so handle it properly
//if pos = len of LL, pos=0 at head=null, so we must be able to insert in that case
// and not return null
	if(head==null) {
		return head;
	}

//at each call we pass the LL from head.next and ask it to insert ele and return the head
//make the current head.next point to the pointer returned by function called on LL from
// head.next. At each call we pass (pos-1) as we pass the remaining LL at each call
	head.next= insert(head.next,pos-1,ele);
	return head;
}
	
}
