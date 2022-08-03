package trees;

public class height {
	
	// return height of tree
	public static int getHeight(TreeNode<Integer> root){
	//fetch max height among each child of root, and return total height of root (hmax+1)
        if(root==null)
            return 0;

        int hmax= 0;
        for(int i=0;i<root.children.size();i++){
            int childHeight= getHeight(root.children.get(i));
            if(childHeight > hmax)
                hmax=childHeight;
        }
        return hmax+1;
	}
	
}
