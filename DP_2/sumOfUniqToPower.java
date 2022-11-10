package DP_2;

public class sumOfUniqToPower {
	
//can't use dp here as there are no repeating subpro
    
    public static int allWays(int x, int n) {
        return countWaysUtil(x,n,1);  //pass num as the number whose power will be included in the sum
        //as we need sum of powers of UNIQUE integers so we can pass each num only once
        //we can choose to either include or not include the num
        //if num is included, then x changes in next call for n+1, x = x - (int)Math.pow(num,n)
        //if not included, x remains same
    }
    
    static int countWaysUtil(int x, int n, int num)
    {
        // Base cases
        int val = (int) (x - Math.pow(num, n));
        if (val == 0)
            return 1;
        if (val < 0)
            return 0;
      
        // Consider two possibilities, num is
        // included and num is not included.
        return countWaysUtil(val, n, num + 1) + countWaysUtil(x, n, num + 1);
    }
	
}
