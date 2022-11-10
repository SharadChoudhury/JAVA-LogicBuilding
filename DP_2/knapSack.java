package DP_2;

public class knapSack {

	//Recursive
	public static int knapsackR(int[] weights, int[] values, int n, int maxWeight) {
        //maxWeight is the max weight that this sack can hold
		// n = length of weights array
		//here we traverse the weight array from end index to start index, analyzing the last index of the 
		//array we pass at each step
		
        //if maxWeight = 0, then nothing more can be added to the sack, so return 0
		//n = 0 means array length is 0, so return 0 as nothing to be added
        if(n == 0 || maxWeight == 0)		
            return 0;
        
        if(weights[n-1] > maxWeight)  //if current weight more than maxWeight, then skip and move to next weight
            return knapsackR(weights, values, n-1, maxWeight); 
        
        else{
        	//don't add the current weight in the sack: The maxWeight remains same, but moves to next weight in the array
            int res1 = knapsackR(weights, values, n-1, maxWeight);  
            
            //add the current weight to sack : maxWeight gets reduced by current weight
            int res2 = values[n-1] + knapsackR(weights, values, n-1, maxWeight - weights[n-1]);	
            
            return Math.max(res1,res2);
        }        
	}
	
	
	//Memoization	
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight, int[][] dp) {
    	
         if(n == 0 || maxWeight == 0){
            dp[n][maxWeight] = 0;
            return 0;
         }
          
        if(dp[n][maxWeight] != -1)  //return if already exists (Main step of memoization)
            return dp[n][maxWeight];
        
        if(weights[n-1] > maxWeight){
           dp[n][maxWeight] = knapsack(weights, values, n-1, maxWeight, dp); 
            return dp[n][maxWeight];
        }  
            
        else{
            int res1 = knapsack(weights, values, n-1, maxWeight, dp);  //don't include current weight
            int res2 = values[n-1] + knapsack(weights, values, n-1, maxWeight - weights[n-1], dp);	//include current weight
            dp[n][maxWeight] =  Math.max(res1,res2);
            return dp[n][maxWeight];
        }
        
	}
    
    public static int knapsackM(int[] weights, int[] values, int n, int maxWeight){
        int[][] dp = new int[n+1][maxWeight+1];  //holds the max value that can be attained by storing weights when
        //max weight limit is j and you have weights from 0th index to (i-1)th index of weights array 
        
        for(int i=0; i<=n ; i++){
            for(int j=0; j<=maxWeight; j++){
                dp[i][j] = -1;
            }
        }
        
        return knapsack(weights, values, n, maxWeight, dp);
    }
    
    
    
    //DP approach iterative
    static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {
        
        // dp array holds the max value possible if we start from index 'i' and take elements till end of 
    	// weights array and maxWeight at this stage is 'j'
    	// weight indexes along 'i' and maxWeight along 'j'
		int[][] dp = new int[n+1][maxWeight+1];
        
		// base case (last row): when you have no weights left in the array to insert , as nth index
    	// won't exist in weights array of size n , so max index is n-1 
        for(int j=0 ; j<= maxWeight; j++){ 
            dp[n][j] = 0;
        }
        
        //base case (first column) :if maxWeight = 0, then we can't add any more weight, so max value possible here is 0
        for(int i=0; i<n ;i++){  
            dp[i][0] = 0;
        }
        
        /*
         * for every cell, we need the value of two cases:
         *  1)	not including current weight(i) and moving to next weight(i+1) (maxWeight(j) stays same) --> bottom cell value
         *  2)	including current weight(i) and moving to next weight(i+1) (maxWeight decreases by a value of current weight
         *   	and moves to the left (j - weight[i])) --> some value on left of this cell and below
         *  		
         */
        for(int i=n-1; i>=0 ; i--){
            for(int j=1; j<=maxWeight; j++){                
                if(weight[i] > j)   //weight of current element is greater than max weight allowed then don't include it
                    dp[i][j] = dp[i+1][j]; //i.e, max value possible here will be max value that was possible before this
                //element was added

                else
                	//dp[i][j]= max value obtained by either not taking or taking the current weight
                    dp[i][j] = Math.max( dp[i+1][j] , value[i] + dp[i+1][j-weight[i]] );               
            }
        }
        
        return dp[0][maxWeight];        
        
    }
	
}
