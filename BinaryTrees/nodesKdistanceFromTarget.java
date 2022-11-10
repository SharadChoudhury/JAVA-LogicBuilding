package BinaryTrees;

public class nodesKdistanceFromTarget {
	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    //Your code goes here
        if(root==null)
            return;
        distanceFromRoot(root, node, k);        
	}
	
	//helper function algo
/* base case :
 * 			if root.data == node : target reached
 * 			call printAtK(node,k) and return 0 as distance of target from root when root=target is 0
 *     
 * fetch distance of target node from root.left =ld = distanceFromRoot(root.left,node,k);
 * if ld != -1  (target node present in left)
 * 		if ld+1 == k , 
 * 				print root
 * 		else if ld+1 < k, 
 * 				then root.right is at distance ld+2 from target node ,
 * 				so call printAtk(root.right , k-(ld+2))
 * 		return ld+1  (distance of target node from root )
 * 
 * repeat same for rd = distance of target node from root.right (this occurs when target 
 * not present in left subtree of root )
 * 
 * if both return -1 means target node is not present anywhere , so return -1
 * 
 */
    public static int distanceFromRoot(BinaryTreeNode<Integer> root, int node, int k){
    	/*	Time:O(n)       space:O(h)
    	 * Time Complexity: At first look the time complexity looks more than O(n), 
    	 * but if we take a closer look, we can observe that no node is traversed more
    	 *  than twice. Therefore the time complexity is O(n).
    	 */
        if(root==null){
            return -1;
        }
        if(root.data == node){
            printAtK(root,k);
            return 0;
        }
        
        int leftD = distanceFromRoot(root.left , node , k);       
        if(leftD != -1){  //if target present in left
            
            if(leftD + 1 == k)
            	System.out.println(root.data);

            else if(leftD + 1 < k)
                printAtK(root.right , k - leftD - 2);
            
            return 1 + leftD;
        }

        //reaches here only if target not present on left
        int rightD = distanceFromRoot(root.right , node, k);
        if(rightD != -1){

            if(rightD +1 == k)
                System.out.println(root.data);

            else if(rightD + 1 < k)
                printAtK(root.left , k - rightD - 2);
            
            return 1 + rightD;

        } 

        // if target not present anywhere in the tree
        return -1;            
    }
    
    
    public static void printAtK(BinaryTreeNode<Integer> root, int k) {
    	//Time:O(n)       space:O(h)
		if ( root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		
		printAtK(root.left , k - 1);
		printAtK(root.right , k - 1);
        
	}
	
}
