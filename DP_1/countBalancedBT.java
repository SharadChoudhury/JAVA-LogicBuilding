package DP_1;

/*
Time complexity: O(2^N)
Space complexity: O(N)

where N is the final height of the binary tree
*/

/*
 * A tree of height h is balanced if :
 * 		1. 	both LST and RST are balanced
 * 		2.	and difference in height of LST and RST <= 1 (0 or 1)
 * 
 * Height of tree = Max(height of LST, Height of RST) + 1
 * 
 * So possible combinations of height of subtrees for tree of Height h :
 * 		LST			RST
 * 	1.  h-1			h-2				--> height diff = 1 , max height = h-1
 *  2.	h-2			h-1				--> height diff = 1 , max height = h-1
 *  3.	h-1			h-1				--> height diff = 0 , max height = h-1
 *  
 *  Each balanced BT of LST can be combined with each balanced BT of RST,so we multiply for combinations
 *  So, height of tree(h) = Max height of subtrees + 1 = (h-1) + 1 = h
 * 		
 */
public class countBalancedBT {
	
	//recursive
	public static long balancedBTs(long h){ //return type long
	    if(h < 0)
	        return 0;
		if(h == 1 || h == 0)  //tree with only one node or no nodes is a Balanced tree itself
	        return 1;
		
		long ans1 = balancedBTs(h-1);
	    long ans2 = balancedBTs(h-2);
	    
	    //sum of count of Balanced trees with all 3 possibilities
	    return (ans1*ans1 + 2*ans1*ans2) % (long)(Math.pow(10,9) + 7) ;
	}
	
	public static int countBalancedBTs(int h){		//return type int
		int mod = (int)Math.pow(10, 9) + 7;
		return countBalancedBTs(h, mod);
	}
	
	public static int countBalancedBTs(int h, int mod){		
		
		if(h == 0 || h == 1){
			return 1;
		}
		
		int x = countBalancedBTs( h - 1);
		int y = countBalancedBTs(h - 2);
		long res1 = (long)x * x;
		long res2 = (long)x * y * 2; 
		int value1 = (int)(res1 % mod);
		int value2 = (int)(res2 % mod);
		return  (value1 + value2) % mod;
	}
	
	//dynamic programming
	public static int balancedBTs(int height){

        int arr[] = new int[height+1];
        arr[0] = arr[1] = 1;
        
        for(int i =2 ; i<= height ;i++){           
            int x = arr[i-1];
            int y = arr[i-2];          
            //x*x or x* y will be too large to handle by int so convert any one of them to long
            //and then multiply and find the mod which will give a small result and it can be 
            //stored in int without loss
            int xl = (int)( (long)x * x   %  (int)(Math.pow(10,9) + 7) );
            int yl = (int)( 2 * (long)y * x   %  (int)(Math.pow(10,9) + 7) );
            
            arr[i] = (xl+yl) % (int)(Math.pow(10,9) + 7);
        }

        return arr[height];      
	}
	
}