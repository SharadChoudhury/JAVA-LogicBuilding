package DP_1;

public class minCountSquares {

	public static int minCount(int n) {
		//Your code goes here
		
		//recursive
//        if (n < 1)
//            return 0;
//        if(n==1)
//            return 1;
//        
//        int min = Integer.MAX_VALUE;
//        for(int i=1; i<=Math.sqrt(n) ;i++){
//            int steps = 1 + minCount(n - i*i);
//            if(steps < min)
//                min = steps;
//        }
//        
//        return min;
         
		//dynamic programming
        int[] arr = new int[n+1];
        arr[1] = 1;
        
        for(int i=2; i<=n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i ; j++){
                int steps = 1 + arr[i - j*j];
                if(steps < min)
                    min = steps;               
            }
            arr[i] = min;
        }
        
        return arr[n];
	}
	
}
