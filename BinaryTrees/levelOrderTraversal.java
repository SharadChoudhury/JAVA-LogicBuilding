package BinaryTrees;

import java.util.*;

public class levelOrderTraversal {
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Time: O(n)		Space:O(n)
        if(root==null )
            return;
        Queue<BinaryTreeNode<Integer>> nodes = new LinkedList<BinaryTreeNode<Integer>>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            int i=0;
            int len = nodes.size();
            while(i<len){
                
                BinaryTreeNode<Integer> front = nodes.poll();
                System.out.print(front.data+" ");
                
                if( front.left != null)
                	nodes.add(front.left);  
                
                if( front.right != null)
                	nodes.add(front.right);
                
                i++;
            }
            System.out.println();           
        }
        
	}
	
}
