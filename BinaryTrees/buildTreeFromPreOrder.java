package BinaryTrees;

public class buildTreeFromPreOrder {

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Time :O(n^2)			space:O(h)
        return BThelper(preOrder , inOrder, 0 , preOrder.length-1 , 0 , inOrder.length-1);
	}

    public static BinaryTreeNode<Integer> BThelper(int[] preOrder, int[] inOrder , int preSi ,int preEi ,int inSi, int inEi){
        if(preSi>preEi || inSi>inEi)
            return null;
        
        //set root as element at start index(preSi) of preorder array
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[preSi]);
        
        //traverse inorder array till root is found
        int i=inSi;
        for(i=inSi; i<inEi ;i++){
            if(inOrder[i]==preOrder[preSi])
                break;
        }
        //now i is the index of root in inOrder array
        int len = i - inSi;  // len is size of each subtree
        
        root.left = BThelper(preOrder, inOrder, preSi+1 , preSi+len , inSi , i-1);
        root.right = BThelper(preOrder, inOrder, preSi+len+1 , preEi , i+1, inEi);
        return root;
    }
	
}
