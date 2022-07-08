package linked_List;

public class deleteEveryNnodes {

/* Approach:
 * if skip=0, it means delete all nodes, i.e return null
 * if delete=0, it means skip all nodes, i.e return head
 * skip 2 pointers, skipNode and deleteNode and two counters skip and delete
 * while skipNode!=null :
 * 		while skip<M and skipNode!=null, increment pointer and the counter
 * 		if skipNode == null, return head or break from the while loop
 * 		deleteNode = skipNode
 * 		while delete<N and deleteNode!=null, increment pointer and counter
 * 		if deleteNode != null, (now deleteNode is pointing to the node just before the
 * 		next node to be skipped) :
 * 					skipNode.next = deleteNode.next
 * 					skipNode = skipNode.next
 * 		else: (now deleteNode = null,i.e it has reached the end of list,so now print 
 * 				nodes only upto last skipNode, so point next of skipNode to null)
 * 			 		skipNode.next = null
 * 
 */
	public static LinkedListNode<Integer> deleteMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		//Time:O(n)			space:O(1)
        
        LinkedListNode<Integer> skipNode= head;
        LinkedListNode<Integer> deleteNode= null;
        int skip=0 , delete=0;
        
        if(M==0 || head==null)
            return null;
        if(N==0)
            return head;
        
        while(skipNode!=null){
            
            while(skip<M-1 && skipNode!=null){
                skipNode=skipNode.next;
                skip++;
            }
            skip=0;
            
            if(skipNode==null){
                break;
            }
            
            deleteNode= skipNode;
            
            while(delete<N && deleteNode!=null){
                deleteNode=deleteNode.next;
                delete++;
            }
            delete=0;
            
            if(deleteNode!=null) {
            	skipNode.next= deleteNode.next;
            	skipNode=skipNode.next;
            }
            else
            	skipNode.next=null;
        }
        
        return head;
	}
	
}
