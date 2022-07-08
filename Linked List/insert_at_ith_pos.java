package linked_List;

public class insert_at_ith_pos {
	
	//time:	O(min(n,pos))		space:	O(1)
	
	public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int data, int pos){
		
		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
		if(pos == 0){
			newNode.next = head;
			return newNode;
		}
		int i = 0;
		LinkedListNode<Integer> temp = head;
		while(i < pos - 1){
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
}
