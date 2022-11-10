package maps;

import java.util.HashMap;

public class pairsumToZero {

	public static int PairSum(int[] input, int size) {

        HashMap<Integer,Integer> map = new HashMap<>();
    	 int count =0;
        
        for(int key : input){
            map.put(key, map.getOrDefault(key,0)+1);
            if(map.containsKey(-key) && key!=0){
                count = count + map.get(-key);
            } 
        }
        
        if( map.containsKey(0)){
            int cnt = map.get(0);
            count  = count + cnt*(cnt -1)/2;
        }
        
        return count;
	}
	
}
