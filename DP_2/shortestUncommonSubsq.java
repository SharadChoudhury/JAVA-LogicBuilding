package DP_2;

public class shortestUncommonSubsq {

	//Memoization
	// we are trying to find any subsequence of string1 that is not present in string 2
	
	
	public int solve(String s,String v, int[][] arr){
        if(s.length() == 0 ){		//if string1 itself ends, then there is no subsequence possible from string1
        	// so return max
            arr[0][v.length()] = 1000000000;
            return arr[0][v.length()];
        }
            
        if(v.length() <= 0){   //if second string ends, then the entire first string at this step is uncommon,
        	//so minimum length is 1 i.e taking any character from the string 1 at this step
            arr[s.length()][v.length()] = 1;
        }
        
        if(arr[s.length()][v.length()] != -1)  //if already exists
            return arr[s.length()][v.length()];
        
        int k = v.indexOf(s.charAt(0));  //finding the index where string1's 0th char occurs first in string2    
        // if string1's first char not found in string2, then this char itself is the smallest subsequence
        if (k == -1)
            return 1;
        
        // minimum length of uncommon subsequence at this cell is the minimum of two results:
        //  1.  we don't take the string1's 0th char in the subsequence
        //	2.  take string1's 0th char in the subsequence : in this case we take the subsequence of string2 from the next
        // 		index of k, and since we take 0th char of s in the subsequence the length increases by 1
        
        arr[s.length()][v.length()] = Math.min(  solve(s.substring(1), v, arr) ,
                1 + solve(s.substring(1), v.substring(k+1), arr) );
        
        return arr[s.length()][v.length()];		
	}
    
	
    public int solve(String s, String v){       
        int[][] arr = new int[s.length()+1][v.length()+1];
        
        for(int i=0; i<= s.length() ; i++){
            for(int j=0 ; j<= v.length(); j++)
                arr[i][j] = -1;
        }
       
        return solve(s,v,arr);
        
         //simple recursive
//         if(s.length() == 0 )
//             return 100000;
            
//         if(v.length() <= 0)
//             return 1;
        
//         int k;
//         for (k = 0; k < v.length(); k++)
//             if (v.charAt(k) == s.charAt(0))
//                 break;
     
//         // char not found in T
//         if (k == v.length())
//             return 1;
                
//         return Math.min(  solve(s.substring(1) ,v) ,
//                 1 + solve( s.substring(1), v.substring(k+1) ) );
        
    }
	
}
