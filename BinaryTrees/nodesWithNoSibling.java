package BinaryTrees;

public class nodesWithNoSibling {

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Time :O(n)			space:O(h)
        if(root==null)
            return ;
        
        if(root.left == root.right) //if both null, then it's a leaf node
            return;
        
        else if(root.right==null){			// no right sibling for the left
            System.out.print(root.left.data+" ");
            printNodesWithoutSibling(root.left);
        }
        
        else if(root.left==null){			//no left sibling for the right
            System.out.print(root.right.data+" ");
            printNodesWithoutSibling(root.right);
        }
        else{								// both left and right exist
           	printNodesWithoutSibling(root.left);
       		printNodesWithoutSibling(root.right); 
        }
                
	}
	
}
