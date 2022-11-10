package binarySearchTree;

public class BSTclass {
	
	private BinaryTreeNode<Integer> root;
	
	public void insert(int data) {
		//store result node in root as the root might have changed after insertion
		root = insert(root,data);	//create helper to pass root	
	}
	
	public BinaryTreeNode<Integer> insert( BinaryTreeNode<Integer> root, int data) {
		//Time:	O(H)			Space:	O(N)	
		if(root == null)
			return new BinaryTreeNode<Integer>(data);
		
		if(data <= root.data) {
			root.left = insert(root.left , data);
			return root;
		}

		else {
			root.right = insert(root.right, data);
			return root;
		}			
				
	}
	
	public void remove(int data) {
		//store result node in root as the root might have changed after insertion
		root = remove(root, data);	 //create helper to pass root
	}
	
	public BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data) {
		//returns the changed root node after deletion
		//Time:	O(H)			Space:	O(N)
		
		if(root == null)
			return null;
		
		if(data < root.data) {
			root.left = remove(root.left, data);
			return root;
		}
					
		else if(data > root.data) {
			root.right = remove(root.right, data);
			return root;
		}
		
		else {	// root.data == data
			if(root.left == null && root.right==null)  // root is leaf node
				return null;
			
			else if(root.left == null) //LST absent,then attach RST to parent of root 
				return root.right;
			
			else if(root.right == null)//RST absent, then attach LST to parent of root
				return root.left;
			
			else {	// both left and right subtrees exist
		//replace with inorder successor(min of RST) or inorder predecessor(max of LST)
			
				BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left != null){ // to find min only move left
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = remove(root.right, minNode.data);
				return root;
			}
				
		}
	}
	
	
	public void printTree() {
		//Implement the printTree() function
		print(root);
	}
	
	public void print(BinaryTreeNode<Integer> root) {
		//Time:	O(N)			Space:	O(N)
		if(root == null)
			return;
		
		System.out.print(root.data);
		
		if(root.left!=null && root.right!=null)
			System.out.print(":L:"+ root.left.data + ",R:"+root.right.data);
		
		else if(root.left == null && root.right != null) 
			System.out.print(":L:,R:"+ root.right.data);
		
		else if(root.right==null && root.left!=null)
			System.out.print(":L:" + root.left.data + ",R:");
		
		System.out.println();
		
		print(root.left);
		print(root.right);
	}
	
	public boolean search(int data) {
		//Implement the search() function
		return search(root, data);		//create helper to pass root
	}
	
	public boolean search(BinaryTreeNode<Integer> root, int data) {
		//Time:	O(H)			Space:	O(N)
		if(root==null)
			return false;
		
		if(root.data == data)
			return true;
		
		else if(data < root.data)
			return search(root.left , data);
		
		else
			return search(root.right, data);
	}
	
}
