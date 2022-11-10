package DP_2;

public class coinsDenominations {

// 	public static int countWaysToMakeChange(int denominations[], int value){
//  // Write your code here
//  if(value <= 0)
//      return 0;
//  if(value == 1)
//      return 1;
 
//  int count = 0;
//  for(int i =0; i< denominations.length; i++){
//      count += countWaysToMakeChange(denominations, value - denominations[i]);
//  }
//  return count;
//}

	public static int countWaysToMakeChange(int denominations[], int value){
	 int[] dp = new int[value + 1];
	
	 dp[0] = 1;
	 
	 for(int i=0; i<denominations.length ; i++)
	     for(int j=denominations[i]; j<=value; j++)
	         dp[j] = dp[j] + dp[j-denominations[i]] ;
	 
	 return dp[value] ;
	}
	
	
	//easier to understand approach (refer striver's lecture)
	public static int countWaysToMakeChange2(int denominations[], int value){
        // denominations are stored vertically and 
		// we arrange elements from 0 to the value that we want to attain horizontally
		// each cell of the matrix(i,j) has the no. of ways we can achieve the value = j using
		// coins with denominations till index = i of the denominations array
		// Eg: (4,5) means how can we attain the value = 5 using changes of  
		// denominations[0],denominations[1],...,denominations[4]
		// Imp note: any coin can be used any no.of times for attaining the value
		
        int[][] arr = new int[denominations.length][value+1];
        
        //value = 0 can be attained always by not choosing any of the coins, so there is always 1 way
        for(int i=0; i<denominations.length; i++){
            arr[i][0] = 1;
        }
        
        //we have to fill at least the first row so that we can fill the below rows as each row depends on its 
        //previous rows. Imagine you want to attain a value = j, and you have only coin, denomination[0]. 
        //value = j is attainable only if it's a multiple of denomination[0]
        for(int j=1; j<= value ; j++){           
            if( j % denominations[0] == 0 )
             	arr[0][j] = 1;
            else
                arr[0][j] = 0;
        }
        
        for(int i=1; i<denominations.length; i++){
            for(int j=1; j<=value; j++){                
            // if we don't take current coin(i) in the sum to attain j. 
            // So the no. of ways to attain j using coins till ith coin = the no. of ways
            // to attain j using sum of coins till (i-1)th coin (value of above cell in same column)
            // it's clear that no matter what, we need the values in the last row(i-1) to calculate current row(i) values
                int notTake = arr[i-1][j];
                
            /*  if we take current coin(i) in the sum to attain j (for this it's necessary that j >= current coin value)
             *  Then,the no. of ways to attain j using coins till ith coin by taking the ith coin in
             *  the sum = no. ways to attain (j - current coin value) using coins till ith coin (as each coin can be used
             *  any no. of times)
             */
          
                int take = 0;
                if(j >= denominations[i])
                	take = arr[i][j - denominations[i]];
                
                arr[i][j] = take + notTake;
            }
        }
        
        return arr[denominations.length-1][value];
	}
	
}
