package trees;

public class printAtDepthK {
	
	//print all nodes at depth k ( depth of root node = 0)
	public static void printAtK(TreeNode<Integer> root, int k) {
		if (k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}
	
}
