package BinaryTrees;
import java.util.*;

public class BinaryTreeUse {

	//recursive
	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		int rootData;
		System.out.println("Enter root data");
		rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}

	
	//levelwise
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
	

	public static void printLevelWise(BinaryTreeNode<Integer> root) {

        if(root==null)
            return;
        
        Queue<BinaryTreeNode<Integer>> nodes= new LinkedList<BinaryTreeNode<Integer>>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            
            BinaryTreeNode<Integer> front= nodes.poll();
            System.out.print(front.data);
            
            if(front.left!=null){
                System.out.print(":L:" + front.left.data);
                nodes.add(front.left);
            }
            else{
                System.out.print(":L:-1");
            }
               
            if(front.right!=null){
                System.out.print(",R:" + front.right.data);
                nodes.add(front.right);
            } 
            else{
                System.out.print(",R:-1");
            }
            System.out.println();
            
        }
        
	}
		
		
	
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		System.out.println(diameterBT.diameterOfBinaryTree(root));
		//s.close();
	}
}
