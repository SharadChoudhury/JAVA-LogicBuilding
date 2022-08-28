package trees;

public class secondLargestInTree {
	
	//if global variables are changed in a call, then successive calls in the 
	//stack will see the changed values itself
    //global variables can be changed and accessed from anywhere
    static TreeNode<Integer> first = new TreeNode<Integer>(Integer.MIN_VALUE);
    static TreeNode<Integer> second = first;;
    
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){         
        findSecondLargestHelper(root);
        return second;
    }
		
	
	public static void findSecondLargestHelper(TreeNode<Integer> root)
    {       
        // Base Case
        if (root == null) {
            return;
        }
         
        // Check if root's data is larger than current largest node's data
        if (root.data > first.data) {
            second = first;
            first = root;
        } 
        else if (root.data > second.data && root.data < first.data)
            second = root;
         
        // recursively find second largest in children
        for (TreeNode<Integer> child: root.children)
            findSecondLargestHelper(child);
    }
	
}
