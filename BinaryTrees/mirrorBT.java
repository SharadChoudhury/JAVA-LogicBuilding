package BinaryTrees;

public class mirrorBT {
	
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
        if(root==null)
            return ;
        
        BinaryTreeNode<Integer> temp = root.left;
        root.left= root.right;
        root.right= temp;
        
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
	}
	
	
}
