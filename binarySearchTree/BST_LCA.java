package binarySearchTree;

public class BST_LCA {
	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root == null)		//neither a found nor b
            return -1;
        if(root.data == a) //if b is present it'll be either in LST or RST of this root, so this root is the LCA
            return a;
        if (root.data == b)
            return b;
        if(a < root.data && b > root.data || a > root.data && b < root.data){
            return root.data;
        }
        else if(a < root.data && b < root.data){
            return getLCA(root.left, a, b);
        }
        else{
            return  getLCA(root.right , a, b);
        }

	}
	
}
