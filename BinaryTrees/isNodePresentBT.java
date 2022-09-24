package BinaryTrees;

public class isNodePresentBT {
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    ///Time :O(n)			space:O(h)
        if(root==null)
            return false;
        
        if(root.data==x)
            return true;
    	return isNodePresent(root.left,x) || isNodePresent(root.right,x) ;
	}
	
}
