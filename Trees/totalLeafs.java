package trees;

public class totalLeafs {
	
	//return count of leaf nodes
	public static int countLeafNodes(TreeNode<Integer> root){
		// Write your code here
        if(root==null)
            return 0;
        int cnt=0;
        
        if(root.children.size()==0)
            return cnt+1;
        
        for(int i=0;i<root.children.size();i++){
            cnt = cnt + countLeafNodes(root.children.get(i));
        }

        return cnt;
	}
	
}
