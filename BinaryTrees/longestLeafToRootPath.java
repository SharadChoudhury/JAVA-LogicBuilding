package BinaryTrees;
import java.util.*;

public class longestLeafToRootPath {
	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		// Write your code here
        
        if(root == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> leftans = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightans = longestRootToLeafPath(root.right);
        
        if (leftans.size() >= rightans.size()){
            leftans.add(root.data) ;
            return leftans;
        }
        else{
           	rightans.add(root.data); 
        	return rightans;
        }
		
	}

	
}
