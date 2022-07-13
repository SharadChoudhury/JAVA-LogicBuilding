package linked_List;

public class removeDupLL {
	
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
//way 1:
//		time:	O(n) 			space:	O(1)
        
		if(head==null)
            return head;
        
		LinkedListNode<Integer> current = head;

        while(current.next!=null){
           if(current.data.equals(current.next.data)){
               current.next=current.next.next;
           } 
            else{
                current = current.next;
            }
        }
        return head;

//way 2:
//        if(head==null)
//          return head;
     
//      LinkedListNode<Integer> prev = head;
//      LinkedListNode<Integer> current = head.next;
//      int prevData= head.data;
//      while(current!=null){
//         if(prevData==current.data){
//             prev.next=current.next;
//             current=current.next;
//         } 
//          else{
//              prev = current;
//              prevData=prev.data;
//              current = current.next;
//          }
//      }
//      return head;
	}
	
}
