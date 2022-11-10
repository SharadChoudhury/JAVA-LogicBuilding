package binarySearchTree;

public class print_InRange {
	
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		//Time:O(N)			space:O(H)
		//here in worst case, case 3 occurs and all nodes are traversed so O(N)
		if(root == null)
            return;
        if(k2 < root.data)
            elementsInRangeK1K2(root.left , k1, k2);
        else if( k1 > root.data)
            elementsInRangeK1K2(root.right , k1, k2);
        else{
            elementsInRangeK1K2(root.left , k1, root.data-1);
            System.out.print(root.data + " ");
            elementsInRangeK1K2(root.right , root.data+1, k2);
        }
	}
	
}
