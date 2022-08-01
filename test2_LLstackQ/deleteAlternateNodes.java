package test2_LLstackQ;

class Node2<T> {
    public T data;
    public Node2<T> next;

    public Node2(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

public class deleteAlternateNodes {
	
    public static void delete(Node2<Integer> head) {
        //Time:O(n)		space:O(1)
    	
        Node2<Integer> curr= head;
        Node2<Integer> temp= null;
        
        //if even no of nodes, curr=null at last step
        //if odd no. of nodes, curr.next=null at last step
        if(head==null || head.next==null)
            return ;
        
        while(curr!=null && curr.next!=null){
            temp= curr.next.next;
            curr.next= temp;
            curr= temp;           
        }
        
        
    }
	
}
