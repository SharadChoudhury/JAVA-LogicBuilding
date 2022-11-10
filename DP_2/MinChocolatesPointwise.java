package DP_2;

public class MinChocolatesPointwise {

	public static int getMin(int arr[], int N){
        int[] dp = new int[N];
        
        // each element has left and right dependency
        // so iterate and find the solution at each index considering only left dependency
        // then iterate in reverse considering right dependency
        
        // since arr[0] has no left dependency, it will have 1 chocolate initially
        dp[0] = 1;
        
        //considering only left dependency
        for(int i=1; i<N; i++){
            if(arr[i] > arr[i-1])   //ith kid has more points
                dp[i] = dp[i-1] + 1;
            else					//ith kid scored less points than i-1th kid
                dp[i] = 1;  // as the minimum chocolate we can give to ith kid so that he has less chocolates than i-1th kid is 1
        }
        
        //considering right dependency
        //we consider from arr[N-2] as the last kid(arr[N-1]) has no right dependency
        for(int i= N-2; i>=0; i--){
            if(arr[i] > arr[i+1] && dp[i] <= dp[i+1])
                dp[i] = dp[i+1] + 1;
        }
        
        int sum =0;
        for(int i: dp){
            //System.out.print(i+" ");
            sum += i;
        }
         //System.out.println();   
        
        return sum;
    }
	
}
