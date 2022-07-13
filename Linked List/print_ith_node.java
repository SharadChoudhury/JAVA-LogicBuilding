package linked_List;

public class print_ith_node {
	
	public static void printIthNode(LinkedListNode<Integer> head, int i){
		//time:O(min(i,n))		space:O(1)
		//print node at ith index, if i>length of list don't print anything
		
        LinkedListNode<Integer> temp = head;
        int cnt=0;
        
        while(cnt<i && temp!=null){
            temp=temp.next;
            cnt++;            
        } 
        
        if(temp!=null){
            System.out.println(temp.data);
        }
        
	}

	
}
