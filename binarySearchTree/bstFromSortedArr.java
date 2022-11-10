package binarySearchTree;

public class bstFromSortedArr {
	//time: O(n)		space:O(n/2) = O(n)
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){			
        return SortedArrayToBST(arr, 0, n-1);
	}

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int si, int ei ){
        if(si > ei)
            return null;
        
        int mid = (si + ei)/2 ;            
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        root.left = SortedArrayToBST(arr, si, mid-1 );
        root.right = SortedArrayToBST(arr, mid+1 , ei);
        
        return root;
    }
	
}
