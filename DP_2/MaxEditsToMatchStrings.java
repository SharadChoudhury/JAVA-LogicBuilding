package DP_2;

public class MaxEditsToMatchStrings {
	
	//Recursive
	//Time: O(3^min(m,n))				space: O(min(m,n))   
	// Min of m and n in complexity is taken because when any one string ends, we return (base case)
	public static int editDistanceR(String s1, String s2){
		   
        int m = s1.length();
        int n = s2.length();
        
        if(m == 0)   //when one of the string is empty, minimum edits needed is equal to length of other string
            return n;
        if(n == 0)
            return m;
        
        if(s1.charAt(0) == s2.charAt(0)){  //since we are comparing the chars at each index of both strings
            //we should take the storage array in dimensions of the sizes of the strings
            return editDistanceR(s1.substring(1),s2.substring(1));  //no edits at this stage, so don't add 1
        }
        else{
            int res1 = editDistanceR(s1.substring(1), s2) + 1; 	//Insertion
            int res2 = editDistanceR(s1, s2.substring(1)) + 1;	//Deletion
            int res3 = editDistanceR(s1.substring(1) , s2.substring(1)) + 1;	//Substitution
            
            return Math.min(res1,Math.min(res2,res3));
        }

	}
    
    
    //	Memoization (Don't forget to pass the storage array in recursive function calls)
	//	Time	: 	O(m*n)			
	//	space	: 	O(m*n + min(m,n)) = O(m*n) 
	//			m*n 		: this is the space taken by dp array
	//  		min(m,n) 	: it's the space taken by the stack calls
    public static int editDistance(String s1, String s2, int[][] dp) {
        int m = s1.length();
        int n = s2.length();
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        if(m == 0){
            dp[m][n] = n;
            return n;
        }
            
        if(n == 0){
            dp[m][n] = m;
            return m;  
        }
         
        //case 1
        if(s1.charAt(0) == s2.charAt(0)){
            dp[m][n] = editDistance(s1.substring(1),s2.substring(1),dp);  //no edits at this stage, so don't add 1
            return dp[m][n];
        }
        else{
        	//add 1 at every step as we are performing 1 edit (I/D/S)
            int res1 = editDistance(s1.substring(1), s2, dp) + 1; 	//Insertion 
            /* Eg: s1 = 'abcd' & s2 = 'ct'
             * after insertion of 'a' in front of s2:
             * s1 = 'abcd'  &  s2 = 'a'+'ct' = 'act'  (don't change the given strings, just imagine the change virtually)
             * so according to case 1, in next call we should pass s1 from index=1 and s2 as it is(as no changes were made to s2)		
             */                      
            int res2 = editDistance(s1, s2.substring(1), dp) + 1;	//Deletion
            /*	Eg: s1 = 'abcd' & s2 = 'ct'
             * after deletion of 0th char of s2:
             * s1 = 'abcd'  &  s2 = 't'  (don't change the given strings, just imagine the change virtually)
             * so in next call we should pass s1 as it is and s2 from index=1
             * (as we consider the 0th char of s2 deleted)
             */
            int res3 = editDistance(s1.substring(1) , s2.substring(1), dp) + 1;	//Substitution
            /* Eg: s1 = 'abcd' & s2 = 'ct'
             * after substituting 0th char of s2 with 0th char of s1:   s1 = 'abcd'   and    s2 = 'at'
             * now both have same chars at 0th indexes, so according to case 1, in next call we should pass s1 from index=1 
             * and s2 from index 1 as we virtually replaced 'c' with 'a' 
             */
            
            dp[m][n] = Math.min(res1,Math.min(res2,res3));
            return dp[m][n];
        }


    }
    
	public static int editDistanceMem(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int i=0; i<= s1.length(); i++){
            for(int j=0; j<= s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return editDistance(s1,s2,dp);
    }

	
	
	//	DP
	//	Time: O(m*n)			space: O(m*n)
	public static int editDistanceDP(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        
        //dp stores 's1' along 'i' and 's2' along 'j'
        //dp[i,j] stores the minimum edits needed to make a string of length i equal to string of length j
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<= m; i++){ //first column(j=0) : when s2 is empty
			dp[i][0] = i;
        }
        for(int j=0; j<= n; j++){ //first row(m=0) : when s1 is empty
			dp[0][j] = j;
        }
        
        /*
         * for every dp[i,j] , we need the value of :
         * 		1.  dp[i-1, j-1] 		: case 1 & substitution case (diagonally above)
         * 		2.  dp[i-1 , j]			: insertion case			 (above in same column)
         * 		3. 	dp[i, j-1]			: deletion case				 (left in same row)
         * since row 0 and column 0 are already filled, the first value we can deduce using these is dp[1,1] and then 
         * fill entire row 1, and then row 2 and so on
         */
        
        for(int i=1; i<=m ; i++){
            for(int j=1 ; j<=n ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))  //start comparing from 0th indexes of strings
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        
        return dp[m][n];  //dp[m,n] stores the minimum edits needed to make a string of length m equal to string of length n
    }
	
	
}
