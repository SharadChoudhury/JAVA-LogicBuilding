package BinaryTrees;

public class insertDuplicateAtLeft {

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
//Time:O(n)		space:O(h)  	
//n=no. of nodes, h=height of tree
//function goes on till it reaches null ->for left call-> space taken =no of calls in stack= O(h) 
//function goes on till it reaches null ->for right call->space taken =no of calls in stack= O(h)
	// right call starts only after left call is finished in the stack
		// h =log(n) for balanced tree
		// h = n for skewed tree
        if(root==null)
            return ;
        BinaryTreeNode<Integer> temp = root.left;
        root.left = new BinaryTreeNode<>(root.data);
        root.left.left = temp;
        insertDuplicateNode(temp);
        insertDuplicateNode(root.right);
	}
	
}
