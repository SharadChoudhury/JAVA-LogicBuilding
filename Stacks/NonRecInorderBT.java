package stacks;

//non-recursive java program for inorder traversal of BT using stacks
import java.util.Stack;

/* Class containing left and right child of
current node and key value*/
class Nodes
{
	int data;
	Nodes left, right;

	public Nodes(int item)
	{
		data = item;
		left = right = null;
	}
}

/* Class to print the inorder traversal */
public class NonRecInorderBT
{
	Nodes root;
	void inorder()
	{
		if (root == null)
			return;


		Stack<Nodes> s = new Stack<Nodes>();
		Nodes curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0)
		{

			/* Reach the left most Node of the
			curr Node */
			while (curr != null)
			{
				/* place pointer to a tree node on
				the stack before traversing
				the node's left subtree */
				s.push(curr);
				curr = curr.left;
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			System.out.print(curr.data + " ");

			/* we have visited the node and its
			left subtree. Now, it's right
			subtree's turn */
			curr = curr.right;
		}
	}

	public static void main(String args[])
	{

		/* creating a binary tree and entering
		the nodes */
		NonRecInorderBT tree = new NonRecInorderBT();
		tree.root = new Nodes(1);
		tree.root.left = new Nodes(2);
		tree.root.right = new Nodes(3);
		tree.root.left.left = new Nodes(4);
		tree.root.left.right = new Nodes(5);
		tree.inorder();
	}
}
