package DP_2;

public class SqMatAll0sSizeMax {

	public static int findMaxSquareWithAllZeros(int[][] input){
        
        if(input.length == 0)
            return 0;
        
        int[][] dp = new int[input.length][input[0].length]; //max size of square with all zeroes ending at (i,j)
        
        int max = 0;  // to track the max square size in the entire matrix
        
        for(int i=0 ; i<input.length; i++){
            if(input[i][0] == 0){  //filling first column: if current cell value= 0, then this itself is the max SQUARE size= 1
             	dp[i][0] = 1;
                max  = 1;
            }
            else
                dp[i][0] = 0;
        }
               
        for(int j=0 ; j<input[0].length; j++){ //likewise filling first row
            if(input[0][j] == 0){
             	dp[0][j] = 1;
                max = 1;
            }
            else
                dp[0][j] = 0;
        }
        
        
        for(int i=1; i<input.length; i++){
            
            for(int j=1; j<input[0].length; j++){                               
                dp[i][j] = 0;              
              //if input[i][j] == 1 , then no square of all zeroes can end at this index, size will be 0
                
                if(input[i][j] == 0){                  	
                    //since input[i][j] == 0, the min size of square ending at (i,j) is at least of size 1
                    dp[i][j] = 1; 
                    
                    //for this logic draw the grid and check why we are taking the minimum
                    if(input[i-1][j] == 0 && input[i][j-1] == 0 && input[i-1][j-1] == 0){  
                        dp[i][j] = 1 + Math.min( dp[i-1][j] , Math.min( dp[i-1][j-1] , dp[i][j-1] ) ); 
                    }                    
                }
                
                if(dp[i][j] > max)  //to keep track of max square size in the dp array
                    max = dp[i][j];
            }
            
        }
            
        return max;
        
	}
	
}
