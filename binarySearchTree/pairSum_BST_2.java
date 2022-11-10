package binarySearchTree;
import java.util.*;


//using inorder and reverse inorder stacks
//time:O(N)   space:O(logN)
public class pairSum_BST_2 {
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int k) {
		// Write your code here
        if(root == null )
            return ;
        
	    Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
        
        BinaryTreeNode<Integer> root1 = root, root2 = root;
        BinaryTreeNode<Integer> curr1 = null, curr2 = null;

        boolean find1 = false, find2 = false; //markers to get new elements

        while (true)
        {
        // standard code for iterative inorder traversal using stack approach
            if (find1 == false)
            {
                while (root1 != null)
                {
                    s1.push(root1);
                    root1 = root1.left;
                }
                curr1 = s1.peek();  //curr1 similar to 'i' in two pointer approach
                s1.pop();
              //next greater element to curr1 is the leftmost element of RST of curr1
              //as it is a stack the inorder successor of curr1 will be stored at the top of s1 in 
              //next insertions of s1
                root1 = curr1.right; 
                find1 = true;
            }
        // standard code for iterative reverse inorder traversal using stack approach
            if (find2 == false)
            {
                while (root2 != null)
                {
                    s2.push(root2);
                    root2 = root2.right;
                }
                curr2 = s2.peek(); //curr2 similar to 'j' in two pointer approach
                s2.pop();
                root2 = curr2.left;
                find2 = true;
            }
        // breaking condition
            if (curr1.data >= curr2.data)
                break;

        // means we need next elements so make find1 and find2 to false to get next elements
            if (curr1.data + curr2.data == k)
            {
                System.out.println(curr1.data +" "+ curr2.data);
                find1 = false;
                find2 = false;
            }
        // means we need greater element so make find1 to false to get next greater
            else if (curr1.data + curr2.data < k)
                find1 = false;

        // means we need smaller element so make find2 to false to get next smaller
            else //if (curr1->data + curr2->data > k)
                find2 = false;

        }

        
	}
	
}
