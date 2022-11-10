package maps;

import java.util.HashMap;

public class pairDiffK {
	
	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Time:O(N)		space:O(N)
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int pairs = 0;
        
        for(int i : arr){   
        	
            if(map.containsKey(i - k))
                pairs += map.get(i-k);
            
            //if k=0, then all identical elements to key will be covered in i-k condition itself
            //so don't count here again as i+k will be same as i-k for k=0
            if(map.containsKey(i + k) && k!=0)
                pairs += map.get(i+k);
            
            //insert the element only after checking above(this is important for k=0 case)
            map.put( i, map.getOrDefault(i,0)+1 );
        }
        
        return pairs;
	}
	
}
