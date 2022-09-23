package BinaryTrees;

class Pair{
	int height;
	int diameter;
	
	Pair(int h, int d){
		height=h;
		diameter=d;
	}
}

public class diameterBT {
	
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
		return heightDiameter(root).diameter;
	}
	
	public static Pair heightDiameter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return new Pair(0,0);
		}
		
		Pair leftans= heightDiameter(root.left);
		Pair rightans= heightDiameter(root.right);
		int currHeight = 1 + Math.max(leftans.height,rightans.height);
		int option1 = leftans.height + rightans.height + 1; //inclusive of nodes and not just edges
		int option2 = leftans.diameter;
		int option3 = rightans.diameter;
		int currDiameter = Math.max(option1, Math.max(option2, option3));
		return new Pair(currHeight, currDiameter);
	}
	
}
