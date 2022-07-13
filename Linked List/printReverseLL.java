package linked_List;

public class printReverseLL {
//	time:	O(n) 			space:	O(n)
	public static void printReverse(LinkedListNode<Integer> root) {
		if(root==null)
            return;

        printReverse(root.next);
        System.out.print(root.data+" ");      
	}
	
}
