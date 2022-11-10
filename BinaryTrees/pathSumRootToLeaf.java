package BinaryTrees;
//import java.util.*;

public class pathSumRootToLeaf {
	
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		PathSum(root, k, "");
	}
	
	public static void PathSum(BinaryTreeNode<Integer> root, int k,String s) {
		//Time:O(n)       space:O(h)  
		
		if(root == null)
			return;
		if(k == root.data ) { //sum of all nodes till this node =k
			
			if(root.left==null && root.right==null)  //if it's leaf node, print and return
				System.out.println(s + root.data);
			
			// if not a leaf node, return
			return;
		}
		
		s = s + root.data +" ";
		PathSum(root.left, k - root.data, s);
		PathSum(root.right, k - root.data, s);
	}
	
}
