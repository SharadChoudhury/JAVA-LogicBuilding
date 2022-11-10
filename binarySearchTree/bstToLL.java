package binarySearchTree;

public class bstToLL {
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		return constructLL(root).head;
	}

	//time :O(n)				space:O(h)
	public static Pair<Integer> constructLL(BinaryTreeNode<Integer> root) {
		if(root == null)
	        return new Pair<Integer>();
	    
	    Pair<Integer> leftpair = constructLL(root.left);
	    Pair<Integer> rightpair = constructLL(root.right);
	    LinkedListNode<Integer> rootnode = new LinkedListNode<Integer>(root.data);
	    
	    if(leftpair.tail != null)
	        leftpair.tail.next = rootnode;
	    
	    rootnode.next = rightpair.head;
	    
	    Pair<Integer> ans= new Pair<Integer>();
	    
	    if( leftpair.head!= null){
	        ans.head = leftpair.head;
	    }
	    else{
	        ans.head = rootnode;
	    }
	    
	    if(rightpair.head!=null){
	        ans.tail = rightpair.tail;
	    }else{
	        ans.tail = rootnode;
	    }
	    
	    return ans;
	    
	}
}

 class Pair<T>{       
    LinkedListNode<T> head;
    LinkedListNode<T> tail;
}

