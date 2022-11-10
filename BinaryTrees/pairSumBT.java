package BinaryTrees;

import java.util.*;

public class pairSumBT {
	
//	1. traverse in preorder/postorder/inorder and add all nodes to arraylist
//	2. sort arraylist
//	3. find pair using two pointers
	
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void preorder(BinaryTreeNode<Integer> root) {
		//time: O(n)		space:O(n)
		if (root == null) {
			return;
		}
		arr.add(root.data);
		preorder(root.left);
        preorder(root.right);
	}
    
    static void pairSum(BinaryTreeNode<Integer> root, int sum){
    //Time: O(n) + O(nlogn) + O(n) = O(nlogn)    
    //space: O(n)
        if(root == null)
            return ;
        
        preorder(root); 	//O(n)
        Collections.sort(arr);	//O(nlogn)
        int i=0;
        int j=arr.size()-1;
        
        while(i<j){  //O(n)         
            if( arr.get(i) + arr.get(j) == sum){
             	System.out.println(arr.get(i)+" "+arr.get(j));
                i++;
                j--;
                //extra conditions not required as given that all are unique elements
            }            
            else if( arr.get(i) + arr.get(j) < sum )
                i++;
            else
                j--;             
        }
        
    }
	
}
