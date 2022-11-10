package binarySearchTree;

public class replaceWithSumOfGreaterNodes {
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root){
        replaceWithLargerNodesSum(root,0);
    }

	public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum) {
		//Time:O(N)			space:O(H)
		if(root == null)
            return sum;
        int rsum = replaceWithLargerNodesSum(root.right, sum);
        root.data  = root.data + rsum;
        int lsum = replaceWithLargerNodesSum(root.left ,root.data);
        
        return lsum ;
	}
	
}
