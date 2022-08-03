package trees;
import java.util.*;


public class nextLargerNode {
	
	//iterative approach using queues
	public static TreeNode<Integer> findNextLargerNodeIter(TreeNode<Integer> root, int n){
        if(root==null)
            return root;
        
        int max = Integer.MAX_VALUE;
        TreeNode<Integer> temp = null;
        if(root.data > n ){
         	max = root.data;
            temp = root;
        }
        
        Queue<TreeNode<Integer>> nodes= new LinkedList<TreeNode<Integer>>();
		
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            TreeNode<Integer> front= nodes.poll();
            for(int i=0;i<front.children.size();i++){
                nodes.add(front.children.get(i));
                if(front.children.get(i).data > n && front.children.get(i).data < max){
                    max = front.children.get(i).data;
                    temp = front.children.get(i);
                }
            }
        }
        
        return temp;
	}
	
    //recursive approach
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        if(root==null)
            return root;
        
        TreeNode<Integer> ans = null; 
        if(root.data > n)
            ans = root;
        
        for(TreeNode<Integer> child : root.children){
            TreeNode<Integer> smallans = findNextLargerNode(child, n);
            
            if(smallans!=null){
                if(ans == null || ans.data > smallans.data)
                    ans = smallans;
            }
        }
        
        return ans;
    }
	
}
