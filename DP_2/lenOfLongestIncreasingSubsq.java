package DP_2;

public class lenOfLongestIncreasingSubsq {

	public static int lis(int arr[]) {
		//Time: O(n^2)   		   space:O(n)
		
		//create a dp[], where each index holds the length of the longest increasing subsequence ending at 
		//that index in input arr
        int[] dp = new int[arr.length];
        dp[0] = 1;
        
        int result = 1; //minimum length of increasing subsequence is 1
        
        for(int i=1; i<dp.length; i++){           
            int max = 1;  //minimum length of increasing subsequence ending at this index = 1, i.e this element itself
            
            //starting from prev index till 0th index find the max length of increasing subsequence where element at
            //that index (arr[j]) is less than current element
            for(int j= i-1; j >= 0 ; j--){
                if(arr[j] < arr[i])
                    max  = Math.max(max , dp[j]+1);    //we compare max with dp[j]+1 as current element at i will also be added
                //to the length of the longest subsequence at j if arr[j] < arr[i]
            }    
            dp[i] = max;
            if(dp[i] > result)
                result = dp[i];
        }
        
        return result;

    }
	
}
