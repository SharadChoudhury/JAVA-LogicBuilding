package trees;

public class traversals {
	
	//print nodes in preorder traversal
	public static void preorder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
	}
	
	
	//print nodes in post order traversal
	public static void printPostOrder(TreeNode<Integer> root){
        if(root==null)
            return ;
        
        for(int i=0;i<root.children.size();i++){
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data+" ");
	}
	
}
