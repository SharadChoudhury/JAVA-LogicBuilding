package maps;
import java.util.*;

public class longestConsecutiveSubsequence {
	
	
	//Time:O(N)		space:O(N)
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		// assume no duplicates in arr
        
	//hashmap to store the status of already covered elements
	//'true' if they haven't been counted for any subsequence yet, 'false' otherwise
        HashMap<Integer,Boolean> status = new HashMap<>();
        
    //hashmap to store the indexes of elements when first traversing the input array
        HashMap<Integer,Integer> indexes = new HashMap<>();

    	int max = 0;
        int start = -1;
        
        for(int i= 0; i<arr.length ; i++){	////takes O(n) time 
            status.put(arr[i], true);
            indexes.put(arr[i], i);
        }
            
 
/*	if status = true, count till consecutive elements exist in right side and keep updating their
	status to false as each element is found but don't make status of they key as false yet
	then repeat same for left side
	now check if count > max ,if true update count and the start element
	if count = max, then check if the start of current subsequence occurs first or the start of 
	the longest subsequence yet does,
	update only if index of current start < index of existing start
*/
        for(int key : status.keySet()){		//takes O(n) time 
        	
            if(status.get(key) == true){                
            //count is initialized with 1 as min length of subsequence is 1 after a key is found
                int cnt = 1;	
                int tempkey = key;
                
                while(status.containsKey(tempkey+1)){
                    cnt++;
                    status.put(tempkey+1,false);
                    tempkey = tempkey+1;
            	}
                
                tempkey = key;
                while(status.containsKey(tempkey-1)){
                    cnt++;
                    status.put(tempkey-1,false);
                    tempkey = tempkey-1;
            	} 
                               
                if(cnt > max ){		
                    max = cnt;
                    start = tempkey;
                }
                else if(cnt == max && indexes.get(tempkey) < indexes.get(start)){ 
            //don't use arraylist's indexOf method here as that takes O(n) time but indexes hashmap
            // will take O(1) time for indexes.get 
                        max = cnt;
                        start = tempkey;
                }
                
                status.put(key,false);
            }
           
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(start);
        ans.add(start + max - 1);
        
        return ans;
        
    }
	
}
