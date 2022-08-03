package trees;

public class checkContainX {
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

		// Write your code here
        if(root==null)
            return false;
        
        if(root.data==x)
            return true;
        
        boolean ans = false;
        for(TreeNode<Integer> node : root.children){
            ans = ans || checkIfContainsX(node,x);
        }
		
        return ans;
	}
	
}
