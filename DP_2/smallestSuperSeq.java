package DP_2;

public class smallestSuperSeq {

	public static int smallestSuperSequence(String str1, String str2, int[][] arr) {
		//smallest string whose subsequences are str1 and str2
		
		int m = str1.length();
        int n = str2.length();
        
        //if any one of the strings is empty then the other sequence itself is the super-sequence
        if(m == 0){    
            arr[m][n] = n;
            return arr[m][n]; 
        }
        if(n == 0){
            arr[m][n] = m;
            return arr[m][n];
        }
        
        if(arr[m][n] != -1){
            return arr[m][n];
        }
        
        //when 0th chars of str1 and str2 are same
        if(str1.charAt(0) == str2.charAt(0))		 //including the common 0th char to sequence so adding 1
            arr[m][n] = 1 + smallestSuperSequence(str1.substring(1), str2.substring(1), arr);
        
        //when 0th chars of str1 and str2 are different
        else 								//including either 0th char of str1 or str2 so increasing length by 1
            arr[m][n] = 1 + Math.min(smallestSuperSequence(str1.substring(1), str2, arr),
                                    smallestSuperSequence(str1, str2.substring(1),arr) );
        
        return arr[m][n];
    }
    
    public static int smallestSuperSequence(String str1, String str2){
        int m = str1.length();
		int n = str2.length();
		
        //Memoization
//		for(int i=0; i<=m; i++) {
//			for(int j=0; j<=n; j++) {
//				dp[i][j] = -1;
//			}
//		}        
//      return smallestSuperSequence(str1, str2, dp);
        
        //DP
		// every cell of the dp array contains the length of the shortest super-sequence
		// given a string of length i and another string of length j ,with string along the i axis(vertical) starts with (m-i)th  
		// char ending at (m-1)th i.e, the last char of str1, and str2 along the j axis(horizontal) starts with 
		// char at (n-j)th index of str2 ending at (n-1)th index i.e, the last char
		
		int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m ; i++) {
			dp[i][0] = i;
		}
		
		for(int j=1; j<=n ; j++) {
			dp[0][j] = j;
		}
        
        for(int i=1; i<=m ;i++) {
			for(int j=1; j<=n; j++) {
                if(str1.charAt(m-i) == str2.charAt(n-j)){
                	dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n] ;
               
    }
	
}
