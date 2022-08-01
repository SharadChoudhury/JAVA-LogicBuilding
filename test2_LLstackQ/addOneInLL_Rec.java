package test2_LLstackQ;

public class addOneInLL_Rec {
//Time:O(n)			space:O(n)
	
	//method 1:
//  public static int addOne(LinkedListNode<Integer> head) {
//		if (head == null) {
//			return 1;
//		}
//		int carry = addOne(head.next);
//		int sum = head.data + carry;
//		head.data = sum % 10;
//		carry = sum / 10;
//		return carry;
//	}
	
    
//	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head){    
//        int carry = addOne(head);
// 		if (carry == 1) {
// 			LinkedListNode<Integer> temp = new LinkedListNode<Integer>(carry);
// 			temp.next = head;
//			head = temp;
// 		}
// 		return head;
//    }
	
	
	
	//Method 2:
	public static LinkedListNode<Integer> next(LinkedListNode<Integer> head) {
        
        if(head==null)
           return head;
       
        if(head.next==null){
            head.data= head.data+1;
            return head;
        }
      
       LinkedListNode<Integer> temp = next(head.next);
       
       if(temp.data > 9){
           head.data = head.data + temp.data/10;
           temp.data = temp.data%10 ;
       }
       
       return head;
	}
	
	
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head){
     
		LinkedListNode<Integer> temp = next(head);
		 
		if(temp.data>9 && temp!=null){           
		    LinkedListNode<Integer> n= new LinkedListNode<Integer>(temp.data/10);
		    temp.data= temp.data%10;
		    n.next=temp;
		    temp = n;
		}
		
		return temp;
     
	}
	
}
