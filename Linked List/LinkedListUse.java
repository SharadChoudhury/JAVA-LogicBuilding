package linked_List;

import java.util.Scanner;

public class LinkedListUse {
	
	
	public static LinkedListNode<Integer> takeInput()
	{
		LinkedListNode<Integer> head = null, tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
				
		while(data != -1){
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}else{
				tail.next = newNode;
				tail = newNode; // tail = tail.next
			}
			data = s.nextInt();
		}
		return head;
	}
	
	
//printing linked list	
	public static void print(LinkedListNode<Integer> head){
		
		//	time:	O(n)			space:	O(1)
		
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();

	}
	

//finding length of linked list	
	public static int length(LinkedListNode<Integer> head){
		
		//	time:	O(n) 			space:	O(1)
		
        int len=0;
        LinkedListNode<Integer> temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
	}
		
	
	public static void main(String[] args) {
		
		LinkedListNode<Integer> head1 = takeInput();
		print(head1);
		print(swapTwoNodes.swapNodes(head1, 0, 2));
		
//		LinkedListNode<Integer> head2 = takeInput();
//		print(head2);
//		LinkedListNode<Integer> head3 = mergeSortedLL.merge(head1, head2);
//		print(head3);
	}
	

}
