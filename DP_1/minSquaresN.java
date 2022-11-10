package DP_1;

public class minSquaresN {

	public static int minSquaresCount(int n) {
		//Time : O(n*n^(1/2))			space:O(n)
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while(j*j <= i) {
				if(dp[i - j*j] < min)
					min = dp[i - j*j];
				j++;
			}
			dp[i] = 1 + min;
		}
		
		return dp[n];
	}
	
	public static void main(String args[]) {
		System.out.println(minSquaresCount(6));
	}
	
}
