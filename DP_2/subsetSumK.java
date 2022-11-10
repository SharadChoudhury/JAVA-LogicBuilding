package DP_2;

public class subsetSumK {

	//Iterative dp
	static boolean isSubsetPresent(int[] arr, int n, int k) {
		//each element can be considered in the subset only once
		
        boolean[][] dp = new boolean[n][k +1];   //each cell(i,j) holds the result if the value j was attained using any
        // subsets of the array till index i
        
        for(int i=0; i<n ; i++){		// first column where target = 0
            dp[i][0] = true;  			//target = 0 is possible always
        }
        
        if (arr[0] < k)
            dp[0][arr[0]] = true;     //rest all in 0th row are already false
        
        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
            	
                //exactly follow the recursion steps and translate them for dp array, n-1 becomes i, sum becomes j
            	//each row of dp depends on its previous row only
            	
                if(arr[i] > j)  //case A : ignore current element if it's greater than k
                	dp[i][j] = dp[i-1][j];

                else  // case B
                	dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];              	
            }
        }
        
        return dp[n-1][k];
                
    }
	
	//recursive - top down 
	//if start from the last element here and till 0th element
	static boolean isSubsetSum(int set[], int n, int sum) {
		// Base Cases
		if (sum == 0)  //if sum == 0 means subset exists with required sum
			return true;
		
		if (n == 0)   //if array is exhausted and sum is still not attained then no subset exists with required sum
			return false;
		
		//case A:  If current element is greater than
		// sum, then ignore it ( there is no option of including it in the subset sum)
		if (set[n - 1] > sum)
			return isSubsetSum(set, n - 1, sum);
		
		/* else, case B: check if sum can be obtained by any of the following
		(a) including the current element
		(b) excluding the current element 
		 	if sum can be attained in any of the above 2 cases, then sum can also be attained in this cell
		*/
		return   isSubsetSum(set, n - 1, sum - set[n - 1])  ||  isSubsetSum(set, n - 1, sum);
	}
	
	
}
