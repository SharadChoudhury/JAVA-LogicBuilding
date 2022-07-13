package linked_List;

public class mergeSortLL {
	
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		//Time:	O(n*logn)			Space:	O(logn)
        if(head==null || head.next==null)
            return head;
        LinkedListNode<Integer> mid = midpoint_of_LL.midPoint(head);
        LinkedListNode<Integer> head2 = mid.next;
        mid.next=null;
        head= mergeSort(head);
        head2= mergeSort(head2);
        return mergeSortedLL.merge(head,head2);
	}
	
}
