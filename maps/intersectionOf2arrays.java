package maps;

import java.util.HashMap;

public class intersectionOf2arrays {
	
	public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr1){
            if(map.containsKey(i))
               map.put(i, map.get(i)+1);            	             
            else
                map.put(i,1);
        }
        
        for(int j : arr2){
            if(map.containsKey(j)){
                System.out.println(j);
                int cnt = map.get(j);
                if(cnt > 1)
                	map.put(j,cnt-1);
                else
                    map.remove(j);				
            }                            
        }

	}
	
}
