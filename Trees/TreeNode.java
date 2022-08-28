package trees;

import java.util.ArrayList;

public class TreeNode<T> {
	public T data;   // data of current node
	public ArrayList<TreeNode<T>> children;		//list of children nodes of current node
	
	public TreeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}
	
}
