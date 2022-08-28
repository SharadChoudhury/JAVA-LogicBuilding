package trees;

public class removeLeafNodes {

	public static TreeNode<Integer> removeLeafs(TreeNode<Integer> root) {
        if(root == null)
            return null;
        
        if(root.children.size() == 0)
            return null;
        
        for(int i =0 ; i< root.children.size() ; i++){
            TreeNode<Integer> child = root.children.get(i);
            if(child.children.size() == 0){
                root.children.remove(i);
                i = i-1;
            }
            else
                root.children.set(i,removeLeafs(root.children.get(i)));
        }
		
        return root;
	}
	
}
