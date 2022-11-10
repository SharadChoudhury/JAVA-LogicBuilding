package binarySearchTree;

public class isNodePresent {
	
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		//Time:O(H)			space:O(H)
		if(root==null)
            return false;
        
        if(root.data == k)
            return true;
        
        if( k < root.data)
            return searchInBST(root.left , k);
        else{
            return searchInBST(root.right , k);
        }
	}
	
}
