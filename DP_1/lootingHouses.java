package DP_1;

public class lootingHouses {
	
	//Recursive
	// public static int maxMoneyLooted(int[] houses, int index){  
    //     if(index < 0)
    //         return 0;
    //     return Math.max( houses[index]+maxMoneyLooted(houses,index-2) , maxMoneyLooted(houses,index-1));
    // }
	
	
	//DP
	//Time :O(n)   space:O(1)
	public static int maxMoneyLooted(int[] houses) {

        if(houses.length == 0) // nothing to loot
            return 0;
        
        if(houses.length == 1) // loot the only house present
            return houses[0];
        
        //for houses[1] , if we loot this, then we can't loot houses[0]
        //else we loot houses[0] and don't loot this house, so choose the max of houses[0] 
        //and houses[1] so that the gain is maximum
        houses[1] = Math.max(houses[0] , houses[1]);
        
        // we can either loot the ith house and add it to the max gain from house[i-2]
        // or we can not loot the ith house and consider the max gain from house[i-1]
        // and set the max gain for ith house as the max value among the 2 options
        for(int i=2 ; i< houses.length ; i++){
			houses[i] = Math.max( houses[i]+houses[i-2] , houses[i-1]);          
        }
        
        //last index of the array stores the max gain obtained from looting all houses 
        return houses[houses.length-1];
	}
	
}
