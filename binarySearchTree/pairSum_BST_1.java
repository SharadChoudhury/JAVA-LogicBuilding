package binarySearchTree;
import java.util.*;

//using inorder arraylist and two pointers technique
//time:O(N)    space:O(N)
public class pairSum_BST_1 {
	
	    private static ArrayList<Integer> inorderArr = new ArrayList<>();
    
		public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
			// Write your code here
	        if(root == null )
	            return ;
	        
	    	inorder(root);        
	        int i = 0;
	        int j = inorderArr.size()-1 ;
	        
	        while(i<j){
	            if(inorderArr.get(i) + inorderArr.get(j) < s)
	                i++;
	            else if(inorderArr.get(i) + inorderArr.get(j) > s)
	                j--;
	            else{
	                System.out.println(inorderArr.get(i)+" "+inorderArr.get(j));
	                i++;
	                j--;
	            }
	        }     
		}
		
	    public static void inorder(BinaryTreeNode<Integer> root){
	        if(root == null)
	            return ;
	        if(root.left == root.right)  //leaf node
	        	inorderArr.add(root.data);

	       	inorder(root.left);
	       	inorderArr.add(root.data);
	        inorder(root.right);          
	    }
	
}
