package DP_1;

public class coinTower {
	
/*
 * 	Let us take few example values of n for x = 3, y = 4. 
	n = 0 	A can not pick any coin so he losses 
	n = 1 	A can pick 1 coin and win the game 
	n = 2 	A can pick only 1 coin. Now B will pick 1 coin and win the game 
	n = 3,4 A will win the game by picking 3 or 4 coins 
	n = 5,6 A will choose 3 or 4 coins. Now B will have to choose from 2 coins so A will win.
	We can observe that A wins game for n coins only when B loses for coins n-1 or n-x or n-y
 */
	
	public static String findWinner(int n, int x, int y) {
	//Your code goes here
		
        int[] dp = new int[n+1];
    // dp[i] = 0 :if 'i' coins are left , then A will lose
    	//	 = 1 :if 'i' coins are left , then A will win
        
    //if zero coins are left to remove then A has lost
        dp[0] = 0; 
        
    //if 1 coin is left to remove, then A will win by removing 1 coin and thus making
    //the last move
        dp[1] = 1;
        
        // Computing other values.
        for (int i = 2; i <= n; i++) {
      
            // If A losses any of i-1 or i-x
            // or i-y game then he will
            // definitely win game i
        	
        	//if 'i' coins are left to remove 
        	
        	//if i-1 >= 0 and if A loses with i-1 coins, then A removes just 1 coin so that B is left 
        	// with i-1 coins and hence B loses. Both players are playing intelligently. 
        	// Similar comparisons are done for i-x and i-y
            if (i - 1 >= 0 && dp[i - 1] == 0)
                dp[i] = 1;
            else if (i - x >= 0 && dp[i - x] == 0)
                dp[i] = 1;
            else if (i - y >= 0 && dp[i - y] == 0)
                dp[i] = 1;
      
            //if no matter if you remove 1/x/y coins, A wins with i-1/i-x/i-y coins, 
            // i.e, dp[i-1/i-x/i-y] = 1, then A will lose with i coins
            else
                dp[i] = 0; //A loses with i coins
        }
        
        if(dp[n]!=0)
            return "Beerus";
        else
            return "Whis";
		
//        boolean[] dp = new boolean[n+1];
//        dp[1] = true;
//        
//        for(int i=2; i<= n; i++){
//            if(dp[i-1] == false)
//                dp[i] = true;
//            else if(i-x >= 0 && dp[i-x] == false)
//                dp[i] = true;
//            else if(i-y >= 0 && dp[i-y] == false)
//                dp[i] = true;
//            else
//                dp[i] = false;
//        }
//        
//        if(dp[n] == true)
//            return "Beerus";
//        else
//            return "Whis";
  
	}

	
}
