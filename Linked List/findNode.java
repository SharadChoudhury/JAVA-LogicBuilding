package linked_List;

public class findNode {
	
	public static int find_Node(LinkedListNode<Integer> head, int n) {
//		time:	O(n) 			space:	O(1)
		
        LinkedListNode<Integer> temp= head;
        int i = -1; //i returns position of found element
        
        while(temp!=null){
            i++;
            if(temp.data==n)
                return i;
            temp = temp.next;
        }
        
        return -1;
	}
	
}
