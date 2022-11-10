package DP_1;

public class staircaseWays {

	public static long staircase(int n) {
		//DP : time= O(n)         space= O(n)
        long[] arr = new long[n+1];
        arr[0] = arr[1] = 1;  // if only 0 steps, then exactly one way to climb it i.e, by
        //standing on that stair itself, and climb only one step for total 1 steps
        
        long x,y,z;
        for(int i=2; i<=n ;i++){
            x = y = z = 0;
            if(i-1 >= 0)
            	x = arr[i-1];
            if(i-2 >= 0)
            	y = arr[i-2];
            if(i-3 >= 0)
            	z = arr[i-3];
            
            arr[i] = x+y+z;  //sum of ways to reach n-1 & n-2 & n-3
        }
        
        return arr[n];
	}
	
}
