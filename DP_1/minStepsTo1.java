package DP_1;

public class minStepsTo1 {

	//Brute force : Time:O(3^n)      space:O(n)
 	public static int countMinStepsToOneBF(int n) {  
 		if(n<=1)
 			return 0;
 		int res1 = countMinStepsToOneBF(n-1);
 		int res2 = Integer.MAX_VALUE;
 		int res3 = Integer.MAX_VALUE;
    
 		if(n%2 == 0)
 			res2 = countMinStepsToOneBF(n/2);
 		if(n%3 == 0)
 			res3 = countMinStepsToOneBF(n/3);
    
 		return 1 + Math.min(res1, Math.min(res2,res3));
	}


 	//using memoization
 	// time: O(n)     space:O(n)
	public static int countMinStepsToOneMem(int n){
	    int[] arr = new int[n+1];
	    for(int i=0; i<n+1; i++)
	        arr[i] = -1;
	   	return countMinStepsToOne(n,arr);       
	}

	private static int countMinStepsToOne(int n, int[] arr) {
	    
	    if(arr[n] != -1) //return from storage array if result already exists
	        return arr[n];
	    
	    if(n <= 1){ // if already at step 1
	        arr[1] = 0;
	        return arr[1];
	    }
	
	    int res1 = Integer.MAX_VALUE;
	    int res2 = Integer.MAX_VALUE;
	    int res3 = Integer.MAX_VALUE;
	    
	    res1 = countMinStepsToOne(n-1, arr);
	    if(n%2 == 0)
	        res2 = countMinStepsToOne(n/2, arr);
	    if(n%3 == 0)
	        res3 = countMinStepsToOne(n/3, arr);
	    
	    arr[n] = 1 + Math.min(res1, Math.min(res2,res3));
	    return arr[n];
	    
//	    int min = countMinStepsToOne(n-1, arr);
//        
//        if(n%2 == 0){ 
//            int res = countMinStepsToOne(n/2, arr);
//            if(res < min)
//                min = res;
//        }
//           
//
//        if(n%3 == 0){
//            int res = countMinStepsToOne(n/3, arr);
//            if(res < min)
//                min = res;
//         }
//
//		arr[n] = 1 + min;
//        return arr[n];
	    
	}
	
	
	//Dynamic Programming	
	//Time: O(n)       space:O(n)
	public static int countMinStepsToOneDP(int n){
        int[] arr = new int[n+1];
        arr[1] = 0;
        int min;
        for(int i=2; i<=n ; i++){
            min = arr[i-1];
            if(i%2 == 0){
                if(arr[i/2] < min)
                    min = arr[i/2];
            }
            if(i%3 == 0){
                if(arr[i/3] < min)
                    min = arr[i/3];
            }
            
            arr[i] = 1 + min;
        } 
        
        return arr[n];
    }
	
}
