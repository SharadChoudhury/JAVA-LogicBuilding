package DP_2;

public class lootHouses {

	public static int maxMoneyLooted(int[] houses) {
        //we cannot loot consecutive houses
		
        if(houses.length == 0)
            return 0;
        
        if(houses.length == 1) {
        	return houses[0];
        }
        
        int[] dp = new int[houses.length];    
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0],houses[1]);
        
        for(int i=2; i< houses.length ; i++){
            dp[i] = Math.max(dp[i-1] , houses[i] + dp[i-2]);
            // when we don't loot the current house, so we store the max money looted till previous house, dp[i-1]
            // If we loot the current house, then we cannot loot the previous house, so we add the max gain from (i-2)th house
            // to money in current house : houses[i] + dp[i-2]
        }
        
        return dp[houses.length-1];
	}
	
}
