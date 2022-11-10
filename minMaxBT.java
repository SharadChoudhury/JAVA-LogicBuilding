package BinaryTrees;

class Pair2<T, U> {
	T minimum;
	U maximum;

	public Pair2(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class minMaxBT {
	//Time:O(n)       space:O(h)     
	// in recursive functions in binary trees, space complexity is O(h) instead of O(n)
	// because now the calls in the stack accumulate till root==null, ie, it is accumulates
	// as many calls as the height of tree.
	public static Pair2<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		
        if(root==null)
            return new Pair2<Integer, Integer> (Integer.MAX_VALUE , Integer.MIN_VALUE);
        
        Pair2<Integer, Integer> ans = new Pair2<Integer,Integer>(0,0);
        
        //very important to store answers of left and right subtree first and then 
        //calculate their min and max instead of calling the function twice on each
        //subtree, otherwise time complexity increases
        Pair2<Integer, Integer> leftans = getMinAndMax(root.left);
        Pair2<Integer, Integer> rightans = getMinAndMax(root.right);
        
        ans.minimum = Math.min(root.data, Math.min(leftans.minimum , rightans.minimum));
        ans.maximum =  Math.max(root.data, Math.max(leftans.maximum , rightans.maximum));
        return ans;
	}
	
	
}
