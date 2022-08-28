package trees;

public class totalNodes {
	
	//return no. of nodes in the tree
	public static int countAllNode(TreeNode<Integer> root){
		if(root==null)
            return 0;
        
        int count = 1;
        for(int i=0; i< root.children.size(); i++){
            count = count + countAllNode(root.children.get(i));
		}
        return count ;
	}
	
}
