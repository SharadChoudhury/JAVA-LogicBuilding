package DP_2;

public class LongestCommonSubsq {
	//find length of the longest common subsequence between a and b
	
	//Recursive
	//Time : O(2^min(m,n))   --> Total no. of nodes for a tree of height 'h' and 2 children at max for each node = 2^h
	//space : O(2^min(m,n))
	public static int lcsR(String a, String b) { 
		int m = a.length();
		int n = b.length();
		
		//base case : It determines the height of tree of stack calls 
		if(m == 0 || n == 0) //if any one of the strings is empty then there is nothing in common
			return 0;		// thus, max height of tree = min(m,n)
		
		if(a.charAt(0) == b.charAt(0))
			return 1 + lcsR( a.substring(1) , b.substring(1) );
		else {
			int res1 = lcsR(a.substring(1), b);
			int res2 = lcsR(a, b.substring(1));
			return Math.max(res1, res2);
		}
	}
	
	
	//Memoization
	// Time: O(m*n)				
	// space: O(m*n) (ignoring stack space)
	public static int lcsM(String a, String b) {
		int m = a.length();
		int n = b.length();
		
		//every cell of the storage array contains the length of the longest common subsequence
		//given a string of length m and another string of length n
		int[][] storage = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				storage[i][j] = -1;
			}
		}
		return lcsM(a,b,storage);
	}
	
	public static int lcsM(String a, String b, int[][] storage) { 
		int m = a.length();
		int n = b.length();
		
		if(storage[m][n] != -1)   //return the value directly if it already exists
			return storage[m][n];
		
		//base case
		if(m == 0 || n == 0) { //if any one of the strings is empty then there is nothing in common			
			storage[m][n] = 0; //filling of storage array starts from here
			return storage[m][n];
		}
		
		if(a.charAt(0) == b.charAt(0)) {
			storage[m][n] = 1 + lcsM( a.substring(1) , b.substring(1), storage);
		}			
		else {
			int res1 = lcsM(a.substring(1), b, storage);
			int res2 = lcsM(a, b.substring(1), storage);
			storage[m][n] = Math.max(res1, res2);
		}
		
		return storage[m][n];
		
	}
	
	//DP :Bottom up (opposite direction of recursion)
	// Time : O(m*n)     				space : O(m*n)
	public static int lcsDP(String a, String b) {
		int m = a.length();
		int n = b.length();
		
		//every cell of the dp array contains the length of the longest common subsequence
		//given a string of length i and another string of length j
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				dp[i][j] = -1;
			}
		}
		
		/*
		 * We know that if any one of 'a' or 'b' is empty string, there will be no common subsequence
		 * So for all cells with i=0 or j=0, value in the cell should be 0
		 */
		
		for(int i=0; i<=m ; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<=n ; j++) {
			dp[0][j] = 0;
		}
		
		/*
		 * To calculate the value of every cell, we need the value of its left cell(n-1) on same row, 
		 * above cell(m-1) on same column , diagonally above cell(m-1,n-1)
		 * 
		 * Eg: To calculate the lcs for m=3,n=2, we need :			where, m = length of a,  n = length of b
		 * 			the lcs of m=2,n=1 (when first char of a and b matches)
		 * 			when first char does not match: we need
		 * 						lcs of m=2,n=2  &
		 * 						lcs of m=3,n=1
		 *  so for (m,n) we need (m-1,n-1) , (m-1,n) & (m,n-1)
		 *  
		 *  So, when first row and first column are completely filled, the cell whose value can be calculated is m=1,n=1
		 *  Likewise all cells can be calculated thereafter
		 */
		
		for(int i=1; i<=m ;i++) {
			for(int j=1; j<=n; j++) {
				/*
				 * Staring from end of the strings, At (m=1,n=1) we have the last chars of a and b i.e, a.charAt(m-1) and b.charAt(n-1)
				 * to generalize, at every cell we are comparing the chars at index (m-i) of string a and (n-j) of string b
				 * We can also start from beginning of two strings if we compare chars at indexes at i-1 and j-1
				 */
				if(a.charAt(m-i) == b.charAt(n-j)) {
					dp[i][j] = 1 + dp[i-1][j-1]; //diagonally above
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];  //final result is when i=m and j=n
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "dgeigeigehrhrderteardri";
		String b = "begigeigfhdhtddrhytei";
		System.out.println(lcsM(a,b));
		System.out.println(lcsDP(a,b));
		System.out.println(lcsR(a,b));
	}

	
}
