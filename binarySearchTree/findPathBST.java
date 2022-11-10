package binarySearchTree;

import java.util.ArrayList;

public class findPathBST {
	
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		//time: O(H)		space:O(H)
		if(root==null) 
            return null;
		
        if(root.data == data){ //when data found,create path arraylist and add node to path
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }
        
        if(data < root.data){ //search only in left of root as it is a BST
            ArrayList<Integer> leftpath = getPath(root.left,data);
            
        	if(leftpath!=null)
            	leftpath.add(root.data);  
            
        	//return null itself if not found in left despite being smaller than root
			return leftpath;            
        }
        
        else{	//if greater than root search only in right of root as it's a BST
        	ArrayList<Integer> rightpath = getPath(root.right, data);
            
       		if(rightpath!=null)
            	rightpath.add(root.data);
            
            return rightpath;

        }
        
	}
	
}
