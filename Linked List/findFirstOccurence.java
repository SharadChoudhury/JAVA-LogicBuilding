package linked_List;

public class findFirstOccurence {
	
	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	//Time:O(n) 		  Space:O(n)
        return findNodeRec(head,n,0);
	}
	
    public static int findNodeRec(LinkedListNode<Integer> head, int n, int index){
        if(head==null)
            return -1;
        if(head.data==n)
            return index;
        return findNodeRec(head.next,n,index+1);
    }
	
}
