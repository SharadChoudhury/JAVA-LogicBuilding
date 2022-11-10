package maps;

import java.util.HashMap;

public class longestSubsetZeroSum {
	
	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		//Time:O(N)		space:O(N)
		
/*	at each element, update the sum yet and the index where this sum occurred
	if the sum is x at index i and sum is x again at index j, it means sum of elements from
	i+1 to j is zero. 
	exception is when the array is like [2,-2,0,-2,2] ie, when sum is 0 from starting itself
 */

        HashMap<Integer,Integer> sumYet = new HashMap<>();
        
        int sum = 0;
        int maxlen = 0;
        int len = 0;
        
        for(int i=0; i< arr.length ; i++){
            sum += arr[i];
            if(sumYet.containsKey(sum) && sum!=0){
                len = i - sumYet.get(sum);
            }
            else{
                if(sum == 0)
                 	len = i + 1;
                sumYet.put(sum,i);
            }
            
            if(len > maxlen)
                maxlen = len;
        }
        
        return maxlen;
	}
	
}
