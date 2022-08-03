package trees;
import java.util.*;

public class nodeMaxSum {
	
//returns the node with max sum of its data and data of all its immediate children

	//Iterative approach using queues
//	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
//		
//		if(root==null)
//			return root;
//		
//        Queue<TreeNode<Integer>> nodes = new LinkedList<TreeNode<Integer>>();
//        nodes.add(root);
//    	int max = Integer.MIN_VALUE;
//        TreeNode<Integer> temp= null;
//        
//        while(!nodes.isEmpty()){
//            TreeNode<Integer> front = nodes.poll();
//            int sum = front.data;
//            for(int i=0; i< front.children.size();i++){
//                sum += front.children.get(i).data;
//                nodes.add(front.children.get(i));
//            }
//            if(sum>max){
//               max=sum;
//               temp=front; 
//            }                
//        }
//        
//        return temp;
//	}

	
	
	//recursive approach
	static class  MaxSumPair<T>{
		TreeNode<T> node;
		int sum;
	}
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if(root == null)
			return root;
		
		return maxSumNodehelper(root).node;
	}
	public static MaxSumPair<Integer> maxSumNodehelper(TreeNode<Integer> root){
		MaxSumPair<Integer> ans= new MaxSumPair<Integer>();
		ans.node=root;
		ans.sum=root.data;
		
		for(TreeNode<Integer> child : root.children) {
			ans.sum += child.data;
		}
		
		for(TreeNode<Integer> child : root.children) {
			MaxSumPair<Integer> childAns= maxSumNodehelper(child);
			if(childAns.sum > ans.sum) {
				ans.sum = childAns.sum;
				ans.node = childAns.node;
			}
		}
		
		return ans;
	}
}
