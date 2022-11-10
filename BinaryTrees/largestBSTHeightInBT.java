package BinaryTrees;


class Result1{
    int min;
    int max;
    boolean isbst;
    int height;
    
    Result1(int min, int max, boolean isbst, int h){
        this.min = min;
        this.max= max;
        this.isbst= isbst;
        height = h;
    }
}

public class largestBSTHeightInBT {
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {            
         return largestBST(root).height;   
	}
    
    public static Result1 largestBST(BinaryTreeNode<Integer> root){
    	//time : O(N)     space:O(N)
    	
        if(root == null)
            return new Result1(Integer.MAX_VALUE, Integer.MIN_VALUE , true, 0);
        
        Result1 leftans = largestBST(root.left);
        Result1 rightans = largestBST(root.right);
        
        int min =  Math.min(root.data,Math.min(leftans.min,rightans.min));
        int max = Math.max(root.data,Math.max(leftans.max,rightans.max));
        boolean isbst = leftans.isbst && rightans.isbst && leftans.max < root.data && rightans.min > root.data;
        int h;
        if(isbst == true )  
            h = 1+ Math.max(leftans.height , rightans.height);
        else
            h = Math.max(leftans.height , rightans.height);
        
        Result1 ans = new Result1( min, max, isbst, h);
        return ans;
    }
	
}