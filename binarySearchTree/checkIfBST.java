package binarySearchTree;


class Result{
	int max;
	int min;
	boolean isbst;
	
	Result(int max, int min, boolean isbst){
		this.max= max;  //max value in entire tree
		this.min= min;	// min value of entire tree
		this.isbst = isbst;
	}
}


public class checkIfBST {
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
     	return isBSThelper(root).isbst;  
     	//return isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
    
	//usual approach
	public static Result isBSThelper(BinaryTreeNode<Integer> root) {
		
		// Time: O(N)   since all nodes are traversed
		// space: O(H)  because right call only starts after end of left call
		// and each call ends after 'h' successive calls; h = height of tree from this node
		
		if (root == null) {
			return new Result(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
		}

		Result leftans = isBSThelper(root.left);
		Result rightans = isBSThelper(root.right);

		Result ans = new Result(rightans.max, leftans.min, leftans.isbst && rightans.isbst);
		
		//ans.max(max of entire tree) is maximum of current root.data , left subtree max 
		//and right subtree max 
		ans.max =  Math.max(root.data, Math.max(leftans.max, rightans.max));
		
		//ans.min(min of entire tree) is minimum of current root.data , left subtree min
		//and right subtree min 
		ans.min = Math.min(root.data, Math.min(leftans.min, rightans.min));
		
/*
 * 	ans.isbst is true only if: 
 * 							1) both subtrees are bst and,
 * 							2) left subtree max is less than current node data and,
 * 							3) right subtree min is greater than or equal to
 * 								current node data
 */

        ans.isbst = (leftans.isbst && rightans.isbst )
            && ( root.data>leftans.max && root.data <= rightans.min );
        
		return ans;
	}
	
	//less complex approach
	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		// Time: O(N)   since all nodes are traversed
		// space: O(H)  because right call only starts after end of left call
		
		if (root == null) {
			return true;
		}
		if (root.data < min || root.data > max) {
			return false;
		}
		//for left subtree max value is root.data-1
		//for right subtree min value is root.data
		boolean isLeftOk = isBST3(root.left, min, root.data - 1);
		boolean isRightOk = isBST3(root.right, root.data, max);
		
		return isLeftOk && isRightOk;
	}
	
}
