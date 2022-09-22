package BinaryTrees;


//part of approach 1
class ans<Integer>{
	int distance;
	BinaryTreeNode<Integer> parent;
	
	ans(int d){
	  distance = d;
	}
}


public class are2NodesCousins {

	//approach 1
    //Time: O(N)			space:O(N)
	public static boolean isCousin2(BinaryTreeNode<Integer> root, int p, int q) {
	//2 nodes will be cousins if they are at same depths from root but have different parents	
        if(root == null)
            return false;
        
        //call findnode() to fetch the depth of p and  from root and their parent
        ans<Integer> pans = findnode(root , p);
        ans<Integer> qans = findnode(root , q);

        if(pans.distance == qans.distance){
        	//same depth and same parent means siblings
            if(pans.parent == qans.parent)
                return false;
            else		// same depth and different parent are cousins
                return true;
        }
        else 		//different depths are not cousins
            return false;

    }
        
    
    public static ans<Integer> findnode(BinaryTreeNode<Integer> root, int k){
        if(root == null){
            int d = -1;
            return new ans<Integer>(d);
        }
           
        if(root.data == k){
            int d = 0;
            return new ans<Integer>(d);
        }
        
        ans<Integer> leftans = findnode(root.left, k);
        
      //if found in LST of current node 
        if(leftans.distance != -1){		       	
        	//if the current node is the parent of p or q update the parent of ans 
        	if(root.left.data == k)		
                leftans.parent = root;
        	
        	//increase depth by 1 as traveling up till the root
            leftans.distance += 1; 
            
            //if found in left subtree directly return from here
            return leftans;
        }
        
        //if not found in LST , find in RST
        ans<Integer> rightans = findnode(root.right, k);
        
        //if found in right return from right
        if(rightans.distance != -1){
            if(root.right.data == k)
               rightans.parent = root;
            
            rightans.distance += 1;
            return rightans;
        }
        
        //if not found anywhere return depth as -1 and parent as null
        return new ans<Integer>(-1);
        
    }
    
    
    // ----------------------------approach 2 -----------------------------------------------

	static int h1=0;
	static int h2=0;
	
    public static boolean isCousin(BinaryTreeNode<Integer> root, int x, int y) {
		if(root==null) return false;

		BinaryTreeNode<Integer> firstParent = isCousinsHelper(root, x, null,0, true);
		BinaryTreeNode<Integer> secondParent = isCousinsHelper(root, y, null,0, false);
		if(h1==h2){     
			if(firstParent==secondParent ) 
				return false;
			else 
				return true;
		}
		return false;
	}
	
	
	public static BinaryTreeNode<Integer> isCousinsHelper(BinaryTreeNode<Integer> curr, int v, BinaryTreeNode<Integer> parent, int height, boolean isFirst)
	{
		if(curr==null) return null;
		if(curr.data == v) {
			if(isFirst== true)  // to check if it is the first data(p)
				h1 = height + 1;
			else 
				h2 = height + 1;
			return parent;
		}
		BinaryTreeNode<Integer> left =  isCousinsHelper(curr.left, v , curr, height+1, isFirst);
		BinaryTreeNode<Integer> right = isCousinsHelper(curr.right, v , curr, height+1,isFirst);

		if(left!=null) return left;
		else if(right!=null) return right;
		return null;
	}
    
}

