package BinaryTrees;

import binarySearchTree.BinaryTreeNode;

public class BT_LCA {
	
	static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		//time :O(n)     space:O(n)  since all nodes are traversed in worst case and
		//function called recursively on both LST and RST as it is not sorted tree or BST
			
	        if(root == null)
	            return -1;
	    //if b is present it will be either in LST or RST of this root, so this root is the LCA
	        if(root.data == a) 
	            return a;
	    //if a is present it will be either in LST or RST of this root, so this root is the LCA
	        if (root.data == b)
	            return b;
	     
	    //since it's not BST, we have to fetch results from both left and right
	        int leftLCA = getLCA(root.left, a, b);
	        int rightLCA = getLCA(root.right , a, b);
	        
	    // if one node found in LST and other in RST then root is the LCA
	        if(leftLCA != -1 && rightLCA != -1) 
	            return root.data;
	    // if not present in any subtree, return -1 
	        else if(leftLCA == -1 && rightLCA == -1)
	            return -1;
	    //if both found in RST, return rightLCA
	        else if(leftLCA == -1)
	            return rightLCA;
	    //if both found in LST, return leftLCA
	        else
	            return leftLCA;
		}
	
}
