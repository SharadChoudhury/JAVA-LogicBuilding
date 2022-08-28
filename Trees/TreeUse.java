package trees;
import java.util.*;
import java.util.Scanner;

/*
 * take input recursive
 * print nodes recursive
 * take input levelwise
 * print nodes levelwise
 */

public class TreeUse {
	
	//take input recursive
	public static TreeNode<Integer> takeInput(Scanner s) {
		
	// create current node by taking input of current node data 		
		System.out.println("Enter next node data");
		int n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
				
	// take input for no of children of current node		
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		
		for (int i = 0; i < childCount; i++) {
			
			//for each child node call takeInput recursively till it reaches the leaf node
			TreeNode<Integer> child = takeInput(s);
			
			//add this child node to list of children of current node
			root.children.add(child);
		}		
		return root;
	}
	
	
	//print all nodes in recursive fashion
	public static void print(TreeNode<Integer> root) {
		// prints nodes in recursive fashion
		
		String s = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	
	// takes input in level wise fashion : always use queues for levelwise operations
	public static TreeNode<Integer> takeInputLevelWise() {
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		
		//use a queue to dequeue current node and enqueue(append) all children of current node 		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		
		//adding root to queue
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			try{
				//dequeue current node
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				
				//take no. of children for current node
				System.out.println("Enter num of children of " + frontNode.data);
				int numChildren = s.nextInt();
				
				for (int i = 0; i < numChildren; i++) {
					
					//create a new child node with entered data
					System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
					TreeNode<Integer> childNode = new TreeNode<Integer>(s.nextInt());
					
					// add the child node to current's children list
					frontNode.children.add(childNode);
					
					//enqueue the child nodes
					pendingNodes.enqueue(childNode);
				}				
			} 
			catch (QueueEmptyException e){
				// Shouldn't come here
				return null;
			}
		}
		return root;
	}
	
		
	//print all nodes levelwise: always use queues for levelwise operations
	public static void printLevelWise(TreeNode<Integer> root){ 
		System.out.println(root.data);
        Queue<TreeNode<Integer>> nodes= new LinkedList<TreeNode<Integer>>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){ 
        	
            // keep no. of nodes in the current level
            int s = nodes.size();
            
            for(int k=0; k<s; k++ ){               
                TreeNode<Integer> front= nodes.poll();
                int nC= front.children.size();

                for(int i=0 ; i<nC ; i++){           
                    System.out.print(front.children.get(i).data+" ");
                    nodes.add(front.children.get(i));
                }
            }           
            //new line only after children of all nodes in current level printed
        	System.out.println();           
        }       
	}
		
	
	public static void main(String[] args) {
//		Scanner s= new Scanner(System.in);	
//		TreeNode<Integer> root = takeInput(s);    // pass scanner when you want to give 
												//input of all nodes at once
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
	}
	
}
