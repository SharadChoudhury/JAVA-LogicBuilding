package Arrays;
import java.util.*;
//output contains elements in order as 
//they appear in arr1 and if an element occurs twice in both arrays 
//then it will be included twice as its an intersection so all common
//elements will be printed

public class IntersectionOfArrays {
     
    public static void intersections(int arr1[], int arr2[]) {
//time complexity= m*n
//space complexity: O(1)
        int m=arr1.length;
        int n=arr2.length;
        
        for(int i=0;i<m;i++){ //iterating arr1            
            for(int j=0;j<n;j++){ // iterating arr2          	
                if(arr1[i]==arr2[j]){
                    System.out.print(arr1[i]+" ");
                    arr2[j]=-1;
                	break; 		//very necessary to break otherwise all duplicates
        // in arr2 corresponding to arr[i] will be printed even if the element occurs  
        // only once in arr1
                }                   
            }           
        }
        
    }
    
    public static void intersection_new(int[] arr1, int[] arr2) {
    	// optimized approach 
//  time complexity= mlog + nlogn + O(m+n)
//	space complexity: O(1)
    	
        Arrays.sort(arr1); //mlogn
        Arrays.sort(arr2); //nlogn
        
        int i=0,j=0;        
        while(i<arr1.length && j<arr2.length){ //O(m+n)
            if(arr1[i]==arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                i++;
            }
        }        
        
	}
    
    public static void main (String[] args) {
        int[] arr1 = {0 ,7 ,2 ,5 ,4 ,7 ,1, 3 ,6};
        int [] arr2 = {7 ,4, 6, 8 ,7, 9};
        
        intersections(arr1,arr2); 
        
    }
}