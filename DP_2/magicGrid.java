package DP_2;

public class magicGrid {

	public static int getMinimumStrength(int[][] grid) {
		//energy in each cell must be > 0
		
        int m = grid.length;
        int n = grid[0].length;
		int[][] dp = new int[m][n]; //each cell (i,j) stores the minimum energy required to reach the destination 
		// cell from current cell
		
        dp[m-1][n-1] = 1;  //minimum energy to reach destination from destination is 1
        
        for(int i=m-2; i>=0 ; i--){		//filling the last column
    	/*
    	 * for the next cell(i+1,j) if the min energy required to reach destination = x,
    	 * then if the sum of current cell min energy(dp[i][j]) and next cell grid value(grid[i+1][j]) is at least 
    	 * equal to x, then we can reach destination 
    	 * 			if  dp[i][j] + grid[i+1][j] >= x , then we can reach destination
    	 * 			=>  dp[i][j] >= x - grid[i+1][j]
    	 * Thus the current cell should have a min energy = next cell min energy(x) - next cell grid value
    	 * if the difference is <= 0 (i.e when the next cell already has sufficient energy to reach destination or 
    	 * next cell grid value > next cell min energy to reach destination, we should set the current cell energy 
    	 * as 1 since min energy a cell must have is 1 
    	 */

           	dp[i][n-1] = dp[i+1][n-1] - grid[i+1][n-1] ; 
            if(dp[i][n-1] < 1)
                dp[i][n-1] = 1;
        }
        
        for(int j=n-2; j>=0 ; j--){
           	dp[m-1][j] = dp[m-1][j+1] - grid[m-1][j+1] ;  //similarly as above for last row
            if(dp[m-1][j] < 1)
                dp[m-1][j] = 1;
        }
        
        for(int i=m-2; i>=0 ; i--){
            for(int j=n-2; j>=0; j--){
                dp[i][j] = Math.min( dp[i+1][j]-grid[i+1][j] , dp[i][j+1]-grid[i][j+1] );  //taking minimum of 
                //the energies in the two paths: 1)moving down  2)moving right
                if(dp[i][j] < 1)
                    dp[i][j] = 1;
            }
        }
        
        return dp[0][0];
    }
	
}
