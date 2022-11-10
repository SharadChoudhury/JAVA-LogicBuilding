package DP_2;

/*
 * size of array(p) = n
 * No. of matrices = n-1
 * M1 size = p[0] * p[1]
 * M2 size = p[1] * p[2]
 * .		.		.
 * .		.		.
 * M(n-1) size = p[n-2] * p[n-1]
 * When we multiply two matrices of size a*b and b*c , then no. of multiplications = a*b*c
 * We have to decide how we take the outer brackets while multiplying, possible ways for multiplying 4 matrices are:
 * start = 0, end = 4 (array(p[]) of size 5, no of matrices = 4)
 * (M1)*(M2*M3*M4)		-->  k = 1
 * (M1*M2)*(M3*M4)		-->  k = 2
 * (M1*M2*M3)*(M4)		-->  k = 3
 * k is where we put the first closing bracket :  		(start index + 1) <= k <= (end index - 1)
 * we have to pass 2 parameters, start index & end index of the array
 * If first group of matrices ends at k : then size of product of matrices of this group = p[start] * p[k]
 * and size of 2nd group = p[k] * p[end]
 */
public class matrixChainMult {

	public static int mcm(int[] p){
        int n = p.length;
        int[][] dp = new int[n][n];
        
		for(int i=0; i<n; i++){
            for(int j=0; j<n ; j++){
                dp[i][j] = -1;
            }
        }
        
        return matMul(p, 0, p.length-1, dp);
	}

	public static int matMul(int[] arr, int start, int end, int[][] dp){
        if(start >= end - 1){  //if start = end, it means there is no matrix
        	// if start = end -1, it means there is one matrix only, so no multiplications required
            dp[start][end] = 0;
            return 0;
        }
        
        if(dp[start][end] != -1)
            return dp[start][end];
        
        int min = Integer.MAX_VALUE;
        int res = 0;       
        
        for(int k=start+1; k<=end-1; k++){
        	// add the total multiplications needed for multiplying the results of both parts to the 
        	// sum of minimum multiplications required from each of the parts divided at k 
            //k is passed in both groups
            //as first group's last matrix size ends at k and 2nd group first matrix size starts at k
        	
            res = arr[start]*arr[k]*arr[end] + matMul(arr,start,k,dp) + matMul(arr,k,end,dp);  
           
            if( res < min )
                min = res;
        }
        dp[start][end] = min;
        return dp[start][end];
        
    }
	
}
