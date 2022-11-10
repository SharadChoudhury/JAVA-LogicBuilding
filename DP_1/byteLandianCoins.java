package DP_1;
import java.util.*;

public class byteLandianCoins {
	
	public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Time: O(logn)    space:O(logn)
		
/*	if we follow recursion without memoization, time:O(3^n)  space:O(3^n)
 * 
	if we follow only dynamic bottom-up approach, then we have to take a very large 
	array(<=10^9) and calculate the bytelandian for each value till 10^9, so both time complexity
	and space complexity is large
	
	so we follow a combination of memoization using maps and recursion 
*/
		if(memo.containsKey(n))
            return memo.get(n);
        if(n == 0)
            return n;

        memo.put(n, Math.max(n ,bytelandian(n/2,memo)+bytelandian(n/3,memo)+bytelandian(n/4,memo)));
        return memo.get(n);
        
	}
	
}
