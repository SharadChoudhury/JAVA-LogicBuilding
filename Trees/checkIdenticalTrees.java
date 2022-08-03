package trees;

public class checkIdenticalTrees {
	
//	public static String preorder(TreeNode<Integer> root, String s) {
//		if (root == null) {
//			return "";
//		}
//
//		s = s+ root.data + " ";
//		for (int i = 0; i < root.children.size(); i++) {
//			s = preorder(root.children.get(i), s);
//		}
//        return s;
//	}
    
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		// approach using preorder traversal strings .compare the traversal strings
//        String s1= preorder(root1,"");
//        // System.out.println(s1);
//        String s2= preorder(root2,"");
//        // System.out.println(s2);
//        return s1.equals(s2) ;  
	
		
		//better approach
		if(root1==null && root2==null)		//both null means identical
			return true;
		
		if(root1==null || root2==null)		//if only one is null -> not identical
			return false;
		
		if(root1.data!=root2.data)		//if data mismatch for same node -> not identical
			return false;
		
		if(root1.children.size()!=root2.children.size()) //no.of children unequal -> non identical
			return false;
		
		for(int i=0;i<root1.children.size();i++) {
			//if root1.children[i] and root2.children[i] not identical then return false
			if(!checkIdentical(root1.children.get(i), root2.children.get(i)) )
				return false;
		}
		return true;
	}
	
}
