package BinaryTrees;

public class buildTreeFromPostOrder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Time :O(n^2)			space:O(h)
        return BThelper(postOrder , inOrder, 0 , postOrder.length-1 , 0 , inOrder.length-1);
	}

    public static BinaryTreeNode<Integer> BThelper(int[] postOrder, int[] inOrder , int postSi ,int postEi ,int inSi, int inEi){
        if(postSi>postEi || inSi>inEi)
            return null;
        
      //set root as element at end index(postEi) of postorder array
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postOrder[postEi]);
        
      //traverse inorder array till root is found
        int i=inSi;
        for(i=inSi; i<inEi ;i++){
            if(inOrder[i]==postOrder[postEi])
                break;
        }
        
        //now i is the index of root in inOrder array
        int len = i-inSi;	// len is size of each subtree
        
        root.left = BThelper(postOrder, inOrder, postSi , postSi+len-1 , inSi , i-1);
        root.right = BThelper(postOrder, inOrder, postSi+len , postEi-1 , i+1, inEi);
        return root;
    }
	
}
